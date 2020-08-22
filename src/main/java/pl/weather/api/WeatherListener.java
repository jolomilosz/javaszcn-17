package pl.weather.api;

public interface WeatherListener {
    void onSuccess(SimpleWeather simpleWeather);

    void onFail(String errorMassage);
}
