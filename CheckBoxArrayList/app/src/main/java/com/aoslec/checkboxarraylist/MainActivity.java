package com.aoslec.checkboxarraylist;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    CheckBox cb1, cb2, cb3, cb4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        cb1 = findViewById(R.id.cb_01);
        cb2 = findViewById(R.id.cb_02);
        cb3 = findViewById(R.id.cb_03);
        cb4 = findViewById(R.id.cb_04);

        cb1.setOnCheckedChangeListener(checkedListener);
        cb2.setOnCheckedChangeListener(checkedListener);
        cb3.setOnCheckedChangeListener(checkedListener);
        cb4.setOnCheckedChangeListener(checkedListener);
    }

    CompoundButton.OnCheckedChangeListener checkedListener = new CompoundButton.OnCheckedChangeListener() {
        ArrayList<String> arrayList = new ArrayList<String>();
        @Override
        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
            String str = "";

            if(buttonView.getId() == R.id.cb_01){
                if(isChecked == true){
                    arrayList.add("운동");
                }else {
                    arrayList.remove("운동");
                }
            }
            if(buttonView.getId() == R.id.cb_02){
                if(isChecked == true){
                    arrayList.add("요리");
                }else {
                    arrayList.remove("요리");
                }
            }
            if(buttonView.getId() == R.id.cb_03){
                if(isChecked == true){
                    arrayList.add("독서");
                }else {
                    arrayList.remove("독서");
                }
            }
            if(buttonView.getId() == R.id.cb_04){
                if(isChecked == true){
                    arrayList.add("여행");
                }else {
                    arrayList.remove("여행");
                }
            }

            for(int i=0; i<arrayList.size(); i++){
                str += arrayList.get(i);
            }

            if(arrayList.isEmpty()){
                Toast.makeText(MainActivity.this,"아무것도 선택하지 않았습니다!", Toast.LENGTH_SHORT).show();
            }else {
                Toast.makeText(MainActivity.this,str + "is Checked", Toast.LENGTH_SHORT).show();
            }
        }
    };
}