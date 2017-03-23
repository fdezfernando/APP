package com.fernandoj.bandasolapp.fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.fernandoj.bandasolapp.R;
import com.fernandoj.bandasolapp.adapters.NoticiasAdapter;
import com.fernandoj.bandasolapp.adapters.OnListFragmentNoticias;
import com.fernandoj.bandasolapp.api.BandaSolApi;
import com.fernandoj.bandasolapp.pojos.Noticias;

import java.util.List;

import retrofit.Call;
import retrofit.Callback;
import retrofit.GsonConverterFactory;
import retrofit.Response;
import retrofit.Retrofit;


public class FragmentNoticias extends Fragment {

    private int mColumnCount = 1;
    RecyclerView recyclerView;

    private OnListFragmentNoticias mListener;


    public FragmentNoticias() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_noticias_list, container, false);

        // Set the adapter
        if (view instanceof RecyclerView) {
            Context context = view.getContext();
            recyclerView = (RecyclerView) view;
            if (mColumnCount <= 1) {
                recyclerView.setLayoutManager(new LinearLayoutManager(context));
            } else {
                recyclerView.setLayoutManager(new GridLayoutManager(context, mColumnCount));
            }

            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(BandaSolApi.ENDPOINT)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

            BandaSolApi servicio = retrofit.create(BandaSolApi.class);


            Call<List<Noticias>> call = servicio.getNoticias();

            call.enqueue(new Callback<List<Noticias>>() {
                @Override
                public void onResponse(Response<List<Noticias>> response, Retrofit retrofit) {
                    if (response.isSuccess()) {
                        List listNoticias = response.body();
                        recyclerView.setAdapter(new NoticiasAdapter(listNoticias, mListener));
                    } else {
                        Log.e("RESP ERROR", "code: "+response.code()+" "+response.message());
                    }
                }

                @Override
                public void onFailure(Throwable t) {

                }
            });

        }
        return view;
    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnListFragmentNoticias) {
            mListener = (OnListFragmentNoticias) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnListFragmentInteractionListener");
        }
    }


}
