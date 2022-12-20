package com.example.uv_eats.Activity.HttpRequest;
import com.example.uv_eats.Activity.POCO.Auth;
import com.example.uv_eats.Activity.POCO.Modelo.Carrito;
import com.example.uv_eats.Activity.POCO.Modelo.ImagenProducto;
import com.example.uv_eats.Activity.POCO.Modelo.MenuImagen;
import com.example.uv_eats.Activity.POCO.Modelo.MenuProducto;
import com.example.uv_eats.Activity.POCO.Modelo.OrdenProducto;
import com.example.uv_eats.Activity.POCO.Modelo.Producto;
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

    //metodos Productos
    @GET("api/producto/")
    Call<List<Producto>> getProducto(@Header("Authorization")String token);
    @GET("api/producto/getFav/{idUsuario}")
    Call<List<Producto>> getProductoFav(@Path("idUsuario")int idUsuario, @Header("Authorization")String token);

    //metodos Carrito
    @GET("api/carro/carroProducto/{idUsuario}")
    Call<List<Carrito>> getCarrito(@Path("idUsuario")int idUsuario, @Header("Authorization")String token);

    //metodos Orden producto
    @GET("api/orden/{idUsuario}")
    Call<List<OrdenProducto>> getOrdenproducto(@Path("idUsuario")int idUsuario, @Header("Authorization")String token);

    //metodos archivo
    @GET("api/archivo/getMenu")
    Call<List<MenuImagen>> getMenuArchivos();
    @GET("api/archivo/getProducto")
    Call<List<ImagenProducto>> getImagenProducto();

}
