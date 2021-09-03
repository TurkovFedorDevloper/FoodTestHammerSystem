package com.masorone.foodtesthammersystem.fragments.pizza;


import android.util.Log;
import android.widget.Toast;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.masorone.foodtesthammersystem.models.PizzaModel;
import com.masorone.foodtesthammersystem.utils.APIService;
import com.masorone.foodtesthammersystem.utils.RetrofitInstance;

import org.jetbrains.annotations.NotNull;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PizzaViewModel extends ViewModel {

    private MutableLiveData<List<PizzaModel>> pizzaList;

    public PizzaViewModel() {
        pizzaList = new MutableLiveData<>();
    }

    public MutableLiveData<List<PizzaModel>> getPizzaListObserver() {
        return pizzaList;
    }

    public void makeApiCall() {
        Log.i("NOOOO", "ff");
        APIService apiService = RetrofitInstance.getRetrofitClient().create(APIService.class);
        Call<List<PizzaModel>> call = apiService.getPizzaList();
        call.enqueue(new Callback<List<PizzaModel>>() {
            @Override
            public void onResponse(@NotNull Call<List<PizzaModel>> call, @NotNull Response<List<PizzaModel>> response) {
                pizzaList.postValue(response.body());
                Log.i("NOOOO", "response.body().get(0).getImage()");
            }

            @Override
            public void onFailure(Call<List<PizzaModel>> call, Throwable t) {
                pizzaList.postValue(null);
                Log.i("NOOOO", t.getMessage());
            }
        });
    }
}
