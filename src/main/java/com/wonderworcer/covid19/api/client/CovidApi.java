package com.wonderworcer.covid19.api.client;

import retrofit2.Call;
import retrofit2.http.GET;

public interface CovidApi {
    @GET("last")
    Call<CovidResponse> getLatestStatistics();
}
