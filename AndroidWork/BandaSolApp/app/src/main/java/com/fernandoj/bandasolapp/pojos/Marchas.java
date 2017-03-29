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
     * Constructor con parámetros
     *
     * @param nombreMarcha
     * @param autor
     */
    public Marchas(String nombreMarcha, String autor) {
        this.nombreMarcha = nombreMarcha;
        this.autor = autor;
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
     * To string marcha
     *
     * @return
     */
    @Override
    public String toString() {
        return "Marchas{" +
                "nombreMarcha='" + nombreMarcha + '\'' +
                ", autor='" + autor + '\'' +
                '}';
    }
}
