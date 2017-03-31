package com.fernandoj.bandasolapp.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.fernandoj.bandasolapp.R;
import com.fernandoj.bandasolapp.pojos.Eventos;

import java.util.List;

/**
 * Adapatador del Fragment Eventos.
 */
public class EventosAdapter extends RecyclerView.Adapter<EventosAdapter.ViewHolder> {

    private final List<Eventos> mValues;

    /**
     * Constructor
     * @param items
     */
    public EventosAdapter(List<Eventos> items) {
        mValues = items;

    }

    /**
     * Método que crea el adaptador.
     *
     * @param parent
     * @param viewType
     * @return
     */
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fragment_eventos_item, parent, false);
        return new ViewHolder(view);
    }

    /**
     * Método que nos permite pasarle los parámetros al fragment para que
     * éste los pinte.
     *
     * @param holder
     * @param position
     */
    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        holder.mItem = mValues.get(position);
        holder.textViewNombreEvento.setText(holder.mItem.getNombreEvento());
        holder.textViewLugar.setText(holder.mItem.getLugar());
        holder.textViewFecha.setText(holder.mItem.getFecha());

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

    /**
     * Método que nos recoge todos los parámetros del objeto eventos.
     *
     * @return
     */
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
