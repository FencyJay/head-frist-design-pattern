package com.feng.designpatterndemo.chapter3.decorator;

import com.feng.designpatterndemo.chapter3.component.Beverage;

/**
 * 摩卡装饰者
 *
 * @Author fency
 * @Date 2025/5/20 13:48
 * @Version 1.0
 */

public class Mocha extends CondimentDecorator {
    Beverage beverage;

    public Mocha(Beverage beverage) {
        this.beverage = beverage;
    }

    @Override
    public String getDescription(){
        return beverage.getDescription() + ", Mocha";
    }

    public double cost(){
        return 0.20 + beverage.cost();
    }

}
