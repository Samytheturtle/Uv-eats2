package com.example.uv_eats.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import com.example.uv_eats.Activity.Adapter.ReclyclerViewCar;
import com.example.uv_eats.Activity.Adapter.ReclyclerViewMenu;
import com.example.uv_eats.Activity.Adapter.ReclyclerViewProduct;
import com.example.uv_eats.Activity.Adapter.ReclyclerViewRecord;
import com.example.uv_eats.Activity.Controller.PagerController;
import com.example.uv_eats.Activity.HttpRequest.API;
import com.example.uv_eats.Activity.HttpRequest.ApiMetodos;
import com.example.uv_eats.Activity.POCO.Auth;
import com.example.uv_eats.Activity.POCO.Modelo.Carrito;
import com.example.uv_eats.Activity.POCO.Modelo.ImagenProducto;
import com.example.uv_eats.Activity.POCO.Modelo.MenuImagen;
import com.example.uv_eats.Activity.POCO.Modelo.MenuProducto;
import com.example.uv_eats.Activity.POCO.Modelo.Orden;
import com.example.uv_eats.Activity.POCO.Modelo.OrdenProducto;
import com.example.uv_eats.Activity.POCO.Modelo.Producto;
import com.example.uv_eats.R;
import com.example.uv_eats.databinding.ActivityPrincipalTabMenuActivityBinding;
import com.google.android.material.tabs.TabItem;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class PrincipalTabMenuActivity extends AppCompatActivity {
    String tipoUsuario="";
    public Auth autenticacion;
    private ActivityPrincipalTabMenuActivityBinding binding;
    TabLayout tabLayout;
    ViewPager viewPager;
    TabItem tabProduct, tabCart, tabRecord;
    PagerController pagerAdapter;
    public String precioCarro;
    public List<MenuProducto> menuRecuperacionEstatico=new ArrayList<>();
    public List<Producto> productoRecuperacionEstatico=new ArrayList<>();
    public List<Carrito> carRecuperacionEstatico=new ArrayList<>();
    public List<OrdenProducto> historialRecuperacionEstatico=new ArrayList<>();

    private RecyclerView recyclerViewMenu;
    private ReclyclerViewMenu adaptadorMenu;
    private RecyclerView recyclerViewCar;
    private ReclyclerViewCar adaptadorCar;
    private RecyclerView recyclerViewProductos;
    private ReclyclerViewProduct adaptadorProductos;
    private RecyclerView recyclerViewRecord;
    private ReclyclerViewRecord adaptadorRecord;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityPrincipalTabMenuActivityBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        Bundle objetoRecibido=getIntent().getExtras();
        autenticacion= (Auth) objetoRecibido.getSerializable("Auth");
        Bundle objeto2Recibido=getIntent().getExtras();
        tipoUsuario=(String) objeto2Recibido.getSerializable("tipo");

        //cargadores de elementos del sistema
        cargarObjetosMenu();
        cargarObjetosProductos();
        cargarObjetosCarrito();
        cargarObjetosHistorial();


        //establecimiento de funcionamiento botones
        System.out.println(tipoUsuario);
        if(tipoUsuario.equals("ESTUDIANTE")){
            System.out.println("A");
            binding.OptionsImage.setVisibility(View.GONE);
        }

        binding.OptionsImage.setOnClickListener(v ->{
            startEmployeeOptions(autenticacion,tipoUsuario);

        });

        binding.ExitImage.setOnClickListener(v ->{
            startLogin();
        });

        binding.UserImage.setOnClickListener(v ->{

            startUserOptions(autenticacion,tipoUsuario);
        });

        tabLayout = binding.tabLayout;
        viewPager = binding.viewPager;
        tabProduct = binding.tabProducts;
        tabCart = binding.tabCart;
        tabRecord = binding.tabRecord;
        pagerAdapter = new PagerController(getSupportFragmentManager(), tabLayout.getTabCount(),autenticacion,precioCarro);
        viewPager.setAdapter(pagerAdapter);

        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tabmenu) {
                viewPager.setCurrentItem(tabmenu.getPosition());
                if(tabmenu.getPosition() == 1){
                    System.out.println("TABLA-PRO"+tabmenu.getPosition());
                    pagerAdapter.notifyDataSetChanged();
                    cargarElementosProductos();

                }
                if(tabmenu.getPosition() == 2){
                    System.out.println("TABLA-CAR"+tabmenu.getPosition());
                    pagerAdapter.notifyDataSetChanged();
                    cargarElementosCarrito();

                }
                if(tabmenu.getPosition() == 3){
                    System.out.println("TABLA-HIS"+tabmenu.getPosition());
                    pagerAdapter.notifyDataSetChanged();
                    cargarElementosOrdenesRealizadas();
                }
                if(tabmenu.getPosition() == 0){
                    System.out.println("TABLA-MENU"+tabmenu.getPosition());
                    pagerAdapter.notifyDataSetChanged();
                    cargarElementosMenu();
                }
                System.out.println("POSICION F "+tabmenu.getPosition());
            }
            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }
            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
    }
