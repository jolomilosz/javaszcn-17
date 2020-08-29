package pl.weather.api;

import pl.weather.models.SimpleWeather;

public interface WeatherListener {
    void onSuccess(SimpleWeather simpleWeather);

    void onFail(String errorMassage);
}
