package com.example.uv_eats.Activity.POCO.Modelo;

public class Carrito {
    private String idProducto;
    private String producto;
    private String cantidad;
    private String precio;
    private String url;

    public Carrito(String idProducto,String producto,String cantidad,String precio,String url){
        this.idProducto=idProducto;
        this.producto=producto;
        this.cantidad=cantidad;
        this.precio=precio;
        this.url=url;
    }
    public String getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(String idProducto) {
        this.idProducto = idProducto;
    }

    public String getProducto() {
        return producto;
    }

    public void setProducto(String producto) {
        this.producto = producto;
    }

    public String getCantidad() {
        return cantidad;
    }

    public void setCantidad(String cantidad) {
        this.cantidad = cantidad;
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
}
