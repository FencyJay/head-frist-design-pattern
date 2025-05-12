package com.feng.designpatterndemo.chapter1.duck;

import com.feng.designpatterndemo.chapter1.duckbehavior.FlyBahavior;
import com.feng.designpatterndemo.chapter1.duckbehavior.QuackBehavior;

/**
 * 策略模式
 *
 *
 * @Author: fency
 */
public abstract class Duck {
    // 组合：持有行为接口引用
    protected FlyBahavior flyBahavior;
    protected QuackBehavior quackBehavior;

    public Duck(){

    }

    /**
     * 鸭子飞行能力委托给行为接口
     */
    public void performFly(){
        flyBahavior.fly();
    }

    // 委托给行为接口
    public void performQuack() {
        quackBehavior.quack();
    }

    public void setFlyBahavior(FlyBahavior fb){
        this.flyBahavior = fb;
    }

    public void setQuackBehavior(QuackBehavior qb){
        this.quackBehavior = qb;
    }

    // 每个具体的鸭子必须实现自己的展示方法
    public abstract void display();

}
