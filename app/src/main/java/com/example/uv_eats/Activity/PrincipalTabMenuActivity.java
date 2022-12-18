package com.example.uv_eats.Activity;

import android.content.Intent;
import android.opengl.Visibility;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import com.example.uv_eats.Activity.Controller.PagerController;
import com.example.uv_eats.Activity.POCO.Auth;
import com.example.uv_eats.databinding.ActivityPrincipalTabMenuActivityBinding;
import com.google.android.material.tabs.TabItem;
import com.google.android.material.tabs.TabLayout;

public class PrincipalTabMenuActivity extends AppCompatActivity {
    String tipoUsuario="";
    public Auth autenticacion;
    private ActivityPrincipalTabMenuActivityBinding binding;
    TabLayout tabLayout;
    ViewPager viewPager;
    TabItem tabProduct, tabCart, tabRecord;
    PagerController pagerAdapter;

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


        binding.OptionsImage.setOnClickListener(v ->{
            startEmployeeOptions();

        });

        binding.ExitImage.setOnClickListener(v ->{
            startLogin();
        });
        System.out.println(tipoUsuario);
        if(tipoUsuario.equals("ESTUDIANTE")){
            System.out.println("A");
            binding.OptionsImage.setVisibility(View.GONE);
        }

        binding.UserImage.setOnClickListener(v ->{

            startUserOptions();
        });

        tabLayout = binding.tabLayout;

        viewPager = binding.viewPager;
        tabProduct = binding.tabProducts;
        tabCart = binding.tabCart;
        tabRecord = binding.tabRecord;

        pagerAdapter = new PagerController(getSupportFragmentManager(), tabLayout.getTabCount(),autenticacion);
        viewPager.setAdapter(pagerAdapter);

        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
                if(tab.getPosition() == 0){

                    pagerAdapter.notifyDataSetChanged();


                }
                if(tab.getPosition() == 1){
                    pagerAdapter.notifyDataSetChanged();
                }
                if(tab.getPosition() == 2){
                    pagerAdapter.notifyDataSetChanged();
                }
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