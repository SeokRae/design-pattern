package com.example.creator.part1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;

class Settings2Test {

    @DisplayName("synchronized 사용하여 동기화 처리하는 테스트")
    @Test
    void testCase1() {
        Settings2 settings1 = Settings2.getInstance();
        Settings2 settings2 = Settings2.getInstance();

        assertThat(settings1).isEqualTo(settings2);
    }

    @DisplayName("싱글턴을 리플렉션으로 깨는 테스트")
    @Test
    void testCase2() throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        Settings2 actual = Settings2.getInstance();
        Constructor<Settings2> declaredConstructor =
                Settings2.class.getDeclaredConstructor();

        declaredConstructor.setAccessible(true);

        Settings2 expected = declaredConstructor.newInstance();

        assertThat(actual).isNotEqualTo(expected);
    }

    @DisplayName("멀티 스레드 기반의 테스트")
    @Test
    void testCase3() throws InterruptedException {
        int THREAD_COUNT = 100;
        ExecutorService executorService = Executors.newFixedThreadPool(THREAD_COUNT);
        CountDownLatch latch = new CountDownLatch(THREAD_COUNT);

        IntStream.rangeClosed(0, THREAD_COUNT)
                .forEach(value -> {
                    executorService.execute(() -> {
                        Settings2 instance = Settings2.getInstance();
                        System.out.println("instance = " + instance);
                        latch.countDown();
                    });
                });

        latch.await();
    }
}