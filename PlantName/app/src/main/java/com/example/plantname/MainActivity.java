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
import android.widget.TextView;
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

public class MainActivity extends AppCompatActivity {
    private String[] responseArray;
    private String[] responseArrayPexels;
    private AutoCompleteTextView textView;
    private ArrayAdapter<String> adapter;
    private Button searchButton;
    private ListView listView;
    //private String[] fruits = {"Apple", "anana", "aherry", "ate", "arape", "Kiwi", "Mango", "Pear"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = findViewById(R.id.searchPlants);
        searchButton = findViewById(R.id.buttonSearchPhoto);
        listView = findViewById(R.id.backgroundListView);
        autoCompleteTextOnChange();
        buttonClick();

    }

    private void makeSearchApiCall(String search) {
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
                    adapter.clear();
                    adapter.addAll(responseArray);
                    adapter.notifyDataSetChanged();
                }
            }

            @Override
            public void onFailure(Call<Plants> call, Throwable t) {

            }
        });
    }

    private void autoCompleteTextOnChange() {
        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_dropdown_item_1line);
        textView.setThreshold(1);
        textView.setAdapter(adapter);
        textView.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                String search = textView.getText().toString();
                makeSearchApiCall(search);
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
    }

    private void buttonClick() {
        searchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                makePhotoApiCall();
            }
        });
    }

    private void makePhotoApiCall() {
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
    }
}