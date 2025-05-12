package com.feng.designpatterndemo.chapter1.duckbehavior;

/**
 * 不会飞
 *
 * @Author fency
 * @Date 2025/5/12 14:41
 * @Version 1.0
 */

public class FlyNoway implements FlyBahavior{
    @Override
    public void fly() {
        System.out.println("我不会飞翔");
    }
}
