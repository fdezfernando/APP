package com.fernandoj.bandasolapp.pojos;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import org.joda.time.DateTime;

/**
 * Created by FernandoJ on 23/03/2017.
 * Clase noticias
 */

public class Noticias {

    /**
     * Atributo titulo
     */
    @SerializedName("titulo")
    @Expose
    private String titulo;
    /**
     * Atributo cuerpo
     */
    @SerializedName("cuerpo")
    @Expose
    private String cuerpo;
    /**
     * Atributo fecha
     */
    @SerializedName("fecha")
    @Expose
    private DateTime fecha;

    /**
     * Constructor con parámetros
     *
     * @param titulo
     * @param cuerpo
     * @param fecha
     */
    public Noticias(String titulo, String cuerpo, DateTime fecha) {
        this.titulo = titulo;
        this.cuerpo = cuerpo;
        this.fecha = fecha;
    }

    /**
     * Constructor vacío
     */
    public Noticias() {
    }

    /**
     * Get titulo
     *
     * @return
     */
    public String getTitulo() {
        return titulo;
    }

    /**
     * Set titulo
     *
     * @param titulo
     */
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    /**
     * Get cuerpo
     *
     * @return
     */
    public String getCuerpo() {
        return cuerpo;
    }

    /**
     * Set cuerpo
     *
     * @param cuerpo
     */
    public void setCuerpo(String cuerpo) {
        this.cuerpo = cuerpo;
    }

    /**
     * Get fecha
     *
     * @return
     */
    public DateTime getFecha() {
        return fecha;
    }

    /**
     * Set fecha
     *
     * @param fecha
     */
    public void setFecha(DateTime fecha) {
        this.fecha = fecha;
    }

    /**
     * To string noticia
     *
     * @return
     */
    @Override
    public String toString() {
        return "Noticias{" +
                ", titulo='" + titulo + '\'' +
                ", cuerpo='" + cuerpo + '\'' +
                ", fecha='" + fecha + '\'' +
                '}';
    }
}
