package com.example.uv_eats.Activity.POCO.Modelo;

public class MenuImagen {
    private int idMenu;
    private String url;

    public MenuImagen(int idMenu,String imageMenu){
        this.idMenu=idMenu;
        this.url=imageMenu;
    }

    public int getIdMenu() {
        return idMenu;
    }

    public void setIdMenu(int idMenu) {
        this.idMenu = idMenu;
    }

    public String geturl() {
        return url;
    }

    public void setImageMenu(String imageMenu) {
        this.url = imageMenu;
    }
}
