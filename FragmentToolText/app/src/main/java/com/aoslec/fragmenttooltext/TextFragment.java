package com.aoslec.fragmenttooltext;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class TextFragment extends Fragment {

    TextView textView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Log.v("Message", "onCreateView_f2");

        View view = inflater.inflate(R.layout.fragment_text, container, false);

        textView = view.findViewById(R.id.tv);

        return view;
    }

    // 크기 변하는 메소드 하나 만들기 (값을 메인에서 받아야 하기 때문에 파라미터가 메인과 동일한 메소드 하나 더 생성)
    public void changeTextProperties(int fontSize, String str){
        Log.v("Message", "changeTextProperties_f2");

        textView.setTextSize(fontSize);
        textView.setText(str);
    }
}