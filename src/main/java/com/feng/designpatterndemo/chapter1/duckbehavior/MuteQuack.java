package com.feng.designpatterndemo.chapter1.duckbehavior;

/**
 * 鸭子安静
 *
 * @Author fency
 * @Date 2025/5/12 14:45
 * @Version 1.0
 */

public class MuteQuack implements QuackBehavior{

    @Override
    public void quack() {
        System.out.println("鸭子安静");
    }
}
