package com.aoslec.frameprac1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {

    Button mainbtn1, mainbtn2;
    LinearLayout linear1, linear2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mainbtn1 = findViewById(R.id.mainbtn1);
        mainbtn2 = findViewById(R.id.mainbtn2);

        linear1 = findViewById(R.id.Linear1);
        linear2 = findViewById(R.id.Linear2);

        mainbtn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                linear1.setVisibility(v.VISIBLE);
                linear2.setVisibility(v.INVISIBLE);
            }
        });

        mainbtn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                linear1.setVisibility(v.INVISIBLE);
                linear2.setVisibility(v.VISIBLE);
            }
        });

    }
}