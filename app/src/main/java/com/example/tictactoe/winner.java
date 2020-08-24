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

public class winner extends AppCompatActivity {
    TextView title,subtitle;
    ImageView im;
    Animation frombottom,fromside2;
    private static int SPLASH_TIME_OUT=4000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_winner);
        title=( TextView) findViewById(R.id.winner);
        subtitle=(TextView)findViewById(R.id.text);
        im=(ImageView)findViewById(R.id.imageView);
        frombottom= AnimationUtils.loadAnimation(this,R.anim.frombottom);
        fromside2=AnimationUtils.loadAnimation(this,R.anim.fromside);
        title.setAnimation(frombottom);
        im.setAnimation(frombottom);
        subtitle.setAnimation(fromside2);


        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                Intent splash = new Intent(winner.this, Game.class);
                startActivity(splash);
                finish();
            }
        },SPLASH_TIME_OUT);


    }
}
