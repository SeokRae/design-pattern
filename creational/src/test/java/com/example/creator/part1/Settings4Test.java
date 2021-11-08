package com.example.creator.part1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

import static org.assertj.core.api.Assertions.assertThat;

class Settings4Test {

    @DisplayName("static inner를 통한 싱글턴 테스트")
    @Test
    void testCase1() {
        Settings4 instance1 = Settings4.getInstance();
        Settings4 instance2 = Settings4.getInstance();

        assertThat(instance1).isEqualTo(instance2);
    }

    @DisplayName("싱글턴의 리플렉션으로 깨는 테스트")
    @Test
    void testCase2() throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        Settings4 actual = Settings4.getInstance();

        Constructor<Settings4> declaredConstructor = Settings4.class.getDeclaredConstructor();

        declaredConstructor.setAccessible(true);

        Settings4 expected = declaredConstructor.newInstance();

        assertThat(actual).isNotEqualTo(expected);
    }
}