package com.fernandoj.bandasolapp.pojos;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by FernandoJ on 26/03/2017.
 * <p>
 * Clase marcha
 */

public class Marchas {


    /**
     * Atributo idMarcha
     */
    @SerializedName("idMarcha")
    @Expose
    private String idMarcha;
    /**
     * Atributo nombre de la marcha
     */
    @SerializedName("nombreMarcha")
    @Expose
    private String nombreMarcha;
    /**
     * Atributo nombre del autor
     */
    @SerializedName("autor")
    @Expose
    private String autor;
    /**
     * Atributo tiempo
     */
    private int tiempo = 220;
    /**
     * Atributo url
     */
    private String url = "http://192.168.1.61/bandasolapp/assets/music/";
    /**
     * Atributo tipo
     */
    private String tipo = ".mp3";

    /***
     * Constructor con parámetros
     * @param idMarcha
     * @param nombreMarcha
     * @param autor
     */
    public Marchas(String idMarcha, String nombreMarcha, String autor, int tiempo, String url, String tipo) {
        this.idMarcha = idMarcha;
        this.nombreMarcha = nombreMarcha;
        this.autor = autor;
        this.tiempo = tiempo;
        this.url = url;
        this.tipo = tipo;
    }

    /**
     * Constructor vacío
     */
    public Marchas() {
    }


    /**
     * Get nombre de la marcha
     *
     * @return
     */
    public String getNombreMarcha() {
        return nombreMarcha;
    }

    /**
     * Set nombre de la marcha
     *
     * @param nombreMarcha
     */
    public void setNombreMarcha(String nombreMarcha) {
        this.nombreMarcha = nombreMarcha;
    }

    /**
     * Get autor
     *
     * @return
     */
    public String getAutor() {
        return autor;
    }

    /**
     * Set autor
     *
     * @param autor
     */
    public void setAutor(String autor) {
        this.autor = autor;
    }

    /**
     * Get idMarcha
     *
     * @return
     */
    public String getIdMarcha() {
        return idMarcha;
    }

    /***
     * Set idMarcha
     * @param idMarcha
     */
    public void setIdMarcha(String idMarcha) {
        this.idMarcha = idMarcha;
    }

    /***
     * Get tiempo
     * @return
     */
    public int getTiempo() {
        return tiempo;
    }

    /***
     * Set tiempo
     * @param tiempo
     */
    public void setTiempo(int tiempo) {
        this.tiempo = tiempo;
    }

    /***
     * Get URL
     * @return
     */
    public String getUrl() {
        return url;
    }

    /***
     * Set URL
     * @param url
     */
    public void setUrl(String url) {
        this.url = url;
    }

    /**
     * Get tipo
     *
     * @return
     */
    public String getTipo() {
        return tipo;
    }

    /**
     * Set tipo
     *
     * @param tipo
     */
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    /**
     * To string marcha
     *
     * @return
     */
    @Override
    public String toString() {
        return "Marchas{" +
                "idMarcha='" + idMarcha + '\'' +
                ", nombreMarcha='" + nombreMarcha + '\'' +
                ", autor='" + autor + '\'' +
                ", tiempo=" + tiempo +
                ", url='" + url + '\'' +
                ", tipo='" + tipo + '\'' +
                '}';
    }
}
