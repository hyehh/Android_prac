package com.aoslec.diary;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    SQLiteDatabase db;
    DiaryHelper diary;
    Button insert, select;
    TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        connectGetData();
    }

    private void connectGetData(){
        diary = new DiaryHelper(MainActivity.this);
        insert = findViewById(R.id.insert);
        select = findViewById(R.id.select);
        tv = findViewById(R.id.tvResult);
        insert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    db = diary.getWritableDatabase();
                    String query = "INSERT INTO diarydata(content, emoji) VALUES ('안드로이드 프로젝트 제발 오늘 안에 끝내자ㅏ', 1);";
                    db.execSQL(query);
                    diary.close();
                    Toast.makeText(MainActivity.this, "insert 성공", Toast.LENGTH_SHORT).show();
                }catch (Exception e){
                    e.printStackTrace();
                    Toast.makeText(MainActivity.this, "insert 실패", Toast.LENGTH_SHORT).show();
                }
            }
        });

        select.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    db = diary.getReadableDatabase();
                    String query = "SELECT id, content, emoji, date FROM diarydata;";
                    Cursor cursor = db.rawQuery(query, null);
                    StringBuffer stringBuffer = new StringBuffer();
                    while (cursor.moveToNext()){
                        int id = cursor.getInt(0);
                        String content = cursor.getString(1);
                        int emoji = cursor.getInt(2);
                        String date = cursor.getString(3);
                        stringBuffer.append("id : " + id + "content : " + content + "emoji : " + emoji + "date : " + date);
                    }
                    tv.setText(stringBuffer.toString());
                    cursor.close();
                    diary.close();
                    Toast.makeText(MainActivity.this, "select 성공", Toast.LENGTH_SHORT).show();
                }catch (Exception e){
                    e.printStackTrace();
                    Toast.makeText(MainActivity.this, "select 실패", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}