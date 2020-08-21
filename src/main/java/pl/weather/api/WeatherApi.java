package pl.weather.api;

import pl.weather.models.SimpleWeather;

import java.io.IOException;

public interface WeatherApi {
    SimpleWeather getWeather(String miasto) throws IOException, WeatherApiException;
}
