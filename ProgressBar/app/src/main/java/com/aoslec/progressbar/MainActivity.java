package com.aoslec.progressbar;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;

public class MainActivity extends AppCompatActivity {

    ProgressBar pb1, pb2;
    Button btnProgress, btnReset, btnShow, btnHide;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        pb1 = findViewById(R.id.pb_01);
        pb2 = findViewById(R.id.pb_02);

        btnProgress = findViewById(R.id.btn1);
        btnReset = findViewById(R.id.btn2);
        btnShow = findViewById(R.id.btn3);
        btnHide = findViewById(R.id.btn4);

        btnProgress.setOnClickListener(clickListener);
        btnReset.setOnClickListener(clickListener);
        btnShow.setOnClickListener(clickListener);
        btnHide.setOnClickListener(clickListener);
    }

    View.OnClickListener clickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()){
                case R.id.btn1:
                    pb1.incrementProgressBy(10);
                    pb1.incrementSecondaryProgressBy(10);
                    break;
                case R.id.btn2:
                    pb1.setProgress(0);
                    pb1.setSecondaryProgress(10);
                    break;
                case R.id.btn3:
                    pb2.setVisibility(v.VISIBLE);
                    break;
                case R.id.btn4:
                    pb2.setVisibility(v.INVISIBLE);
                    break;
            }
        }
    };
}