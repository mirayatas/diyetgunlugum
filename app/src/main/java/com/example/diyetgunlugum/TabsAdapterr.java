package com.example.diyetgunlugum;

import android.app.DownloadManager;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class TabsAdapterr extends FragmentPagerAdapter {
    public TabsAdapterr(@NonNull FragmentManager fm) {
        super(fm);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                FoodFragment foodFragment = new FoodFragment();
                return foodFragment;
            case 1:
                Exercisefragment exercisefragment = new Exercisefragment();
                return exercisefragment;
            default:return null;
        }

    }

    @Override
    public int getCount() {
        return 2;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        switch (position){
            case 0:
                return "Yiyecekler";
            case 1:
                return "Egzersizler";
                default:
                    return null;
        }

    }
}

