package com.example.paulj;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.media.Image;
import android.support.constraint.ConstraintLayout;
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


import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.Random;

public class Acht extends AppCompatActivity {
    Animation animleft,animleft2,animleft3,animleft4,animtop,animbottom,animright;
    Button btn_help,btn_exit,btn_next,btn_hide;
    public boolean visible=true;
    public static int current_card=0;
    ArrayList<String> stapel = new ArrayList<String>();
    TextView help;
    ConstraintLayout l;
    ImageView karte;



    View rect;
    TextView title;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_acht);
        getSupportActionBar().hide();
        fillStack();

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
        l=(ConstraintLayout) findViewById(R.id.l);
        karte=(ImageView)findViewById(R.id.karte) ;

        btn_next=(Button)findViewById(R.id.btn_next);
        btn_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int number_of_cards=stapel.size();


                Random r = new Random();
                int randomnumber = r.nextInt((number_of_cards) - 0) + 0;
                final int image_id = getResources().getIdentifier(getPackageName()+":drawable/" + stapel.get(randomnumber), null, null);

                karte.setTag(image_id);

                stapel.remove(randomnumber);

                final ImageView  imageView=findViewById(R.id.karte);

                        final ObjectAnimator oa1 = ObjectAnimator.ofFloat(imageView, "scaleX", 1f, 0f);
                        final ObjectAnimator oa2 = ObjectAnimator.ofFloat(imageView, "scaleX", 0f, 1f);
                        oa1.setInterpolator(new DecelerateInterpolator());
                        oa2.setInterpolator(new AccelerateDecelerateInterpolator());
                        oa1.addListener(new AnimatorListenerAdapter() {
                            @Override
                            public void onAnimationEnd(Animator animation) {
                                super.onAnimationEnd(animation);
                                imageView.setImageResource(image_id);
                                oa2.start();
                                btn_next.setEnabled(true);
                                btn_hide.setEnabled(true);
                            }

                            @Override
                            public void onAnimationStart(Animator animation) {
                                super.onAnimationStart(animation);

                                btn_next.setEnabled(false);
                                btn_hide.setEnabled(false);
                            }
                        });
                        oa1.start();
                    }


        });

        btn_hide=(Button)findViewById(R.id.btn_hide);
        btn_hide.setEnabled(false);
        btn_hide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(visible==true){





                    current_card=(Integer)karte.getTag();
                    final ImageView  imageView=findViewById(R.id.karte);

                    final ObjectAnimator oa1 = ObjectAnimator.ofFloat(imageView, "scaleX", 1f, 0f);
                    final ObjectAnimator oa2 = ObjectAnimator.ofFloat(imageView, "scaleX", 0f, 1f);
                    oa1.setInterpolator(new DecelerateInterpolator());
                    oa2.setInterpolator(new AccelerateDecelerateInterpolator());
                    oa1.addListener(new AnimatorListenerAdapter() {
                        @Override
                        public void onAnimationEnd(Animator animation) {
                            super.onAnimationEnd(animation);
                            imageView.setImageResource(R.drawable.ic_unbenannt);
                            oa2.start();

                            btn_hide.setEnabled(true);
                        }

                        @Override
                        public void onAnimationStart(Animator animation) {
                            super.onAnimationStart(animation);

                            btn_next.setEnabled(false);
                            btn_hide.setEnabled(false);
                        }
                    });
                    oa1.start();
                    btn_next.setEnabled(false);


                    btn_hide.setText("Zeigen");
                    visible=false;
                }else if (visible==false){

                    final ImageView  imageView=findViewById(R.id.karte);

                    final ObjectAnimator oa1 = ObjectAnimator.ofFloat(imageView, "scaleX", 1f, 0f);
                    final ObjectAnimator oa2 = ObjectAnimator.ofFloat(imageView, "scaleX", 0f, 1f);
                    oa1.setInterpolator(new DecelerateInterpolator());
                    oa2.setInterpolator(new AccelerateDecelerateInterpolator());
                    oa1.addListener(new AnimatorListenerAdapter() {
                        @Override
                        public void onAnimationEnd(Animator animation) {
                            super.onAnimationEnd(animation);
                            imageView.setImageResource(current_card);
                            oa2.start();
                            btn_next.setEnabled(true);
                            btn_hide.setEnabled(true);
                        }

                        @Override
                        public void onAnimationStart(Animator animation) {
                            super.onAnimationStart(animation);

                            btn_next.setEnabled(false);
                            btn_hide.setEnabled(false);
                        }
                    });
                    oa1.start();

                    btn_hide.setText("Verdecken");
                    visible=true;
                }
            }
        });



        final Animation anim = AnimationUtils.loadAnimation(this, R.anim.scale);
        btn_help.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                l.setVisibility(View.VISIBLE);
                l.startAnimation(anim);
                btn_help.setEnabled(false);
                btn_next.setEnabled(false);
                btn_hide.setEnabled(false);

            }
        });
        final Animation anim2 = AnimationUtils.loadAnimation(this, R.anim.scale_out);
        btn_exit=(Button)findViewById(R.id.btn_exit);
        btn_exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                l.setVisibility(View.INVISIBLE);
                l.startAnimation(anim2);
                btn_help.setEnabled(true);
                btn_next.setEnabled(true);
                btn_hide.setEnabled(true);

            }
        });








    }

    public void fillStack(){

        //Rot Herz alle karten
        stapel.add("ic_rha");
        stapel.add("ic_rh2");
        stapel.add("ic_rh3");
        stapel.add("ic_rh4");
        stapel.add("ic_rh5");
        stapel.add("ic_rh6");
        stapel.add("ic_rh7");
        stapel.add("ic_rh8");
        stapel.add("ic_rh9");
        stapel.add("ic_rh10");
        stapel.add("ic_rhd");
        stapel.add("ic_rhk");
        stapel.add("ic_rhb");

        //Rot karo alle karten
        stapel.add("ic_rka");
        stapel.add("ic_rk2");
        stapel.add("ic_rk3");
        stapel.add("ic_rk4");
        stapel.add("ic_rk5");
        stapel.add("ic_rk6");
        stapel.add("ic_rk7");
        stapel.add("ic_rk8");
        stapel.add("ic_rk9");
        stapel.add("ic_rk10");
        stapel.add("ic_rkd");
        stapel.add("ic_rkk");
        stapel.add("ic_rkb");

        //schwarz kreuz alle karten
        stapel.add("ic_ska");
        stapel.add("ic_sk2");
        stapel.add("ic_sk3");
        stapel.add("ic_sk4");
        stapel.add("ic_sk5");
        stapel.add("ic_sk6");
        stapel.add("ic_sk7");
        stapel.add("ic_sk8");
        stapel.add("ic_sk9");
        stapel.add("ic_sk10");
        stapel.add("ic_skd");
        stapel.add("ic_skk");
        stapel.add("ic_skb");

        //schwarz pick alle karten
        stapel.add("ic_spa");
        stapel.add("ic_sp2");
        stapel.add("ic_sp3");
        stapel.add("ic_sp4");
        stapel.add("ic_sp5");
        stapel.add("ic_sp6");
        stapel.add("ic_sp7");
        stapel.add("ic_sp8");
        stapel.add("ic_sp9");
        stapel.add("ic_sp10");
        stapel.add("ic_spd");
        stapel.add("ic_spk");
        stapel.add("ic_spb");



    }
}
