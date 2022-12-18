package com.example.uv_eats.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.example.uv_eats.databinding.ActivityEmployeeOptionsBinding;

public class EmployeeOptions extends AppCompatActivity {

    private ActivityEmployeeOptionsBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityEmployeeOptionsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.ButtonUserRegister.setOnClickListener(v ->{
            startUserRegister();
        });

        binding.ButtonCategoryRegister.setOnClickListener(v ->{
            startCategoryRegister();
        });
        binding.ButtonProductRegister.setOnClickListener(v ->{
            startProductRegister();
        });

        binding.ButtonEditProduct.setOnClickListener(v ->{
            startEditProduct();
        });

        binding.ButtonEditCategory.setOnClickListener(v ->{
            startEditCategory();
        });

        binding.ButtonConsultCategories.setOnClickListener(v ->{
            startConsultCategories();
        });

        binding.ButtonConsultMenus.setOnClickListener(v ->{
            startConsultMenus();
        });

        binding.ButtonConsultProducts.setOnClickListener(v ->{
            startConsultProducts();
        });
    }

    private void startConsultProducts() {
        Intent intent = new Intent(this, ConsultProducts.class);
        startActivity(intent);
    }

    private void startConsultMenus() {
        Intent intent = new Intent(this, ConsultMenus.class);
        startActivity(intent);
    }

    private void startConsultCategories() {
        Intent intent = new Intent(this, ConsultCategories.class);
        startActivity(intent);
    }

    private void startEditCategory() {
        Intent intent = new Intent(this, CategoryEdit.class);
        startActivity(intent);
    }

    private void startEditProduct() {
        Intent intent = new Intent(this, ProductEdit.class);
        startActivity(intent);
    }

    private void startProductRegister() {
        Intent intent = new Intent(this, ProductRegister.class);
        startActivity(intent);
    }

    private void startCategoryRegister() {
        Intent intent = new Intent(this, CategoryRegister.class);
        startActivity(intent);
    }

    private void startUserRegister(){
        Intent intent = new Intent(this, SignIn.class);
        startActivity(intent);
    }

}