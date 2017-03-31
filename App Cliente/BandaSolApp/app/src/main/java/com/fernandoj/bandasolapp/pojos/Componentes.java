package com.fernandoj.bandasolapp.pojos;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by FernandoJ on 26/03/2017.
 * <p>
 * Clase componentes
 */

public class Componentes {

    /**
     * Atributo nombre
     */
    @SerializedName("nombre")
    @Expose
    private String nombre;
    /**
     * Atributo apellido
     */
    @SerializedName("apellidos")
    @Expose
    private String apellidos;
    /**
     * Atributo mote
     */
    @SerializedName("mote")
    @Expose
    private String mote;
    /**
     * Atributo movil
     */
    @SerializedName("movil")
    @Expose
    private String movil;

    /**
     * Constructor con parámetros
     *
     * @param nombre
     * @param apellidos
     * @param mote
     * @param movil
     */

    public Componentes(String nombre, String apellidos, String mote, String movil) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.mote = mote;
        this.movil = movil;
    }

    /**
     * Constructor vacío
     */
    public Componentes() {
    }

    /**
     * Get nombre
     *
     * @return
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Set nombre
     *
     * @param nombre
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Get apellidos
     *
     * @return
     */
    public String getApellidos() {
        return apellidos;
    }

    /**
     * Set apellidos
     *
     * @param apellidos
     */
    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    /**
     * Get mote
     *
     * @return
     */
    public String getMote() {
        return mote;
    }

    /**
     * Set mote
     *
     * @param mote
     */
    public void setMote(String mote) {
        this.mote = mote;
    }

    /**
     * Get móvil
     *
     * @return
     */
    public String getMovil() {
        return movil;
    }

    /**
     * Set móvil
     *
     * @param movil
     */
    public void setMovil(String movil) {
        this.movil = movil;
    }

    /**
     * To String componente
     *
     * @return
     */
    @Override
    public String toString() {
        return "Componentes{" +
                "nombre='" + nombre + '\'' +
                ", apellidos='" + apellidos + '\'' +
                ", mote='" + mote + '\'' +
                ", movil='" + movil + '\'' +
                '}';
    }
}