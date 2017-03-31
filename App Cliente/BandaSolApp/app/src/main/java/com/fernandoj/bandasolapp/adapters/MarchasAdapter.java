package com.fernandoj.bandasolapp.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.fernandoj.bandasolapp.R;
import com.fernandoj.bandasolapp.constantes.ConstantesMusica;
import com.fernandoj.bandasolapp.interfaces.OnListFragmentMarchas;
import com.fernandoj.bandasolapp.pojos.Marchas;

import java.util.List;

/**
 * Adapatador del Fragment Marchas.
 */
public class MarchasAdapter extends RecyclerView.Adapter<MarchasAdapter.ViewHolder> {

    private final List<Marchas> mValues;
    private final OnListFragmentMarchas mListener;

    /**
     * Constructor
     *
     * @param items
     */
    public MarchasAdapter(List<Marchas> items, OnListFragmentMarchas listener) {
        mValues = items;
        mListener = listener;
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
                .inflate(R.layout.fragment_marchas_item, parent, false);
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

        holder.textViewNombreMarcha.setText(holder.mItem.getNombreMarcha());
        holder.textViewAutor.setText(ConstantesMusica.AUTOR + ": " + holder.mItem.getAutor());
        holder.mItem.getIdMarcha();


        holder.mView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (null != mListener) {
                    // Notify the active callbacks interface (the activity, if the
                    // fragment is attached to one) that an item has been selected.
                    mListener.onClickMarcha(holder.mItem);
                }
            }
        });
    }

    /**
     * Método que nos recoge todos los parámetros del objeto marchas.
     *
     * @return
     */
    @Override
    public int getItemCount() {
        return mValues.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public final View mView;
        public final TextView textViewNombreMarcha;
        public final TextView textViewAutor;
        public Marchas mItem;

        public ViewHolder(View view) {
            super(view);
            mView = view;
            textViewNombreMarcha = (TextView) view.findViewById(R.id.text_view_nombreMarcha);
            textViewAutor = (TextView) view.findViewById(R.id.text_view_autor);
        }

        @Override
        public String toString() {
            return super.toString() + " '" + mItem.toString() + "'";
        }
    }
}
