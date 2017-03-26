package com.fernandoj.bandasolapp.details;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

import com.fernandoj.bandasolapp.R;
import com.fernandoj.bandasolapp.constantes.ConstantesNoticia;

public class ScrollingActivityNoticia extends AppCompatActivity {

    TextView textViewTituloDetalle, textViewCuerpoDetalle, textViewFechaDetalle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scrolling_activityn_noticias);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        textViewTituloDetalle = (TextView) findViewById(R.id.text_view_tituloDetalle);
        textViewCuerpoDetalle = (TextView) findViewById(R.id.text_view_cuerpoDetalle);
        textViewFechaDetalle = (TextView) findViewById(R.id.text_view_fechaDetalle);

        /*FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });*/


        Bundle extras = getIntent().getExtras();
        String titulo = extras.getString(ConstantesNoticia.EXTRA_TITULO);
        String cuerpo = extras.getString(ConstantesNoticia.EXTRA_CUERPO);
        String fecha = extras.getString(ConstantesNoticia.EXTRA_FECHA_NOTICIA);

        textViewTituloDetalle.setText(titulo);
        textViewCuerpoDetalle.setText(cuerpo);
        textViewFechaDetalle.setText(fecha);

        setTitle("");

    }
}
