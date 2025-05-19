package com.feng.designpatterndemo.chapter2.observer;

import com.feng.designpatterndemo.chapter2.subject.Subject;

/**
 * 当前气象状况显示器
 *
 * @Author fency
 * @Date 2025/5/19 16:00
 * @Version 1.0
 */

public class CurrentConditionsDisplay implements Observer,DisplayElement{

    private float temperature;
    private float humidity;
    private Subject weatherData;

    public CurrentConditionsDisplay(Subject weatherData){
        this.weatherData = weatherData;
        weatherData.registerObserver(this);
    }


    @Override
    public void update(float temperature, float humidity, float pressure) {
        this.temperature = temperature;
        this.humidity = humidity;
        display();
    }

    @Override
    public void display() {
        System.out.println("Current conditions: " + temperature + "F degrees and " + humidity + "% humidity");
    }
}
