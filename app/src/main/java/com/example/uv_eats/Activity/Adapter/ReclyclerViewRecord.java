package com.example.uv_eats.Activity.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.uv_eats.Activity.POCO.Modelo.OrdenProducto;
import com.example.uv_eats.Activity.POCO.Modelo.Producto;
import com.example.uv_eats.R;
import com.squareup.picasso.Picasso;

import java.util.List;

public class ReclyclerViewRecord extends RecyclerView.Adapter<ReclyclerViewRecord.ViewHolder> {
    public static class ViewHolder extends RecyclerView.ViewHolder{
        private TextView producto,cantidad,precio,estado,ubicacion;
        private ImageView fotoProducto;

        public ViewHolder(View itemView){
            super(itemView);
            producto=(TextView) itemView.findViewById(R.id.productName);
            cantidad=(TextView) itemView.findViewById(R.id.productDescription);
            estado=(TextView) itemView.findViewById(R.id.FormatPay);
            precio=(TextView) itemView.findViewById(R.id.change);
            ubicacion=(TextView) itemView.findViewById(R.id.Place);
            fotoProducto=(ImageView) itemView.findViewById(R.id.iconProduct);
        }
    }
    public List<OrdenProducto>productosOrden;

    public ReclyclerViewRecord(List<OrdenProducto> productosOrden){
        this.productosOrden=productosOrden;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.record_item,parent,false);
        ViewHolder viewHolder=new ViewHolder(view);
        return viewHolder;
    }
    @Override
    public void onBindViewHolder(@NonNull ReclyclerViewRecord.ViewHolder holder, int position) {
        holder.producto.setText(productosOrden.get(position).getProducto());
        holder.cantidad.setText(productosOrden.get(position).getFecha());
        holder.estado.setText(productosOrden.get(position).getEstado());
        holder.precio.setText(productosOrden.get(position).getTotal());
        holder.ubicacion.setText("FACULTAD DE ECONOMIA E INFORMATICA");
        Picasso.get().load("EROR").error(R.drawable.icon_menu).into(holder.fotoProducto);
    }
    @Override
    public int getItemCount(){
        return productosOrden.size();
    }
}
