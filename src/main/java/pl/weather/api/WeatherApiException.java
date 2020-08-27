package pl.weather.api;

public class WeatherApiException extends RuntimeException {
    private final int code;

    public WeatherApiException(String message, int code) {
        super(message);
        this.code = code;
    }

    public int getCode() {
        return code;
    }
}
