package com.example.ccsm;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

interface cmInterface {


    @GET("latest")
    Call<List<Currencies>>  getCurrencies();
}
