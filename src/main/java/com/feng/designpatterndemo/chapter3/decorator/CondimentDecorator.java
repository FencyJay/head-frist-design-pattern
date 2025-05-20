package com.feng.designpatterndemo.chapter3.decorator;

import com.feng.designpatterndemo.chapter3.component.Beverage;

/**
 * 调味装饰者
 *
 * @Author fency
 * @Date 2025/5/20 13:46
 * @Version 1.0
 */

public abstract class CondimentDecorator extends Beverage {

    public abstract String getDescription();

}
