package com.example.creator._01_singleton;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;

class Settings3Test {

    @DisplayName("double checked locking 싱글턴 유지 테스트")
    @Test
    void testCase1() {
        Settings3 actual = Settings3.getInstance();
        Settings3 expected = Settings3.getInstance();

        assertThat(actual).isEqualTo(expected);
    }

    @DisplayName("싱글턴을 리플렉션으로 깨는 테스트")
    @Test
    void testCase2() throws InvocationTargetException, InstantiationException, IllegalAccessException, NoSuchMethodException {
        Settings3 actual = Settings3.getInstance();

        Constructor<Settings3> declaredConstructor = Settings3.class.getDeclaredConstructor();
        declaredConstructor.setAccessible(true);

        Settings3 expected = declaredConstructor.newInstance();

        assertThat(actual).isEqualTo(expected);
    }

    @DisplayName("멀티 스레드 기반의 테스트")
    @Test
    void testCase3() throws InterruptedException {
        int THREAD_COUNT = 100;
        ExecutorService executorService = Executors.newFixedThreadPool(THREAD_COUNT);
        CountDownLatch latch = new CountDownLatch(THREAD_COUNT);

        IntStream.rangeClosed(0, THREAD_COUNT)
                .forEach(value -> executorService.execute(() -> {
                    Settings3 instance = Settings3.getInstance();
                    System.out.println("instance = " + instance);
                    latch.countDown();
                }));

        latch.await();
    }
}