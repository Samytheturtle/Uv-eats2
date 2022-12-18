package com.example.uv_eats.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.uv_eats.databinding.ActivityFavoriteProductsBinding;

public class FavoriteProducts extends AppCompatActivity {

    private ActivityFavoriteProductsBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityFavoriteProductsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
    }
}