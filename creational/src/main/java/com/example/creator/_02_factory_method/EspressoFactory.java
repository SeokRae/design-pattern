package com.example.creator._02_factory_method;

public class EspressoFactory implements CoffeeMachine {
    @Override
    public Coffee createCoffee(EspressoBean bean, int water) {
        EspressoBean grindBean = grindBean(bean);
        return new Espresso(grindBean, 0);
    }

    private EspressoBean grindBean(EspressoBean espressoBean) {
        espressoBean.setBeanName("갈린 " + espressoBean.getBeanName());
        return espressoBean;
    }
}
