package pl.weather.api;

import pl.weather.models.SimpleWeather;

import java.io.IOException;

public class CloudApi implements WeatherApi {
//    private OkHttpClient httpClient = OkHttp.INSTANCE.getClient();
//    private RequestBuilder requestBuilder = new WeatherRequestBuilder();
//    private WeatherDataConverter dataConverter = new SimpleDataWeatherConverter();

    @Override
    public SimpleWeather getWeather(String city) throws IOException, WeatherApiException {

        /**
         * TODO
         * 1.Tworzymy nowy request za pomocą RequestBuilder'a
         * 2.Za pomocą OkHttp wysyłamy nowy request (zajrzyj do dokumentacji)
         * 3.Jeśli request wykonał się poprawnie, skonwertuj za pomocą SimpleDataWeatherConverter
         *  jeśli nie wywołaj WeatherApiException
         */
        return null;
    }
}
