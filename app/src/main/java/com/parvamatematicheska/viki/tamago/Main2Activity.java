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
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {
    ImageView myImageView;
    TextView tv_napraweni_klikowe_2;
    Button nazad_btn;
    int counter=0;
    Animation animation = null;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        myImageView = (ImageView) findViewById(R.id.imageView);
        tv_napraweni_klikowe_2 = (TextView) findViewById(R.id.tv_broi_napraweni_klikowe_2);
        nazad_btn = (Button) findViewById(R.id.nazad_btn_id);


        myImageView.setBackgroundResource(R.drawable.dino_egg);


        myImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                counter++;
                if(counter >= 18 && counter <36) {
                    myImageView.setBackgroundResource(R.drawable.dino_egg2);
                }if (counter >= 36 && counter<54) {
                    myImageView.setBackgroundResource(R.drawable.dino_egg3);
                }if (counter >= 54 && counter<72) {
                    myImageView.setBackgroundResource(R.drawable.dino_egg5);
                }if (counter >= 72 && counter<90) {
                    myImageView.setBackgroundResource(R.drawable.dino_egg6);
                }if (counter >= 90 && counter<108) {
                    myImageView.setBackgroundResource(R.drawable.dino_egg8);
                }if (counter >= 108 && counter<126) {
                    myImageView.setBackgroundResource(R.drawable.dino_egg10);
                }if (counter >= 126 && counter<144) {
                    myImageView.setBackgroundResource(R.drawable.dino_egg11);
                }if (counter >= 144 && counter<150) {
                    myImageView.setBackgroundResource(R.drawable.dino_egg13);
                }if (counter >= 150) {
                    myImageView.setBackgroundResource(R.drawable.dino);
                    myImageView.setEnabled(false);
                }
                tv_napraweni_klikowe_2.setText("БРОЙ НАПРАВЕНИ КЛИКАНИЯ: "+String.valueOf(counter));

                if (counter==150){
                    SharedPreferences schupenvaniq_na_qjca = getSharedPreferences("main", MODE_PRIVATE);
                    int egg_brokens = schupenvaniq_na_qjca.getInt("egg_brokens", 0);
                    egg_brokens++;

                    SharedPreferences.Editor editor = schupenvaniq_na_qjca.edit();
                    editor.putInt("egg_brokens", egg_brokens);
                    editor.apply();


                }

                if(counter<=149){

                    animation = AnimationUtils.loadAnimation(Main2Activity.this, R.anim.translate);
                    myImageView.startAnimation(animation);

                }


            }
        });

        nazad_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Main2Activity.this, MainActivity.class);
                startActivity(intent);
                finish();

            }
        });

        SharedPreferences preferences = getSharedPreferences("main", MODE_PRIVATE);
        int statAppsOpened = preferences.getInt("statAppsOpened", 0);
        statAppsOpened++;

        SharedPreferences.Editor editor = preferences.edit();
        editor.putInt("statAppsOpened", statAppsOpened);
        editor.apply();


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
    protected void onPause(){
        super.onPause();
        SharedPreferences pref = getSharedPreferences("main", 0);
        SharedPreferences.Editor editor = pref.edit();
        editor.putInt("klikaniq", counter);
        editor.commit();
    }


    @Override
    protected void onResume() {
        super.onResume();
        SharedPreferences pref = getSharedPreferences("main", 0);
        counter = pref.getInt("klikaniq", 0);
        if (counter!=0){
            tv_napraweni_klikowe_2.setText("БРОЙ НАПРАВЕНИ КЛИКАНИЯ: "+String.valueOf(counter));
        }

        if(counter >= 18 && counter <36) {
            myImageView.setBackgroundResource(R.drawable.dino_egg2);
        }if (counter >= 36 && counter<54) {
            myImageView.setBackgroundResource(R.drawable.dino_egg3);
        }if (counter >= 54 && counter<72) {
            myImageView.setBackgroundResource(R.drawable.dino_egg5);
        }if (counter >= 72 && counter<90) {
            myImageView.setBackgroundResource(R.drawable.dino_egg6);
        }if (counter >= 90 && counter<108) {
            myImageView.setBackgroundResource(R.drawable.dino_egg8);
        }if (counter >= 108 && counter<126) {
            myImageView.setBackgroundResource(R.drawable.dino_egg10);
        }if (counter >= 126 && counter<144) {
            myImageView.setBackgroundResource(R.drawable.dino_egg11);
        }if (counter >= 144 && counter<150) {
            myImageView.setBackgroundResource(R.drawable.dino_egg13);
        }if (counter >= 150) {
            myImageView.setBackgroundResource(R.drawable.dino);
            myImageView.setEnabled(false);
        }
    }







}
