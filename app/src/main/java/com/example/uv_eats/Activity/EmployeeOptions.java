package com.example.uv_eats.Activity;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;

import com.example.uv_eats.Activity.POCO.Auth;
import com.example.uv_eats.databinding.ActivityEmployeeOptionsBinding;

public class EmployeeOptions extends AppCompatActivity {
    String tipoUsuario="";
    public Auth autenticacion;
    private ActivityEmployeeOptionsBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityEmployeeOptionsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        Bundle objetoRecibido=getIntent().getExtras();
        autenticacion= (Auth) objetoRecibido.getSerializable("Auth");
        Bundle objeto2Recibido=getIntent().getExtras();
        tipoUsuario=(String) objeto2Recibido.getSerializable("tipo");

        binding.ButtonUserRegister.setOnClickListener(v ->{
            startUserRegister(autenticacion,tipoUsuario);
        });

        binding.ButtonCategoryRegister.setOnClickListener(v ->{
            startCategoryRegister();
        });
        binding.ButtonProductRegister.setOnClickListener(v ->{
            startProductRegister(autenticacion,tipoUsuario);
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
        /*Intent intent = new Intent(this, ConsultProducts.class);
        startActivity(intent);*/
        cajadealerta("Consultar productos--> PROXIMAMENTE...:D");
    }

    private void startConsultMenus() {
        /*Intent intent = new Intent(this, ConsultMenus.class);
        startActivity(intent);*/
        cajadealerta("Consultar de Menu--> PROXIMAMENTE...:D");
    }

    private void startConsultCategories() {
        /*Intent intent = new Intent(this, ConsultCategories.class);
        startActivity(intent);*/
        cajadealerta("Consultar de categorias--> PROXIMAMENTE...:D");
    }

    private void startEditCategory() {
        //Intent intent = new Intent(this, CategoryEdit.class);
        //startActivity(intent);
        cajadealerta("Edicion de categorias--> PROXIMAMENTE...:D");
    }

    private void startEditProduct() {
        /*Intent intent = new Intent(this, ProductEdit.class);
        startActivity(intent);*/
        cajadealerta("edicion de productos--> PROXIMAMENTE...:D");
    }

    private void startProductRegister(Auth auth, String tipoUsuario) {
        /*Intent intent = new Intent(this, ProductRegister.class);
        Bundle bundle = new Bundle();
        Bundle bundle2 = new Bundle();
        startActivity(intent);

        bundle.putSerializable("Auth",auth);
        intent.putExtras(bundle);
        bundle2.putSerializable("tipo",tipoUsuario);
        intent.putExtras(bundle2);*/
        cajadealerta("Registro de productos--> PROXIMAMENTE...:D");


    }

    private void startCategoryRegister() {
        //Intent intent = new Intent(this, CategoryRegister.class);
        //startActivity(intent);
        cajadealerta("Registro de categorias--> PROXIMAMENTE...:D");
    }

    private void startUserRegister(Auth auth, String tipoUsuario){
        Intent intent = new Intent(this, SignIn.class);
        Bundle bundle = new Bundle();
        Bundle bundle2 = new Bundle();

        bundle.putSerializable("Auth",auth);
        intent.putExtras(bundle);
        bundle2.putSerializable("tipo",tipoUsuario);
        intent.putExtras(bundle2);
        startActivity(intent);

    }
    public void cajadealerta(String tipoError){
        AlertDialog.Builder alerta = new AlertDialog.Builder(EmployeeOptions.this);
        alerta.setMessage("ALERTA DE ERROR").setCancelable(false).setPositiveButton("Ok", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.cancel();
            }
        });
        AlertDialog titulo = alerta.create();
        titulo.setTitle(tipoError);
        titulo.show();
    }
}