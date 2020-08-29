package pl.weather.api;

import okhttp3.Headers;
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
        /**
         * TODO
         * 1.Tworzymy nowy request za pomocą RequestBuilder'a
         * 2.Za pomocą OkHttp wysyłamy nowy request (zajrzyj do dokumentacji)
         * 3.Jeśli request wykonał się poprawnie, skonwertuj za pomocą SimpleDataWeatherConverter
         *  jeśli nie wywołaj WeatherApiException
         */

        Request request = requestBuilder.newRequest(city);

        try (Response response = httpClient.newCall(request).execute()) {
            if (!response.isSuccessful()) {
//                throw new IOException("Unexpected code " + response);
                throw new WeatherApiException(response.body().string());
            }

            /*
            Headers responseHeaders = response.headers();
            for (int i = 0; i < responseHeaders.size(); i++) {
                System.out.println(responseHeaders.name(i) + ": " + responseHeaders.value(i));
            }
             */

            String responseJson = response.body().string();
            System.out.println("response body: " + responseJson);

            WeatherDataConverter simpleDataWeatherConverter = new SimpleDataWeatherConverter();

            SimpleWeather simpleWeather = simpleDataWeatherConverter.convertData(responseJson);

            return simpleWeather;
        }
    }
}
