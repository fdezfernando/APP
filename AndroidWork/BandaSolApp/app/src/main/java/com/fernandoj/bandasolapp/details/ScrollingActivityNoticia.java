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

/**
 * Clase Detalle de Noticias.
 */
public class ScrollingActivityNoticia extends AppCompatActivity {

    TextView textViewTituloDetalle, textViewCuerpoDetalle, textViewFechaDetalle;

    /**
     * Método que crear una instancia del Scrolling.
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scrolling_activityn_noticias);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        /*
        Instaciamos los objetos del XML.
         */
        textViewTituloDetalle = (TextView) findViewById(R.id.text_view_tituloDetalle);
        textViewCuerpoDetalle = (TextView) findViewById(R.id.text_view_cuerpoDetalle);
        textViewFechaDetalle = (TextView) findViewById(R.id.text_view_fechaDetalle);


        /*
        Pasamos los parámetros recogidos en el Activity.
         */
        Bundle extras = getIntent().getExtras();
        String titulo = extras.getString(ConstantesNoticia.EXTRA_TITULO);
        String cuerpo = extras.getString(ConstantesNoticia.EXTRA_CUERPO);
        String fecha = extras.getString(ConstantesNoticia.EXTRA_FECHA_NOTICIA);

        /*
        Seteando con los datos recgidos en el activity main
         */
        textViewTituloDetalle.setText(titulo);
        textViewCuerpoDetalle.setText(cuerpo);
        textViewFechaDetalle.setText(fecha);

        setTitle(""); // No nos interesa tener título así que lo dejamos en blanco.

    }
}
