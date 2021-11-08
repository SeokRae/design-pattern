package com.example.creator.part1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

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
}