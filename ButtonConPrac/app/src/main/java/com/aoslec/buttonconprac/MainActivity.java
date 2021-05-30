package com.aoslec.buttonconprac;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button red;
    Button green;
    Button blue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        red = findViewById(R.id.btnRed);
        green = findViewById(R.id.btnGreen);
        blue = findViewById(R.id.btnBlue);

        red.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this,"빨간색 버튼을 누르셨습니다!", Toast.LENGTH_SHORT).show();
            }
        });

        green.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this,"초록색 버튼을 누르셨습니다!", Toast.LENGTH_SHORT).show();
            }
        });

        blue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this,"파란색 버튼을 누르셨습니다!", Toast.LENGTH_SHORT).show();
            }
        });

    }
}