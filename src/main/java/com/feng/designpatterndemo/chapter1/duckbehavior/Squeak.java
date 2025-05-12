package com.feng.designpatterndemo.chapter1.duckbehavior;

/**
 * 鸭子吱吱叫
 *
 * @Author fency
 * @Date 2025/5/12 14:44
 * @Version 1.0
 */

public class Squeak implements QuackBehavior{

    @Override
    public void quack() {
        System.out.println("鸭子吱吱叫");
    }
}
