package com.example.spider_task2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class Gameplay extends AppCompatActivity {
    public static String single;
    public static String player1;
    public static String player2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        single=getIntent().getStringExtra("single");
        player1=getIntent().getStringExtra("player1");
        player2=getIntent().getStringExtra("player2");
        Board game=new Board(this);
        setContentView(R.layout.activity_gameplay);
   }

    @Override
    protected void onStop() {
        super.onStop();
        finish();
    }
}
