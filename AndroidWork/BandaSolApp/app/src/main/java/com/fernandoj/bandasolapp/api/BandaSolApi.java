package com.fernandoj.bandasolapp.api;

import com.fernandoj.bandasolapp.pojos.Componentes;
import com.fernandoj.bandasolapp.pojos.Eventos;
import com.fernandoj.bandasolapp.pojos.LoginResponse;
import com.fernandoj.bandasolapp.pojos.Marchas;
import com.fernandoj.bandasolapp.pojos.Noticias;

import java.util.List;

import retrofit.Call;
import retrofit.http.Field;
import retrofit.http.FormUrlEncoded;
import retrofit.http.GET;
import retrofit.http.POST;


/**
 * Created by FernandoJ on 23/03/2017.
 * <p>
 * Interfaz para la gestión de las peticiones a Retrofit.
 */

public interface BandaSolApi {

    /*
        Url base.
     */
    //http://10.0.2.2/
    String ENDPOINT = "http://192.168.1.59/bandasolapp/api/v0/";

    /*
    Contiene una lista de Noticias.
     */
    @GET("noticias/lista_noticias")
    Call<List<Noticias>> getNoticias();

    /*
    Contiene una lista de Componentes.
     */
    @GET("componentes/lista_componentes")
    Call<List<Componentes>> getComponentes();

    /*
    Contiene una lista de Eventos.
     */
    @GET("eventos/lista_eventos")
    Call<List<Eventos>> getEventos();

    /*
    Contiene una lista de Marchas
     */
    @GET("marchas/lista_marchas")
    Call<List<Marchas>> getMarchas();

    /*
    Petición del usuario y la contraseña al servidor.
     */
    @FormUrlEncoded
    @POST("usuarios/login")
    Call<LoginResponse> getLogin(@Field("e") String u,
                                 @Field("p") String p);


}
