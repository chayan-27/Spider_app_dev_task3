package com.example.spider_task2;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;


public class LeaderBoard extends AppCompatActivity {
List<String> list;
SharedPreferences sharedPreferences;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_leader_board);
        sharedPreferences= getSharedPreferences("App_settings", MODE_PRIVATE);

        list=new ArrayList<>();
        Set<String> set = sharedPreferences.getStringSet("DATE_LIST", null);
        if(set!=null) {
            list.addAll(set);
        }else{
            list.add("No Data Available");
        }
        RecyclerView recyclerView=(RecyclerView)findViewById(R.id.recycle);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(new LeadAdaper(list));

    }
}
