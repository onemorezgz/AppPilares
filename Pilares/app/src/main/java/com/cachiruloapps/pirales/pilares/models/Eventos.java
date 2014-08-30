package com.cachiruloapps.pirales.pilares.models;

/**
 * Created by javierjavier on 27/08/14.
 */
public class Eventos {

    private String titulo, descripcion, fecha, hora, lugarNombre, tipo;
    private double lugarLatitud, lugarlongitud;

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public String getLugarNombre() {
        return lugarNombre;
    }

    public void setLugarNombre(String lugarNombre) {
        this.lugarNombre = lugarNombre;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public double getLugarLatitud() {
        return lugarLatitud;
    }

    public void setLugarLatitud(double lugarLatitud) {
        this.lugarLatitud = lugarLatitud;
    }

    public double getLugarlongitud() {
        return lugarlongitud;
    }

    public void setLugarlongitud(double lugarlongitud) {
        this.lugarlongitud = lugarlongitud;
    }
}
