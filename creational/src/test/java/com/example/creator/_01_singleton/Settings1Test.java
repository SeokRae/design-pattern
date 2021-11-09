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

class Settings1Test {

    @DisplayName("private 생성자와 public static 메서드를 사용하는 방법")
    @Test
    void testCase1() {
        Settings1 instance1 = Settings1.getInstance();
        Settings1 instance2 = Settings1.getInstance();

        assertThat(instance1).isEqualTo(instance2);
    }

    @DisplayName("싱글턴을 리플렉션으로 깨는 테스트")
    @Test
    void testCase2() throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        Settings1 actual = Settings1.getInstance();
        Constructor<Settings1> declaredConstructor = Settings1.class.getDeclaredConstructor();
        declaredConstructor.setAccessible(true);

        Settings1 expected = declaredConstructor.newInstance();

        assertThat(actual).isNotEqualTo(expected);
    }

    @DisplayName("멀티 스레드 기반의 테스트")
    @Test
    void testCase3() throws InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        CountDownLatch latch = new CountDownLatch(10);

        IntStream.rangeClosed(0, 10)
                .forEach(value -> {
                    executorService.execute(() -> {
                        Settings1 instance = Settings1.getInstance();
                        System.out.println("instance = " + instance);
                        latch.countDown();
                    });
                });

        latch.await();
    }
}