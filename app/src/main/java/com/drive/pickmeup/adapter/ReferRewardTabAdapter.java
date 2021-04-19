package com.drive.pickmeup.adapter;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.drive.pickmeup.fragments.refertab.ReferToDriveFragment;
import com.drive.pickmeup.fragments.refertab.ReferToRideFragment;

public class ReferRewardTabAdapter extends FragmentPagerAdapter {

    public ReferRewardTabAdapter(@NonNull FragmentManager fm) {
        super(fm);
    }

    public ReferRewardTabAdapter(@NonNull FragmentManager fm, int behavior) {
        super(fm, behavior);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position) {

            case 0:
                ReferToDriveFragment referToDriveFragment = new ReferToDriveFragment();
                return referToDriveFragment;
            case 1:
                ReferToRideFragment referToRideFragment = new ReferToRideFragment();
                return referToRideFragment;

            default:
                return null;
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
               return "Refer to Drive";
           case 1:
               return "Refer to Ride";
           default:
               return null;
       }
    }
}
