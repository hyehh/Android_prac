package com.aoslec.buttonconprac1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button red, green, blue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        red = findViewById(R.id.btnRed);
        green = findViewById(R.id.btnGreen);
        blue = findViewById(R.id.btnBlue);

        red.setOnClickListener(onClickListener);
        green.setOnClickListener(onClickListener);
        blue.setOnClickListener(onClickListener);

    }

    View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            String colorString = "";
            switch (v.getId()){
                case R.id.btnRed:
                    colorString = "빨간색";
                    break;
                case R.id.btnGreen:
                    colorString = "초록색";
                    break;
                case R.id.btnBlue:
                    colorString = "파란색";
                    break;
            }
            Toast.makeText(MainActivity.this,colorString+" 버튼을 눌렀습니다!",Toast.LENGTH_SHORT).show();
        }
    }; // ; 꼭 써줘야 함! (변수로 만든 함수이기 때문)
}