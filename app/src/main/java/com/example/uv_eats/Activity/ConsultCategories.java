package com.example.uv_eats.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.uv_eats.databinding.ActivityConsultCategoriesBinding;

public class ConsultCategories extends AppCompatActivity {

    private ActivityConsultCategoriesBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityConsultCategoriesBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
    }
}