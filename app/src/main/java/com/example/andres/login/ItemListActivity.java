package com.example.andres.login;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;


public class ItemListActivity extends AppCompatActivity {

    Button btnCarView1;
    FloatingActionButton fab;
       @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_list);

           btnCarView1 = (Button)findViewById(R.id.btnCarView1);

           btnCarView1.setOnClickListener(new View.OnClickListener() {
               @Override
               public void onClick(View v) {
                   Intent intent=new Intent(ItemListActivity.this, ItemDetailActivity.class);
                   startActivity(intent);
               }
           });
       }


    }

