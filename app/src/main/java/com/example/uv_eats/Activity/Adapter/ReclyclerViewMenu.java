package com.example.uv_eats.Activity.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.uv_eats.Activity.POCO.Modelo.MenuProducto;
import com.example.uv_eats.R;
import com.squareup.picasso.Picasso;

import org.w3c.dom.Text;

import java.util.List;

public class ReclyclerViewMenu extends RecyclerView.Adapter<ReclyclerViewMenu.ViewHolder> {
    public static class ViewHolder extends RecyclerView.ViewHolder{
        private TextView nombre, descripcion,precio;
        private ImageView fotoProducto;

        public ViewHolder(View itemView){
            super(itemView);
            nombre=(TextView) itemView.findViewById(R.id.productName);
            descripcion=(TextView) itemView.findViewById(R.id.productDescription);
            precio=(TextView) itemView.findViewById(R.id.productPrice);
            fotoProducto=(ImageView) itemView.findViewById(R.id.iconProduct);
        }
    }
    public List<MenuProducto>menuproducto;

    public ReclyclerViewMenu(List<MenuProducto> menuproducto){
        this.menuproducto=menuproducto;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.menu_item,parent,false);
        ViewHolder viewHolder=new ViewHolder(view);
        return viewHolder;
    }
    @Override
    public void onBindViewHolder(@NonNull ReclyclerViewMenu.ViewHolder holder, int position) {
        holder.nombre.setText(menuproducto.get(position).getNombre());
        holder.descripcion.setText(menuproducto.get(position).getDescripcion());
        holder.precio.setText(menuproducto.get(position).getPrecio());
        Picasso.get().load(menuproducto.get(position).getUrl()).error(R.drawable.icon_menu).into(holder.fotoProducto);
    }
    @Override
    public int getItemCount(){
        return menuproducto.size();
    }
}
