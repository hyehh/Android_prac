package com.aoslec.putextra;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    TextView tv_Second;
    Button btn_Second;
    String Id;
    int Pw;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        tv_Second = findViewById(R.id.tv_Second);
        btn_Second = findViewById(R.id.btn_Second);

        Intent intent = getIntent();

        Id = intent.getStringExtra("Id");
        Pw = intent.getIntExtra("Pw", 0);

        tv_Second.setText("UserId : " + Id + " / Password : " + Pw);

        btn_Second.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}