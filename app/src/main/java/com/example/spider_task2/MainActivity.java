package com.example.spider_task2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText editText;
    EditText editText1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editText = (EditText) findViewById(R.id.textView2);
        editText1 = (EditText) findViewById(R.id.textView);
    }

    public void start(View view) {
        try {
            if (!((editText.getText().toString().equals("")) || (editText1.getText().toString().equals("")))) {

                Intent intent = new Intent(MainActivity.this, Gameplay.class);
                intent.putExtra("single", "no");
                intent.putExtra("player1", editText.getText().toString());
                intent.putExtra("player2", editText1.getText().toString());
                startActivity(intent);
                finish();
            } else {
                Toast.makeText(MainActivity.this, "Enter Valid Details", Toast.LENGTH_SHORT).show();

            }
        } catch (Exception e) {
            Toast.makeText(MainActivity.this, "Enter Valid Details", Toast.LENGTH_SHORT).show();
        }
    }

    public void single(View view) {
        try {
            if (!((editText.getText().toString().equals("")) || (editText1.getText().toString().equals("")))) {
                Intent intent = new Intent(MainActivity.this, Gameplay.class);
                intent.putExtra("single", "yes");
                intent.putExtra("player1", editText.getText().toString());
                intent.putExtra("player2", editText1.getText().toString());
                startActivity(intent);
                finish();
            } else {
                Toast.makeText(MainActivity.this, "Enter Valid Details", Toast.LENGTH_SHORT).show();

            }
        } catch (Exception e) {
            Toast.makeText(MainActivity.this, "Enter Valid Details", Toast.LENGTH_SHORT).show();

        }
    }

    public void leader(View view) {
        Intent intent=new Intent(this,LeaderBoard.class);
        startActivity(intent);

    }

    @Override
    protected void onStop() {
        super.onStop();

    }
}
