package com.example.uv_eats.Activity.POCO.Modelo;

public class Producto {
    private String idProducto;
    private String nombre;
    private String descripcion;
    private String precio;
    private String unidades;
    private String numLike;
    private String numDislike;
    private String url;

    public Producto(String idProducto, String nombre, String descripcion, String precio, String unidades, String numLike, String numDislike,String imagenProducto) {
        this.idProducto = idProducto;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precio = precio;
        this.unidades = unidades;
        this.numLike = numLike;
        this.numDislike = numDislike;
        this.url=imagenProducto;
    }

    public String getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(String idProducto) {
        this.idProducto = idProducto;
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

    public String getUnidades() {
        return unidades;
    }

    public void setUnidades(String unidades) {
        this.unidades = unidades;
    }

    public String getNumLike() {
        return numLike;
    }

    public void setNumLike(String numLike) {
        this.numLike = numLike;
    }

    public String getNumDislike() {
        return numDislike;
    }

    public void setNumDislike(String numDislike) {
        this.numDislike = numDislike;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String imagenProducto) {
        this.url = imagenProducto;
    }
}
