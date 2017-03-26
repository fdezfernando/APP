package com.fernandoj.bandasolapp.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.fernandoj.bandasolapp.R;
import com.fernandoj.bandasolapp.interfaces.OnListFragmentComponentes;
import com.fernandoj.bandasolapp.pojos.Componentes;

import java.util.List;


public class ComponentesAdapter extends RecyclerView.Adapter<ComponentesAdapter.ViewHolder> {

    private final List<Componentes> mValues;
    private final OnListFragmentComponentes mListener;

    public ComponentesAdapter(List<Componentes> items, OnListFragmentComponentes listener) {
        mValues = items;
        mListener = listener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fragment_componentes_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        holder.mItem = mValues.get(position);

        holder.textViewNombreApellidos.setText(holder.mItem.getNombre() + " " + holder.mItem.getApellidos());
        holder.textViewMote.setText(holder.mItem.getMote());
        holder.textViewMovil.setText(holder.mItem.getMovil());


        holder.mView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (null != mListener) {
                    // Notify the active callbacks interface (the activity, if the
                    // fragment is attached to one) that an item has been selected.
                    // mListener.onClickComponente(holder.mItem);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return mValues.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public final View mView;
        public final TextView textViewNombreApellidos;
        public final TextView textViewMote;
        public final TextView textViewMovil;

        public Componentes mItem;

        public ViewHolder(View view) {
            super(view);
            mView = view;
            textViewNombreApellidos = (TextView) view.findViewById(R.id.text_view_nombre_apellidos);
            textViewMote = (TextView) view.findViewById(R.id.text_view_mote);
            textViewMovil = (TextView) view.findViewById(R.id.text_view_movil);
        }

        @Override
        public String toString() {
            return super.toString() + " '" + mItem.toString() + "'";
        }
    }
}
