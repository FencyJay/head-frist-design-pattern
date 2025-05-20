package com.feng.designpatterndemo.chapter2.weatherdata;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import com.feng.designpatterndemo.chapter2.observer.CurrentConditionsDisplay;
import com.feng.designpatterndemo.chapter2.subject.WeatherData;
import org.json.JSONArray;
import org.json.JSONObject;

/**
 * 调用天气 API
 */
public class WeatherApiClient {

    public static void main(String[] args) {
        String apiUrl = "https://wis.qq.com/weather/common?source=pc&weather_type=observe|forecast_1h|forecast_24h|index|alarm|limit|tips|rise&province=%E4%B8%8A%E6%B5%B7&city=%E4%B8%8A%E6%B5%B7&county=%E6%B5%A6%E4%B8%9C%E6%96%B0%E5%8C%BA";

        try {
            URL url = new URL(apiUrl);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");

            int responseCode = conn.getResponseCode();
            if (responseCode == HttpURLConnection.HTTP_OK) {
                BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
                String inputLine;
                StringBuilder response = new StringBuilder();

                while ((inputLine = in.readLine()) != null) {
                    response.append(inputLine);
                }
                in.close();

                // 解析 JSON 响应
                JSONObject jsonResponse = new JSONObject(response.toString());
                JSONArray results = jsonResponse.getJSONArray("results");
                JSONObject locationWeather = results.getJSONObject(0);
                JSONObject now = locationWeather.getJSONObject("now");

                String text = now.getString("text");
                String temperature = now.getString("temperature");
                String lastUpdate = locationWeather.getString("last_update");

                WeatherData weatherData = new WeatherData();
                CurrentConditionsDisplay currentConditionsDisplay = new CurrentConditionsDisplay(weatherData);
                weatherData.setMeasurements(Float.parseFloat(temperature), 0, 0);

            } else {
                System.out.println("请求失败，响应码: " + responseCode);
            }
            conn.disconnect();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}