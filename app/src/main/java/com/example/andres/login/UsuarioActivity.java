package com.example.andres.login;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class UsuarioActivity extends AppCompatActivity {

    Button btnSeguir, btnAcercaDe;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_usuario);

        btnSeguir = (Button)findViewById(R.id.btnSegir);
        btnAcercaDe = (Button)findViewById(R.id.btnAcercaDe);

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
