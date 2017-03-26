package com.fernandoj.bandasolapp.pojos;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import org.joda.time.DateTime;

/**
 * Created by FernandoJ on 26/03/2017.
 */

public class Componentes {

    @SerializedName("nombre")
    @Expose
    private String nombre;
    @SerializedName("apellidos")
    @Expose
    private String apellidos;
    @SerializedName("anteriorFormacion")
    @Expose
    private String anteriorFormacion;
    @SerializedName("email")
    @Expose
    private String email;
    @SerializedName("fechaBaja")
    @Expose
    private DateTime fechaBaja;
    @SerializedName("fechaIngreso")
    @Expose
    private DateTime fechaIngreso;
    @SerializedName("fechaNacimiento")
    @Expose
    private DateTime fechaNacimiento;
    @SerializedName("hermandad")
    @Expose
    private String hermandad;
    @SerializedName("localidad")
    @Expose
    private String localidad;
    @SerializedName("mote")
    @Expose
    private String mote;
    @SerializedName("movil")
    @Expose
    private String movil;

    @SerializedName("profesion")
    @Expose
    private String profesion;
    @SerializedName("telefonoFijo")
    @Expose
    private String telefonoFijo;
    @SerializedName("Instrumento_idInstrumento")
    @Expose
    private String instrumentoIdInstrumento;


    public Componentes(String nombre, String apellidos, String anteriorFormacion, String email, DateTime fechaBaja, DateTime fechaIngreso, DateTime fechaNacimiento, String hermandad, String localidad, String mote, String movil, String profesion, String telefonoFijo, String instrumentoIdInstrumento) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.anteriorFormacion = anteriorFormacion;
        this.email = email;
        this.fechaBaja = fechaBaja;
        this.fechaIngreso = fechaIngreso;
        this.fechaNacimiento = fechaNacimiento;
        this.hermandad = hermandad;
        this.localidad = localidad;
        this.mote = mote;
        this.movil = movil;
        this.profesion = profesion;
        this.telefonoFijo = telefonoFijo;
        this.instrumentoIdInstrumento = instrumentoIdInstrumento;
    }


    public Componentes() {
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getAnteriorFormacion() {
        return anteriorFormacion;
    }

    public void setAnteriorFormacion(String anteriorFormacion) {
        this.anteriorFormacion = anteriorFormacion;
    }


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public DateTime getFechaBaja() {
        return fechaBaja;
    }

    public void setFechaBaja(DateTime fechaBaja) {
        this.fechaBaja = fechaBaja;
    }

    public DateTime getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(DateTime fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    public DateTime getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(DateTime fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getHermandad() {
        return hermandad;
    }

    public void setHermandad(String hermandad) {
        this.hermandad = hermandad;
    }

    public String getLocalidad() {
        return localidad;
    }

    public void setLocalidad(String localidad) {
        this.localidad = localidad;
    }

    public String getMote() {
        return mote;
    }

    public void setMote(String mote) {
        this.mote = mote;
    }

    public String getMovil() {
        return movil;
    }

    public void setMovil(String movil) {
        this.movil = movil;
    }

    public String getProfesion() {
        return profesion;
    }

    public void setProfesion(String profesion) {
        this.profesion = profesion;
    }

    public String getTelefonoFijo() {
        return telefonoFijo;
    }

    public void setTelefonoFijo(String telefonoFijo) {
        this.telefonoFijo = telefonoFijo;
    }

    public String getInstrumentoIdInstrumento() {
        return instrumentoIdInstrumento;
    }

    public void setInstrumentoIdInstrumento(String instrumentoIdInstrumento) {
        this.instrumentoIdInstrumento = instrumentoIdInstrumento;
    }


    @Override
    public String toString() {
        return "Componentes{" +
                "nombre='" + nombre + '\'' +
                ", apellidos='" + apellidos + '\'' +
                ", anteriorFormacion='" + anteriorFormacion + '\'' +
                ", email='" + email + '\'' +
                ", fechaBaja=" + fechaBaja +
                ", fechaIngreso=" + fechaIngreso +
                ", fechaNacimiento='" + fechaNacimiento + '\'' +
                ", hermandad='" + hermandad + '\'' +
                ", localidad='" + localidad + '\'' +
                ", mote='" + mote + '\'' +
                ", movil='" + movil + '\'' +
                ", profesion='" + profesion + '\'' +
                ", telefonoFijo='" + telefonoFijo + '\'' +
                ", instrumentoIdInstrumento='" + instrumentoIdInstrumento + '\'' +
                '}';
    }
}