package com.laboratorio.desafio2farmacia.model;

public class Medicamentos {
    String Nombre;
    String UrlImagen;
    String Codigo;
    int Cantidad;
    Double Precio;

    public  Medicamentos(){}

    public Medicamentos(String nombre, String codigo,String urlImagen, int cantidad, Double precio) {

        Codigo = codigo;
        Nombre = nombre;
        UrlImagen = urlImagen;
        Cantidad = cantidad;
        Precio = precio;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public String getUrlImagen() {
        return UrlImagen;
    }

    public void setUrlImagen(String urlImagen) {
        UrlImagen = urlImagen;
    }

    public int getCantidad() {
        return Cantidad;
    }

    public void setCantidad(int cantidad) {
        Cantidad = cantidad;
    }

    public Double getPrecio() {
        return Precio;
    }

    public void setPrecio(Double precio) {
        Precio = precio;
    }
    public String getCodigo() {
        return Codigo;
    }

    public void setCodigo(String codigo) {
        Codigo = codigo;
    }
}
