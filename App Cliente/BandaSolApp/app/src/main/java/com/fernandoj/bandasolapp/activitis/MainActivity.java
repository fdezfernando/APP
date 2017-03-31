package com.fernandoj.bandasolapp.activitis;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.fernandoj.bandasolapp.R;
import com.fernandoj.bandasolapp.constantes.ConstantesMusica;
import com.fernandoj.bandasolapp.constantes.ConstantesNoticia;
import com.fernandoj.bandasolapp.constantes.ConstantesPermisos;
import com.fernandoj.bandasolapp.constantes.ConstantesUsuario;
import com.fernandoj.bandasolapp.details.ScrollingActivityNoticia;
import com.fernandoj.bandasolapp.fragments.FragmentComponentes;
import com.fernandoj.bandasolapp.fragments.FragmentEventos;
import com.fernandoj.bandasolapp.fragments.FragmentMarchas;
import com.fernandoj.bandasolapp.fragments.FragmentNoticias;
import com.fernandoj.bandasolapp.interfaces.OnListFragmentComponentes;
import com.fernandoj.bandasolapp.interfaces.OnListFragmentMarchas;
import com.fernandoj.bandasolapp.interfaces.OnListFragmentNoticias;
import com.fernandoj.bandasolapp.pojos.Componentes;
import com.fernandoj.bandasolapp.pojos.Marchas;
import com.fernandoj.bandasolapp.pojos.Noticias;

import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

/**
 * Activity principal con NavigationDrawer
 */

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener, OnListFragmentNoticias, OnListFragmentComponentes, OnListFragmentMarchas {

    Fragment f;
    NavigationView navigationView;
    TextView textViewUsuario;
    String call;
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        /* Instanciamos y recatamos el menú lateral*/
        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        View header = navigationView.getHeaderView(0);

        /* Rescatamos el parámetro del usuario*/
        textViewUsuario = (TextView) header.findViewById(R.id.text_view_navigation_user);

        /* Cargamos las preferencias con el nombre de usuario*/
        SharedPreferences prefs =
                getSharedPreferences("MisPreferencias", Context.MODE_PRIVATE);

        String usuario = prefs.getString(ConstantesUsuario.USUARIO, "Usuario");

        /* Seteamos el texto del menú lateral con el nombre de nuestro usuario*/
        textViewUsuario.setText(usuario);

        /* Cargamos una vista por defecto del menú*/
        onNavigationItemSelected(navigationView.getMenu().getItem(0));
        /* Nos permite que se chequee el botón del menú lateral*/
        navigationView.getMenu().getItem(0).setChecked(true);


        if (ContextCompat.checkSelfPermission(this,
                Manifest.permission.CALL_PHONE)
                != PackageManager.PERMISSION_GRANTED) {

            if (ActivityCompat.shouldShowRequestPermissionRationale(this,
                    Manifest.permission.CALL_PHONE)) {

            } else {

                ActivityCompat.requestPermissions(this,
                        new String[]{Manifest.permission.CALL_PHONE},
                        ConstantesPermisos.MI_PERMISOS);

            }
        }
    }

    /**
     * Método que maneja el botón de ir hacia atrás
     * para nuestro menú lateral
     */
    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    /**
     * Método que crear el menú de opciones.
     * Infla el menú.
     *
     * @param menu
     * @return
     */
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    /**
     * Método que rescata el item de nuestro menú de la derecha.
     *
     * @param item
     * @return
     */
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        switch (id) {
            case R.id.action_logout:
                Intent i = new Intent(MainActivity.this, LoginActivity.class);
                startActivity(i);
                break;
        }


        return super.onOptionsItemSelected(item);
    }


    /**
     * Método que rescata el item en el que hacemos click
     * y carga el fragment dinámicamente.
     *
     * @param item
     * @return
     */
    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        switch (id) {
            case R.id.nav_noticias:
                f = new FragmentNoticias();
                addFragment(f); //Llamámos al método que agrega el fragment dinámicamente
                setTitle(item.getTitle());
                break;
            case R.id.nav_componentes:
                f = new FragmentComponentes();
                replaceFragment(f); //Llamámos al método que reemplaza el fragment dinámicamente
                setTitle(item.getTitle());
                break;
            case R.id.nav_eventos:
                f = new FragmentEventos();
                replaceFragment(f);
                setTitle(item.getTitle());
                break;
            case R.id.nav_marchas:
                f = new FragmentMarchas();
                replaceFragment(f);
                setTitle(item.getTitle());
                break;
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    /**
     * Método que agrega un fragment.
     *
     * @param f
     */
    public void addFragment(Fragment f) {
        getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.container, f)
                .detach(f)      // detach y attach nos permite refrescar el fragment
                .attach(f)      // por si hay algún cambio en el servidor.
                .commit();
    }

    /**
     * Método que reemplaza un fragment.
     *
     * @param f
     */
    public void replaceFragment(Fragment f) {
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.container, f)
                .detach(f)
                .attach(f)
                .commit();
    }

    /**
     * Método que de la interfaz OnListFragmentNoticias.
     * Recoge el objeto que se le ha hecho click con
     * un bundle y lo pasamos al acttivity ScrollingActivity
     *
     * @param noticias
     */
    @Override
    public void onClickNoticias(Noticias noticias) {

        Bundle extras = new Bundle();
        extras.putString(ConstantesNoticia.EXTRA_TITULO, noticias.getTitulo());
        extras.putString(ConstantesNoticia.EXTRA_CUERPO, noticias.getCuerpo());

        DateTimeFormatter fmt = DateTimeFormat.forPattern("d MMMM, yyyy");
        String fechaNoticia = fmt.print(noticias.getFecha());

        extras.putString(ConstantesNoticia.EXTRA_FECHA_NOTICIA, fechaNoticia);

        intent = new Intent(MainActivity.this, ScrollingActivityNoticia.class);
        intent.putExtras(extras);
        startActivity(intent);
    }

    @Override
    public void onClickMarcha(Marchas marcha) {
        intent = new Intent(MainActivity.this, MusicActivity.class);

        SharedPreferences prefs =
                getSharedPreferences("MisPreferencias", Context.MODE_PRIVATE);

        SharedPreferences.Editor editor = prefs.edit();
        editor.putString(ConstantesMusica.URL ,marcha.getUrl()+marcha.getIdMarcha()+marcha.getTipo());
        editor.putString(ConstantesMusica.AUTOR, marcha.getAutor());
        editor.putString(ConstantesMusica.NOMBRE_MARCHA, marcha.getNombreMarcha());
        editor.putInt(String.valueOf(ConstantesMusica.MINUTOS), marcha.getTiempo());
        editor.commit();

        startActivity(intent);

    }

    @Override
    public void onClickComponente(Componentes componente) {

        call = componente.getMovil();

        Intent intent = new Intent(Intent.ACTION_CALL, Uri.parse("tel:" + call));
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return;
        }
        startActivity(intent);

    }


    @Override
    public void onRequestPermissionsResult(int requestCode, String permissions[], int[] grantResults) {
        switch (requestCode) {
            case ConstantesPermisos.MI_PERMISOS: {
                // If request is cancelled, the result arrays are empty.
                if (grantResults.length > 0
                        && grantResults[0] == PackageManager.PERMISSION_GRANTED) {

                } else {

                    Toast.makeText(this, "Ha cancelado los permisos, no podrá hacer llamadas", Toast.LENGTH_SHORT).show();

                }
                return;
            }
        }
    }


}
