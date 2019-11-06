package com.example.paulj;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.os.Bundle;
import android.app.Activity;
import android.util.Log;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.DecelerateInterpolator;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.paulj.saufautomat.R;

import java.util.Random;

public class Shotmuehle extends Activity implements View.OnClickListener {
    Animation animleft,animright;
    View rect;
    TextView title;
    ImageView shot1,shot2,shot3,shot4,shot5,shot6;

    boolean [] shots=new boolean[6];

    public static final Random RANDOM = new Random();
    private Button rollDices;
    private ImageView imageView1, imageView2;
    private TextView resultView;
    private int dOne, dTwo;
    public int value;

    Animation anim1;
    Animation anim2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shotmuehle);

        animleft= AnimationUtils.loadAnimation(this,R.anim.fromleft);
        shot1=(ImageView)findViewById(R.id.shot1);
        shot2=(ImageView)findViewById(R.id.shot2);
        shot3=(ImageView)findViewById(R.id.shot3);
        shot4=(ImageView)findViewById(R.id.shot4);
        shot5=(ImageView)findViewById(R.id.shot5);
        shot6=(ImageView)findViewById(R.id.shot6);
        shots[0]=true;
        shots[1]=true;
        shots[2]=true;
        shots[3]=true;
        shots[4]=true;
        shots[5]=true;


        animright= AnimationUtils.loadAnimation(this,R.anim.fromright);

        rect=(View) findViewById(R.id.myRectangleView);
        rect.setAnimation(animright);
        title=(TextView)findViewById(R.id.Saufautomat);
        title.setAnimation(animleft);


        dOne = 1;
        dTwo = 1;

        rollDices = (Button) findViewById(R.id.rollDiceButton);
        imageView1 = (ImageView) findViewById(R.id.diceView1);



        rollDices.setOnClickListener(this);

        anim1 = AnimationUtils.loadAnimation(Shotmuehle.this, R.anim.shake);

        this.setUpAnimation();

    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {

            case R.id.diceView1:
                imageView1.startAnimation(anim1);
                break;
            case R.id.rollDiceButton:
                imageView1.startAnimation(anim1);




                break;


            default:
                break;
        }
    }

    public void setUpAnimation() {
        final Animation.AnimationListener animationListener = new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
            }

            @Override
            public void onAnimationEnd(Animation animation) {
                 value = randomDiceValue();
                int res = getResources().getIdentifier("dice_" + value, "drawable", "com.example.paulj.saufautomat");


                if(animation == anim1){
                    dOne = value;
                    imageView1.setImageResource(res);
                }
                spiel();

            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        };

        anim1.setAnimationListener(animationListener);
       // anim2.setAnimationListener(animationListener);
    }

    public static int randomDiceValue() {
        return RANDOM.nextInt(6) + 1;
    }

    public void spiel(){


        if(value==1){
            if(shots[0]==true){
                Animation animFadeIn = AnimationUtils.loadAnimation(this, R.anim.fadein);

                shots[0]=false;
                animFadeIn.reset();
                shot1.clearAnimation();
                shot1.setImageDrawable(null);
                shot1.setBackgroundResource(R.drawable.shot_leer);
                shot1.startAnimation(animFadeIn);
            }else if(shots[0]==false){
                Animation animFadeIn = AnimationUtils.loadAnimation(this, R.anim.fadein);

                shots[0]=true;
                animFadeIn.reset();
                shot1.clearAnimation();
                shot1.setImageDrawable(null);
                shot1.setBackgroundResource(R.drawable.shot_voll);
                shot1.startAnimation(animFadeIn);
            }
        }else if(value==2){
            if(shots[1]==true){
                Animation animFadeIn = AnimationUtils.loadAnimation(this, R.anim.fadein);

                shots[1]=false;
                animFadeIn.reset();
                shot2.clearAnimation();
                shot2.setImageDrawable(null);
                shot2.setBackgroundResource(R.drawable.shot_leer);
                shot2.startAnimation(animFadeIn);
            }else if(shots[1]==false){
                Animation animFadeIn = AnimationUtils.loadAnimation(this, R.anim.fadein);

                shots[1]=true;
                animFadeIn.reset();
                shot2.clearAnimation();
                shot2.setImageDrawable(null);
                shot2.setBackgroundResource(R.drawable.shot_voll);
                shot2.startAnimation(animFadeIn);
            }
        }else if(value==3){
            if(shots[2]==true){
                Animation animFadeIn = AnimationUtils.loadAnimation(this, R.anim.fadein);

                shots[2]=false;

                animFadeIn.reset();
                shot3.clearAnimation();
                shot3.setImageDrawable(null);
                shot3.setBackgroundResource(R.drawable.shot_leer);
                shot3.startAnimation(animFadeIn);
            }else if(shots[2]==false){
                Animation animFadeIn = AnimationUtils.loadAnimation(this, R.anim.fadein);

                shots[2]=true;
                animFadeIn.reset();
                shot3.clearAnimation();
                shot3.setImageDrawable(null);
                shot3.setBackgroundResource(R.drawable.shot_voll);
                shot3.startAnimation(animFadeIn);
            }
        }if(value==4){
            if(shots[3]==true){
                Log.d("Hi","Hallo");
                Animation animFadeIn = AnimationUtils.loadAnimation(this, R.anim.fadein);

                shots[3]=false;
                animFadeIn.reset();
                shot4.clearAnimation();
                shot4.setImageDrawable(null);
                shot4.setBackgroundResource(R.drawable.shot_leer);
                shot4.startAnimation(animFadeIn);
            }else if(shots[3]==false){
                Animation animFadeIn = AnimationUtils.loadAnimation(this, R.anim.fadein);

                shots[3]=true;
                animFadeIn.reset();
                shot4.clearAnimation();
                shot4.setImageDrawable(null);
                shot4.setBackgroundResource(R.drawable.shot_voll);
                shot4.startAnimation(animFadeIn);
            }
        }if(value==5){
            if(shots[4]==true){
                Animation animFadeIn = AnimationUtils.loadAnimation(this, R.anim.fadein);

                shots[4]=false;
                animFadeIn.reset();
                shot5.clearAnimation();
                shot5.setImageDrawable(null);
                shot5.setBackgroundResource(R.drawable.shot_leer);
                shot5.startAnimation(animFadeIn);
            }else if(shots[4]==false){
                Animation animFadeIn = AnimationUtils.loadAnimation(this, R.anim.fadein);

                shots[4]=true;
                animFadeIn.reset();
                shot5.clearAnimation();
                shot5.setImageDrawable(null);
                shot5.setBackgroundResource(R.drawable.shot_voll);
                shot5.startAnimation(animFadeIn);
            }
        }else if(value==6){
            if(shots[5]==true){
                Animation animFadeIn = AnimationUtils.loadAnimation(this, R.anim.fadein);

                shots[5]=false;
                animFadeIn.reset();
                shot6.clearAnimation();
                shot6.setImageDrawable(null);
                shot6.setBackgroundResource(R.drawable.shot_leer);
                shot6.startAnimation(animFadeIn);
            }else if(shots[5]==false){
                Animation animFadeIn = AnimationUtils.loadAnimation(this, R.anim.fadein);

                shots[5]=true;
                animFadeIn.reset();
                shot6.clearAnimation();
                shot6.setImageDrawable(null);
                shot6.setBackgroundResource(R.drawable.shot_voll);
                shot6.startAnimation(animFadeIn);
            }
        }



    }

}
