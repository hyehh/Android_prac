package com.aoslec.callother;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ComponentName;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button web, dial, list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        web = findViewById(R.id.web);
        dial = findViewById(R.id.dial);
        list = findViewById(R.id.list);

        web.setOnClickListener(onClickListener);
        dial.setOnClickListener(onClickListener);
        list.setOnClickListener(onClickListener);
    }

    View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent = null;
            switch (v.getId()){
                case R.id.web:
                    intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.google.com"));
                    startActivity(intent);
                    break;
                case R.id.dial:
                    intent = new Intent(Intent.ACTION_VIEW, Uri.parse("tel:010-1111-2222"));
                    startActivity(intent);
                    break;
                case R.id.list:
                    intent = new Intent(Intent.ACTION_MAIN);
                    intent.setComponent(new ComponentName("com.aoslec.listadddel", "com.aoslec.listadddel.MainActivity"));
                    startActivity(intent);
                    break;
            }
        }
    };
}