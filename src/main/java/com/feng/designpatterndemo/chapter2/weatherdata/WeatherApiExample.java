package com.feng.designpatterndemo.chapter2.weatherdata;

import java.net.URI;
import java.net.URLEncoder;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;

public class WeatherApiExample {

    // 定义完整响应结构的 POJO 类
    static class WeatherResponse {
        @SerializedName("data")
        WeatherData data;
        String message;
        int status;
    }

    static class WeatherData {
        // 逐小时预报（动态键名用 Map 接收）
        @SerializedName("forecast_1h")
        java.util.Map<String, Forecast1H> forecast1h;

        // 24小时预报
        @SerializedName("forecast_24h")
        java.util.Map<String, Forecast24H> forecast24h;

        // 生活指数（动态键名用 Map 接收）
        Index index;

        // 实时观测数据
        Observe observe;

        // 日出日落
        java.util.Map<String, RiseItem> rise;

        // 其他字段可根据需要补充...
    }

    // 逐小时预报数据结构
    static class Forecast1H {
        String degree;
        @SerializedName("update_time")
        String updateTime;
        String weather;
        @SerializedName("weather_code")
        String weatherCode;
        @SerializedName("wind_direction")
        String windDirection;
        @SerializedName("wind_power")
        String windPower;
    }

    // 24小时预报数据结构
    static class Forecast24H {
        @SerializedName("day_weather")
        String dayWeather;
        @SerializedName("max_degree")
        String maxDegree;
        @SerializedName("min_degree")
        String minDegree;
        String time;
        // 其他字段可根据需要补充...
    }

    // 生活指数结构
    static class Index {
        @SerializedName("airconditioner")
        IndexItem airConditioner;
        IndexItem allergy;
        IndexItem carwash;
        // 其他指数字段可继续补充...
    }

    static class IndexItem {
        String detail;
        String info;
        String name;
    }

    // 实时观测数据
    static class Observe {
        String degree;
        String humidity;
        String precipitation;
        String pressure;
        @SerializedName("update_time")
        String updateTime;
        String weather;
    }

    // 日出日落数据
    static class RiseItem {
        String sunrise;
        String sunset;
        String time;
    }

    public static void main(String[] args) throws Exception {
        // url:https://wis.qq.com/weather/common?source=pc&weather_type=observe|forecast_1h|forecast_24h|index|alarm|limit|tips|rise&province=上海&city=上海&county=浦东新区
        // 定义参数并编码
        Map<String, String> params = new HashMap<>();
        params.put("source", "pc");
        params.put("weather_type", "observe|forecast_1h|forecast_24h|index|alarm|limit|tips|rise");
        params.put("province", "上海");
        params.put("city", "上海");
        params.put("county", "浦东新区");

        // 对参数进行 URL 编码
        String encodedParams = params.entrySet().stream()
                .map(entry -> URLEncoder.encode(entry.getKey(), StandardCharsets.UTF_8) +
                        "=" + URLEncoder.encode(entry.getValue(), StandardCharsets.UTF_8))
                .collect(Collectors.joining("&"));

        String apiUrl = "https://wis.qq.com/weather/common?" + encodedParams;

        // 使用 HttpClient 发送请求（代码与之前相同）
        HttpClient client = HttpClient.newBuilder()
                .connectTimeout(Duration.ofSeconds(10))
                .build();

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(apiUrl)) // 此处已使用编码后的 URL
                .timeout(Duration.ofSeconds(10))
                .header("Accept", "application/json")
                .GET()
                .build();

        // 发送请求并获取响应
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        if (response.statusCode() == 200) {
            Gson gson = new Gson();
            WeatherResponse weatherResponse = gson.fromJson(response.body(), WeatherResponse.class);

            // 解析实时天气
            if (weatherResponse.data.observe != null) {
                Observe observe = weatherResponse.data.observe;
                System.out.println("=== 实时天气 ===");
                System.out.printf("温度: %s℃ 湿度: %s%% 天气: %s 更新时间: %s%n",
                        observe.degree, observe.humidity, observe.weather, observe.updateTime);
            }

            // 解析逐小时预报
            if (weatherResponse.data.forecast1h != null) {
                System.out.println("\n=== 逐小时预报 ===");
                weatherResponse.data.forecast1h.forEach((key, forecast) -> {
                    System.out.printf("[%s时] %s %s℃ %s %s%n",
                            key, forecast.weather, forecast.degree,
                            forecast.windDirection, forecast.windPower);
                });
            }

            // 解析生活指数
            if (weatherResponse.data.index != null) {
                System.out.println("\n=== 生活指数 ===");
                System.out.printf("穿衣建议: %s - %s%n",
                        weatherResponse.data.index.airConditioner.name,
                        weatherResponse.data.index.airConditioner.info);
                System.out.printf("紫外线指数: %s - %s%n",
                        weatherResponse.data.index.airConditioner.name,
                        weatherResponse.data.index.airConditioner.info);
            }

        } else {
            System.out.println("请求失败，状态码: " + response.statusCode());
        }
    }
}