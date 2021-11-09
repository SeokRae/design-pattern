package com.example.creator._01_singleton;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

class Settings5Test {

    @DisplayName("enum 타입의 싱글턴 테스트")
    @Test
    void testCase1() {
        Settings5 actual = Settings5.INSTANCE;
        Settings5 expected = Settings5.INSTANCE;

        assertThat(actual).isEqualTo(expected);
    }

    @DisplayName("싱글턴 리플렉션 불가 예외 테스트")
    @Test
    void testCase2() {
        assertThatExceptionOfType(NoSuchMethodException.class)
                .isThrownBy(Settings5.class::getDeclaredConstructor);
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
                        Settings5 instance = Settings5.INSTANCE;
                        System.out.println("instance = " + instance.hashCode());
                        latch.countDown();
                    });
                });

        latch.await();
    }
}