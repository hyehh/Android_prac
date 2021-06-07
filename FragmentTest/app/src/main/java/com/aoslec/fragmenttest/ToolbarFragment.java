package com.aoslec.fragmenttest;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SeekBar;

public class ToolbarFragment extends Fragment {

    EditText editText = null;
    Button button = null;
    SeekBar seekBar = null;
    int seekValue = 10;

    ToolbarListener activityCallback;

    public interface ToolbarListener{
        // 여기서는 interface 선언만 해준다!
        public void onButtonClick(int position, String text);
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        try{

        }catch
    }
}