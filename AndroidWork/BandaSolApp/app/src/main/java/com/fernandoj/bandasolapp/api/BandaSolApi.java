package com.fernandoj.bandasolapp.api;

import com.fernandoj.bandasolapp.pojos.Noticias;

import java.util.List;

import retrofit.Call;
import retrofit.http.GET;

/**
 * Created by FernandoJ on 23/03/2017.
 */

public interface BandaSolApi {

    String ENDPOINT = "http://10.0.2.2/bandasolapp/api/v0/";

    @GET("noticias/lista_noticias")
    Call<List<Noticias>> getNoticias();


}
