package com.example.tictactoe;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.text.Html;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private ViewPager mSlidePager;
    private LinearLayout mDotLayout;
    private TextView[] mDots;
    private  Slide_Adapter slide_adapter;
    private Button mBackBtn;
    private Button mnext;
    private int CurrentPage;
    private static int SPLASH_TIME_OUT=1000;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        mSlidePager=(ViewPager) findViewById(R.id.slideViewPager);
        mnext=(Button)findViewById(R.id.next_button);
        mBackBtn=(Button)findViewById(R.id.prev_Button);
        mDotLayout=(LinearLayout) findViewById(R.id.dotslayout);
        slide_adapter=new Slide_Adapter(this);
        mSlidePager.setAdapter(slide_adapter);

        addDotsIndicator(0);
        mSlidePager.addOnPageChangeListener(viewListener);
        mnext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mSlidePager.setCurrentItem(CurrentPage+1);
            }
        });
        mBackBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mSlidePager.setCurrentItem(CurrentPage-1);

            }
        });
    }
    public void addDotsIndicator(int position){
        mDots=new TextView[3];
        mDotLayout.removeAllViews();
        for(int i=0;i<mDots.length;i++){
            mDots[i]=new TextView(this);
            mDots[i].setText(Html.fromHtml("&#8226;"));
            mDots[i].setTextSize(35);
            mDots[i].setTextColor(getResources().getColor(R.color.colorTransparentWhite));
            mDotLayout.addView(mDots[i]);

        } if(mDots.length>0){
            mDots[position].setTextColor(getResources().getColor(R.color.colorWhite));
        }

    }ViewPager.OnPageChangeListener viewListener=new ViewPager.OnPageChangeListener() {
        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

        }

        @Override
        public void onPageSelected(int i) {
            addDotsIndicator(i);
            CurrentPage = i;
            if (i == 0) {

                mnext.setEnabled(true);
                mBackBtn.setEnabled(false);
                mBackBtn.setVisibility(View.INVISIBLE);
                mnext.setText("Next");
                mBackBtn.setText("");
            } else if (i == mDots.length-2 ) {
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {

                        Intent splash = new Intent(MainActivity.this, Game.class);
                        startActivity(splash);
                        finish();
                    }
                },SPLASH_TIME_OUT);



            } else {
                mnext.setEnabled(true);
                mBackBtn.setEnabled(true);

                mBackBtn.setVisibility(View.VISIBLE);
                mnext.setText("FINISH");
                mBackBtn.setText("Back");


            }


        }

        @Override
        public void onPageScrollStateChanged(int state) {

        }
    };
}
