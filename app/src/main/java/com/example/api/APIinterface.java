package com.example.api;

import retrofit2.Call;
import retrofit2.http.GET;

public interface APIinterface {

    @GET("entries")
    Call<Modelclass> getdata();


}
