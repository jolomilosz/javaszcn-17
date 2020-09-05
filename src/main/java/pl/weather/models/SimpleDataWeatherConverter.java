package pl.weather.models;

import com.google.gson.Gson;

public class SimpleDataWeatherConverter implements WeatherDataConverter {

    private Gson gson = new Gson();

    @Override
    public SimpleWeather convertData(String json) {
        WeatherForCity weatherForCity = gson.fromJson(json, WeatherForCity.class);
        return simplifyWeather(weatherForCity);
    }

    private SimpleWeather simplifyWeather(WeatherForCity weatherForCity) {
        SimpleWeather simpleWeather = new SimpleWeather(
                weatherForCity.getCityName(),
                getDescription(weatherForCity),
                weatherForCity.getDetails().getTemp(),
                weatherForCity.getDetails().getFeelsLike(),
                weatherForCity.getDetails().getPressure(),
                weatherForCity.getDetails().getHumidity()
        );
        return simpleWeather;
    }

    private String getDescription(WeatherForCity weatherForCity) {

        return weatherForCity.getWeatherList().get(0).getDescription();
    }
}
