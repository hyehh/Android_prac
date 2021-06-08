package com.aoslec.fragmenttooltext;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SeekBar;

public class ToolbarFragment extends Fragment {

    // ToolBarListener의 기능들을 activityCallback 라고 재정의할꺼야
    // 기본적으로 정의되는 게 있는데 우리가 따로 갖다 써야 하니까 따로 정의해주겠다!
    ToolBarListener activityCallback;

    EditText editText = null;
    SeekBar seekBar = null;
    Button button = null;

    int seekValue = 10;

    public interface ToolBarListener{
        public void onButtonClick(int position, String str);
    }

    @Override
    public void onAttach(Context context) {
        Log.v("Message", "onAttach_f1");
        super.onAttach(context);
        try {
            // Main에게 activityCallback의 기능은 context라고 정의한 것
            activityCallback = (ToolBarListener) context;
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Log.v("Message", "onCreateView_f1");

        View view = inflater.inflate(R.layout.fragment_toolbar, container, false);

        editText = view.findViewById(R.id.edit);
        seekBar = view.findViewById(R.id.seekBar);
        button = view.findViewById(R.id.btn);

        seekBar.setProgress(seekValue);

        seekBar.setOnSeekBarChangeListener(onSeekBarChangeListener);
        button.setOnClickListener(onClickListener);

        return view;
    }

    SeekBar.OnSeekBarChangeListener onSeekBarChangeListener = new SeekBar.OnSeekBarChangeListener() {

        @Override
        public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
            Log.v("Message", "onProgressChanged_f1");

            seekValue = progress;
        }

        @Override
        public void onStartTrackingTouch(SeekBar seekBar) {
            Log.v("Message", "onStartTrackingTouch_f1");

        }

        @Override
        public void onStopTrackingTouch(SeekBar seekBar) {
            Log.v("Message", "onStopTrackingTouch_f1");

        }
    };

    View.OnClickListener onClickListener = new View.OnClickListener() {

        @Override
        public void onClick(View v) {
            Log.v("Message", "onClick_f1");

            activityCallback.onButtonClick(seekValue, editText.getText().toString());
        }
    };
}