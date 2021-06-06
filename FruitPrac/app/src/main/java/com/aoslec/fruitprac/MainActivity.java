package com.aoslec.fruitprac;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button btnApple, btnBanana;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnApple = findViewById(R.id.btnApple);
        btnBanana = findViewById(R.id.btnBanana);

        btnApple.setOnClickListener(onClickListener);
        btnBanana.setOnClickListener(onClickListener);
    }

    View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()){
                case R.id.btnApple:
                    btnApple.setTextColor(0xffff0000);
                    btnBanana.setTextColor(0xff050505);
                    // btnApple.setBackgroundColor(Color.RED);
                    Toast.makeText(MainActivity.this, "APPLE CHOICE", Toast.LENGTH_SHORT).show();
                    break;
                case R.id.btnBanana:
                    btnBanana.setTextColor(0xff00ff00);
                    btnApple.setTextColor(0xff050505);
                    Toast.makeText(MainActivity.this, "BANANA CHOICE", Toast.LENGTH_SHORT).show();
                    break;
            }
        }
    };
}