package com.example.creator.part2._04_before;

/**
 * Factory에서 담당해야할 기능은 주문을 받는 기능과 그와 관련된 부가기능 뿐이다.
 */
public class CoffeeMachine {

    private CoffeeMachine() {
    }

    public static Coffee orderCoffee(EspressoBean espressoBean, int water, String name) {
        // 유효성 검사
        if (espressoBean.isValid()) {
            throw new IllegalArgumentException("원두가 부족합니다.");
        }
        if (isWaterAmount(water)) {
            throw new IllegalArgumentException("물이 부족합니다.");
        }

        prepareFor(espressoBean);

        // 원두 분쇄 작업
        espressoBean.setBeanName("분쇄된 " + espressoBean.getBeanName());

        Coffee coffee = new Coffee(espressoBean, water);

        if (water == 0) {
            coffee.setName("에스프레소 커피");
        } else {
            coffee.setName("아메리카노 커피");
        }

        servingTo(name, coffee);

        return coffee;
    }

    private static boolean isWaterAmount(int water) {
        return water < 1;
    }

    private static void prepareFor(EspressoBean espressoBean) {
        System.out.println("커피 제조중...");
        System.out.println("사용한 원두는 " + espressoBean.getBeanName() + " 입니다.");
    }

    private static void servingTo(String name, Coffee coffee) {
        System.out.println(name + " 님 주문하신 " + coffee.getName() + " 나왔습니다.");
    }
}
