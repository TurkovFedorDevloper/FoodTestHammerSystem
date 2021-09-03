package com.masorone.foodtesthammersystem.adapters;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.masorone.foodtesthammersystem.R;
import com.masorone.foodtesthammersystem.databinding.PizzaItemBinding;
import com.masorone.foodtesthammersystem.models.PizzaModel;
import com.squareup.picasso.Picasso;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class PizzaAdapter extends RecyclerView.Adapter<PizzaAdapter.PizzaViewHolder> {

    private List<PizzaModel> pizzaModels;

    public PizzaAdapter(List<PizzaModel> pizzaModels) {
        this.pizzaModels = pizzaModels;
    }

    public void setPizzaModels(List<PizzaModel> pizzaModels) {
        this.pizzaModels = pizzaModels;
        notifyDataSetChanged();
    }

    @NonNull
    @NotNull
    @Override
    public PizzaAdapter.PizzaViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        return new PizzaAdapter.PizzaViewHolder(PizzaItemBinding.inflate(
                LayoutInflater.from(parent.getContext()),
                parent,
                false));
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull PizzaAdapter.PizzaViewHolder holder, int position) {
        PizzaModel pizzaModel = pizzaModels.get(position);
        if (pizzaModel.getImage() != "null") {
            Picasso.get().load(pizzaModel.getImage()).into(holder.mBinding.iconPizza);
        } else {
            holder.mBinding.iconPizza.setBackgroundResource(R.drawable.ic_launcher_foreground);
        }
    }

    @Override
    public int getItemCount() {
        return pizzaModels.size();
    }

    public class PizzaViewHolder extends RecyclerView.ViewHolder {

        private PizzaItemBinding mBinding;

        public PizzaViewHolder(@NonNull @NotNull PizzaItemBinding binding) {
            super(binding.getRoot());
            mBinding = binding;
        }
    }
}
