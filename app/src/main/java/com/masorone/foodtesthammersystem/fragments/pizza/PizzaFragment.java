package com.masorone.foodtesthammersystem.fragments.pizza;


import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.masorone.foodtesthammersystem.adapters.PizzaAdapter;
import com.masorone.foodtesthammersystem.databinding.FragmentPizzaBinding;
import com.masorone.foodtesthammersystem.models.PizzaModel;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;


public class PizzaFragment extends Fragment {

    private FragmentPizzaBinding binding;

    private PizzaViewModel viewModel;

    private List<PizzaModel> pizzaModels;
    private PizzaAdapter pizzaAdapter;

    @Override
    public void onViewCreated(@NonNull @NotNull View view, @Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        pizzaModels = new ArrayList<>();

        pizzaAdapter = new PizzaAdapter(pizzaModels);
        binding.recyclerViewPizza.setHasFixedSize(true);
        binding.recyclerViewPizza.setLayoutManager(new LinearLayoutManager(requireContext()));
        binding.recyclerViewPizza.setAdapter(pizzaAdapter);


        viewModel = new ViewModelProvider(requireActivity()).get(PizzaViewModel.class);
        viewModel.makeApiCall();
        viewModel.getPizzaListObserver().observe(requireActivity(), pizzaModels -> {
            if (pizzaModels != null) {
                this.pizzaModels = pizzaModels;
                pizzaAdapter.setPizzaModels(pizzaModels);
            } else {
                Toast.makeText(requireContext(), "Нет сети", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentPizzaBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}