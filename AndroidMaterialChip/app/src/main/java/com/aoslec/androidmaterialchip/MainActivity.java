package com.aoslec.androidmaterialchip;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.Toast;

import com.google.android.material.button.MaterialButton;
import com.google.android.material.chip.Chip;
import com.google.android.material.chip.ChipGroup;
import com.google.android.material.textfield.TextInputEditText;

public class MainActivity extends AppCompatActivity {

    Chip chip;
    MaterialButton btn_add_tag, btn_get_selected;
    ChipGroup chipGroup;
    TextInputEditText textInputEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        chip = findViewById(R.id.chip_example);

        chip.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                Toast.makeText(MainActivity.this, "Checked change to " + isChecked, Toast.LENGTH_SHORT).show();
            }
        });
        chip.setOnCloseIconClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Close icon clicked", Toast.LENGTH_SHORT).show();
            }
        });

        btn_add_tag = findViewById(R.id.btn_add_tag);
        btn_get_selected = findViewById(R.id.btn_add_selected);
        chipGroup = findViewById(R.id.chip_group1);
        textInputEditText = findViewById(R.id.input);

        btn_add_tag.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String[] tags = textInputEditText.getText().toString().split(" ");
                LayoutInflater inflater = LayoutInflater.from(MainActivity.this);
                for(String text : tags){
                    Chip chip = (Chip) inflater.inflate(R.layout.chip_item, null, false);
                    chip.setText(text);
                    chip.setOnCloseIconClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            chipGroup.removeView(v);
                        }
                    });
                    chipGroup.addView(chip);
                }
            }
        });

        btn_get_selected.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                StringBuilder result = new StringBuilder("");
                for(int i=0; i<chipGroup.getChildCount(); i++){
                    Chip chip = (Chip) chipGroup.getChildAt(i);
                    if(chip.isChecked())
                        if(i<chipGroup.getChildCount()-1)
                            result.append(chip.getText()).append(",");
                        else
                            result.append(chip.getText());


                }
                Toast.makeText(MainActivity.this, "" + result.toString(), Toast.LENGTH_SHORT).show();

            }
        });
    }
}