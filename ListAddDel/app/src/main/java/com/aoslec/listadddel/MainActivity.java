package com.aoslec.listadddel;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<String> items = null;
    ArrayAdapter<String> adapter = null;
    EditText editText;
    Button btnAdd, btnDel;
    ListView list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = findViewById(R.id.edit);
        btnAdd = findViewById(R.id.btnAdd);
        btnDel = findViewById(R.id.btnDel);

        items = new ArrayList<String>();
        items.add("First");
        items.add("Second");
        items.add("Third");

        adapter = new ArrayAdapter<String>(MainActivity.this, android.R.layout.simple_list_item_single_choice, items);

        list = findViewById(R.id.lv_01);
        list.setAdapter(adapter);
        list.setChoiceMode(ListView.CHOICE_MODE_SINGLE);

        list.setOnItemClickListener(mClickListener);

        btnAdd.setOnClickListener(onClickListener);
        btnDel.setOnClickListener(onClickListener);
    }

    AdapterView.OnItemClickListener mClickListener = new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            String message = null;
            message = "Select item : " + items.get(position);
            Toast.makeText(MainActivity.this, message, Toast.LENGTH_SHORT).show();
        }
    };

    View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()){
                case R.id.btnAdd:
                    String text = editText.getText().toString().trim();
                    if(text.isEmpty() == false){
                        items.add(text);
                        editText.setText("");
                        adapter.notifyDataSetChanged();
                    }else{
                        Toast.makeText(MainActivity.this, "text를 입력해 주세요!", Toast.LENGTH_SHORT).show();
                    }
                    break;
                case R.id.btnDel:
                    int id;
                    id = list.getCheckedItemPosition();
                    if(id != ListView.INVALID_POSITION){
                        items.remove(id);
                        list.clearChoices();
                        adapter.notifyDataSetChanged();
                    }else {
                        Toast.makeText(MainActivity.this, "삭제할 item을 선택해주세요!", Toast.LENGTH_SHORT).show();
                    }
                    break;
            }
        }
    };
}