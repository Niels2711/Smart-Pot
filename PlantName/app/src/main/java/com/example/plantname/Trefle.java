package com.example.plantname;

import android.os.Build;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import com.example.plantname.Retrofit.ApiInterfacePexels;
import com.example.plantname.Retrofit.ApiInterfaceTrefle;
import com.example.plantname.Retrofit.RetrofitClient;
import com.example.plantname.Retrofit.RetrofitClientPexels;
import com.example.plantname.modelsPexels.Photo;
import com.example.plantname.modelsPexels.Photos;
import com.example.plantname.modelsTrefle.Plants;
import com.example.plantname.modelsTrefle.data;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Trefle {
    private String[] responseArray;

    public String[] makeSearchApiCall(String search) {
        ApiInterfaceTrefle apiInterfaceTrefle;
        apiInterfaceTrefle = RetrofitClient.getRetrofitInstance("https://trefle.io/").create(ApiInterfaceTrefle.class);
        Call<Plants> call = apiInterfaceTrefle.getSearchData("WPPPrJr3fBWhOI22pU9NL4KtZRixTVlkqmn1cI2DB0Q", search);

        call.enqueue(new Callback<Plants>() {
            @RequiresApi(api = Build.VERSION_CODES.N)
            @Override
            public void onResponse(Call<Plants> call, Response<Plants> response) {
                if (response.isSuccessful()) {
                    List<data> response_get = response.body().getData();
                    responseArray = new String[response_get.size()];
                    for (int i = 0; i < response_get.size(); i++) {
                        responseArray[i] = response_get.get(i).getScientificName();
                    }
                }
            }

            @Override
            public void onFailure(Call<Plants> call, Throwable t) {

            }
        });
        return responseArray;
    }
}
