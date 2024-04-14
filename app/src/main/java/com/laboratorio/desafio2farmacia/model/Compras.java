package com.laboratorio.desafio2farmacia.model;

import com.google.firebase.database.snapshot.StringNode;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class Compras {
    String Codigo;
    String Fecha;
    double CostoTotalCompra;

    public Compras() {

    }

    public Compras(String codigo, String fecha, double costoTotalCompra) {
        Codigo = codigo;
        Fecha = fecha;
        CostoTotalCompra = costoTotalCompra;
    }


    public String getCodigo() {
        return Codigo;
    }

    public void setCodigo(String codigo) {
        Codigo = codigo;
    }

    public String getFecha() {
        return Fecha;
    }

    public void setFecha(String fecha) {
        Fecha = fecha;
    }

    public double getCostoTotalCompra() {
        return CostoTotalCompra;
    }

    public void setCostoTotalCompra(double costoTotalCompra) {
        CostoTotalCompra = costoTotalCompra;
    }
}
