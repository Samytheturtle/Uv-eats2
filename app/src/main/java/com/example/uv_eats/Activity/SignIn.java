package com.example.uv_eats.Activity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.example.uv_eats.Activity.HttpRequest.API;
import com.example.uv_eats.Activity.HttpRequest.ApiMetodos;
import com.example.uv_eats.Activity.POCO.Auth;
import com.example.uv_eats.Activity.POCO.Usuario;
import com.example.uv_eats.databinding.ActivitySignInBinding;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class SignIn extends AppCompatActivity {
    String tipoUsuario="";
    public Auth autenticacion;
    private ActivitySignInBinding binding;
    public String usernameText;
    public String passwordText;
    public String appellidText;
    public String confirPasswordText;
    public String correoText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySignInBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        Bundle objetoRecibido=getIntent().getExtras();
        autenticacion= (Auth) objetoRecibido.getSerializable("Auth");
        Bundle objeto2Recibido=getIntent().getExtras();
        tipoUsuario=(String) objeto2Recibido.getSerializable("tipo");

        binding.ButtonRegister.setOnClickListener(v -> {
            usernameText = String.valueOf(binding.TextUser.getText());
            passwordText = String.valueOf(binding.TextPassword.getText());
            appellidText = String.valueOf(binding.TextName.getText());
            correoText=String.valueOf(binding.TextEmail.getText());
            confirPasswordText=String.valueOf(binding.TextRepitPassword.getText());

            validarCampos();
            //returnEmployeeOptions();
        });
        binding.ButtonReturn.setOnClickListener(v -> {
            returnEmployeeOptions(autenticacion,tipoUsuario);
        });
    }
    public void validarCampos(){
        if(usernameText.equals("")||passwordText.equals("")||appellidText.equals("")||correoText.equals("")||confirPasswordText.equals("")){

            //startPrincipalTab2();
        }else if(!confirPasswordText.equals(passwordText)||!passwordText.equals(confirPasswordText)){
            cajadealerta("Error: las contrasenia no coninciden, favor de verificar.");

        }else{
            ConsumoAPI();
            returnEmployeeOptions(autenticacion,tipoUsuario);
        }
    }
    private void ConsumoAPI(){

        Usuario usuarioNew = new Usuario(correoText,passwordText,usernameText,appellidText);
        Retrofit retrofit = new Retrofit.Builder().baseUrl(API.getUrl()).addConverterFactory((GsonConverterFactory.create())).build();
        ApiMetodos apiService = retrofit.create(ApiMetodos.class);
        Call<Usuario> call = apiService.addUsuario(usuarioNew);

        call.enqueue(new Callback<Usuario>() {
            @Override
            public void onResponse(Call<Usuario> call, Response<Usuario> response) {
                Toast.makeText(SignIn.this, "Usuario: "+response.body().getNombre()+" Registrado con exito", Toast.LENGTH_LONG).show();
            }

            @Override
            public void onFailure(Call<Usuario> call, Throwable t) {

            }
        });

    }
    private void returnEmployeeOptions(Auth auth, String tipoUsuario){
        Intent intent = new Intent(this, EmployeeOptions.class);
        Bundle bundle = new Bundle();
        Bundle bundle2 = new Bundle();

        bundle.putSerializable("Auth",auth);
        intent.putExtras(bundle);
        bundle2.putSerializable("tipo",tipoUsuario);
        intent.putExtras(bundle2);
        startActivity(intent);
    }
    public void cajadealerta(String tipoError){
        AlertDialog.Builder alerta = new AlertDialog.Builder(SignIn.this);
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