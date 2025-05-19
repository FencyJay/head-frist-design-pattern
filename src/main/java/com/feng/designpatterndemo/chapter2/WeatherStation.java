package com.feng.designpatterndemo.chapter2;

import com.feng.designpatterndemo.chapter2.observer.CurrentConditionsDisplay;
import com.feng.designpatterndemo.chapter2.observer.StatisticsDisplay;
import com.feng.designpatterndemo.chapter2.subject.WeatherData;

/**
 * @Author fency
 * @Date 2025/5/19 16:02
 * @Version 1.0
 */

public class WeatherStation {
    public static void main(String[] args) {
        WeatherData weatherData = new WeatherData();
        CurrentConditionsDisplay currentDisplay = new CurrentConditionsDisplay(weatherData);
        StatisticsDisplay statisticsDisplay = new StatisticsDisplay(weatherData);
        weatherData.setMeasurements(80, 65, 30.4f);


    }
}
