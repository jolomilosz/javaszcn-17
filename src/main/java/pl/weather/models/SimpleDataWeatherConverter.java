package pl.weather.models;

import com.google.gson.Gson;

import java.util.List;

public class SimpleDataWeatherConverter implements WeatherDataConverter {
    private static final String DESCRIPTION_SEPARATOR = " ";

    private Gson gson = new Gson();

    @Override
    public SimpleWeather convertData(String json) {
        WeatherForCity weatherForCity = gson.fromJson(json, WeatherForCity.class);
        return simplifyWeather(weatherForCity);
    }

    private SimpleWeather simplifyWeather(WeatherForCity weatherForCity) {
        SimpleWeather simpleWeather = new SimpleWeather();
        simpleWeather.setName(weatherForCity.getName());
        simpleWeather.setTemp(weatherForCity.getDetails().getTemp());
        simpleWeather.setFeelsLike(weatherForCity.getDetails().getFeelsLike());
        simpleWeather.setHumidity(weatherForCity.getDetails().getHumidity());
        simpleWeather.setPressure(weatherForCity.getDetails().getPressure());
        simpleWeather.setDescription(getDescription(weatherForCity));
        return simpleWeather;
    }

    private String getDescription(WeatherForCity weatherForCity) {
        List<Weather> weatherList = weatherForCity.getWeather();
        StringBuilder description = new StringBuilder();
        for (Weather weather : weatherList) {
            description.append(weather.getDescription());
            description.append(DESCRIPTION_SEPARATOR);
        }

        return description.toString();
    }
}
