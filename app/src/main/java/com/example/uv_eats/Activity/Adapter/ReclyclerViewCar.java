package com.example.uv_eats.Activity.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.uv_eats.Activity.POCO.Modelo.Carrito;
import com.example.uv_eats.Activity.POCO.Modelo.MenuProducto;
import com.example.uv_eats.R;
import com.squareup.picasso.Picasso;

import java.util.List;

public class ReclyclerViewCar extends RecyclerView.Adapter<ReclyclerViewCar.ViewHolder> {
    public static class ViewHolder extends RecyclerView.ViewHolder{
        private TextView nombre, descripcion,precio;
        private ImageView fotoProducto;

        public ViewHolder(View itemView){
            super(itemView);
            nombre=(TextView) itemView.findViewById(R.id.productName);
            descripcion=(TextView) itemView.findViewById(R.id.amountNumber);
            precio=(TextView) itemView.findViewById(R.id.productPrice);
            fotoProducto=(ImageView) itemView.findViewById(R.id.iconProduct);
        }
    }
    public List<Carrito>carrito;

    public ReclyclerViewCar(List<Carrito> carrito){
        this.carrito=carrito;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.cart_item,parent,false);
        ViewHolder viewHolder=new ViewHolder(view);
        return viewHolder;
    }
    @Override
    public void onBindViewHolder(@NonNull ReclyclerViewCar.ViewHolder holder, int position) {
        holder.nombre.setText(carrito.get(position).getProducto());
        holder.descripcion.setText(carrito.get(position).getCantidad());
        holder.precio.setText(carrito.get(position).getPrecio());
        Picasso.get().load(carrito.get(position).getUrl()).error(R.drawable.icon_menu).into(holder.fotoProducto);
    }
    @Override
    public int getItemCount(){
        return carrito.size();
    }
}
