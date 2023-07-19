package com.example.gpacalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.TextView;

import com.airbnb.lottie.LottieAnimationView;

public class splashscreen extends AppCompatActivity {

    TextView appname;
//    TextView appname2;
    LottieAnimationView lottie;


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spashscreen);

        appname = findViewById(R.id.appname);
//        appname2 = findViewById(R.id.appname2);
        lottie = findViewById(R.id.lottie);


//        appname2.animate().translationY(0).setDuration(2000).setStartDelay(0);
        appname.animate().translationY(-1450 ).setDuration(2100).setStartDelay(0);
        lottie.animate().translationX(2000 ).setDuration(2000).setStartDelay(2900);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent i = new Intent(getApplicationContext(),MainActivity.class);
                startActivity(i);

            }
        },4000);



    }

}