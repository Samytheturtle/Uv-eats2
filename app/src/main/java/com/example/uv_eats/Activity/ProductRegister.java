package com.example.uv_eats.Activity;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.widget.ArrayAdapter;
import android.widget.Spinner;


import com.example.uv_eats.Activity.HttpRequest.API;
import com.example.uv_eats.Activity.HttpRequest.ApiMetodos;
import com.example.uv_eats.Activity.POCO.Auth;
import com.example.uv_eats.Activity.POCO.Modelo.Categoria;
import com.example.uv_eats.Activity.POCO.Usuario;
import com.example.uv_eats.R;
import com.example.uv_eats.databinding.ActivityProductRegisterBinding;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ProductRegister extends AppCompatActivity {
    String tipoUsuario="";
    public Auth autenticacion;
    private ActivityProductRegisterBinding binding;
    private Spinner spinnerCategorias;
    public List<Categoria> listCategorias=new ArrayList<>();

    public String nombre;
    public String descripcion;
    public String precio;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityProductRegisterBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        Bundle objetoRecibido=getIntent().getExtras();
        autenticacion= (Auth) objetoRecibido.getSerializable("Auth");
        Bundle objeto2Recibido=getIntent().getExtras();
        tipoUsuario=(String) objeto2Recibido.getSerializable("tipo");

        cargarCategorias();
        poblarEspiner();
        binding.ImageProduct.setOnClickListener(v ->{
            chargeImage();
        });
        binding.ButtonRegisterProduct.setOnClickListener(v ->{
            nombre = String.valueOf(binding.TextNameProduct.getText());
            descripcion = String.valueOf(binding.TextDescription.getText());
            precio = String.valueOf(binding.TextPrice.getText());

            startActivityEmployeeOptions();
        });



    }

    private void cargarCategorias() {
        Retrofit retrofit = new Retrofit.Builder().baseUrl(API.getUrl()).addConverterFactory((GsonConverterFactory.create())).build();
        ApiMetodos apiService = retrofit.create(ApiMetodos.class);
        Call<List<Categoria>> call= apiService.getCategorias(autenticacion.getToken());

        call.enqueue(new Callback<List<Categoria>>() {
            @Override
            public void onResponse(Call<List<Categoria>> call, Response<List<Categoria>> response) {
                listCategorias=response.body();
            }

            @Override
            public void onFailure(Call<List<Categoria>> call, Throwable t) {

            }
        });
    }

    private void poblarEspiner() {
        spinnerCategorias=findViewById(R.id.OptionsCategory);
        //ArrayAdapter<String> spinnerAdapter = new ArrayAdapter<String>(getC,android.R.layout.simple_spinner_item, listCategorias);
        //spinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
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