package com.feng.designpatterndemo.chapter2.observer;

/**
 * 显示器接口
 *
 * @Author fency
 * @Date 2025/5/19 15:53
 * @Version 1.0
 */

public interface Observer {
    void update(float temperature, float humidity, float pressure);
}
