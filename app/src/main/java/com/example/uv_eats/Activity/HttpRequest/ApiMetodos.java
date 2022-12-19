package com.example.uv_eats.Activity.HttpRequest;
import com.example.uv_eats.Activity.POCO.Auth;
import com.example.uv_eats.Activity.POCO.Modelo.MenuImagen;
import com.example.uv_eats.Activity.POCO.Modelo.MenuProducto;
import com.example.uv_eats.Activity.POCO.Usuario;
import com.google.gson.Gson;

import java.util.List;
import java.util.Map;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Part;
import retrofit2.http.Path;
import retrofit2.http.Query;
import retrofit2.http.QueryMap;

public interface ApiMetodos {
    //Metodos Usuario
    @Headers({"Content-Type: application/json"})
    @POST("api/auth")
    Call<Auth> getUsuario(@Body Usuario usuarioConsulta);

    //metodos menu
    //@Headers({"Content-Type: application/json"})
    @GET("api/Menu/")
    Call<List<MenuProducto>> getMenu(@Header("Authorization")String token);

    //metodos archivo
    @GET("api/archivo/getMenu")
    Call<List<MenuImagen>> getMenuArchivos();

}
