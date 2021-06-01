package com.aoslec.editabletest;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText editText;
    Button btnIns, btnDel, btnApp, btnRep, btnClear;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = findViewById(R.id.edit);

//        btnIns = findViewById(R.id.btnIns);
//        btnDel = findViewById(R.id.btnDel);
//        btnApp = findViewById(R.id.btnApp);
//        btnRep = findViewById(R.id.btnRep);
//        btnClear = findViewById(R.id.btnClear);
//        한 줄로 적을 수도 있음
        findViewById(R.id.btnIns).setOnClickListener(mClickListener);
        findViewById(R.id.btnDel).setOnClickListener(mClickListener);
        findViewById(R.id.btnApp).setOnClickListener(mClickListener);
        findViewById(R.id.btnRep).setOnClickListener(mClickListener);
        findViewById(R.id.btnClear).setOnClickListener(mClickListener);
    }

    View.OnClickListener mClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Editable edit = editText.getText();
            switch (v.getId()){
                case R.id.btnIns:
                    edit.insert(0,"INS");
                    break;
                case R.id.btnDel:
                    edit.delete(2,5);
                    break;
                case R.id.btnApp:
                    edit.append("APP");
                    break;
                case R.id.btnRep:
                    edit.replace(2,6,"REP");
                    break;
                case R.id.btnClear:
                    edit.clear();
                    break;
            }
        }
    };
}