package com.parvamatematicheska.viki.tamago;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.animation.Animation;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class Main3Activity extends AppCompatActivity {
    TextView otvarqniq;
    TextView schupwaniq;
    Button nazad;
    ImageView proba;
    Animation animation = null;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        nazad = (Button) findViewById(R.id.button);

        nazad.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(Main3Activity.this, MainActivity.class);
                startActivity(intent1);
                finish();
            }
        });



        SharedPreferences preferences = getSharedPreferences("main", MODE_PRIVATE);
        int statAppsOpened = preferences.getInt("statAppsOpened", 0);

        otvarqniq = (TextView) findViewById(R.id.otvarqniq_id);
        otvarqniq.setText(Integer.toString(statAppsOpened));

        SharedPreferences schupvaniq_na_qjca = getSharedPreferences("main", MODE_PRIVATE);
        int egg_brokens = preferences.getInt("egg_brokens", 0);

        schupwaniq = (TextView) findViewById(R.id.eggs_brokens);
        schupwaniq.setText(Integer.toString(egg_brokens));











        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }


}