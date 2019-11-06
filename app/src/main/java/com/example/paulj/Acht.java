package com.example.paulj;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.ScaleAnimation;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.paulj.saufautomat.R;
import com.squareup.picasso.Picasso;

public class Acht extends AppCompatActivity {
    Animation animleft,animleft2,animleft3,animleft4,animtop,animbottom,animright;
    Button btn_help,btn_h;

    String[] stapel=new String[52];
    TextView help;
    LinearLayout l;


    View rect;
    TextView title;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_acht);
        getSupportActionBar().hide();

        animleft= AnimationUtils.loadAnimation(this,R.anim.fromleft);
        animleft2= AnimationUtils.loadAnimation(this,R.anim.fromleft2);
        animleft3= AnimationUtils.loadAnimation(this,R.anim.fromleft3);
        animleft4= AnimationUtils.loadAnimation(this,R.anim.fromleft4);
        animtop= AnimationUtils.loadAnimation(this,R.anim.fromtop);
        animbottom= AnimationUtils.loadAnimation(this,R.anim.frombottom);
        animright= AnimationUtils.loadAnimation(this,R.anim.fromright);
        help=(TextView)findViewById(R.id.help);
        rect=(View) findViewById(R.id.myRectangleView);
        rect.setAnimation(animright);
        title=(TextView)findViewById(R.id.Saufautomat);
        title.setAnimation(animleft);
        btn_help=(Button)findViewById(R.id.btn_help);
        l=(LinearLayout)findViewById(R.id.l);
        final Animation anim = AnimationUtils.loadAnimation(this, R.anim.scale);
        btn_help.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
l.setVisibility(View.VISIBLE);
                l.startAnimation(anim);
            }
        });




        final ImageView  imageView=findViewById(R.id.imageView2);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final ObjectAnimator oa1 = ObjectAnimator.ofFloat(imageView, "scaleX", 1f, 0f);
                final ObjectAnimator oa2 = ObjectAnimator.ofFloat(imageView, "scaleX", 0f, 1f);
                oa1.setInterpolator(new DecelerateInterpolator());
                oa2.setInterpolator(new AccelerateDecelerateInterpolator());
                oa1.addListener(new AnimatorListenerAdapter() {
                    @Override
                    public void onAnimationEnd(Animator animation) {
                        super.onAnimationEnd(animation);
                        imageView.setImageResource(R.drawable.ic_rh10);
                        oa2.start();
                    }
                });
                oa1.start();
            }
        });

Log.d("hh","hhndfvkj.bdxkj.c");

    }
}
