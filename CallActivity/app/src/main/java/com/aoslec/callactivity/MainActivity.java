package com.aoslec.callactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button mainBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.v("Message", "onCreateMain");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mainBtn = findViewById(R.id.mainBtn);

        mainBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, SubActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    protected void onStart() {
        Log.v("Message", "onStartMain");
        super.onStart();
    }

    @Override
    protected void onResume() {
        Log.v("Message", "onResumeMain");
        super.onResume();
    }

    @Override
    protected void onPause() {
        Log.v("Message", "onPauseMain");
        super.onPause();
    }

    @Override
    protected void onStop() {
        Log.v("Message", "onStopMain");
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        Log.v("Message", "onDestroyMain");
        super.onDestroy();
    }
}