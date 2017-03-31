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
import android.widget.Toast;

import com.fernandoj.bandasolapp.R;
import com.fernandoj.bandasolapp.adapters.MarchasAdapter;
import com.fernandoj.bandasolapp.api.BandaSolApi;
import com.fernandoj.bandasolapp.interfaces.OnListFragmentMarchas;
import com.fernandoj.bandasolapp.pojos.Marchas;

import java.util.List;

import retrofit.Call;
import retrofit.Callback;
import retrofit.GsonConverterFactory;
import retrofit.Response;
import retrofit.Retrofit;

/***
 * Fragment Marchas
 */
public class FragmentMarchas extends Fragment {


    private int mColumnCount = 1;
    RecyclerView recyclerView;
    private OnListFragmentMarchas mListener;

    /***
     * Constructor vacío
     */
    public FragmentMarchas() {
    }

    /***
     * Método que crea una instancia del fragment
     * @param savedInstanceState
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    /***
     * * Método que crea la vista del fragment.
     * Cargamos Retrofit y se lo pasamos al recycler.
     * @param inflater
     * @param container
     * @param savedInstanceState
     * @return
     */
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_marchas_list, container, false);

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

            final BandaSolApi servicio = retrofit.create(BandaSolApi.class);

            Call<List<Marchas>> call = servicio.getMarchas();

            call.enqueue(new Callback<List<Marchas>>() {
                @Override
                public void onResponse(Response<List<Marchas>> response, Retrofit retrofit) {
                    if (response.isSuccess()) {
                        List listMarchas = response.body();
                        recyclerView.setAdapter(new MarchasAdapter(listMarchas, mListener));
                    } else {
                        Log.e("RESP ERROR", "code: " + response.code() + " " + response.message());
                    }
                }

                @Override
                public void onFailure(Throwable t) {
                    Toast.makeText(getContext(), "Error: " + t.getMessage(), Toast.LENGTH_SHORT).show();
                }
            });


        }
        return view;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnListFragmentMarchas) {
            mListener = (OnListFragmentMarchas) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " deberías implementar la interfaz de marchas");
        }
    }


}
