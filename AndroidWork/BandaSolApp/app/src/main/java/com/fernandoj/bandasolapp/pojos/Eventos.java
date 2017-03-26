package com.fernandoj.bandasolapp.pojos;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import org.joda.time.DateTime;

/**
 * Created by FernandoJ on 26/03/2017.
 */

public class Eventos {

    @SerializedName("fecha")
    @Expose
    private DateTime fecha;
    @SerializedName("lugar")
    @Expose
    private String lugar;
    @SerializedName("nombreEvento")
    @Expose
    private String nombreEvento;

    public Eventos(DateTime fecha, String lugar, String nombreEvento) {

        this.fecha = fecha;
        this.lugar = lugar;
        this.nombreEvento = nombreEvento;
    }

    public Eventos() {
    }


    public DateTime getFecha() {
        return fecha;
    }

    public void setFecha(DateTime fecha) {
        this.fecha = fecha;
    }

    public String getLugar() {
        return lugar;
    }

    public void setLugar(String lugar) {
        this.lugar = lugar;
    }

    public String getNombreEvento() {
        return nombreEvento;
    }

    public void setNombreEvento(String nombreEvento) {
        this.nombreEvento = nombreEvento;
    }

    @Override
    public String toString() {
        return "Eventos{" +
                ", fecha=" + fecha +
                ", lugar='" + lugar + '\'' +
                ", nombreEvento='" + nombreEvento + '\'' +
                '}';
    }
}

