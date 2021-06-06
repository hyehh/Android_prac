package com.aoslec.fontprac;

import androidx.annotation.Dimension;
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
        btnLarge.setOnClickListener(onClickListener);
    }

    View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            int size = 0;
            switch (v.getId()){
                case R.id.btnSmall:
                    size = (int) textView.getTextSize();
                    size -= 1;
                    textView.setTextSize(Dimension.DP, size);
                    break;
                case R.id.btnLarge:
                    size = (int) textView.getTextSize();
                    size += 1;
                    textView.setTextSize(Dimension.DP, size);
                    break;
            }
        }
    };
}