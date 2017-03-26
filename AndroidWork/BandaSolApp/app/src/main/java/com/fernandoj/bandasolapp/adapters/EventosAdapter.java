package com.fernandoj.bandasolapp.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.fernandoj.bandasolapp.R;
import com.fernandoj.bandasolapp.pojos.Eventos;

import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import java.util.List;


public class EventosAdapter extends RecyclerView.Adapter<EventosAdapter.ViewHolder> {

    private final List<Eventos> mValues;


    public EventosAdapter(List<Eventos> items) {
        mValues = items;

    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fragment_eventos_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        holder.mItem = mValues.get(position);

        DateTimeFormatter fmt = DateTimeFormat.forPattern("d MMMM, yyyy HH:mm");
        String fechaEvento = fmt.print(holder.mItem.getFecha());

        holder.textViewNombreEvento.setText(holder.mItem.getNombreEvento());
        holder.textViewLugar.setText(holder.mItem.getLugar());
        holder.textViewFecha.setText(fechaEvento);

        holder.mView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /*if (null != mListener) {
                    // Notify the active callbacks interface (the activity, if the
                    // fragment is attached to one) that an item has been selected.
                    mListener.onListFragmentInteraction(holder.mItem);
                }*/
            }
        });
    }

    @Override
    public int getItemCount() {
        return mValues.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public final View mView;
        public final TextView textViewNombreEvento;
        public final TextView textViewLugar;
        public final TextView textViewFecha;
        public Eventos mItem;

        public ViewHolder(View view) {
            super(view);
            mView = view;
            textViewNombreEvento = (TextView) view.findViewById(R.id.text_view_nombreEvento);
            textViewLugar = (TextView) view.findViewById(R.id.text_view_lugar);
            textViewFecha = (TextView) view.findViewById(R.id.text_view_fechaEvento);
        }

        @Override
        public String toString() {
            return super.toString() + " '" + mItem.toString() + "'";
        }
    }
}
