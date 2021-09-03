package com.masorone.foodtesthammersystem.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.masorone.foodtesthammersystem.databinding.SaleItemBinding;
import com.masorone.foodtesthammersystem.models.SaleModel;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

public class SaleAdapter extends RecyclerView.Adapter<SaleAdapter.SaleViewHolder> {

    private ArrayList<SaleModel> sales;

    public SaleAdapter(ArrayList<SaleModel> sales) {
        this.sales = sales;
    }

    @NonNull
    @NotNull
    @Override
    public SaleAdapter.SaleViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        return new SaleViewHolder(SaleItemBinding.inflate(
                LayoutInflater.from(parent.getContext()),
                parent,
                false));
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull SaleAdapter.SaleViewHolder holder, int position) {
        holder.mBinding.imageViewSaleItem.setImageDrawable(sales.get(position).getImageView());
    }

    @Override
    public int getItemCount() {
        return sales.size();
    }

    public class SaleViewHolder extends RecyclerView.ViewHolder {

        private SaleItemBinding mBinding;

        public SaleViewHolder(@NonNull @NotNull SaleItemBinding binding) {
            super(binding.getRoot());
            mBinding = binding;
        }
    }
}
