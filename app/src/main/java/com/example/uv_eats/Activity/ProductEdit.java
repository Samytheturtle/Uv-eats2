package com.example.uv_eats.Activity;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;

import com.example.uv_eats.databinding.ActivityProductEditBinding;

public class ProductEdit extends AppCompatActivity {

    private ActivityProductEditBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityProductEditBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        binding.ImageProduct.setOnClickListener(v ->{
            chargeImage();
        });
        binding.ButtonRegisterProduct.setOnClickListener(v ->{
            startActivityEmployeeOptions();
        });

    }

    private void startActivityEmployeeOptions() {
        Intent intent = new Intent(this, EmployeeOptions.class);
        startActivity(intent);
    }

    private void chargeImage() {
        Intent intent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        intent.setType("image/");
        startActivityForResult(intent.createChooser(intent, "Seleccionar imagen"), 10);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(resultCode == RESULT_OK){
            Uri Path= data.getData();
            binding.ImageProduct.setImageURI(Path);
        }
    }
}