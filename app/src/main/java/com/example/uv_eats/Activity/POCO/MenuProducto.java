package com.example.uv_eats.Activity.POCO;

import android.widget.ImageView;

public class MenuProducto {
    private String nombre;
    private String descripcion;
    private String precio;
    private ImageView url;

    public MenuProducto(String nombre, String descripcion, String precio,ImageView url){
        this.nombre=nombre;
        this.descripcion=descripcion;
        this.precio=precio;
        this.url = url;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getPrecio() {
        return precio;
    }

    public void setPrecio(String precio) {
        this.precio = precio;
    }

    public ImageView getUrl() {
        return url;
    }

    public void setUrl(ImageView url) {
        this.url = url;
    }
}
