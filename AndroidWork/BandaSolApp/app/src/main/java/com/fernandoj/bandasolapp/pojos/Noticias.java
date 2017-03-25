package com.fernandoj.bandasolapp.pojos;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import org.joda.time.DateTime;

/**
 * Created by FernandoJ on 23/03/2017.
 */

public class Noticias {

    @SerializedName("idNoticia")
    @Expose
    private String idNoticia;
    @SerializedName("titulo")
    @Expose
    private String titulo;
    @SerializedName("cuerpo")
    @Expose
    private String cuerpo;
    @SerializedName("fecha")
    @Expose
    private DateTime fecha;

    public Noticias(String idNoticia, String titulo, String cuerpo, DateTime fecha) {
        this.idNoticia = idNoticia;
        this.titulo = titulo;
        this.cuerpo = cuerpo;
        this.fecha = fecha;
    }

    public Noticias() {
    }

    public String getIdNoticia() {
        return idNoticia;
    }

    public void setIdNoticia(String idNoticia) {
        this.idNoticia = idNoticia;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getCuerpo() {
        return cuerpo;
    }

    public void setCuerpo(String cuerpo) {
        this.cuerpo = cuerpo;
    }

    public DateTime getFecha() {
        return fecha;
    }

    public void setFecha(DateTime fecha) {
        this.fecha = fecha;
    }

    @Override
    public String toString() {
        return "Noticias{" +
                "idNoticia='" + idNoticia + '\'' +
                ", titulo='" + titulo + '\'' +
                ", cuerpo='" + cuerpo + '\'' +
                ", fecha='" + fecha + '\'' +
                '}';
    }
}
