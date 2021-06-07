package com.aoslec.gallery;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Gallery;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    private int[] posterID = null;
    //private MyGalleryAdapter adapter = null;
    private GalleryAdapter adapter = null;
    private Gallery gallery = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        posterID = new int[]{R.drawable.mov01, R.drawable.mov02, R.drawable.mov03, R.drawable.mov04, R.drawable.mov05, R.drawable.mov06, R.drawable.mov07, R.drawable.mov08, R.drawable.mov09, R.drawable.mov10
                            };

        adapter = new GalleryAdapter(MainActivity.this, posterID);
        //adapter = new MyGalleryAdapter(this);

        gallery = findViewById(R.id.gallery1);
        gallery.setAdapter(adapter);
    }

    public class MyGalleryAdapter extends BaseAdapter {

        private Context mContext = null;

        public MyGalleryAdapter(Context mContext) {
            this.mContext = mContext;
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

            if (convertView == null) {
                imageView = new ImageView(mContext);
                imageView.setLayoutParams(new Gallery.LayoutParams(200, 300));
                imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
                imageView.setPadding(5, 5, 5, 5);
            }

            imageView.setImageResource(posterID[position]);

            imageView.setOnTouchListener(new View.OnTouchListener() {
                @Override
                public boolean onTouch(View v, MotionEvent event) {
                    ImageView ivPoster = findViewById(R.id.ivPoster);
                    ivPoster.setScaleType(ImageView.ScaleType.FIT_CENTER);
                    ivPoster.setImageResource(posterID[position]);
                    return false;
                }
            });

            return imageView;
        }
    }
}