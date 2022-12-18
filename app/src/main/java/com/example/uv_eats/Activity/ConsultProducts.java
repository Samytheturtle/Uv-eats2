package com.example.uv_eats.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.uv_eats.databinding.ActivityConsultProductsBinding;

public class ConsultProducts extends AppCompatActivity {

    private ActivityConsultProductsBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityConsultProductsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
    }
}