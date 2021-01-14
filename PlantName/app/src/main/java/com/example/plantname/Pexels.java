package com.example.plantname;

import android.widget.TextView;

import com.example.plantname.Retrofit.ApiInterfacePexels;
import com.example.plantname.Retrofit.RetrofitClientPexels;
import com.example.plantname.modelsPexels.Photo;
import com.example.plantname.modelsPexels.Photos;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Pexels {
    private String[] responseArrayPexels;

    public String[] makePhotoApiCall(TextView textView) {
        ApiInterfacePexels apiInterfacePexels;
        apiInterfacePexels = RetrofitClientPexels.getRetrofitInstancePexels("https://api.pexels.com/").create(ApiInterfacePexels.class);
        Call<Photos> callPexels = apiInterfacePexels.getPhoto(textView.getText().toString());

        callPexels.enqueue(new Callback<Photos>() {
            @Override
            public void onResponse(Call<Photos> callPexels, Response<Photos> responsePexels) {
                List<Photo> response_get = responsePexels.body().getPhotos();
                responseArrayPexels = new String[response_get.size()];
                for (int i = 0; i < response_get.size(); i++) {
                    responseArrayPexels[i] = response_get.get(i).getSrc().getOriginal();
                }
            }

            @Override
            public void onFailure(Call<Photos> callPexels, Throwable tPexels) {


            }
        });
        return responseArrayPexels;
    }
}
