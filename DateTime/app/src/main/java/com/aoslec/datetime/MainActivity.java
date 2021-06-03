package com.aoslec.datetime;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.Chronometer;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.TimePicker;

public class MainActivity extends AppCompatActivity {

    Chronometer chrono;
    Button btnStart, btnEnd;
    RadioButton rbCal, rbTime;
    RadioGroup group;
    CalendarView calView;
    TimePicker timeView;
    TextView tv_year, tv_month, tv_day, tv_hour, tv_minute;

    int selectYear, selectMonth, selectDay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setTitle("시간 예약");

        chrono = findViewById(R.id.chronometer1);
        btnStart = findViewById(R.id.btnStart);
        btnEnd = findViewById(R.id.btnFinish);
        rbCal = findViewById(R.id.rbCal);
        rbTime = findViewById(R.id.rbTime);
        group = findViewById(R.id.rg_01);
        calView = findViewById(R.id.calView);
        timeView = findViewById(R.id.timeView);
        tv_year = findViewById(R.id.tv_year);
        tv_month = findViewById(R.id.tv_month);
        tv_day = findViewById(R.id.tv_day);
        tv_hour = findViewById(R.id.tv_hour);
        tv_minute = findViewById(R.id.tv_minute);

        calView.setVisibility(View.INVISIBLE);
        timeView.setVisibility(View.INVISIBLE);

        // 라디오 그룹 선언 시에는 이렇게 해주면 됨! (라디오 그룹으로 메소드 주든 라디오 버튼으로 메소드 주든 상관 없음)
//        group.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
//            @Override
//            public void onCheckedChanged(RadioGroup group, int checkedId) {
//                switch (group.getCheckedRadioButtonId()){
//                    case R.id.rbCal:
//                        calView.setVisibility(View.VISIBLE);
//                        timeView.setVisibility(View.INVISIBLE);
//                        break;
//                    case R.id.rbTime:
//                        calView.setVisibility(View.INVISIBLE);
//                        timeView.setVisibility(View.VISIBLE);
//                        break;
//                }
//            }
//        });

        rbCal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calView.setVisibility(View.VISIBLE);
                timeView.setVisibility(View.INVISIBLE);
            }
        });

        rbTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calView.setVisibility(View.INVISIBLE);
                timeView.setVisibility(View.VISIBLE);
            }
        });

        // 타이머 설정
        btnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // elapsedRealtime은 시스템 부팅부터 지금까지 흐른 시간을 반환
                chrono.setBase(SystemClock.elapsedRealtime());
//                chrono.setBase(SystemClock.currentThreadTimeMillis()); -> SystemClock에 다양한 속성들이 존재
                chrono.start();
                chrono.setTextColor(Color.RED);
            }
        });

        // 캘린더에서 선택한 날짜 저장하기
        calView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView view, int year, int month, int dayOfMonth) {
                selectYear = year;
                selectMonth = month + 1;
                selectDay = dayOfMonth;
            }
        });

        // 예약 완료 버튼
        btnEnd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                chrono.stop();
                chrono.setTextColor(Color.BLUE);

                tv_year.setText(Integer.toString(selectYear));
                tv_month.setText(Integer.toString(selectMonth));
                tv_day.setText(Integer.toString(selectDay));

                // TimePicker에서 선택한 시간과 분
                tv_hour.setText(Integer.toString(timeView.getCurrentHour()));
                tv_minute.setText(Integer.toString(timeView.getCurrentMinute()));
            }
        });
    } // onCreate
}