package com.example.spider_task2;

import android.content.Intent;
import android.content.SharedPreferences;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Results extends AppCompatActivity {
    TextView textView;
    MediaPlayer mediaPlayer;
    SharedPreferences sharedPreferences;
    List<String> list=new ArrayList<>();
    Set<String> set;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_results);
        sharedPreferences= getSharedPreferences("App_settings", MODE_PRIVATE);
        set = sharedPreferences.getStringSet("DATE_LIST", null);
if(set!=null)
            list.addAll(set);

        //list=new ArrayList<>();
        Intent intent=getIntent();
        String winner;
        String result="";
        if(intent.getStringExtra("winner").equals("Its a Draw")) {
             winner = intent.getStringExtra("winner");
        }else{
            winner = intent.getStringExtra("winner") + " wins";
            result=intent.getStringExtra("winner")+" : 1 ";

        }
        String dec=intent.getStringExtra("dec");
        if(dec.equals("Player1 wins")){
           mediaPlayer= MediaPlayer.create(this,R.raw.p1win);
            SharedPreferences.Editor editor = sharedPreferences.edit();
            list.add(result);
            set = new HashSet<String>();
            set.addAll(list);
            editor.putStringSet("DATE_LIST", set);
            editor.apply();
        }else if(dec.equals("Player2 wins")){
            mediaPlayer=MediaPlayer.create(this,R.raw.p2win);
            SharedPreferences.Editor editor = sharedPreferences.edit();
            list.add(result);
            set = new HashSet<String>();
            set.addAll(list);
            editor.putStringSet("DATE_LIST", set);
            editor.apply();
        }else{
            mediaPlayer=MediaPlayer.create(this,R.raw.draw);
        }
        mediaPlayer.start();
        textView=(TextView)findViewById(R.id.textView3);

        textView.setText(winner);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent intent=new Intent(Results.this,MainActivity.class);
        startActivity(intent);
        finish();
    }
}
