package com.aoslec.spinner;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity {

    ArrayAdapter<CharSequence> adapter = null;
    Spinner spinner = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Adapter 준비
        adapter = ArrayAdapter.createFromResource(this, R.array.travelArea, android.R.layout.simple_list_item_1);

        // Spinner 와 Adapter 연결
        spinner = findViewById(R.id.sp_01);
        spinner.setAdapter(adapter);
    }
}