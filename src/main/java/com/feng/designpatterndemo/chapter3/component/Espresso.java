package com.feng.designpatterndemo.chapter3.component;

/**
 * 浓缩咖啡
 *
 * @Author fency
 * @Date 2025/5/20 13:47
 * @Version 1.0
 */

public class Espresso extends Beverage {
    public Espresso() {
        description = "Espresso";
    }

    @Override
    public double cost() {
        return 1.99;
    }
}
