package com.feng.designpatterndemo.chapter1.duck;

import com.feng.designpatterndemo.chapter1.duckbehavior.FlyWithWings;
import com.feng.designpatterndemo.chapter1.duckbehavior.Quack;

/**
 * 红头鸭，会飞会叫
 *
 * @Author fency
 * @Date 2025/5/12 14:55
 * @Version 1.0
 */

public class RedHeadDuck extends Duck{

    public RedHeadDuck(){
        // 构造时注入具体行为
        super.flyBahavior = new FlyWithWings();
        super.quackBehavior = new Quack();
    }

    @Override
    public void display() {
        System.out.println("我是一只红头鸭");
    }
}
