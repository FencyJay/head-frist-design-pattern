package com.feng.designpatterndemo.chapter1.duckbehavior;

/**
 * 鸭子正常叫声
 *
 * @Author fency
 * @Date 2025/5/12 14:43
 * @Version 1.0
 */

public class Quack implements QuackBehavior{
    @Override
    public void quack() {
        System.out.println("呱呱叫");
    }
}
