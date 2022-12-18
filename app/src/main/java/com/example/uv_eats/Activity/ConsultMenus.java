package com.example.uv_eats.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.uv_eats.databinding.ActivityConsultMenusBinding;

public class ConsultMenus extends AppCompatActivity {

    private ActivityConsultMenusBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityConsultMenusBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
    }
}