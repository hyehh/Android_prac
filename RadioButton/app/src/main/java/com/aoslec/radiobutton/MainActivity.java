package com.aoslec.radiobutton;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity {

    RadioGroup group;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        group = findViewById(R.id.rg_01);

        group.setOnCheckedChangeListener(checkedListener);
    }

    RadioGroup.OnCheckedChangeListener checkedListener = new RadioGroup.OnCheckedChangeListener() {
        @Override
        public void onCheckedChanged(RadioGroup group, int checkedId) {
            String str = "";

            switch (checkedId){
                case R.id.rb_01:
                    str += "서울";
                    break;
                case R.id.rb_02:
                    str += "경기도";
                    break;
                case R.id.rb_03:
                    str += "강원도";
                    break;
                case R.id.rb_04:
                    str += "충청도";
                    break;
                case R.id.rb_05:
                    str += "경상도";
                    break;
                case R.id.rb_06:
                    str += "전라도";
                    break;
                case R.id.rb_07:
                    str += "제주도";
                    break;
            }
            Toast.makeText(MainActivity.this,"당신의 고향은 " + str + " 입니다!", Toast.LENGTH_SHORT).show();
            Snackbar.make(group,"당신의 고향은 " + str + " 입니다!", Snackbar.LENGTH_SHORT).show();
        }
    };
}