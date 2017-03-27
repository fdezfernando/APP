package com.fernandoj.bandasolapp.activitis;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.fernandoj.bandasolapp.R;
import com.fernandoj.bandasolapp.constantes.ConstantesNoticia;
import com.fernandoj.bandasolapp.details.ScrollingActivityNoticia;
import com.fernandoj.bandasolapp.fragments.FragmentComponentes;
import com.fernandoj.bandasolapp.fragments.FragmentEventos;
import com.fernandoj.bandasolapp.fragments.FragmentMarchas;
import com.fernandoj.bandasolapp.fragments.FragmentNoticias;
import com.fernandoj.bandasolapp.interfaces.OnListFragmentComponentes;
import com.fernandoj.bandasolapp.interfaces.OnListFragmentNoticias;
import com.fernandoj.bandasolapp.pojos.Componentes;
import com.fernandoj.bandasolapp.pojos.Noticias;

import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener, OnListFragmentNoticias, OnListFragmentComponentes {

    Fragment f;
    NavigationView navigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (savedInstanceState == null) {
            //getSupportFragmentManager().beginTransaction().replace(R.id.container, new FragmentNoticias()).commit();
            //onNavigationItemSelected(navigationView.getMenu().getItem(R.id.nav_noticias));
        }

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        switch (id) {
            case R.id.nav_noticias:
                f = new FragmentNoticias();
                addFragment(f); //Llamámos al método que agrega el fragment dinámicamente
                break;
            case R.id.nav_componentes:
                f = new FragmentComponentes();
                replaceFragment(f); //Llamámos al método que reemplaza el fragment dinámicamente
                break;
            case R.id.nav_eventos:
                f = new FragmentEventos();
                replaceFragment(f);
                break;
            case R.id.nav_marchas:
                f = new FragmentMarchas();
                replaceFragment(f);
                break;
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    /* Método que agrega un fragment*/
    public void addFragment(Fragment f) {
        getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.container, f)
                .detach(f)      // detach y attach nos permite refrescar el fragment
                .attach(f)      // por si hay algún cambio en el servidor.
                .commit();
    }

    /* Método que reemplaza un fragment*/
    public void replaceFragment(Fragment f) {
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.container, f)
                .detach(f)
                .attach(f)
                .commit();
    }

    @Override
    public void onClickNoticias(Noticias noticias) {

        Bundle extras = new Bundle();
        extras.putString(ConstantesNoticia.EXTRA_TITULO, noticias.getTitulo());
        extras.putString(ConstantesNoticia.EXTRA_CUERPO, noticias.getCuerpo());

        DateTimeFormatter fmt = DateTimeFormat.forPattern("d MMMM, yyyy");
        String fechaNoticia = fmt.print(noticias.getFecha());

        extras.putString(ConstantesNoticia.EXTRA_FECHA_NOTICIA, fechaNoticia);

        Intent intent = new Intent(MainActivity.this, ScrollingActivityNoticia.class);
        intent.putExtras(extras);
        startActivity(intent);
    }

    @Override
    public void onClickComponente(Componentes componente) {

    }


}
