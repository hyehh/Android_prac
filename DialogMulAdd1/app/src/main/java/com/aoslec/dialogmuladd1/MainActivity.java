package com.aoslec.dialogmuladd1;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    int a, b, result = 0;
    Button button;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = findViewById(R.id.btn);
        textView = findViewById(R.id.tv);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new AlertDialog.Builder(MainActivity.this)
                        .setTitle("질문1")
                        .setMessage("좌변을 선택 하십시오!")
                        .setCancelable(false)
                        .setNegativeButton("4", firstClick)
                        .setPositiveButton("3", firstClick)
                        .show();
            }
        });
    }

    DialogInterface.OnClickListener firstClick = new DialogInterface.OnClickListener() {
        @Override
        public void onClick(DialogInterface dialog, int which) {
            if(which == DialogInterface.BUTTON_POSITIVE){
                a = 3;
            }else {
                a = 4;
            }
            new AlertDialog.Builder(MainActivity.this)
                    .setTitle("질문2")
                    .setMessage("우변을 선택 하십시오!")
                    .setCancelable(false)
                    .setNegativeButton("6", secondClick)
                    .setPositiveButton("5", secondClick)
                    .show();
        }
    };

    DialogInterface.OnClickListener secondClick = new DialogInterface.OnClickListener() {
        @Override
        public void onClick(DialogInterface dialog, int which) {
            if(which == DialogInterface.BUTTON_NEGATIVE){
                b = 6;
            }else {
                b = 5;
            }
            new AlertDialog.Builder(MainActivity.this)
                    .setTitle("질문3")
                    .setMessage("어떤 연산을 하시겠습니까?")
                    .setCancelable(false)
                    .setNegativeButton("곱셈", thirdClick)
                    .setPositiveButton("덧셈", thirdClick)
                    .show();
        }
    };

    DialogInterface.OnClickListener thirdClick = new DialogInterface.OnClickListener() {
        @Override
        public void onClick(DialogInterface dialog, int which) {
            if(which == DialogInterface.BUTTON_POSITIVE){
                result = a + b;
            }else {
                result = a * b;
            }
            textView.setText("연산 결과 : " + result);
            Toast.makeText(MainActivity.this, "연산을 완료 했습니다!", Toast.LENGTH_SHORT).show();
        }
    };
}