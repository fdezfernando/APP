package com.fernandoj.bandasolapp.activitis;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.TaskStackBuilder;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.fernandoj.bandasolapp.R;
import com.fernandoj.bandasolapp.constantes.ConstantesMusica;
import com.fernandoj.bandasolapp.servicios.ServicioMusica;

import co.mobiwise.library.MusicPlayerView;

public class MusicActivity extends AppCompatActivity implements View.OnClickListener {

    TextView textViewNombreCancion;
    MusicPlayerView musicPlayerView;
    boolean pausado = false;
    int minutos;
    NotificationCompat.Builder mBuilder;
    NotificationManager mNotificationManager;
    Intent i;
    String url, nombreMarcha;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_music);

        textViewNombreCancion = (TextView) findViewById(R.id.text_view_nombre_cancion);

        SharedPreferences prefs =
                getSharedPreferences("MisPreferencias", Context.MODE_PRIVATE);

        nombreMarcha = prefs.getString(ConstantesMusica.NOMBRE_MARCHA, " ");
        url = prefs.getString(ConstantesMusica.ID_CANCION, " ");
        minutos = prefs.getInt(String.valueOf(ConstantesMusica.MINUTOS), 1);

        musicPlayerView = (MusicPlayerView) findViewById(R.id.mpv);
        musicPlayerView.setOnClickListener(MusicActivity.this);
        musicPlayerView.setAutoProgress(true);
        musicPlayerView.setCoverURL("http://www.bandasol.com/wp-content/uploads/2017/02/Frontal-6-300x300.jpg");
        musicPlayerView.setMax(minutos);
        textViewNombreCancion.setText(nombreMarcha);

        i = new Intent(this, ServicioMusica.class);
        stopService(i);
    }

    @Override
    public void onClick(View v) {
        if (musicPlayerView.isRotating()) {
            stopService(i);
            textViewNombreCancion.setText(nombreMarcha);
            pausado = true;
            musicPlayerView.stop();
        } else {
            musicPlayerView.start();
            mBuilder = new NotificationCompat.Builder(this)
                    .setSmallIcon(R.drawable.bandasolcom)
                    .setContentTitle("Escuchando..." + nombreMarcha);


            Intent resultIntent = new Intent(this, MusicActivity.class);

            TaskStackBuilder stackBuilder = TaskStackBuilder.create(this);

            // Activity desde el que se lanza la Notificación
            stackBuilder.addParentStack(MusicActivity.class);
            stackBuilder.addNextIntent(resultIntent);
            PendingIntent resultPendingIntent =
                    stackBuilder.getPendingIntent(
                            0,
                            PendingIntent.FLAG_UPDATE_CURRENT
                    );
            mBuilder.setContentIntent(resultPendingIntent);
            // fin gestión pila navegación

            mNotificationManager =
                    (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);

            // La siguiente línea de código es la responsable de mostrar
            // la notificación en el statusBar.
            mNotificationManager.notify(ConstantesMusica.ID_NOTIFICACION_REPRODUCTOR, mBuilder.build());

            if (pausado) {
                stopService(i);
                i.putExtra("tiempo", musicPlayerView.getProgress());
            }
            i.putExtra("urlMarcha", url);
            startService(i);
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        //mNotificationManager.cancel(ConstantesMusica.ID_NOTIFICACION_REPRODUCTOR);
        stopService(i);
    }

}

