package com.aoslec.tablecaculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText editNum1, editNum2;
    Button btnPlus, btnMinus, btnMul, btnDiv;
    TextView calResult;
    int num1, num2;
    String result;

    // 10개의 숫자 버튼 배열
    Button[] numButtons = new Button[10];
    // 10개의 숫자 버튼의 id 값 배열
    Integer[] numBtnIDs = {R.id.zero, R.id.one, R.id.two, R.id.three, R.id.four, R.id.five, R.id.six, R.id.seven, R.id.eight, R.id.nine};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editNum1 = findViewById(R.id.num1);
        editNum2 = findViewById(R.id.num2);

        btnPlus = findViewById(R.id.plus);
        btnMinus = findViewById(R.id.minus);
        btnMul = findViewById(R.id.mul);
        btnDiv = findViewById(R.id.div);

        calResult = findViewById(R.id.result);

        for(int i=0; i<numButtons.length; i++){
            numButtons[i] = findViewById(numBtnIDs[i]);
        }

        // 사칙연산 클릭 이벤트 처리하기
        btnPlus.setOnClickListener(calClickListener);
        btnMinus.setOnClickListener(calClickListener);
        btnMul.setOnClickListener(calClickListener);
        btnDiv.setOnClickListener(calClickListener);

        // 숫자 클릭 이벤트 처리하기
        for(int i=0; i<numButtons.length; i++){
            final int index = i;

            numButtons[index].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(editNum1.isFocused() == true){
                        num1 = Integer.parseInt(editNum1.getText().toString() + numButtons[index].getText().toString());
                        editNum1.setText(Integer.toString(num1));
                    }else if(editNum2.isFocused() == true){
                        num2 = Integer.parseInt(editNum2.getText().toString() + numButtons[index].getText().toString());
                        editNum2.setText(Integer.toString(num2));
                    }else{
                        Toast.makeText(MainActivity.this,"입력 항목부터 선택하세요!", Toast.LENGTH_SHORT).show();
                    }
                }
            });
        } // for 종료
    } // onCreate 종료

    View.OnClickListener calClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if(editNum1.getText().toString().isEmpty() || editNum2.getText().toString().isEmpty()){
                Toast.makeText(MainActivity.this,"숫자를 먼저 입력해주세요!", Toast.LENGTH_SHORT).show();
            }else {
                num1 = Integer.parseInt(editNum1.getText().toString());
                num2 = Integer.parseInt(editNum2.getText().toString());

                switch (v.getId()){
                    case R.id.plus:
                        result = Integer.toString(num1 + num2);
                        break;
                    case R.id.minus:
                        result = Integer.toString(num1 - num2);
                        break;
                    case R.id.mul:
                        result = Integer.toString(num1 * num2);
                        break;
                    case R.id.div:
                        result = Double.toString(num1 / (double)num2);
                }
                calResult.setText("계산결과 : " + result);
            }
        }
    };
} // MainActivity 종료