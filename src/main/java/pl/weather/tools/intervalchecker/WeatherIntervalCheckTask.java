package pl.weather.tools.intervalchecker;

import pl.weather.api.CloudApi;
import pl.weather.api.WeatherApi;
import pl.weather.api.WeatherApiException;
import pl.weather.api.WeatherListener;
import pl.weather.models.SimpleWeather;

import java.io.IOException;
import java.util.TimerTask;

public class WeatherIntervalCheckTask extends TimerTask {
    private final WeatherApi api = new CloudApi();

    private final WeatherListener listener;
    private final String city;

    public WeatherIntervalCheckTask(WeatherListener listener, String city) {

        this.listener = listener;
        this.city = city;
    }

    @Override
    public void run() {
        try {
            SimpleWeather weather = api.getWeather(city);
            listener.onSuccess(weather);
        } catch (IOException | WeatherApiException e) {
            listener.onFail(e.getMessage());
        }
    }
}