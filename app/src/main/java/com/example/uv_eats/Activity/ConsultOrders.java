package com.example.uv_eats.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.uv_eats.databinding.ActivityConsultOrdersBinding;


public class ConsultOrders extends AppCompatActivity {

    private ActivityConsultOrdersBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityConsultOrdersBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
    }
}