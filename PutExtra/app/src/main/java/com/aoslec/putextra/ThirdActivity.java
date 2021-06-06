package com.aoslec.putextra;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ThirdActivity extends AppCompatActivity {

    final static int ResultV = 1;
    TextView tv_Third;
    Button btn_Third;
    String Id;
    int Pw;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);

        tv_Third = findViewById(R.id.tv_Third);
        btn_Third = findViewById(R.id.btn_Third);

        Intent intent = getIntent();
        Id = intent.getStringExtra("Id");
        Pw = intent.getIntExtra("Pw", 0);
        tv_Third.setText("UserId : " + Id + " / Password : " + Pw);

        btn_Third.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.putExtra("result", "aaaa");
                setResult(ResultV, intent);
                finish();
            }
        });
    }
}