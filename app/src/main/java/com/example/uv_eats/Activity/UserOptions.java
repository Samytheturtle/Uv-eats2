package com.example.uv_eats.Activity;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;

import com.example.uv_eats.Activity.POCO.Auth;
import com.example.uv_eats.databinding.ActivityUserOptionsBinding;

public class UserOptions extends AppCompatActivity {
    public String tipoUsuario="";
    public Auth autenticacion;
    private ActivityUserOptionsBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityUserOptionsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        Bundle objetoRecibido=getIntent().getExtras();

        autenticacion= (Auth) objetoRecibido.getSerializable("Auth");
        Bundle objeto2Recibido=getIntent().getExtras();
        tipoUsuario=(String) objeto2Recibido.getSerializable("tipo");

        binding.FavoriteProducts.setOnClickListener(v ->{
            startFavoriteProducts(autenticacion,tipoUsuario);
        });

        binding.ProceedPurchase.setOnClickListener(v ->{
            startProceedPurchase();
        });

        binding.ConsultOrders.setOnClickListener(v ->{
            startConsultOrders();
        });
    }

    private void startConsultOrders() {
        cajadealerta("CONSULTA DE ORDENES==> Proximante... Se desarrollara en un futuro :D");
    }

    private void startProceedPurchase() {
        //Intent intent =  new Intent(this, ProceedPurchase.class);
        //startActivity(intent);
        cajadealerta("PROCEDER A PEDIDO==> Proximante... Se desarrollara en un futuro :D");
    }

    private void startFavoriteProducts(Auth auth, String tipoUsuario) {
        Intent intent =  new Intent(this, FavoriteProducts.class);
        startActivity(intent);
        Bundle bundle = new Bundle();
        Bundle bundle2 = new Bundle();

        bundle.putSerializable("Auth",auth);
        intent.putExtras(bundle);
        bundle2.putSerializable("tipo",tipoUsuario);
        intent.putExtras(bundle2);
        startActivity(intent);
    }
    public void cajadealerta(String tipoError){
        AlertDialog.Builder alerta = new AlertDialog.Builder(UserOptions.this);
        alerta.setMessage(tipoError).setCancelable(false).setPositiveButton("Ok", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.cancel();
            }
        });
        AlertDialog titulo = alerta.create();
        titulo.setTitle("ADVERTENCIA ");
        titulo.show();
    }
}