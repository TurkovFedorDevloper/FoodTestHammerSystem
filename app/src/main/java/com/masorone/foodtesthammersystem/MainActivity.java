package com.masorone.foodtesthammersystem;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;

import com.google.android.material.navigation.NavigationBarView;
import com.masorone.foodtesthammersystem.databinding.ActivityMainBinding;
import com.masorone.foodtesthammersystem.fragments.BasketFragment;
import com.masorone.foodtesthammersystem.fragments.MenuFragment;
import com.masorone.foodtesthammersystem.fragments.ProfileFragment;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);
        binding.bottomNavigationView.setOnItemSelectedListener(itemSelectedListener);
    }

    @SuppressLint("NonConstantResourceId")
    private final NavigationBarView.OnItemSelectedListener itemSelectedListener =
            item -> {

                Fragment selectedFragment = null;

                switch (item.getItemId()) {
                    case R.id.menu_fragment:
                        selectedFragment = new MenuFragment();
                        break;

                    case R.id.profile_fragment:
                        selectedFragment = new ProfileFragment();
                        break;

                    case R.id.basket_fragment:
                        selectedFragment = new BasketFragment();
                        break;
                }

                getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.fragment_container, selectedFragment)
                        .commit();

                return true;
            };
}