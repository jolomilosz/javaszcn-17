package pl.weather.models;

public interface WeatherDataConverter {
    SimpleWeather convertData(String json);
}
