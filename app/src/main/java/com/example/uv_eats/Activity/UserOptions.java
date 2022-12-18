package com.example.uv_eats.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.example.uv_eats.databinding.ActivityUserOptionsBinding;

public class UserOptions extends AppCompatActivity {

    private ActivityUserOptionsBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityUserOptionsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.FavoriteProducts.setOnClickListener(v ->{
            startFavoriteProducts();
        });

        binding.ProceedPurchase.setOnClickListener(v ->{
            startProceedPurchase();
        });

        binding.ConsultOrders.setOnClickListener(v ->{
            startConsultOrders();
        });
    }

    private void startConsultOrders() {
        Intent intent =  new Intent(this, ConsultOrders.class);
        startActivity(intent);
    }

    private void startProceedPurchase() {
        Intent intent =  new Intent(this, ProceedPurchase.class);
        startActivity(intent);
    }

    private void startFavoriteProducts() {
        Intent intent =  new Intent(this, FavoriteProducts.class);
        startActivity(intent);
    }
}