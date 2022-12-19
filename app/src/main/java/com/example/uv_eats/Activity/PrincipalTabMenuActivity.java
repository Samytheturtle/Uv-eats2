package com.example.uv_eats.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import com.example.uv_eats.Activity.Adapter.ReclyclerViewMenu;
import com.example.uv_eats.Activity.Controller.PagerController;
import com.example.uv_eats.Activity.HttpRequest.API;
import com.example.uv_eats.Activity.HttpRequest.ApiMetodos;
import com.example.uv_eats.Activity.POCO.Auth;
import com.example.uv_eats.Activity.POCO.Modelo.MenuImagen;
import com.example.uv_eats.Activity.POCO.Modelo.MenuProducto;
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

    private RecyclerView recyclerViewMenu;
    private ReclyclerViewMenu adaptadorMenu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityPrincipalTabMenuActivityBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        System.out.println("A1");

        Bundle objetoRecibido=getIntent().getExtras();
        autenticacion= (Auth) objetoRecibido.getSerializable("Auth");

        Bundle objeto2Recibido=getIntent().getExtras();
        tipoUsuario=(String) objeto2Recibido.getSerializable("tipo");

        System.out.println(tipoUsuario);
        if(tipoUsuario.equals("ESTUDIANTE")){
            System.out.println("A");
            binding.OptionsImage.setVisibility(View.GONE);
        }

        binding.OptionsImage.setOnClickListener(v ->{
            startEmployeeOptions();

        });

        binding.ExitImage.setOnClickListener(v ->{
            startLogin();
        });


        binding.UserImage.setOnClickListener(v ->{

            startUserOptions();
        });
        //RECUPERACION DE LOS OBJETOS API:


        tabLayout = binding.tabLayout;
        viewPager = binding.viewPager;
        tabProduct = binding.tabProducts;
        tabCart = binding.tabCart;
        tabRecord = binding.tabRecord;

        pagerAdapter = new PagerController(getSupportFragmentManager(), tabLayout.getTabCount(),autenticacion);
        viewPager.setAdapter(pagerAdapter);

        System.out.println("TABLA-INICIO");

        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {

            @Override
            public void onTabSelected(TabLayout.Tab tabmenu) {
                System.out.println("POSICION 1 "+tabmenu.getPosition());
                viewPager.setCurrentItem(tabmenu.getPosition());
                System.out.println("POSICION 2 "+tabmenu.getPosition());
                System.out.println("TABLA-CARGA"+tabmenu.getPosition());
                //cargarElementosValidacion(tabmenu.getPosition());
                if(tabmenu.getPosition() == 1){
                    System.out.println("TABLA-PRO"+tabmenu.getPosition());
                    pagerAdapter.notifyDataSetChanged();

                }
                if(tabmenu.getPosition() == 2){
                    System.out.println("TABLA-CAR"+tabmenu.getPosition());
                    pagerAdapter.notifyDataSetChanged();
                }
                if(tabmenu.getPosition() == 3){
                    System.out.println("TABLA-HIS"+tabmenu.getPosition());
                    pagerAdapter.notifyDataSetChanged();
                }
                if(tabmenu.getPosition() == 0){
                    System.out.println("TABLA-MENU"+tabmenu.getPosition());
                    pagerAdapter.notifyDataSetChanged();
                    cargarElementosValidacion(tabmenu.getPosition());
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

       /* Retrofit retrofit2 = new Retrofit.Builder().baseUrl(API.getUrl()).addConverterFactory((GsonConverterFactory.create())).build();
        System.out.println("cargarMenu-AUTN2");
        ApiMetodos apiService2 = retrofit2.create(ApiMetodos.class);
        System.out.println("cargarMenu-AUTN3");
        Call<MenuImagen[]> call2 = apiService2.getMenuArchivos();
        System.out.println("cargarMenu-AUTN4");


        call2.enqueue(new Callback<MenuImagen[]>() {
            @Override
            public void onResponse(Call<MenuImagen[]> call, Response<MenuImagen[]> response) {
                if(response.isSuccessful()){
                    tempMenuimagen = Arrays.asList(response.body());
                }else{
                    tempMenuimagen=null;
                }
            }

            @Override
            public void onFailure(Call<MenuImagen[]> call, Throwable t) {
                System.out.println("fail2");
            }
        });*/

        /*for(int i=0;i<tempMenu.size();i++){
            tempMenu.get(i).setUrl(tempMenuimagen.get(i).getImageMenu());
        }*/

    }
    private void cargarImagenesMenu(List<MenuProducto> menuitems){
        System.out.println("cargarImagen");
        Retrofit retrofit = new Retrofit.Builder().baseUrl(API.getUrl()).addConverterFactory((GsonConverterFactory.create())).build();
        System.out.println("cargarImagen");
        ApiMetodos apiService = retrofit.create(ApiMetodos.class);
        Call<List<MenuImagen>> call= apiService.getMenuArchivos();
        System.out.println("cargarImagen");
        call.enqueue(new Callback<List<MenuImagen>>() {
            @Override
            public void onResponse(Call<List<MenuImagen>> call, Response<List<MenuImagen>> response) {
                if (response.isSuccessful()) {
                    System.out.println("cargarMenu1 "+response.body().get(0).toString()+menuitems.get(0).toString());
                    System.out.println(response.body().get(0).getIdMenu()+"\n"+response.body().get(0).geturl());
                    agregarImagenesMenu(menuitems,response.body());
                } else {

                }
            }

            @Override
            public void onFailure(Call<List<MenuImagen>> call, Throwable t) {
                System.out.println("fail2");
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
        cargarElementosMenu(menu);
    }
    private void cargarElementosValidacion(int posicion) {
        if(posicion==0){
            System.out.println("VALIDACION CORRECTA");
            cargarObjetosMenu();
        }else{
            System.out.println("NO CARGA CARGA hecha anterorimente");
        }
    }

    public void cargarElementosMenu(List<MenuProducto> menu) {
        recyclerViewMenu=(RecyclerView) findViewById(R.id.eq_recycler_menu);
        recyclerViewMenu.setLayoutManager(new LinearLayoutManager(this));

        adaptadorMenu=new ReclyclerViewMenu(menu);
        recyclerViewMenu.setAdapter(adaptadorMenu);
    }
    private void startUserOptions() {
        Intent intent =  new Intent(this, UserOptions.class);
        startActivity(intent);
    }

    private void startLogin() {
        Intent intent =  new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    private void startEmployeeOptions() {
        Intent intent = new Intent(this, EmployeeOptions.class);
        startActivity(intent);
    }

}