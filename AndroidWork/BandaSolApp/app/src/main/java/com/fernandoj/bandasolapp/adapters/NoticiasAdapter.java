package com.fernandoj.bandasolapp.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.fernandoj.bandasolapp.R;
import com.fernandoj.bandasolapp.pojos.Noticias;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import java.util.List;


public class NoticiasAdapter extends RecyclerView.Adapter<NoticiasAdapter.ViewHolder> {

    private final List<Noticias> mValues;
    private final OnListFragmentNoticias mListener;

    public NoticiasAdapter(List<Noticias> items, OnListFragmentNoticias listener) {
        mValues = items;
        mListener = listener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fragment_noticias_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        holder.mItem = mValues.get(position);

        DateTimeFormatter fmt = DateTimeFormat.forPattern("d MMMM, yyyy");
        String fechaNoticia = fmt.print(holder.mItem.getFecha());


        holder.textViewTitulo.setText(holder.mItem.getTitulo());
        holder.textViewCuerpo.setText(holder.mItem.getCuerpo());
        holder.textViewFecha.setText(fechaNoticia);


        holder.mView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (null != mListener) {
                    // Notify the active callbacks interface (the activity, if the
                    // fragment is attached to one) that an item has been selected.
                   // mListener.onClickNoticias(holder.mItem);
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
        public final TextView textViewTitulo;
        public final TextView textViewCuerpo;
        public final TextView textViewFecha;
        public Noticias mItem;

        public ViewHolder(View view) {
            super(view);
            mView = view;
            textViewTitulo = (TextView) view.findViewById(R.id.text_view_titulo);
            textViewCuerpo = (TextView) view.findViewById(R.id.text_view_cuerpo);
            textViewFecha = (TextView) view.findViewById(R.id.text_view_fecha);
        }

        @Override
        public String toString() {
            return super.toString() + " '" + mItem.toString() + "'";
        }
    }
}
