package com.example.tictactoe;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class player2win extends AppCompatActivity {
    TextView title1,subtitle2;
    ImageView im1;
    Animation frombottom1,fromside1;
    private static int SPLASH_TIME_OUT=4000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_player2win);
        title1=( TextView) findViewById(R.id.winner1);
        subtitle2=( TextView) findViewById(R.id.textView3);
        im1=(ImageView)findViewById(R.id.imageView1);
        frombottom1= AnimationUtils.loadAnimation(this,R.anim.frombottom);
        fromside1=AnimationUtils.loadAnimation(this,R.anim.fromside);

        title1.setAnimation(frombottom1);
        im1.setAnimation(frombottom1);
        subtitle2.setAnimation(fromside1);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                Intent splash = new Intent(player2win.this, Game.class);
                startActivity(splash);
                finish();
            }
        },SPLASH_TIME_OUT);


    }
}
