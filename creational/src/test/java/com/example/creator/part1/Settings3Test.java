package com.example.creator.part1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

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
}