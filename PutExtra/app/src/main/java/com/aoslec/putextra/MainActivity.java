package com.aoslec.putextra;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    final static int Rvalue = 1;
    TextView tv_Main;
    Button btn_Main1, btn_Main2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv_Main = findViewById(R.id.tv_Main);
        btn_Main1 = findViewById(R.id.btn_Main1);
        btn_Main2 = findViewById(R.id.btn_Main2);

        btn_Main1.setOnClickListener(onClickListener);
        btn_Main2.setOnClickListener(onClickListener);
    }

    View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()){
                case R.id.btn_Main1:
                    Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                    intent.putExtra("Id", "root");
                    intent.putExtra("Pw", 1111);
                    startActivity(intent);
                    break;
                case R.id.btn_Main2:
                    // 같은 scope안에 있기 때문에 굳이 한 번 더 선언해주지 않아도 가능!
                    intent = new Intent(MainActivity.this, ThirdActivity.class);
                    intent.putExtra("Id", "admin");
                    intent.putExtra("Pw", 2222);
                    startActivityForResult(intent, Rvalue);
                    break;
                default:
                    break;
            }
        }
    };

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        switch (resultCode){
            case MainActivity.Rvalue:
                tv_Main.setText("Return Value : " + data.getStringExtra("result"));
                break;
            default:
                break;
        }
        super.onActivityResult(requestCode, resultCode, data);
    }
}