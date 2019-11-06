package com.example.paulj;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.TextView;

import com.example.paulj.saufautomat.R;

public class MainActivity extends AppCompatActivity {
Button btn8,btnm,btnq,btnn;
View rect;
TextView title;
Animation animleft,animleft2,animleft3,animleft4,animtop,animbottom,animright;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();

        animleft= AnimationUtils.loadAnimation(this,R.anim.fromleft);
        animleft2= AnimationUtils.loadAnimation(this,R.anim.fromleft2);
        animleft3= AnimationUtils.loadAnimation(this,R.anim.fromleft3);
        animleft4= AnimationUtils.loadAnimation(this,R.anim.fromleft4);
        animtop= AnimationUtils.loadAnimation(this,R.anim.fromtop);
        animbottom= AnimationUtils.loadAnimation(this,R.anim.frombottom);
        animright= AnimationUtils.loadAnimation(this,R.anim.fromright);



        btn8=(Button)findViewById(R.id.button);

        btn8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getBaseContext(), Acht.class);

                startActivity(i);
            }
        });

        btnm=(Button)findViewById(R.id.button2);

        btnm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        btnq=(Button)findViewById(R.id.button3);

        btnq.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        btnn=(Button)findViewById(R.id.button4);

        btnn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getBaseContext(), Shotmuehle.class);

                startActivity(i);
            }
        });
        btn8.setVisibility(View.INVISIBLE);
        btnm.setVisibility(View.INVISIBLE);
        btnq.setVisibility(View.INVISIBLE);
        btnn.setVisibility(View.INVISIBLE);
rect=(View) findViewById(R.id.myRectangleView);
rect.setAnimation(animright);
title=(TextView)findViewById(R.id.Saufautomat);
title.setAnimation(animtop);

animtop.setAnimationListener(new Animation.AnimationListener() {
    @Override
    public void onAnimationStart(Animation animation) {

    }

    @Override
    public void onAnimationEnd(Animation animation) {
        btn8.setVisibility(View.VISIBLE);
        btnm.setVisibility(View.VISIBLE);
        btnq.setVisibility(View.VISIBLE);
        btnn.setVisibility(View.VISIBLE);
        btn8.setAnimation(animleft);
        btnm.setAnimation(animleft2);
        btnq.setAnimation(animleft3);
        btnn.setAnimation(animleft4);


    }

    @Override
    public void onAnimationRepeat(Animation animation) {

    }
});


    }


}
