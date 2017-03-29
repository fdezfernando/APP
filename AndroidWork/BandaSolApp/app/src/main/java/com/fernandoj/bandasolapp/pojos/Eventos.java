package com.fernandoj.bandasolapp.pojos;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by FernandoJ on 26/03/2017.
 * Clase Evento
 */

public class Eventos {

    /**
     * Atributo fecha
     */
    @SerializedName("fecha")
    @Expose
    private String fecha;
    /**
     * Atributo lugar
     */
    @SerializedName("lugar")
    @Expose
    private String lugar;
    /**
     * Atributo nombre del evento
     */
    @SerializedName("nombreEvento")
    @Expose
    private String nombreEvento;

    /**
     * Constructor con parámetros
     *
     * @param fecha
     * @param lugar
     * @param nombreEvento
     */
    public Eventos(String fecha, String lugar, String nombreEvento) {

        this.fecha = fecha;
        this.lugar = lugar;
        this.nombreEvento = nombreEvento;
    }

    /**
     * Constructor vacío
     */
    public Eventos() {
    }

    /**
     * Get fecha
     *
     * @return
     */
    public String getFecha() {
        return fecha;
    }

    /**
     * Set fecha
     *
     * @param fecha
     */
    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    /**
     * Get lugar
     *
     * @return
     */
    public String getLugar() {
        return lugar;
    }

    /**
     * Set lugar
     *
     * @param lugar
     */
    public void setLugar(String lugar) {
        this.lugar = lugar;
    }

    /**
     * Get nombre del evento
     *
     * @return
     */
    public String getNombreEvento() {
        return nombreEvento;
    }

    /**
     * set nombre del evento
     *
     * @param nombreEvento
     */
    public void setNombreEvento(String nombreEvento) {
        this.nombreEvento = nombreEvento;
    }

    /**
     * To string evento
     *
     * @return
     */
    @Override
    public String toString() {
        return "Eventos{" +
                ", fecha=" + fecha +
                ", lugar='" + lugar + '\'' +
                ", nombreEvento='" + nombreEvento + '\'' +
                '}';
    }
}

