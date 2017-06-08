package com.example.kaushik.jobs4u;

/**
 * Created by user on 6/8/2017.
 */

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

public class pagerMyActivity extends FragmentStatePagerAdapter {

    //integer to count number of tabs
    int tabCount;

    //Constructor to the class
    public pagerMyActivity(FragmentManager fm, int tabCount) {
        super(fm);
        //Initializing tab count
        this.tabCount= tabCount;
    }

    //Overriding method getItem
    @Override
    public Fragment getItem(int position) {
        //Returning the current tabs
        switch (position) {
            case 0:
                MyActivityHistory tab1 = new MyActivityHistory();
                return tab1;
            case 1:
                MyActivityFavourite tab2 = new MyActivityFavourite();
                return tab2;
            case 2:
                MyActivityApplied tab3 = new MyActivityApplied();
                return tab3;

            default:
                return null;
        }
    }

    //Overriden method getCount to get the number of tabs
    @Override
    public int getCount() {
        return tabCount;
    }
}