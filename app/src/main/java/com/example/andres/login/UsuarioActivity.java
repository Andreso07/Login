package com.example.andres.login;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class UsuarioActivity extends AppCompatActivity {

    Button btnSeguir, btnAcercaDe;

    TextView tvNombre, tvUsuario, tvEdad, tvPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_usuario);

        btnSeguir = (Button)findViewById(R.id.btnSegir);
        btnAcercaDe = (Button)findViewById(R.id.btnAcercaDe);

        tvNombre = (TextView) findViewById(R.id.tvNombre);
        tvUsuario = (TextView) findViewById(R.id.tvUsuario);
        tvEdad = (TextView) findViewById(R.id.tvEdad);
        tvPassword = (TextView) findViewById(R.id.tvContraseña);

        //para recibir
        Intent intent= getIntent();
        String name= intent.getStringExtra("name");
        String username= intent.getStringExtra("username");
        String password= intent.getStringExtra("password");
        int age= intent.getIntExtra("age",-1);

        tvNombre.setText(name);
        tvUsuario.setText(username);
        tvPassword.setText(password);
        tvEdad.setText(age+"");

        btnSeguir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent=new Intent(UsuarioActivity.this, ItemListActivity.class);
                startActivity(intent);
            }
        });
    }
    public void acercaDe(View view){

        Intent i=new Intent(this,AcercaDe.class);
        startActivity(i);

    }
}
