package com.aoslec.callactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class SubActivity extends AppCompatActivity {

    Button subBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.v("Message", "onCreateSub");
        super.onCreate(savedInstanceState);

        // 화면 회전
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);

        setContentView(R.layout.activity_sub);

        subBtn = findViewById(R.id.subBtn);

        subBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    @Override
    protected void onStart() {
        Log.v("Message", "onStartSub");
        super.onStart();
    }

    @Override
    protected void onResume() {
        Log.v("Message", "onResumeSub");
        super.onResume();
    }

    @Override
    protected void onPause() {
        Log.v("Message", "onPauseSub");
        super.onPause();
    }

    @Override
    protected void onStop() {
        Log.v("Message", "onStopSub");
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        Log.v("Message", "onDestroySub");
        super.onDestroy();
    }
}