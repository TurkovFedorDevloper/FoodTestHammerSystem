package com.masorone.foodtesthammersystem.fragments;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.viewpager.widget.ViewPager;


import com.masorone.foodtesthammersystem.R;
import com.masorone.foodtesthammersystem.adapters.SaleAdapter;
import com.masorone.foodtesthammersystem.adapters.ViewPagerAdapter;
import com.masorone.foodtesthammersystem.databinding.FragmentMenuBinding;
import com.masorone.foodtesthammersystem.fragments.pizza.PizzaFragment;
import com.masorone.foodtesthammersystem.models.SaleModel;

import java.util.ArrayList;
import java.util.Arrays;


public class MenuFragment extends Fragment {

    private FragmentMenuBinding binding;
    private ArrayList<SaleModel> sales;
    private SaleAdapter saleAdapter;
    private ViewPagerAdapter viewPagerAdapter;
    private ViewPager viewPager;

    @SuppressLint("UseCompatLoadingForDrawables")
    @Override
    public void onViewCreated(@NonNull @org.jetbrains.annotations.NotNull View view, @Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        SaleModel saleModel1 = new SaleModel(getResources().getDrawable(R.drawable.bunner_1));
        SaleModel saleModel2 = new SaleModel(getResources().getDrawable(R.drawable.bunner_2));
        SaleModel saleModel3 = new SaleModel(getResources().getDrawable(R.drawable.bunner_3));
        SaleModel saleModel4 = new SaleModel(getResources().getDrawable(R.drawable.bunner_4));

        sales = new ArrayList<>(Arrays.asList(
                saleModel1,
                saleModel2,
                saleModel3,
                saleModel4
        ));

        saleAdapter = new SaleAdapter(sales);

        binding.recyclerViewSales.setHasFixedSize(true);
        binding.recyclerViewSales.setLayoutManager(new LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false));
        binding.recyclerViewSales.setAdapter(saleAdapter);

        viewPager = requireActivity().findViewById(R.id.view_pager);
        binding.slidingTabs.setupWithViewPager(viewPager);

        viewPagerAdapter = new ViewPagerAdapter(requireActivity().getSupportFragmentManager(), FragmentPagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
        viewPagerAdapter.addFragment(new PizzaFragment(), getString(R.string.pizza));
        viewPagerAdapter.addFragment(new ComboFragment(), getString(R.string.combo));
        viewPagerAdapter.addFragment(new DessertFragment(), getString(R.string.deserts));
        viewPagerAdapter.addFragment(new DrinkFragment(), getString(R.string.drinks));
        viewPagerAdapter.addFragment(new OtherProductsFragment(), getString(R.string.other_products));

        viewPager.setAdapter(viewPagerAdapter);
    }

    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentMenuBinding.inflate(inflater, container, false);

        String[] array = getResources().getStringArray(R.array.cites);
        ArrayAdapter arrayAdapter = new ArrayAdapter(requireContext(), R.layout.dropdown_item, array);
        binding.autoCompleteTextView.setAdapter(arrayAdapter);

        return binding.getRoot();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}