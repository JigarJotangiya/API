package com.example.api;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiClient {

    public static final String URL = "https://api.publicapis.org/";
    public static Retrofit retrofit ;
    public static Retrofit getApiclient(){

        retrofit = new Retrofit.Builder().baseUrl(URL).addConverterFactory( GsonConverterFactory.create()).build();
        return retrofit;
    }

}
