package com.xlukog.ReportClient.retrofit;
import com.google.gson.Gson;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class RetrofitService {

    private Retrofit retrofit = new Retrofit.Builder()
            .baseUrl("https://d51e-27-4-109-125.eu.ngrok.io")
            .addConverterFactory(GsonConverterFactory.create(new Gson()))
            .build();
    public RetrofitService(){
        initializeRetrofit();
    }

    private void initializeRetrofit() {
    }
    public Retrofit getRetrofit(){
        return retrofit;
    }
}
