package com.covianhive.WeatherApi.service;

import com.covianhive.WeatherApi.model.Weather;
import org.json.JSONObject;
import org.springframework.stereotype.Service;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

@Service
public class WeatherService {

    private final GeoService geoService;

    public WeatherService(GeoService geoService) {
        this.geoService = geoService;
    }

    public Weather getWeather(String city) {
        double[] coords = geoService.getCoordinates(city);
        if (coords == null) {
            return new Weather(city, 0, 0, "City not found");
        }

        try {
            String url = "https://api.open-meteo.com/v1/forecast?"
                    + "latitude=" + coords[0]
                    + "&longitude=" + coords[1]
                    + "&current_weather=true";

            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(url))
                    .build();

            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            JSONObject json = new JSONObject(response.body());
            JSONObject cw = json.getJSONObject("current_weather");

            double temp = cw.getDouble("temperature");
            double wind = cw.getDouble("windspeed");
            int weatherCode = cw.getInt("weathercode");
            String condition = mapWeatherCode(weatherCode);

            return new Weather(city, temp, wind, condition);

        } catch (Exception e) {
            e.printStackTrace();
            return new Weather(city, 0, 0, "Error fetching weather");
        }
    }

    // Maps Open-Meteo weather codes to human-readable text
    private String mapWeatherCode(int code) {
        return switch (code) {
            case 0 -> "Clear sky";
            case 1 -> "Mainly clear";
            case 2 -> "Partly cloudy";
            case 3 -> "Overcast";
            case 45 -> "Fog";
            case 48 -> "Depositing rime fog";
            case 51 -> "Light drizzle";
            case 53 -> "Moderate drizzle";
            case 55 -> "Dense drizzle";
            case 61 -> "Slight rain";
            case 63 -> "Moderate rain";
            case 65 -> "Heavy rain";
            case 71 -> "Slight snow";
            case 73 -> "Moderate snow";
            case 75 -> "Heavy snow";
            case 80 -> "Slight rain showers";
            case 81 -> "Moderate rain showers";
            case 82 -> "Violent rain showers";
            case 95 -> "Thunderstorm";
            case 99 -> "Hailstorm";
            default -> "Unknown";
        };
    }
}