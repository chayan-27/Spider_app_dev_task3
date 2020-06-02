package com.example.spider_task2;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class LeadAdaper extends RecyclerView.Adapter<LeadAdaper.LeadHold> {
    List<String> list;
    public LeadAdaper(List<String> list){
        this.list=new ArrayList<>(list);
    }

    @NonNull
    @Override
    public LeadHold onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater layoutInflater=LayoutInflater.from(viewGroup.getContext());
        View view=layoutInflater.inflate(R.layout.leader,viewGroup,false);
        return (new LeadHold(view));
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    @Override
    public void onBindViewHolder(@NonNull LeadHold leadHold, int i) {
leadHold.textView.setText(list.get(i));
    }

    public  class LeadHold extends RecyclerView.ViewHolder{
TextView textView;
        public LeadHold(@NonNull View itemView) {
            super(itemView);
            textView=itemView.findViewById(R.id.textViewf);

        }
    }
}
