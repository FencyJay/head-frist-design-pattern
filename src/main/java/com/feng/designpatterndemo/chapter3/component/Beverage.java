package com.feng.designpatterndemo.chapter3.component;

/**
 * 咖啡基类
 *
 * @Author fency
 * @Date 2025/5/20 13:45
 * @Version 1.0
 */

public abstract class Beverage {
    String description = "Unknown Beverage";

    public String getDescription() {
        return description;
    }

    public abstract double cost();

}
