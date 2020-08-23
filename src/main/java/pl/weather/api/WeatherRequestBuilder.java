package pl.weather.api;

import okhttp3.HttpUrl;
import okhttp3.Request;
import pl.weather.Units;

public class WeatherRequestBuilder implements RequestBuilder {
    private UrlProvider urlProvider = new UrlProvider();

    @Override
    public Request newRequest(String city) {
        /**
         * TODO:
         *  1. Stwórz Url za pomocą UrlProvider'a i Request'a
         */
        HttpUrl httpUrl = urlProvider.createUrl(city, Units.METRIC);

        Request request = new Request.Builder()
                .url(httpUrl)
                .build();

        return request;
    }
}
