package com.aoslec.gallery;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Gallery;
import android.widget.ImageView;

public class GalleryAdapter extends BaseAdapter {

    private Context mContext = null;
    private int[] posterID = null;
    private LayoutInflater inflater = null;

    public GalleryAdapter(Context mContext, int[] posterID) {
        this.mContext = mContext;
        this.posterID = posterID;
    }

    @Override
    public int getCount() {
        return posterID.length;
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

        if(convertView == null){
            imageView = new ImageView(mContext);
            imageView.setLayoutParams(new Gallery.LayoutParams(200, 300));
            imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
            imageView.setPadding(5,5,5,5);
        }

        imageView.setImageResource(posterID[position]);

        imageView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                View view = inflater.inflate(R.layout.activity_main, parent, false);
                ImageView ivPoster = view.findViewById(R.id.ivPoster);
                ivPoster.setScaleType(ImageView.ScaleType.FIT_CENTER);
                ivPoster.setImageResource(posterID[position]);
                return false;
            }
        });

        return imageView;
    }
}
