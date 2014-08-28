package com.rauwamsterdam.rauwamsterdam.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.rauwamsterdam.rauwamsterdam.ContactFragment;
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
                // Profiel fragment activity
                return new ProfielFragment();
            case 1:
                // Trainingen fragment activity
                return new TrainingenFragment();
            case 2:
                // Nieuws fragment activity
                return new ContactFragment();
        }

        return null;
    }

    @Override
    public int getCount() {
        // get item count - equal to number of tabs
        return 3;
    }

}
