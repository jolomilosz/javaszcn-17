package pl.weather;

import pl.weather.api.CloudApi;
import pl.weather.models.SimpleDataWeatherConverter;
import pl.weather.models.SimpleWeather;
import pl.weather.models.WeatherDataConverter;

import java.io.IOException;

public class Main {
    public static void main(String[] args) {

        CloudApi cloudApi = new CloudApi();
        try {
            SimpleWeather simpleWeather2 = cloudApi.getWeather("Szczecin");
            System.out.println(simpleWeather2);

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
