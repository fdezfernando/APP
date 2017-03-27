package com.fernandoj.bandasolapp.pojos;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import java.util.Date;

/**
 * Created by FernandoJ on 26/03/2017.
 */

public class Eventos {

    @SerializedName("fecha")
    @Expose
    private String fecha;
    @SerializedName("lugar")
    @Expose
    private String lugar;
    @SerializedName("nombreEvento")
    @Expose
    private String nombreEvento;

    public Eventos(String fecha, String lugar, String nombreEvento) {

        this.fecha = fecha;
        this.lugar = lugar;
        this.nombreEvento = nombreEvento;
    }

    public Eventos() {
    }


    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
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

