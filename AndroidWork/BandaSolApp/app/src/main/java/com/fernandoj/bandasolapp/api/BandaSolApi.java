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
 */

public interface BandaSolApi {

    String ENDPOINT = "http://10.0.2.2/bandasolapp/api/v0/";

    @GET("noticias/lista_noticias")
    Call<List<Noticias>> getNoticias();

    @GET("componentes/lista_componentes")
    Call<List<Componentes>> getComponentes();

    @GET("eventos/lista_eventos")
    Call<List<Eventos>> getEventos();

    @GET("marchas/lista_marchas")
    Call<List<Marchas>> getMarchas();

    @FormUrlEncoded
    @POST("usuarios/login")
    Call<LoginResponse> getLogin(@Field("e") String u,
                                 @Field("p") String p);


}
