package com.aoslec.intentidpw;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText id, pw;
    Button btnMain;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        id = findViewById(R.id.id);
        pw = findViewById(R.id.pw);
        btnMain = findViewById(R.id.mainBtn);

        btnMain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String userId = id.getText().toString();
                String userPw = pw.getText().toString();
                //int userPw = Integer.parseInt(pw.getText().toString());
                //if(userId.equals("aaa") && userPw == 1111){
                if(userId.equals("aaa") && userPw.equals("1111")){
                    Intent intent = new Intent(MainActivity.this, SubActivity.class);
                    startActivity(intent);
                }else {
                    Toast.makeText(MainActivity.this, "ID나 패스워드가 올바르지 않습니다", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}