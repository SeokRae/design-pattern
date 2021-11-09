package com.example.creator.part2;

public class AmericanoFactory implements CoffeeMachine {
    @Override
    public Coffee createCoffee() {
        EspressoBean espressoBean = new EspressoBean("좋은 원두", 7);
        EspressoBean grindBean = grindBean(espressoBean);
        return new Americano(grindBean, 10);
    }

    private EspressoBean grindBean(EspressoBean espressoBean) {
        espressoBean.setBeanName("갈린 " + espressoBean.getBeanName());
        return espressoBean;
    }
}
