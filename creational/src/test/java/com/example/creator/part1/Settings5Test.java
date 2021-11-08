package com.example.creator.part1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

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
}