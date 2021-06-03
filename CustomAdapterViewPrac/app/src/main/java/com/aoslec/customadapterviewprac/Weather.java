package com.aoslec.customadapterviewprac;

import android.widget.TextView;

public class Weather {

    // Property(=Field)
    private String day;
    private int icon;
    private String comment;

    // Constructor
    public Weather(String day, int icon, String comment) {
        this.day = day;
        this.icon = icon;
        this.comment = comment;
    }

    // Method (여러 개의 데이터가 한 줄에 들어가야 하기 때문에 get set 만들어줌! -> 갤러리나 그리드뷰처럼 하나의 데이터만 들어가면 된다면 get set 만들 필요 없음)
    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public int getIcon() {
        return icon;
    }

    public void setIcon(int icon) {
        this.icon = icon;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}
