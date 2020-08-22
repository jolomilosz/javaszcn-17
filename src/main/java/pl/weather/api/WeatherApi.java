package pl.weather.api;

import java.io.IOException;

public interface WeatherApi {
    SimpleWeather getWeather(String miasto) throws IOException, WeatherApiException;
}
