package com.example.andres.login;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

public class RegistroActivity extends AppCompatActivity implements View.OnClickListener {

    EditText etNombre, etUsuario, etPassword, etEdad;
    Button btnRegistrar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);

        etNombre   = (EditText)findViewById(R.id.etNombre);
        etUsuario  = (EditText)findViewById(R.id.etUsuario);
        etPassword = (EditText)findViewById(R.id.etPassword);
        etEdad     = (EditText)findViewById(R.id.etEdad);

        btnRegistrar =(Button)findViewById(R.id.btnRegistrar);

        btnRegistrar.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {

        //capturamos los textos
        final String name=etNombre.getText().toString();
        final String username=etUsuario.getText().toString();
        final String password=etPassword.getText().toString();
        final int age= Integer.parseInt(etEdad.getText().toString());

        //variables capturadas por las cajas

        Response.Listener<String> respoListener= new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                try {
                    JSONObject jsonResponse = new JSONObject(response);

                    //corresponde a una respuesta de register php
                    boolean success = jsonResponse.getBoolean("success");

                    if (success){
                        Intent intent=new Intent(RegistroActivity.this, MainActivity.class);
                        RegistroActivity.this.startActivity(intent);


                    }
                    else{
                        //Toast toast=  Toast.makeText(RegistroActivity.this, "Error en el registro.", Toast.LENGTH_LONG);
                        //toast.show();

                        AlertDialog.Builder builder=new AlertDialog.Builder(RegistroActivity.this);
                        builder.setMessage("Error al registro")
                                .setNegativeButton("Retry", null)
                                .create().show();

                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        };

       RegisterRequest registerRequest=new RegisterRequest(name,username,age,password,respoListener);
        RequestQueue queue = Volley.newRequestQueue(RegistroActivity.this);
        queue.add(registerRequest);
    }
}
