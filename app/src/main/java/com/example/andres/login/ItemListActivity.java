package com.example.andres.login;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TabHost;


public class ItemListActivity extends AppCompatActivity {

    TabHost th;

    Button btnCarView1Tab1;

    //FloatingActionButton fab;


       @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_list);

        btnCarView1Tab1 = (Button)findViewById(R.id.btnCarView1Tab1);

           btnCarView1Tab1.setOnClickListener(new View.OnClickListener() {
               @Override
               public void onClick(View v) {
                   Intent intent=new Intent(ItemListActivity.this, ItemDetailActivity.class);
                   startActivity(intent);
               }
           });
        th=(TabHost) findViewById(R.id.th);

        //Tab1
        th.setup();
           TabHost.TabSpec ts1=th.newTabSpec("Tab1");
           ts1.setIndicator("Comida Típica");
           ts1.setContent(R.id.tab1);

           th.addTab(ts1);

           //Tab2
           th.setup();
           TabHost.TabSpec ts2=th.newTabSpec("Tab2");
           ts2.setIndicator("Comida a la parrilla y plancha");
           ts2.setContent(R.id.tab2);

           th.addTab(ts2);

           //Tab3
           th.setup();
           TabHost.TabSpec ts3=th.newTabSpec("Tab3");
           ts3.setIndicator("Postres y bebidas");
           ts3.setContent(R.id.tab3);

           th.addTab(ts3);


       }


    }

