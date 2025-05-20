package com.feng.designpatterndemo.chapter3.component;

/**
 * 混合咖啡
 *
 * @Author fency
 * @Date 2025/5/20 13:47
 * @Version 1.0
 */

public class HouseBlend extends Beverage {
    public HouseBlend() {
        description = "House Blend Coffee";
    }

    @Override
    public double cost() {
        return 0.89;
    }
}
