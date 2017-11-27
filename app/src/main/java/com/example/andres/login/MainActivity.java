package com.example.andres.login;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {

    EditText etUser, etPass;
    TextView tvRegistrar;
    Button btnIngresar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etUser=(EditText)findViewById(R.id.etUser);
        etPass=(EditText)findViewById(R.id.etPass);

        tvRegistrar=(TextView) findViewById(R.id.tvRegistrar);
        tvRegistrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this, RegistroActivity.class);
                MainActivity.this.startActivity(intent);
            }
        });

        btnIngresar = (Button)findViewById(R.id.btnIngresar);
        btnIngresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final String username=etUser.getText().toString();
                final String password=etPass.getText().toString();

                //escuchador login
                Response.Listener<String> responseListener= new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {

                        try {
                            JSONObject jsonResponse= new JSONObject(response);
                            boolean success = jsonResponse.getBoolean("success");

                            if (success){
                                //extraer los datos
                                String name=jsonResponse.getString("name");
                                int age=jsonResponse.getInt("age");

                                //enviar datos al activityUsuario
                                Intent intent=new Intent(MainActivity.this, UsuarioActivity.class);

                                intent.putExtra("name", name);
                                intent.putExtra("username", username);
                                intent.putExtra("age", age);
                                intent.putExtra("password", password);

                                startActivity(intent);

                            }
                            else{
                                //Toast toast=  Toast.makeText(RegistroActivity.this, "Error en el registro.", Toast.LENGTH_LONG);
                                //toast.show();

                                AlertDialog.Builder builder=new AlertDialog.Builder(MainActivity.this);
                                builder.setMessage("Usuario ó Contraseña Incorrectos!")
                                        .setNegativeButton("Retry", null)
                                        .create().show();

                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                };

                LoginRequest loginRequest = new LoginRequest(username,password, responseListener);
                RequestQueue queue = Volley.newRequestQueue(MainActivity.this);
                queue.add(loginRequest);

            }
        }

        );
    }
}
