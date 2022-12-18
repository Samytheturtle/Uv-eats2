package com.example.uv_eats.Activity.Controller;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.uv_eats.Activity.POCO.MenuProducto;
import com.example.uv_eats.R;

import org.w3c.dom.Text;

import java.util.List;

public class RecyclerViewAdaptador extends RecyclerView.Adapter<RecyclerViewAdaptador.ViewHolder> {
    public static class ViewHolder extends RecyclerView.ViewHolder{
        private TextView nombre,descripcion,precio;
        ImageView fotoProducto;

        public ViewHolder(View itemView) {
            super(itemView);
            nombre=(TextView)itemView.findViewById(R.id.productName);
            descripcion=(TextView) itemView.findViewById(R.id.productDescription);
            precio=(TextView) itemView.findViewById(R.id.productPrice);
            fotoProducto=(ImageView) itemView.findViewById(R.id.iconProduct);
        }
    }
    public List<MenuProducto> productosListaMenu;

    public RecyclerViewAdaptador(List<MenuProducto> productoslistaproductos){
        this.productosListaMenu=productoslistaproductos;
    }
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.menu_item,parent,false);
        ViewHolder viewHolder=new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.nombre.setText(productosListaMenu.get(position).getNombre());
        holder.descripcion.setText(productosListaMenu.get(position).getDescripcion());
        holder.precio.setText(productosListaMenu.get(position).getPrecio());
        holder.fotoProducto.setImageResource(productosListaMenu.get(position).hashCode());
    }
    @Override
    public int getItemCount(){
        return  productosListaMenu.size();
    }
}
