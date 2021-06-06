package com.aoslec.fontprac;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Button btnSmall, btnLarge;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnSmall = findViewById(R.id.btnSmall);
        btnLarge = findViewById(R.id.btnLarge);
        textView = findViewById(R.id.tv);

        btnSmall.setOnClickListener(onClickListener);
        btnSmall.setOnClickListener(onClickListener);
    }

    View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()){
                case R.id.btnSmall:

            }
        }
    };
}