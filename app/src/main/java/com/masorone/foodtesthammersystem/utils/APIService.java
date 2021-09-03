package com.masorone.foodtesthammersystem.utils;

import com.masorone.foodtesthammersystem.models.PizzaModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface APIService {

    @GET("image")
    Call<List<PizzaModel>> getPizzaList();
}
