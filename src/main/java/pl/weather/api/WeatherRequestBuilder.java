package pl.weather.api;

import okhttp3.HttpUrl;
import okhttp3.Request;
import pl.weather.Units;

public class WeatherRequestBuilder implements RequestBuilder {
    private UrlProvider urlProvider = new UrlProvider();

    @Override
    public Request newRequest(String city) {
        HttpUrl url = urlProvider.createUrl(city, Units.CELSIUS);
        return new Request.Builder()
                .url(url)
                .build();
    }
}
