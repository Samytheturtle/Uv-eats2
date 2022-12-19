package com.example.uv_eats.Activity.POCO.Modelo;

public class OrdenProducto {
    private String idProducto;
    private String producto;
    private String cantidad;
    private String precio;
    private String url;
    private String fecha;
    private String total;
    private String estado;

    public OrdenProducto(String idProducto, String producto, String cantidad, String precio, String url,String fecha,String total,String estado) {
        this.idProducto = idProducto;
        this.producto = producto;
        this.cantidad = cantidad;
        this.precio = precio;
        this.url = url;
        this.fecha=fecha;
        this.total=total;
        this.estado=estado;
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

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}
