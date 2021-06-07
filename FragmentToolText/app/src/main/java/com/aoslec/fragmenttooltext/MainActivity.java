package com.aoslec.fragmenttooltext;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity implements ToolbarFragment.ToolBarListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.v("Message", "onCreate_m");

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public void onButtonClick(int position, String text) {
        Log.v("Message", "onButtonClick_m");

        TextFragment textFragment = (TextFragment) getSupportFragmentManager().findFragmentById(R.id.fg_02);
        textFragment.changeTextProperties(position, text);
    }
}