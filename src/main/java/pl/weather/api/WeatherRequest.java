package pl.weather.api;

import okhttp3.HttpUrl;
import okhttp3.Request;
import org.jetbrains.annotations.NotNull;

import java.net.URL;

public class WeatherRequest {
    private static final String QUERY_PARAMETER_PLACE = "q";
    private static final String QUERY_PARAMETER_APP_ID = "APPID";
    private static final String QUERY_PARAMETER_UNITS = "units";
    private static final String DEFAULT_API_KEY = "1d4cbd5eae1fbb37f92be746f37e4615";
    private static final String DEFAULT_COUNTRY_CODE = "pl";
    private static final String DEFAULT_UNITS = "imperial";
    private static final String DEFAULT_PARAMS_SEPARATOR = ",";

    private final HttpUrl.Builder baseBuilder = new HttpUrl.Builder()
            .scheme("http")
            .host("api.openweathermap.org")
            .addPathSegments("data/2.5/weather");

    private String city;
    private String apiKey;
    private String countryCode;
    private String units;


    /**
     * TODO
     *  1. Stwórz klasę spełniającą wzorzec budowniczego w oparciu o wypisane pola
     */

}
