package com.example.tictactoe;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

public class Slide_Adapter extends PagerAdapter {
    Context context;
    LayoutInflater layoutInflater;
    public Slide_Adapter(Context context){
        this.context=context;
    }
    public int[] slide_images={

            R.drawable.ttt2

    };
    public String[] slide_headings={
            "TIC TAC TOE",

            "INSTRUCTIONS"

    };
        public String[] slide_desc={
                "",
                "The game is played on a grid that's 3 squares by 3 squares You are X, your friend (or the computer in this case) is O. Players take turns putting their marks in empty squares."+
        "The first player to get 3 of her marks in a row (up, down, across, or diagonally) is the winner. "

        };
    @Override
    public int getCount() {
        return slide_headings.length;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view==(RelativeLayout)object;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        layoutInflater=(LayoutInflater)context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        View view=layoutInflater.inflate(R.layout.slidelayout,container,false);
        //ImageView slideImageView=(ImageView) view.findViewById(R.id.imageView3);
        TextView slideHeading=(TextView) view.findViewById(R.id.zero);
       TextView slideDescription=(TextView) view.findViewById(R.id.cross);
        //slideImageView.setImageResource(slide_images[position]);
        slideHeading.setText( slide_headings[position]);
        slideDescription.setText(slide_desc[position]);
        container.addView(view);
        return view;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((RelativeLayout)object);
    }
}
