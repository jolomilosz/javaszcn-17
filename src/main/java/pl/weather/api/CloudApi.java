package pl.weather.api;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import pl.weather.models.SimpleDataWeatherConverter;
import pl.weather.models.SimpleWeather;
import pl.weather.models.WeatherDataConverter;

import java.io.IOException;

public class CloudApi implements WeatherApi {
    private OkHttpClient httpClient = OkHttp.INSTANCE.getClient();
    private RequestBuilder requestBuilder = new WeatherRequestBuilder();
    private WeatherDataConverter dataConverter = new SimpleDataWeatherConverter();

    @Override
    public SimpleWeather getWeather(String city) throws IOException, WeatherApiException {
        Request request = requestBuilder.newRequest(city);
        Response response = httpClient.newCall(request).execute();
        if (response.isSuccessful()) {
            String json = response.body().string();
            return dataConverter.convertData(json);
        } else {
            throw new WeatherApiException("Pobieranie dany sie nie powiodlo: " + response.message(), response.code());
        }
    }
}
