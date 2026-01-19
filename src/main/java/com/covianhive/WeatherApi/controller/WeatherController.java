package com.covianhive.WeatherApi.controller;

import com.covianhive.WeatherApi.model.Weather;
import com.covianhive.WeatherApi.service.WeatherService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/weather")
public class WeatherController {

    private final WeatherService service;

    public WeatherController(WeatherService service) {
        this.service = service;
    }

    @GetMapping("/{city}")
    public Weather getWeather(@PathVariable String city) {
        return service.getWeather(city);
    }
}