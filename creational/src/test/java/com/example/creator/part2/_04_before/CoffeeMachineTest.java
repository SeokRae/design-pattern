package com.example.creator.part2._04_before;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CoffeeMachineTest {

    @DisplayName("커피 주문 서비스 팩토리 메서드 패턴 테스트")
    @Test
    void testCase1() {
        String orderName = "주문자";
        EspressoBean espressoBean = new EspressoBean("좋은 원두", 7);
        Coffee coffee = CoffeeMachine.orderCoffee(espressoBean, 10, orderName);

        assertThat(coffee.getName()).isEqualTo("아메리카노 커피");
    }
}