//cargar elementos Menu
    private void cargarObjetosMenu() {
        System.out.println("cargarMenu");
        Retrofit retrofit = new Retrofit.Builder().baseUrl(API.getUrl()).addConverterFactory((GsonConverterFactory.create())).build();
        System.out.println("cargarMenu1");
        ApiMetodos apiService = retrofit.create(ApiMetodos.class);
        System.out.println("cargarMenu3 "+autenticacion.getToken());

        Call<List<MenuProducto>> call = apiService.getMenu(autenticacion.getToken());
        System.out.println("cargarMenu4 "+autenticacion.getToken());
        call.enqueue(new Callback<List<MenuProducto>>() {
            @Override
            public void onResponse(Call<List<MenuProducto>> call, Response<List<MenuProducto>> response) {
                if (response.isSuccessful()) {
                    System.out.println("cargarMenu1 "+response.body().get(0).toString());
                    cargarImagenesMenu(response.body());
                } else {

                }
            }
            @Override
            public void onFailure(Call<List<MenuProducto>> call, Throwable t) {

            }
        });
    }
    private void cargarImagenesMenu(List<MenuProducto> menuitems){
        Retrofit retrofit = new Retrofit.Builder().baseUrl(API.getUrl()).addConverterFactory((GsonConverterFactory.create())).build();
        ApiMetodos apiService = retrofit.create(ApiMetodos.class);
        Call<List<MenuImagen>> call= apiService.getMenuArchivos();
        call.enqueue(new Callback<List<MenuImagen>>() {
            @Override
            public void onResponse(Call<List<MenuImagen>> call, Response<List<MenuImagen>> response) {
                if (response.isSuccessful()) {
                    agregarImagenesMenu(menuitems,response.body());
                } else {

                }
            }
            @Override
            public void onFailure(Call<List<MenuImagen>> call, Throwable t) {

            }
        });
    }
    private void agregarImagenesMenu(List<MenuProducto> menu, List<MenuImagen> menuImagens){
        int precio=0;
        for(int i=0;i<menu.size();i++){
            menu.get(i).setUrl(menuImagens.get(i).geturl());
            precio=(int)Math.floor(Math.random()*150);;
            menu.get(i).setPrecio(""+precio+"$");
            System.out.println(menu.get(i).getIdMenu());
            System.out.println(menu.get(i).getNombre());
            System.out.println(menu.get(i).getDescripcion());
            System.out.println(menu.get(i).getPrecio());
            System.out.println(menu.get(i).getUrl());
        }
        menuRecuperacionEstatico=menu;

    }

//Cargar elementos productos
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
                agregarImagenesProductos(productoItems,response.body());
            }

            @Override
            public void onFailure(Call<List<ImagenProducto>> call, Throwable t) {

            }
        });
    }
    private void agregarImagenesProductos(List<Producto> producto, List<ImagenProducto> menuImagens){
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
        productoRecuperacionEstatico=producto;
        cargarElementosProductos();
    }

//Cargar elementos carrito
    private void cargarObjetosCarrito(){
        Retrofit retrofit = new Retrofit.Builder().baseUrl(API.getUrl()).addConverterFactory((GsonConverterFactory.create())).build();
        ApiMetodos apiService = retrofit.create(ApiMetodos.class);

        Call<List<Carrito>> call = apiService.getCarrito(autenticacion.getId(),autenticacion.getToken());
        System.out.println("cargarMenu4 "+autenticacion.getToken());
        call.enqueue(new Callback<List<Carrito>>() {
            @Override
            public void onResponse(Call<List<Carrito>> call, Response<List<Carrito>> response) {
                System.out.println("cargarMenu5 "+autenticacion.getId());
                cargarImagenesCarrito(response.body());
            }

            @Override
            public void onFailure(Call<List<Carrito>> call, Throwable t) {

            }
        });
    }
    private void cargarImagenesCarrito(List<Carrito> carritoItems){
        System.out.println("cargarMenu IMAGEN");
        Retrofit retrofit = new Retrofit.Builder().baseUrl(API.getUrl()).addConverterFactory((GsonConverterFactory.create())).build();
        ApiMetodos apiService = retrofit.create(ApiMetodos.class);
        Call<List<ImagenProducto>> call= apiService.getImagenProducto();
        System.out.println("cargarMenu IMAGEN2");
        call.enqueue(new Callback<List<ImagenProducto>>() {
            @Override
            public void onResponse(Call<List<ImagenProducto>> call, Response<List<ImagenProducto>> response) {
                System.out.println("cargarMenu IMAGEN313");
                System.out.println("-------------------"+response.body().get(12).getUrl());
                agregarImagenesCarrito(carritoItems,response.body());
            }

            @Override
            public void onFailure(Call<List<ImagenProducto>> call, Throwable t) {

            }
        });
    }
    private void agregarImagenesCarrito(List<Carrito> carroItem, List<ImagenProducto> menuImagens){
        System.out.println("cargarMenu IMAGEN8645451dasdw");
        int precioProductos=0;
        for(int i=0;i<carroItem.size();i++){
            System.out.println("cArgar imagen for "+carroItem.get(i).getIdProducto());
            for(int o=0;o<menuImagens.size();o++){
                System.out.println("cArgar imagen for2 "+menuImagens.get(o).getIdProducto());
                if(carroItem.get(i).getIdProducto().equals(menuImagens.get(o).getIdProducto())){
                    System.out.println("AAAAAAAAAAAA");
                    carroItem.get(i).setUrl(menuImagens.get(o).getUrl());
                    System.out.println(carroItem.get(i).getIdProducto());
                    System.out.println(carroItem.get(i).getProducto());
                    System.out.println(carroItem.get(i).getCantidad());
                    System.out.println(carroItem.get(i).getPrecio());
                    System.out.println(carroItem.get(i).getUrl());
                    precioProductos=precioProductos+Integer.parseInt(carroItem.get(i).getPrecio());
                }
            }
        }

        precioCarro=String.valueOf(precioProductos);
        carRecuperacionEstatico=carroItem;
    }

