package com.aoslec.bottomsheet;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.google.android.material.bottomsheet.BottomSheetDialogFragment;

public class BottomSheet extends BottomSheetDialogFragment {

    Button button;

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        Log.v("Message", "onCreateView_b");
        return inflater.inflate(R.layout.activity_bottom_sheet, container, false);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        Log.v("Message", "onActivityCreated_b");
        super.onActivityCreated(savedInstanceState);
        button = getView().findViewById(R.id.btnBottom);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.v("Message", "onClick_b");
                dismiss();
            }
        });
    }
}