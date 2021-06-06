package com.aoslec.spinnerprac;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity {

    ArrayAdapter<CharSequence> adapter = null;
    Spinner spinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        adapter = ArrayAdapter.createFromResource(MainActivity.this, R.array.travel, android.R.layout.simple_list_item_1);

        spinner = findViewById(R.id.sp_01);
        spinner.setAdapter(adapter);

    }
}