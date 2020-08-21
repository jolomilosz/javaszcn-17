package pl.weather.api;

import okhttp3.Request;

public interface RequestBuilder {
    Request newRequest(String city);
}
