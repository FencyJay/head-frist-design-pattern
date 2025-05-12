package com.feng.designpatterndemo.chapter1.duckbehavior;

/**
 * 飞行行为实现类
 *
 * @Author fency
 * @Date 2025/5/12 14:40
 * @Version 1.0
 */

public class FlyWithWings implements FlyBahavior{
    @Override
    public void fly() {
        System.out.println("我会飞翔");
    }
}
