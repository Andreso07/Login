package com.example.andres.login;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

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

                if (etUser.getText().toString().equals("admin") && etPass.getText().toString().equals("admin")) {
                    Intent intent = new Intent(MainActivity.this, UsuarioActivity.class);
                    startActivity(intent);
                }
                else{
                    Toast toast=  Toast.makeText(MainActivity.this, "Verifique usuario o password.", Toast.LENGTH_LONG);
                    toast.show();
                }
            }
        }

        );
    }
}
