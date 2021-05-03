package com.lppwm.tasklist.ui;

import android.content.Context;

import androidx.annotation.Nullable;
import androidx.annotation.StringRes;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.lppwm.tasklist.R;
import com.lppwm.tasklist.ui.tabs.CreateTaskTab;
import com.lppwm.tasklist.ui.tabs.PlanningTab;
import com.lppwm.tasklist.ui.tabs.TaskListTab;

/**
 * A [FragmentPagerAdapter] that returns a fragment corresponding to
 * one of the sections/tabs/pages.
 */
public class SectionsPagerAdapter extends FragmentPagerAdapter {

    @StringRes
    private static final int[] TAB_TITLES = new int[]{R.string.tab_1_name, R.string.tab_2_name/*, R.string.tab_3_name*/};
    private final Context mContext;

    public SectionsPagerAdapter(Context context, FragmentManager fm) {
        super(fm);
        mContext = context;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return TaskListTab.getInstance();
            case 1: ;
                return new CreateTaskTab();
//            case 2:
//                return PlanningTab.getInstance();
            default:
                return null;
        }
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return mContext.getResources().getString(TAB_TITLES[position]);
    }

    @Override
    public int getCount() {
        return TAB_TITLES.length;
    }
}