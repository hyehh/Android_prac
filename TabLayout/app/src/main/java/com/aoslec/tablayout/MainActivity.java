package com.aoslec.tablayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.util.Log;

import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity {

    TabLayout tabLayout;
    ViewPager pager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.v("Message","onCreate_m");

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

         tabLayout = findViewById(R.id.tablayout);
         pager = findViewById(R.id.pager);

         // tabLayout 상단에 tab이름과 아이콘 설정
        tabLayout.addTab(tabLayout.newTab().setText("Tab1 Item <<<<").setIcon(android.R.drawable.ic_dialog_email));
        tabLayout.addTab(tabLayout.newTab().setText("Tab2 Item <<<<").setIcon(android.R.drawable.ic_dialog_dialer));
        tabLayout.addTab(tabLayout.newTab().setText("Tab3 Item <<<<").setIcon(android.R.drawable.ic_dialog_map));
        tabLayout.addTab(tabLayout.newTab().setText("Tab4 Item <<<<").setIcon(android.R.drawable.ic_dialog_info));

        // pageradapter 만들기
        PagerAdapter pagerAdapter = new TabPagerAdapter(getSupportFragmentManager(), tabLayout.getTabCount());

        // view와 adapter 연결하기
        pager.setAdapter(pagerAdapter);

        // pager를 옆으로 밀 때 이벤트
        // 이 listener가 없으면 pager를 옆으로 밀 때 화면 전환은 되는데 탭바 전환이 안됨
        pager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));

        // tab 클릭 시 이벤트
        // 이 listener 가 없으면 tab 버튼 클릭시 탭바 전환만 되고 화면 전환이 안됨
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                Log.v("Message","onTabSelected_m");

                pager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }
}