package com.feng.designpatterndemo.chapter3.decorator;

import com.feng.designpatterndemo.chapter3.component.Beverage;

/**
 * @Author fency
 * @Date 2025/5/20 14:03
 * @Version 1.0
 */

public class Whip extends CondimentDecorator {
    Beverage beverage;

    public Whip(Beverage beverage) {
        this.beverage = beverage;
    }

    @Override
    public String getDescription() {
        return beverage.getDescription() + ", Whip";
    }

    public double cost(){
        return 0.10 + beverage.cost();
    }
}
