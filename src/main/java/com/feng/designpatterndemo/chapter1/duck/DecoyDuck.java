package com.feng.designpatterndemo.chapter1.duck;

import com.feng.designpatterndemo.chapter1.duckbehavior.FlyNoway;
import com.feng.designpatterndemo.chapter1.duckbehavior.MuteQuack;

/**
 * 诱饵鸭，不能飞，不会叫
 *
 * @Author fency
 * @Date 2025/5/12 14:57
 * @Version 1.0
 */

public class DecoyDuck extends Duck{

    public DecoyDuck(){
        flyBahavior = new FlyNoway();
        quackBehavior = new MuteQuack();
    }

    @Override
    public void display() {
        System.out.println("我是一只诱饵鸭");
    }
}
