package com.feng.designpatterndemo.chapter2.subject;

import com.feng.designpatterndemo.chapter2.observer.Observer;

/**
 * 气象站主题接口
 *
 * @Author fency
 * @Date 2025/5/19 15:52
 * @Version 1.0
 */

public interface Subject {
    void registerObserver(Observer observer);

    void removeObserver(Observer observer);

    void notifyObservers();
}
