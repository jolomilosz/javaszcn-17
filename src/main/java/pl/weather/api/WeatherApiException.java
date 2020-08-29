package pl.weather.api;

import okhttp3.Response;

import java.io.IOException;

public class WeatherApiException extends IOException {

    /**
     * TODO
     *  1. Podaj wiadomość do klasy bazowej
     *  2. Stwórz pole dla kodu błędu
     */

    private String errorMessage;

    public WeatherApiException(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String toString() {
        return "WeatherApiException: " + errorMessage;
    }

}
