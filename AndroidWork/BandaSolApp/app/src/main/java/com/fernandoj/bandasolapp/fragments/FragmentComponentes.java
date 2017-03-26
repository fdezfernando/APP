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
import com.fernandoj.bandasolapp.adapters.ComponentesAdapter;
import com.fernandoj.bandasolapp.api.BandaSolApi;
import com.fernandoj.bandasolapp.interfaces.OnListFragmentComponentes;
import com.fernandoj.bandasolapp.pojos.Componentes;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;

import net.danlew.android.joda.JodaTimeAndroid;

import org.joda.time.DateTime;

import java.lang.reflect.Type;
import java.util.Date;
import java.util.List;

import retrofit.Call;
import retrofit.Callback;
import retrofit.GsonConverterFactory;
import retrofit.Response;
import retrofit.Retrofit;


public class FragmentComponentes extends Fragment {


    private int mColumnCount = 1;
    private OnListFragmentComponentes mListener;
    RecyclerView recyclerView;


    public FragmentComponentes() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_componentes_list, container, false);

        // Set the adapter
        if (view instanceof RecyclerView) {
            Context context = view.getContext();
            recyclerView = (RecyclerView) view;
            if (mColumnCount <= 1) {
                recyclerView.setLayoutManager(new LinearLayoutManager(context));
            } else {
                recyclerView.setLayoutManager(new GridLayoutManager(context, mColumnCount));
            }

            JodaTimeAndroid.init(getActivity());

            Gson gson = new GsonBuilder()
                    .registerTypeAdapter(DateTime.class, new DateTimeTypeConverter())
                    .create();

            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(BandaSolApi.ENDPOINT)
                    .addConverterFactory(GsonConverterFactory.create(gson))
                    .build();

            BandaSolApi servicio = retrofit.create(BandaSolApi.class);

            Call<List<Componentes>> call = servicio.getComponentes();

            call.enqueue(new Callback<List<Componentes>>() {
                @Override
                public void onResponse(Response<List<Componentes>> response, Retrofit retrofit) {
                    if (response.isSuccess()) {
                        List listComponentes = response.body();
                        recyclerView.setAdapter(new ComponentesAdapter(listComponentes, mListener));
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
        if (context instanceof OnListFragmentComponentes) {
            mListener = (OnListFragmentComponentes) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnListFragmentInteractionListener");
        }
    }


    private static class DateTimeTypeConverter
            implements JsonSerializer<DateTime>, JsonDeserializer<DateTime> {
        @Override
        public JsonElement serialize(DateTime src, Type srcType, JsonSerializationContext context) {
            return new JsonPrimitive(src.toString());
        }

        @Override
        public DateTime deserialize(JsonElement json, Type type, JsonDeserializationContext context)
                throws JsonParseException {
            try {
                return new DateTime(json.getAsString());
            } catch (IllegalArgumentException e) {
                // May be it came in formatted as a java.util.Date, so try that
                Date date = context.deserialize(json, Date.class);
                return new DateTime(date);
            }
        }
    }


}
