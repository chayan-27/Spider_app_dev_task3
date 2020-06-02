package com.example.spider_task2;

import android.content.Intent;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

public class Splash extends AppCompatActivity {
    Animation animation;
    Animation animation1;
    Animation animation2;
    TextView textView;
    TextView textView1;
    TextView textView2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        textView=(TextView)findViewById(R.id.tic);
        textView1=(TextView)findViewById(R.id.tac);
        textView2=(TextView)findViewById(R.id.toe);
        animation= AnimationUtils.loadAnimation(this,R.anim.tic);
        animation1=AnimationUtils.loadAnimation(this,R.anim.tac);
        animation2=AnimationUtils.loadAnimation(this,R.anim.toe);
        textView.setAnimation(animation);
        textView1.setAnimation(animation1);
        textView2.setAnimation(animation2);
        final Intent intent=new Intent(Splash.this,MainActivity.class);
        Thread timer=new Thread(){
            @RequiresApi(api = Build.VERSION_CODES.KITKAT)
            public void run(){
                try {
                    sleep(3000);
                }catch (InterruptedException e) {
                    e.printStackTrace();
                }
                finally {
                     startActivity(intent);
                    finish();
                }
            }
        };
        timer.start();
    }
    }
