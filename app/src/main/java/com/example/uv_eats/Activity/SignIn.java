package com.example.uv_eats.Activity;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.example.uv_eats.databinding.ActivitySignInBinding;

public class SignIn extends AppCompatActivity {

    private ActivitySignInBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySignInBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        binding.ButtonRegister.setOnClickListener(v -> {
            returnEmployeeOptions();
        });
        binding.ButtonReturn.setOnClickListener(v -> {
            returnEmployeeOptions();
        });
    }

    private void returnEmployeeOptions(){
        Intent intent = new Intent(this, EmployeeOptions.class);
        startActivity(intent);
    }
}