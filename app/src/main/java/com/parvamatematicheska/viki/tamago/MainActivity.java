package com.parvamatematicheska.viki.tamago;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView tv_napraweni_klikowe_1;
    ImageView start_btn;
    ImageView restart;
    ImageView statistiki;
    int viki;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        tv_napraweni_klikowe_1= (TextView) findViewById(R.id.tv_broi_napraweni_klikowe_1);
        start_btn = (ImageView) findViewById(R.id.start_btn_id);
        restart = (ImageView) findViewById(R.id.restart);
        statistiki = (ImageView) findViewById(R.id.stats);



        start_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent secondPage = new Intent(MainActivity.this, Main2Activity.class);
                startActivity(secondPage);

            }
        });

        restart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences pref = getSharedPreferences("main", 0);
                SharedPreferences.Editor editor = pref.edit();
                editor.putInt("klikaniq", 0);
                editor.commit();
                viki = 0;
                tv_napraweni_klikowe_1.setText(String.valueOf(viki) +"/150");


            }
        });

        statistiki.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent thirdPage = new Intent(MainActivity.this, Main3Activity.class);
                startActivity(thirdPage);

            }
        });






        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        SharedPreferences pref = getSharedPreferences("main", 0);
        viki = pref.getInt("klikaniq", 0);
        if (viki != 0) {
            tv_napraweni_klikowe_1.setText(String.valueOf(viki)+"/150");
        }

    }









    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
