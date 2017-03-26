package com.fernandoj.bandasolapp.pojos;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by FernandoJ on 26/03/2017.
 */

public class Marchas {

    @SerializedName("idMarcha")
    @Expose
    private String idMarcha;
    @SerializedName("nombreMarcha")
    @Expose
    private String nombreMarcha;
    @SerializedName("autor")
    @Expose
    private String autor;
    @SerializedName("Componente_idComponente")
    @Expose
    private String componenteIdComponente;


    public Marchas(String idMarcha, String nombreMarcha, String autor, String componenteIdComponente) {
        this.idMarcha = idMarcha;
        this.nombreMarcha = nombreMarcha;
        this.autor = autor;
        this.componenteIdComponente = componenteIdComponente;
    }

    public Marchas() {
    }

    public String getIdMarcha() {
        return idMarcha;
    }

    public void setIdMarcha(String idMarcha) {
        this.idMarcha = idMarcha;
    }

    public String getNombreMarcha() {
        return nombreMarcha;
    }

    public void setNombreMarcha(String nombreMarcha) {
        this.nombreMarcha = nombreMarcha;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getComponenteIdComponente() {
        return componenteIdComponente;
    }

    public void setComponenteIdComponente(String componenteIdComponente) {
        this.componenteIdComponente = componenteIdComponente;
    }




}
