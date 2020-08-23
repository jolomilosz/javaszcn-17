package pl.weather.api;

import okhttp3.OkHttpClient;

public enum OkHttp {

    /**
     * TODO
     * 1. Utwórz Singleton dla OkHttpClient
     */

    INSTANCE(new OkHttpClient());

    public final OkHttpClient client;

    OkHttp(OkHttpClient okHttpClient) {
        this.client = okHttpClient;
    }

    public OkHttpClient getClient() {
        return client;
    }
}
