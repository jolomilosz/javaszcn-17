package pl.weather;

import pl.weather.models.SimpleDataWeatherConverter;
import pl.weather.models.SimpleWeather;
import pl.weather.models.WeatherDataConverter;

public class Main {
    public static void main(String[] args) {

        // fake response
        String responseJson = "{\"coord\":{\"lon\":36.25,\"lat\":50},\"weather\":[{\"id\":800,\"main\":\"Clear\",\"description\":\"clear sky\",\"icon\":\"01d\"}],\"base\":\"stations\",\"main\":{\"temp\":25,\"feels_like\":22.83,\"temp_min\":25,\"temp_max\":25,\"pressure\":1017,\"humidity\":31},\"visibility\":10000,\"wind\":{\"speed\":2,\"deg\":190},\"clouds\":{\"all\":0},\"dt\":1598173774,\"sys\":{\"type\":1,\"id\":8905,\"country\":\"UA\",\"sunrise\":1598150227,\"sunset\":1598200706},\"timezone\":10800,\"id\":706483,\"name\":\"Kharkiv\",\"cod\":200}";

        WeatherDataConverter simpleDataWeatherConverter = new SimpleDataWeatherConverter();

        SimpleWeather simpleWeather = simpleDataWeatherConverter.convertData(responseJson);

        System.out.println(simpleWeather);

    }
}
