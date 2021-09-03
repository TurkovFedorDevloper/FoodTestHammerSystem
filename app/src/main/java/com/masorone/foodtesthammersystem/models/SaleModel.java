package com.masorone.foodtesthammersystem.models;

import android.graphics.drawable.Drawable;
import android.widget.ImageView;

public class SaleModel {
    private Drawable imageView;

    public SaleModel(Drawable imageView) {
        this.imageView = imageView;
    }

    public Drawable getImageView() {
        return imageView;
    }

    public void setImageView(Drawable imageView) {
        this.imageView = imageView;
    }
}
