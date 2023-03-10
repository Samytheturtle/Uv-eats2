package com.example.uv_eats.Activity.Controller;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.uv_eats.Activity.Adapter.ReclyclerViewMenu;
import com.example.uv_eats.Activity.POCO.Auth;
import com.example.uv_eats.Activity.POCO.Modelo.MenuProducto;
import com.example.uv_eats.R;
import com.example.uv_eats.databinding.ActivityPrincipalTabMenuActivityBinding;
import com.example.uv_eats.databinding.FragmentMenuBinding;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Menu#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Menu extends Fragment{

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private Auth autenticacionRecibida;
    private FragmentMenuBinding binding;



    public Menu() {
        // Required empty public constructor
    }
    public Menu(Auth autenticacion) {
       this.autenticacionRecibida=autenticacion;
    }
    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Menu.
     */
    // TODO: Rename and change types and number of parameters
    public static Menu newInstance(String param1, String param2) {
        Menu fragment = new Menu();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        binding = FragmentMenuBinding.inflate(getLayoutInflater());

        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }

        //recyclerViewMenu=(RecyclerView) findViewById(R.id.eq_recycler_product);
        //recyclerViewMenu.setLayoutManager(new LinearLayoutManager(this));
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_menu, container, false);

    }
}