package pl.weather.api;

import okhttp3.HttpUrl;
import pl.weather.Units;

class UrlProvider {
    private static final String DEFAULT_REQUEST_SCHEMA = "http";
    private static final String DEFAULT_REQUEST_HOST = "api.openweathermap.org";
    private static final String DEFAULT_REQUEST_SOURCE = "data/2.5/weather";
    private static final String DEFAULT_API_KEY = "1d4cbd5eae1fbb37f92be746f37e4615";

    public HttpUrl createUrl(String city) {
        /**
         * TODO
         * 1. Zbuduj url w oparciu o HttpUrl
         * - scheme
         * - host
         * - addPathSegments
         * - addQueryParameasdater
         * - build
         */
        HttpUrl url = new HttpUrl.Builder()
                .scheme(DEFAULT_REQUEST_SCHEMA)
                .host(DEFAULT_REQUEST_HOST)
                .addPathSegment(DEFAULT_REQUEST_SOURCE)
                .addQueryParameter("q", city)
                .addQueryParameter("appid", DEFAULT_API_KEY)
                .build();
        return url;
    }

    public HttpUrl createUrl(String city, Units units) {
        /**
         * TODO
         * 1. Jak wyżej,z dodatkowym addQueryParamter
         */
        HttpUrl url = new HttpUrl.Builder()
                .scheme(DEFAULT_REQUEST_SCHEMA)
                .host(DEFAULT_REQUEST_HOST)
                .addPathSegment(DEFAULT_REQUEST_SOURCE)
                .addQueryParameter("q", city)
                .addQueryParameter("appid", DEFAULT_API_KEY)
                .addQueryParameter("units", units.getUnits())
                .build();
        return url;
    }
}
