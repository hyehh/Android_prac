package com.aoslec.posterprac;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setTitle("그리드뷰 영화 포스터");
        MyGridAdapter adapter = new MyGridAdapter(MainActivity.this);

        GridView gv = findViewById(R.id.gv_01);
        gv.setAdapter(adapter);

    }

    public class MyGridAdapter extends BaseAdapter{

        Context mContext = null;
        int[] posterID = {R.drawable.mov01, R.drawable.mov02, R.drawable.mov03, R.drawable.mov04, R.drawable.mov05, R.drawable.mov06, R.drawable.mov07, R.drawable.mov08, R.drawable.mov09, R.drawable.mov10,
                R.drawable.mov01, R.drawable.mov02, R.drawable.mov03, R.drawable.mov04, R.drawable.mov05, R.drawable.mov06, R.drawable.mov07, R.drawable.mov08, R.drawable.mov09, R.drawable.mov10,
                R.drawable.mov01, R.drawable.mov02, R.drawable.mov03, R.drawable.mov04, R.drawable.mov05, R.drawable.mov06, R.drawable.mov07, R.drawable.mov08, R.drawable.mov09, R.drawable.mov10
                };

        public MyGridAdapter(Context mContext) {
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
            imageView = new ImageView(mContext);
            imageView.setLayoutParams(new GridView.LayoutParams(200, 300));
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            imageView.setPadding(5,5,5,5);

            imageView.setImageResource(posterID[position]);

            // 이미지 크게 보여주기
            imageView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    View dialogView = View.inflate(mContext, R.layout.dialog, null);
//                    View dialogView = View.inflate(MainActivity.this, R.layout.dialog, null); main이기 때문에 mContext 아닌 MainActivity.this 써도 가능
                    AlertDialog.Builder dlg = new AlertDialog.Builder(mContext);
//                    AlertDialog.Builder dlg = new AlertDialog.Builder(MainActivity.this); main이기 때문에 mContext 아닌 MainActivity.this 써도 가능
                    ImageView iv_poster = dialogView.findViewById(R.id.iv_poster);
                    iv_poster.setImageResource(posterID[position]);

                    dlg.setTitle(" >>> 포스터 <<<");
                    dlg.setView(dialogView);
                    dlg.setNegativeButton("닫기", null);
                    dlg.show();
                }
            });

            return imageView;
        }
    }
}