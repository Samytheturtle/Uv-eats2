package com.example.uv_eats.Activity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import com.google.gson.Gson;
import android.os.Message;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;


import com.example.uv_eats.Activity.HttpRequest.API;
import com.example.uv_eats.Activity.HttpRequest.ApiMetodos;
import com.example.uv_eats.Activity.POCO.Auth;
import com.example.uv_eats.Activity.POCO.Usuario;
import com.example.uv_eats.databinding.ActivityMainBinding;
import com.google.gson.GsonBuilder;

import java.io.IOException;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class MainActivity extends AppCompatActivity {
    Auth authVerificacion = new Auth();
    private ActivityMainBinding binding;
    public String usernameText;
    public String passwordText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.ButtonLogin.setOnClickListener(v ->{
            String username = String.valueOf(binding.TextUser.getText());
            String password = String.valueOf(binding.TextPassword.getText());
            //RECORDATORIO agregar inicio de sesion exitos.
            //Toast.makeText(MainActivity.this, "Username:" + username + " Password:" + password.toString(), Toast.LENGTH_LONG).show();
            validarCampos();
        });


    }
    public void validarCampos(){
        usernameText=String.valueOf(binding.TextUser.getText());
        passwordText=String.valueOf(binding.TextPassword.getText());

        if(usernameText.equals("")||passwordText.equals("")){
            cajadealerta("Campos vacios, por favor verificar");
            //startPrincipalTab2();
        }else{
            ConsumoAPI();
        }
    }
    private void ConsumoAPI(){

        Usuario usuarioConsulta = new Usuario(usernameText,passwordText);
        Retrofit retrofit = new Retrofit.Builder().baseUrl(API.getUrl()).addConverterFactory((GsonConverterFactory.create())).build();
        ApiMetodos apiService = retrofit.create(ApiMetodos.class);


        Call<Auth> call = apiService.getUsuario(usuarioConsulta);

        call.enqueue(new Callback<Auth>() {
            @Override
            public void onResponse(Call<Auth> call, Response<Auth> response) {
                if(response.isSuccessful()){
                    authVerificacion=response.body();
                    if(authVerificacion.getMessage().equals("authenticated user")){
                        char[] verificacionTipoUsuario=usernameText.toCharArray();

                        if(verificacionTipoUsuario[0]=='z'&& verificacionTipoUsuario[1]=='s'){
                            startPrincipalTab(authVerificacion,"ESTUDIANTE");
                        }else{
                            startPrincipalTab(authVerificacion,"EMPLEADO");
                        }

                    }else{
                        cajadealerta("Error usuario no valido");
                    }
                }else{
                    cajadealerta("Error de inicio");
                }
            }

            @Override
            public void onFailure(Call<Auth> call, Throwable t) {

            }
        });
    }

    private void startPrincipalTab(Auth auth, String tipoUsuario){
        Intent intent = new Intent(this, PrincipalTabMenuActivity.class);
        Bundle bundle = new Bundle();
        Bundle bundle2 = new Bundle();

        bundle.putSerializable("Auth",auth);
        intent.putExtras(bundle);
        bundle2.putSerializable("tipo",tipoUsuario);
        intent.putExtras(bundle2);
        startActivity(intent);
    }
    private void startPrincipalTab2(){
        Intent intent = new Intent(this, PrincipalTabMenuActivity.class);
        startActivity(intent);
    }
    public void cajadealerta(String tipoError){
        AlertDialog.Builder alerta = new AlertDialog.Builder(MainActivity.this);
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
