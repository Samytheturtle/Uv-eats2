package com.example.uv_eats.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.uv_eats.Activity.Adapter.ReclyclerViewProduct;
import com.example.uv_eats.Activity.Adapter.ReclyclerViewProductFav;
import com.example.uv_eats.Activity.HttpRequest.API;
import com.example.uv_eats.Activity.HttpRequest.ApiMetodos;
import com.example.uv_eats.Activity.POCO.Auth;
import com.example.uv_eats.Activity.POCO.Modelo.ImagenProducto;
import com.example.uv_eats.Activity.POCO.Modelo.Producto;
import com.example.uv_eats.R;
import com.example.uv_eats.databinding.ActivityFavoriteProductsBinding;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class FavoriteProducts extends AppCompatActivity {
    public String tipoUsuario="";
    public Auth autenticacion;
    private ActivityFavoriteProductsBinding binding;
    public List<Producto> productoRecuperacionEstatico=new ArrayList<>();

    private RecyclerView recyclerViewProductos;
    private ReclyclerViewProductFav adaptadorProductos;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityFavoriteProductsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        Bundle objetoRecibido=getIntent().getExtras();
        autenticacion= (Auth) objetoRecibido.getSerializable("Auth");
        Bundle objeto2Recibido=getIntent().getExtras();
        tipoUsuario=(String) objeto2Recibido.getSerializable("tipo");

        cargarProductosFav();
        cargarObjetosProductos();

    }

    private void cargarProductosFav() {
        Retrofit retrofit = new Retrofit.Builder().baseUrl(API.getUrl()).addConverterFactory((GsonConverterFactory.create())).build();
        ApiMetodos apiService = retrofit.create(ApiMetodos.class);

        Call<List<Producto>> call = apiService.getProductoFav(autenticacion.getId(),autenticacion.getToken());

        System.out.println("cargarMenu4 "+autenticacion.getToken());
        call.enqueue(new Callback<List<Producto>>() {
            @Override
            public void onResponse(Call<List<Producto>> call, Response<List<Producto>> response) {
                productoRecuperacionEstatico=response.body();

            }

            @Override
            public void onFailure(Call<List<Producto>> call, Throwable t) {

            }
        });
    }
    private void cargarObjetosProductos(){
        Retrofit retrofit = new Retrofit.Builder().baseUrl(API.getUrl()).addConverterFactory((GsonConverterFactory.create())).build();
        ApiMetodos apiService = retrofit.create(ApiMetodos.class);

        Call<List<Producto>> call = apiService.getProducto(autenticacion.getToken());
        System.out.println("cargarMenu4 "+autenticacion.getToken());
        call.enqueue(new Callback<List<Producto>>() {
            @Override
            public void onResponse(Call<List<Producto>> call, Response<List<Producto>> response) {
                cargarImagenesProductos(response.body());
            }

            @Override
            public void onFailure(Call<List<Producto>> call, Throwable t) {

            }
        });
    }
    private void cargarImagenesProductos(List<Producto> productoItems){
        Retrofit retrofit = new Retrofit.Builder().baseUrl(API.getUrl()).addConverterFactory((GsonConverterFactory.create())).build();
        ApiMetodos apiService = retrofit.create(ApiMetodos.class);
        Call<List<ImagenProducto>> call= apiService.getImagenProducto();
        call.enqueue(new Callback<List<ImagenProducto>>() {
            @Override
            public void onResponse(Call<List<ImagenProducto>> call, Response<List<ImagenProducto>> response) {
                System.out.println("-------------------"+response.body().get(12).getUrl());
                agregarImagenesProductosDatos(productoItems,response.body());
            }

            @Override
            public void onFailure(Call<List<ImagenProducto>> call, Throwable t) {

            }
        });
    }
    private void agregarImagenesProductosDatos(List<Producto> producto, List<ImagenProducto> menuImagens){
        for(int i=0;i<producto.size();i++){
            producto.get(i).setUrl(menuImagens.get(i).getUrl());
            /*System.out.println(producto.get(i).getIdProducto());
            System.out.println(producto.get(i).getNombre());
            System.out.println(producto.get(i).getDescripcion());
            System.out.println(producto.get(i).getPrecio());
            System.out.println(producto.get(i).getNumLike());
            System.out.println(producto.get(i).getNumDislike());
            System.out.println(producto.get(i).getUrl());*/
        }
        for(int i=0;i<productoRecuperacionEstatico.size();i++){
            for(int z=0;z<producto.size();z++){
                if(productoRecuperacionEstatico.get(i).getIdProducto().equals(producto.get(z).getIdProducto())){
                    System.out.println("AAAAAAAAAAAA");
                    productoRecuperacionEstatico.get(i).setUrl(producto.get(z).getUrl());
                    productoRecuperacionEstatico.get(i).setNombre(producto.get(z).getNombre());
                    productoRecuperacionEstatico.get(i).setDescripcion(producto.get(z).getDescripcion());
                    productoRecuperacionEstatico.get(i).setPrecio(producto.get(z).getPrecio());
                    productoRecuperacionEstatico.get(i).setUnidades(producto.get(z).getUnidades());
                    productoRecuperacionEstatico.get(i).setNumDislike(producto.get(z).getNumDislike());
                    productoRecuperacionEstatico.get(i).setNumLike(producto.get(z).getNumLike());
                    System.out.println(productoRecuperacionEstatico.get(i).getNombre());
                    System.out.println(productoRecuperacionEstatico.get(i).getDescripcion());
                    System.out.println(productoRecuperacionEstatico.get(i).getPrecio());
                    System.out.println(productoRecuperacionEstatico.get(i).getUnidades());
                    System.out.println(productoRecuperacionEstatico.get(i).getNumDislike());
                    System.out.println( productoRecuperacionEstatico.get(i).getNumLike());
                    System.out.println(productoRecuperacionEstatico.get(i).getUrl());
                }
            }
        }
        //productoRecuperacionEstatico=producto;
        cargarElementosProductos();
    }
    public void cargarElementosProductos() {
        recyclerViewProductos=(RecyclerView) findViewById(R.id.eq_recycler_product);
        recyclerViewProductos.setLayoutManager(new LinearLayoutManager(this));
        adaptadorProductos=new ReclyclerViewProductFav(productoRecuperacionEstatico);
        recyclerViewProductos.setAdapter(adaptadorProductos);
        System.out.println("AAAAAAA"+adaptadorProductos.getItemCount());

    }
}