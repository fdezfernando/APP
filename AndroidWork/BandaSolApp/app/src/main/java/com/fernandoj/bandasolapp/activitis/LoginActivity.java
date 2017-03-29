package com.fernandoj.bandasolapp.activitis;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.fernandoj.bandasolapp.R;
import com.fernandoj.bandasolapp.api.BandaSolApi;
import com.fernandoj.bandasolapp.constantes.ConstantesUsuario;
import com.fernandoj.bandasolapp.pojos.LoginResponse;

import retrofit.Call;
import retrofit.Callback;
import retrofit.GsonConverterFactory;
import retrofit.Response;
import retrofit.Retrofit;

/**
 * Activity para hacer nuestro login
 */

public class LoginActivity extends AppCompatActivity {

    EditText editTextUsername, editTextPassword;
    Button btn;
    String username, password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        /* Rescatamos los campos de usuario y contraseña y el botón.
            */
        editTextUsername = (EditText) findViewById(R.id.edit_text_username);
        editTextPassword = (EditText) findViewById(R.id.edit_text_password);
        btn = (Button) findViewById(R.id.button_login);

        /**
         * Método con función anónima con el que controlaremos la acción del botón.
         */
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                /* Rescatamos los parametros del EditText */
                username = editTextUsername.getText().toString();
                password = editTextPassword.getText().toString();

                /* Creación de Retrofit para hacer un POST a la base
                de datos y comprobar si el usuario está registrado.
                 */

                Retrofit retrofit = new Retrofit.Builder()
                        .baseUrl(BandaSolApi.ENDPOINT)
                        .addConverterFactory(GsonConverterFactory.create())
                        .build();

                BandaSolApi service = retrofit.create(BandaSolApi.class);

                Call<LoginResponse> repos = service.getLogin(username, password);

                repos.enqueue(new Callback<LoginResponse>() {
                    @Override
                    public void onResponse(Response<LoginResponse> response, Retrofit retrofit) {
                        if (response.isSuccess()) {

                            String nombre = response.body().getData().getFirstName();
                            String apellido = response.body().getData().getLastName();

                            SharedPreferences prefs =
                                    getSharedPreferences("MisPreferencias", Context.MODE_PRIVATE);

                            SharedPreferences.Editor editor = prefs.edit();
                            editor.putString(ConstantesUsuario.USUARIO, nombre + " " + apellido);
                            editor.commit();

                            Intent i = new Intent(LoginActivity.this, MainActivity.class);
                            startActivity(i);
                            finish(); // Elimina de la pila el Login activity para que usuario no pueda volver atrás.
                        } else {
                            Toast.makeText(LoginActivity.this, "Usuario o contraseña incorrecta", Toast.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void onFailure(Throwable t) {
                    }


                });
            }
        });


    }
}