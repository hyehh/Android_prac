package com.aoslec.gridviewprac;

import android.app.AlertDialog;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

public class CustomAdapter extends BaseAdapter {

    // Property
    private Context mContext = null;
    private int[] data = null;

    // Constructor
    public CustomAdapter(Context mContext, int[] data) {
        this.mContext = mContext;
        this.data = data;
    }

    @Override
    public int getCount() {
        return data.length;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ImageView imageView = null;

        if(convertView  == null){
            // 화면에 이미지를 보여줄꺼야!
            imageView = new ImageView(mContext);
            // 보여줄 이미지 크기는 이렇게 정할꺼야!
            imageView.setLayoutParams(new GridView.LayoutParams(100, 100));
            // 이미지는 이렇게 정렬할꺼야!
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            // 이미지 padding 은 이렇게 할꺼야!
            imageView.setPadding(5,5,5,5);
        }else {
            imageView = (ImageView) convertView;
        }

        imageView.setImageResource(data[position]);

        // 이미지 크게 보여주기
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                View dialogView = View.inflate(mContext, R.layout.dialog, null);
                AlertDialog.Builder dlg = new AlertDialog.Builder(mContext);
                ImageView ivDialog = dialogView.findViewById(R.id.ivDialog);
                ivDialog.setImageResource(data[position]);

                dlg.setTitle(" >>> 날씨 <<< ");
                dlg.setView(dialogView);
                dlg.setNegativeButton("닫기", null);
                dlg.show();
            }
        });

        return imageView;
    }
}
