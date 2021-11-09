package com.example.creator._02_factory_method;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CoffeeMachineFactoryTest {

    @DisplayName("아메리카노 팩토리를 통한 커피 생성 테스트")
    @Test
    void testCase1() {
        CoffeeMachine machine = new AmericanoFactory();
        String orderName = "주문자";
        EspressoBean espressoBean = new EspressoBean("좋은 원두", 7);

        Coffee coffee = machine.orderCoffee(espressoBean, 10, orderName);

        assertThat(coffee).hasToString("아메리카노 커피");
    }

    @DisplayName("에소프레소 팩토리를 통한 커피 생성 테스트")
    @Test
    void testCase2() {
        CoffeeMachine machine = new EspressoFactory();
        String orderName = "주문자";
        EspressoBean espressoBean = new EspressoBean("좋은 원두", 7);

        Coffee coffee = machine.orderCoffee(espressoBean, 0, orderName);

        assertThat(coffee).hasToString("에소프레소 커피");
    }
}
