package com.example.creator._02_factory_method;

public class EspressoFactory implements CoffeeMachine {
    @Override
    public Coffee createCoffee() {
        EspressoBean espressoBean = new EspressoBean("좋은 원두", 7);
        EspressoBean grindBean = grindBean(espressoBean);
        return new Espresso(grindBean, 0);
    }

    private EspressoBean grindBean(EspressoBean espressoBean) {
        espressoBean.setBeanName("갈린 " + espressoBean.getBeanName());
        return espressoBean;
    }
}
