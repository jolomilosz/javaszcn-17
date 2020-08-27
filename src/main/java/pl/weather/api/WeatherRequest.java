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

    public WeatherRequest(String city) {
        this.city = city;
    }

    public WeatherRequest apiKey(String apiKey) {
        this.apiKey = apiKey;
        return this;
    }

    public WeatherRequest countryCode(String countryCode) {
        this.countryCode = countryCode;
        return this;
    }

    public WeatherRequest units(String units) {
        this.units = units;
        return this;
    }

    public Request build() {
        final URL requestUrl = createUrl(city, getCountryCode(), getApiKey(), getUnits());
        return new Request.Builder()
                .url(requestUrl)
                .build();
    }


    private URL createUrl(String city, String country, String apiKey, String units) {
        return baseBuilder
                .addQueryParameter(QUERY_PARAMETER_PLACE, concatPlace(city, country))
                .addQueryParameter(QUERY_PARAMETER_APP_ID, apiKey)
                .addQueryParameter(QUERY_PARAMETER_UNITS, units)
                .build()
                .url();
    }

    @NotNull
    private String concatPlace(String city, String country) {
        return city + DEFAULT_PARAMS_SEPARATOR + country;
    }

    public String getApiKey() {
        if (apiKey == null) {
            return DEFAULT_API_KEY;
        }

        return apiKey;
    }

    public String getCountryCode() {
        if (countryCode == null) {
            return DEFAULT_COUNTRY_CODE;
        }

        return countryCode;
    }

    public String getUnits() {
        if (units == null) {
            return DEFAULT_UNITS;
        }

        return units;
    }
}
