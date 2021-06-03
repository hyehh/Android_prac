package com.aoslec.customadapterviewprac;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class WeatherAdapter extends BaseAdapter {

    private Context mContext = null;
    private int layout = 0;
    private ArrayList<Weather> data = null;
    private LayoutInflater inflater = null;

    public WeatherAdapter(Context mContext, int layout, ArrayList<Weather> data) {
        this.mContext = mContext;
        this.layout = layout;
        this.data = data;
        this.inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public Object getItem(int position) {
        return data.get(position).getDay();
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if(convertView == null){ // 1번 convertView 비어있는지 확인 -> 데이터 올리기 -> 2번 convertView 비어있는지 확인 -> 데이터 올리기 -> 무한반복
            convertView = inflater.inflate(this.layout, parent, false);
        }

        // 데이터 연결하기 (내가 만든 custom_layout 에는 tools:context=".MainActivity" 해당 속성이 없기 때문에 그냥 find~ 쓰면 안되고 앞에 convertView 같은 view 를 연결해줘야 함!
        TextView tv_day = convertView.findViewById(R.id.tv_day);
        ImageView iv_weather = convertView.findViewById(R.id.iv_weather);
        TextView tv_comment = convertView.findViewById(R.id.tv_comment);

        // 데이터 넣기
        tv_day.setText(data.get(position).getDay() + " ");
        iv_weather.setImageResource(data.get(position).getIcon());
        tv_comment.setText(data.get(position).getComment());

        // convertView 홀짝 으로 배경 색 바꾸기
        if(position % 2 == 1){
            convertView.setBackgroundColor(0x5000ff00);
        }else {
            convertView.setBackgroundColor(0x2000ff00);
        }
        return convertView;
    }
}
