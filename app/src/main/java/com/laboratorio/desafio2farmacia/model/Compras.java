package com.laboratorio.desafio2farmacia.model;

public class Compras {
    String Codigo;
    double CostoTotalCompra;

    public Compras(String codigo, double costoTotalCompra){
        Codigo = codigo;
        CostoTotalCompra = costoTotalCompra;
    }

    public String getCodigo(){return Codigo;}
    public void setCodigo(String codigo){Codigo = codigo;}

    public Double getCostoTotal(){return CostoTotalCompra;}
    public void setCostoTotalCompra(Double costo){CostoTotalCompra = costo;}
}
