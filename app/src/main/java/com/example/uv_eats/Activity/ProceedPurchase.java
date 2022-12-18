package com.example.uv_eats.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.uv_eats.databinding.ActivityProceedPurchaseBinding;

public class ProceedPurchase extends AppCompatActivity {

    private ActivityProceedPurchaseBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityProceedPurchaseBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
    }
}