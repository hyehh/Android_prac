package com.aoslec.checkboxradio;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    CheckBox checkBox;
    TextView textView;
    RadioGroup radioGroup;
    RadioButton btn1, btn2, btn3;
    Button button;
    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        checkBox = findViewById(R.id.cb_01);
        textView = findViewById(R.id.tv_01);
        radioGroup = findViewById(R.id.rg_01);
        btn1 = findViewById(R.id.rb_01);
        btn2 = findViewById(R.id.rb_02);
        btn3 = findViewById(R.id.rb_03);
        button = findViewById(R.id.btn);
        imageView = findViewById(R.id.imgPet);

        checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(checkBox.isChecked()){
                    textView.setVisibility(buttonView.VISIBLE);
                    radioGroup.setVisibility(buttonView.VISIBLE);
                    button.setVisibility(buttonView.VISIBLE);
                }else {
                    textView.setVisibility(buttonView.INVISIBLE);
                    radioGroup.setVisibility(buttonView.INVISIBLE);
                    button.setVisibility(buttonView.INVISIBLE);
                    imageView.setVisibility(buttonView.INVISIBLE);
                }
            }
        });

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imageView.setVisibility(v.VISIBLE);
                switch (radioGroup.getCheckedRadioButtonId()){
                    case R.id.rb_01:
                        imageView.setImageResource(R.drawable.dog);
                        break;
                    case R.id.rb_02:
                        imageView.setImageResource(R.drawable.cat);
                        break;
                    case R.id.rb_03:
                        imageView.setImageResource(R.drawable.rabbit);
                        break;
                    default:
                        Toast.makeText(getApplicationContext(),"좋아하는 동물을 선택한 후 버튼을 눌러주세요!", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}