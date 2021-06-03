package com.aoslec.customadapterviewprac;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ArrayList<Weather> data = null;
    private WeatherAdapter adapter = null;
    private ListView list = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Data 만들기
        data = new ArrayList<Weather>();

        data.add(new Weather("월", R.drawable.w1, "맑음"));
        data.add(new Weather("화", R.drawable.w2, "흐림"));
        data.add(new Weather("수", R.drawable.w3, "눈"));
        data.add(new Weather("목", R.drawable.w4, "우박"));
        data.add(new Weather("금", R.drawable.w5, "비"));
        data.add(new Weather("토", R.drawable.w6, "추움"));
        data.add(new Weather("일", R.drawable.w7, "더움"));
        data.add(new Weather("월", R.drawable.w1, "맑음"));
        data.add(new Weather("화", R.drawable.w2, "흐림"));
        data.add(new Weather("수", R.drawable.w3, "눈"));
        data.add(new Weather("목", R.drawable.w4, "우박"));
        data.add(new Weather("금", R.drawable.w5, "비"));
        data.add(new Weather("토", R.drawable.w6, "추움"));
        data.add(new Weather("일", R.drawable.w7, "더움"));

        // Adapter 만들기
        adapter = new WeatherAdapter(this, R.layout.custom_layout, data);

        // ListView와 Adapter 연결
        list = findViewById(R.id.lv_weather);
        list.setAdapter(adapter);
   }
}