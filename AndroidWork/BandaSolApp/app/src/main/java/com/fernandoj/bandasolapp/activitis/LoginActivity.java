package com.fernandoj.bandasolapp.activitis;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.fernandoj.bandasolapp.R;
import com.fernandoj.bandasolapp.api.BandaSolApi;
import com.fernandoj.bandasolapp.pojos.LoginResponse;

import retrofit.Call;
import retrofit.Callback;
import retrofit.GsonConverterFactory;
import retrofit.Response;
import retrofit.Retrofit;

public class LoginActivity extends AppCompatActivity {

    EditText editTextUsername, editTextPassword;
    Button btn;
    String username, password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);


        editTextUsername = (EditText) findViewById(R.id.edit_text_username);
        editTextPassword = (EditText) findViewById(R.id.edit_text_password);
        btn = (Button) findViewById(R.id.button_login);


        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                username = editTextUsername.getText().toString();
                password = editTextPassword.getText().toString();

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