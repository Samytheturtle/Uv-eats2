package com.example.uv_eats.Activity.POCO.Modelo;

public class Orden {
    private String idOrden;
    private String fecha;
    private String total;
    private String estado;
    private String idUsuario;
    private String idCarro;

    public Orden(){}

    public Orden(String idOrden,String fecha,String total,String estado, String idUsuario,String idCarro){
        this.idOrden=idOrden;
        this.fecha=fecha;
        this.total=total;
        this.estado=estado;
        this.idUsuario=idUsuario;
        this.idCarro=idCarro;
    }
    public String getIdOrden() {
        return idOrden;
    }

    public void setIdOrden(String idOrden) {
        this.idOrden = idOrden;
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

    public String getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(String idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getIdCarro() {
        return idCarro;
    }

    public void setIdCarro(String idCarro) {
        this.idCarro = idCarro;
    }
}
