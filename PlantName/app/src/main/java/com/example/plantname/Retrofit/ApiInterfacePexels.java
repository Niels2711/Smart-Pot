package com.example.plantname.Retrofit;

import com.example.plantname.modelsPexels.Photo;
import com.example.plantname.modelsPexels.Photos;
import com.example.plantname.modelsPexels.Src;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Query;

public interface ApiInterfacePexels {
    @GET("v1/search")
    @Headers("Authorization: 563492ad6f9170000100000185db8b1b3c1c4077901a4b25a7367029")
    Call<Photos> getPhoto(@Query("query")  String searchPhoto);
}