//Cargar elementos historial productos
    private void cargarObjetosHistorial(){
        System.out.println("cargarMenu IMAGEN");
        Retrofit retrofit = new Retrofit.Builder().baseUrl(API.getUrl()).addConverterFactory((GsonConverterFactory.create())).build();
        ApiMetodos apiService = retrofit.create(ApiMetodos.class);
        Call<List<OrdenProducto>> call= apiService.getOrdenproducto(autenticacion.getId(),autenticacion.getToken());
        System.out.println("cargarMenu IMAGEN2");
        call.enqueue(new Callback<List<OrdenProducto>>() {
            @Override
            public void onResponse(Call<List<OrdenProducto>> call, Response<List<OrdenProducto>> response) {
                historialRecuperacionEstatico=response.body();
            }

            @Override
            public void onFailure(Call<List<OrdenProducto>> call, Throwable t) {

            }
        });
    }

///Adaptadores de carga de elementos.
    public void cargarElementosMenu() {
        recyclerViewMenu=(RecyclerView) findViewById(R.id.eq_recycler_menu);
        recyclerViewMenu.setLayoutManager(new LinearLayoutManager(this));
        adaptadorMenu=new ReclyclerViewMenu(menuRecuperacionEstatico);
        recyclerViewMenu.setAdapter(adaptadorMenu);
    }
    public void cargarElementosProductos() {
        recyclerViewProductos=(RecyclerView) findViewById(R.id.eq_recycler_product);
        recyclerViewProductos.setLayoutManager(new LinearLayoutManager(this));
        adaptadorProductos=new ReclyclerViewProduct(productoRecuperacionEstatico);
        recyclerViewProductos.setAdapter(adaptadorProductos);
    }

    public void cargarElementosCarrito() {
        recyclerViewCar=(RecyclerView) findViewById(R.id.eq_recycler_car);
        recyclerViewCar.setLayoutManager(new LinearLayoutManager(this));

        adaptadorCar=new ReclyclerViewCar(carRecuperacionEstatico);
        recyclerViewCar.setAdapter(adaptadorCar);
    }
    public void cargarElementosOrdenesRealizadas() {
        recyclerViewRecord=(RecyclerView) findViewById(R.id.eq_recycler_record);
        recyclerViewRecord.setLayoutManager(new LinearLayoutManager(this));

        adaptadorRecord=new ReclyclerViewRecord(historialRecuperacionEstatico);
        recyclerViewRecord.setAdapter(adaptadorRecord);
    }


    private void startUserOptions(Auth auth, String tipoUsuario) {
        Intent intent =  new Intent(this, UserOptions.class);
        startActivity(intent);
        Bundle bundle = new Bundle();
        Bundle bundle2 = new Bundle();

        bundle.putSerializable("Auth",auth);
        intent.putExtras(bundle);
        bundle2.putSerializable("tipo",tipoUsuario);
        intent.putExtras(bundle2);
        startActivity(intent);
    }

    private void startLogin() {
        Intent intent =  new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    private void startEmployeeOptions(Auth auth, String tipoUsuario) {
        Intent intent = new Intent(this, EmployeeOptions.class);
        Bundle bundle = new Bundle();
        Bundle bundle2 = new Bundle();

        bundle.putSerializable("Auth",auth);
        intent.putExtras(bundle);
        bundle2.putSerializable("tipo",tipoUsuario);
        intent.putExtras(bundle2);
        startActivity(intent);
    }

}