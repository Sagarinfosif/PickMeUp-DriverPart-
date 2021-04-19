package com.drive.pickmeup.adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.drive.pickmeup.fragments.tab.HistoryRewardFragment;
import com.drive.pickmeup.fragments.tab.TodayRewardFragment;
import com.drive.pickmeup.fragments.tab.UpcomingRewardFragment;

public class RewardTabAdapter extends FragmentPagerAdapter {

    public RewardTabAdapter(@NonNull FragmentManager fm, int behavior) {
        super(fm, behavior);
    }

    public RewardTabAdapter(FragmentManager supportFragmentManager) {
        super(supportFragmentManager);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position) {

            case 0:
                HistoryRewardFragment historyRewardFragment = new HistoryRewardFragment();
                return historyRewardFragment;
            case 1:
                TodayRewardFragment todayRewardFragment = new TodayRewardFragment();
                return todayRewardFragment;

            case 2:
                UpcomingRewardFragment upcomingRewardFragment = new UpcomingRewardFragment();
                return upcomingRewardFragment;

            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return 3;
    }

    public CharSequence getPageTitle(int position) {
        switch (position) {

            case 0:
                return "History";
            case 1:
                return "Today";
            case 2:
                return "Upcoming";

            default:
                return null;
        }
    }
}
