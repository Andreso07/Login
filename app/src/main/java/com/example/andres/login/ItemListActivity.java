package com.example.andres.login;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TabHost;


public class ItemListActivity extends AppCompatActivity {

    TabHost th;

    //FloatingActionButton fab;


       @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_list);

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
           ts3.setIndicator("Postres");
           ts3.setContent(R.id.tab3);

           th.addTab(ts3);


       }


    }

