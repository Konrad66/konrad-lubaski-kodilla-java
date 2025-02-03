package com.kodilla.testing.weather.stub;

import java.util.*;

public class WeatherForecast {

    private Temperatures temperatures;
    private Map<String, Double> resultMap;

    public WeatherForecast(Temperatures temperatures) {
        this.temperatures = temperatures;
    }

    public Map<String, Double> calculateForecast() {
        resultMap = new HashMap<>();

        for (Map.Entry<String, Double> temperature : temperatures.getTemperatures().entrySet()) {
            resultMap.put(temperature.getKey(), temperature.getValue() + 1.0); // [1]
        }
        return resultMap;
    }

    public double averageTemperature() {
        resultMap = temperatures.getTemperatures();
        double averageTemperature = 0;
        for (Map.Entry<String, Double> temperature : resultMap.entrySet()) {
            averageTemperature += temperature.getValue();
        }
        return averageTemperature / temperatures.getTemperatures().size();
    }

    public double medianTemperature() {
        resultMap = temperatures.getTemperatures();
        List<Double> temperaturesList = new ArrayList<>();
        double medianTemperature = 0;
        for (Map.Entry<String, Double> temperature : resultMap.entrySet()) {
            temperaturesList.add(temperature.getValue());
        }
        int n = temperaturesList.size();
        Collections.sort(temperaturesList);
        if (n % 2 == 1) {
            medianTemperature = temperaturesList.get(n / 2);
        } else {
            medianTemperature = temperaturesList.get(n / 2 - 1) + temperaturesList.get(n / 2);
        }
        return medianTemperature;
    }
}