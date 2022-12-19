package com.example.uv_eats.Activity.POCO.Modelo;

import android.widget.ImageView;

public class MenuProducto {
    private int idMenu;
    private String nombre;
    private String descripcion;
    private String precio;
    private String url;

    public MenuProducto(String nombre, String descripcion, String precio,String url){
        this.nombre=nombre;
        this.descripcion=descripcion;
        this.precio=precio;
        this.url = url;
    }
    public MenuProducto(int idMenu,String nombre, String descripcion, String precio,String url){
        this.idMenu=idMenu;
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

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public int getIdMenu() {
        return idMenu;
    }

    public void setIdMenu(int idMenu) {
        this.idMenu = idMenu;
    }
}
