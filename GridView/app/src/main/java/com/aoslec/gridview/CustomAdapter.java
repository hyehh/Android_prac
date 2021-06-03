package com.aoslec.gridview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

public class CustomAdapter extends BaseAdapter {

    private Context mContext = null;
    private int[] data = null;

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
        ImageView imageView;

        if(convertView == null){ // convertView 가 null 이라면
            // context(화면) 에 이미지를 저장하겠다
            imageView = new ImageView(mContext);
            // 이미지 크기는 이렇게 정하겠다
            imageView.setLayoutParams(new GridView.LayoutParams(100, 100));
            // 이미지 정렬은 이렇게 정하겠다
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            // 이미지 패딩도 주겠다
            imageView.setPadding(5,5,5,5);
        }else { // null 이 아니라면
            imageView = (ImageView) convertView;
        }

        // 이 위치에 이미지 src 를 설정해주겠다
        imageView.setImageResource(data[position]);

        return imageView;
    }
}
