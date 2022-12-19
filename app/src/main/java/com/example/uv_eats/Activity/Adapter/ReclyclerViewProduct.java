package com.example.uv_eats.Activity.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.uv_eats.Activity.POCO.Modelo.MenuProducto;
import com.example.uv_eats.Activity.POCO.Modelo.Producto;
import com.example.uv_eats.R;
import com.squareup.picasso.Picasso;

import java.util.List;

public class ReclyclerViewProduct extends RecyclerView.Adapter<ReclyclerViewProduct.ViewHolder> {
    public static class ViewHolder extends RecyclerView.ViewHolder{
        private TextView nombre, descripcion,precio,numLike,numDislike;
        private ImageView fotoProducto;

        public ViewHolder(View itemView){
            super(itemView);
            nombre=(TextView) itemView.findViewById(R.id.productName);
            descripcion=(TextView) itemView.findViewById(R.id.productDescription);
            precio=(TextView) itemView.findViewById(R.id.productPrice);
            numLike=(TextView) itemView.findViewById(R.id.numLike);
            numDislike=(TextView) itemView.findViewById(R.id.numdislike);
            fotoProducto=(ImageView) itemView.findViewById(R.id.iconProduct);
        }
    }
    public List<Producto>productoMenu;

    public ReclyclerViewProduct(List<Producto> productoMenu){
        this.productoMenu=productoMenu;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.product_item,parent,false);
        ViewHolder viewHolder=new ViewHolder(view);
        return viewHolder;
    }
    @Override
    public void onBindViewHolder(@NonNull ReclyclerViewProduct.ViewHolder holder, int position) {
        holder.nombre.setText(productoMenu.get(position).getNombre());
        holder.descripcion.setText(productoMenu.get(position).getDescripcion());
        holder.precio.setText(productoMenu.get(position).getPrecio());
        holder.numLike.setText(productoMenu.get(position).getNumLike());
        holder.numDislike.setText(productoMenu.get(position).getNumDislike());
        Picasso.get().load(productoMenu.get(position).getUrl()).error(R.drawable.icon_menu).into(holder.fotoProducto);
    }
    @Override
    public int getItemCount(){
        return productoMenu.size();
    }
}
