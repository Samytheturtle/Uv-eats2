package com.example.uv_eats.Activity.POCO.Modelo;

public class ImagenProducto {
    private String idProducto;
    private String url;


    public ImagenProducto(String idProducto, String url) {
        this.idProducto = idProducto;
        this.url = url;
    }

    public String getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(String idProducto) {
        this.idProducto = idProducto;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
