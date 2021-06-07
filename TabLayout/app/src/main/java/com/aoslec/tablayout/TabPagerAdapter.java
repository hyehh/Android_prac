package com.aoslec.tablayout;

import android.util.Log;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class TabPagerAdapter extends FragmentPagerAdapter {

    // Property
    int tabCount;

    // Constructor
    public TabPagerAdapter(FragmentManager fm, int behavior){
        super(fm, behavior);
        this.tabCount = behavior;
    }

    @Override
    public Fragment getItem(int position) {
        Log.v("Message","getItem_adapter");

        switch (position){
            case 0:
                Tab1Fragment tab1Fragment = new Tab1Fragment();
                return tab1Fragment;
            case 1:
                Tab2Fragment tab2Fragment = new Tab2Fragment();
                return tab2Fragment;
            case 2:
                Tab3Fragment tab3Fragment = new Tab3Fragment();
                return tab3Fragment;
            case 3:
                Tab4Fragment tab4Fragment = new Tab4Fragment();
                return tab4Fragment;
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        Log.v("Message","getCount_adapter");

        return tabCount;
    }
}
