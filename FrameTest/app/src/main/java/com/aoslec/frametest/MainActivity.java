package com.aoslec.frametest;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    Button button;
    ImageView image;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = findViewById(R.id.btn);
        image = findViewById(R.id.image1);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(image.getVisibility()==v.INVISIBLE){
                    image.setVisibility(v.VISIBLE);
                }else {
                    image.setVisibility(v.INVISIBLE);
                }
            }
        });

    }
}