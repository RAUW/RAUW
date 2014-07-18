package com.rauwamsterdam.rauwamsterdam.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.rauwamsterdam.rauwamsterdam.NieuwsFragment;
import com.rauwamsterdam.rauwamsterdam.ProfielFragment;
import com.rauwamsterdam.rauwamsterdam.TrainingenFragment;

public class TabsPagerAdapter extends FragmentPagerAdapter {

    public TabsPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {

        switch (position) {
            case 0:
                // Nieuws fragment activity
                return new NieuwsFragment();
            case 1:
                // Trainingen fragment activity
                return new TrainingenFragment();
            case 2:
                // Profiel fragment activity
                return new ProfielFragment();
        }

        return null;
    }

    @Override
    public int getCount() {
        // get item count - equal to number of tabs
        return 3;
    }

}
