package com.feng.designpatterndemo.chapter1;

import com.feng.designpatterndemo.chapter1.duck.*;
import com.feng.designpatterndemo.chapter1.duckbehavior.FlyNoway;

/**
 * 策略模式
 *
 * @Author fency
 * @Date 2025/5/12 14:59
 * @Version 1.0
 */

public class MiniDuckSimulator {
    public static void main(String[] args) {
        // 创建不同类型的鸭子
        MallardDuck mallardDuck = new MallardDuck();
        RedHeadDuck redHeadDuck = new RedHeadDuck();
        RubberDuck rubberDuck = new RubberDuck();
        DecoyDuck decoyDuck = new DecoyDuck();

        System.out.println("------Mallard Duck-------");
        mallardDuck.display();
        mallardDuck.performFly();
        mallardDuck.performQuack();

        System.out.println("------RedHead Duck-------");
        redHeadDuck.display();
        redHeadDuck.performFly();
        redHeadDuck.performQuack();

        System.out.println("------Rubber Duck-------");
        rubberDuck.display();
        rubberDuck.performFly();
        rubberDuck.performQuack();

        System.out.println("------DecoyDuck Duck-------");
        decoyDuck.display();
        decoyDuck.performFly();
        decoyDuck.performQuack();

        // 动态更改行为
        System.out.println("\n--- Dynamic Behavior Change ---");
        Duck model = new MallardDuck();
        // 默认行为
        model.display();
        model.performFly();

        // 给模型鸭装上火箭
        model.setFlyBahavior( new FlyNoway(){

            @Override
            public void fly() {
                System.out.println("我能用火箭飞");
            }
        });

        model.performFly();


    }
}
