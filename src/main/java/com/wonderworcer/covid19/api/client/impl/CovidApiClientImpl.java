package com.wonderworcer.covid19.api.client.impl;

import com.wonderworcer.covid19.api.client.CovidApi;
import com.wonderworcer.covid19.api.client.CovidApiClient;
import com.wonderworcer.covid19.api.client.CovidResponse;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import java.io.IOException;

import static okhttp3.logging.HttpLoggingInterceptor.Level.BODY;

public class CovidApiClientImpl implements CovidApiClient {
    private static final String BASE_URL = "http://covid19.bvn13.com/stats/";
    private final CovidApi api;

    @Override
    public CovidResponse getLatestStatistics() {
        return execute(api.getLatestStatistics());
    }


    public CovidApiClientImpl(boolean enableLog) {
        OkHttpClient.Builder builder = new OkHttpClient.Builder();

        if (enableLog) {
            HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor();
            httpLoggingInterceptor.setLevel(BODY);
            builder.addInterceptor(httpLoggingInterceptor);
        }

        api = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(builder.build())
                .build()
                .create(CovidApi.class);
    }


    private <T> T execute(Call<T> call) {
        try {
            Response<T> response = call.execute();
            if (response.isSuccessful()) {
                return response.body();
            }
            throw new CovidApiException("Unsuccessful response: " + response);
        } catch (IOException e) {
            throw new CovidApiException(e);
        }
    }

}
