package com.example.plantname.Retrofit;

import com.example.plantname.modelsTrefle.Plants;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiInterfaceTrefle {
    @GET("api/v1/plants/search")
    Call<Plants> getSearchData(@Query("token") String token,
                               @Query("q") String search);
}
