package com.aoslec.selectdialogcheckbox;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Button button;
    TextView textView;
    boolean[] mSelectMulti = {false, false, false, false};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = findViewById(R.id.btn);
        textView  = findViewById(R.id.tv);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new AlertDialog.Builder(MainActivity.this)
                        .setTitle("음식을 선택하세요")
                        .setIcon(R.mipmap.ic_launcher)
                        .setMultiChoiceItems(R.array.food, mSelectMulti, new DialogInterface.OnMultiChoiceClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which, boolean isChecked) {
                                // 체크한 것만 true로 전환
                                mSelectMulti[which] = isChecked;
                            }
                        })
                        .setCancelable(false)
                        .setNegativeButton("취소", null)
                        .setPositiveButton("확인", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                String[] food = getResources().getStringArray(R.array.food);
                                String result = "선텍한 음식 : ";
                                for(int i=0; i<mSelectMulti.length; i++){
                                    if(mSelectMulti[i]){
                                        result += food[i] + " / ";
                                    }
                                }
                                textView.setText(result);
                            }
                        })
                        .show();
            }
        });
    }
}