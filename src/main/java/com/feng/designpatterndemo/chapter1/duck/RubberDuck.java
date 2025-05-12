package com.feng.designpatterndemo.chapter1.duck;

import com.feng.designpatterndemo.chapter1.duckbehavior.FlyNoway;
import com.feng.designpatterndemo.chapter1.duckbehavior.Squeak;

/**
 * 橡皮鸭，不会飞，会吱吱叫
 *
 * @Author fency
 * @Date 2025/5/12 14:55
 * @Version 1.0
 */

public class RubberDuck extends Duck{

    public RubberDuck(){
        // 构造时注入具体行为
        flyBahavior = new FlyNoway();
        quackBehavior = new Squeak();
    }

    @Override
    public void display() {
        System.out.println("我是一只橡皮鸭");
    }
}
