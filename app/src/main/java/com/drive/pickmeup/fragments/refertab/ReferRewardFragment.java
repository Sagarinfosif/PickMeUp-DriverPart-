package com.drive.pickmeup.fragments.refertab;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.drive.pickmeup.R;
import com.drive.pickmeup.adapter.ReferRewardTabAdapter;
import com.google.android.material.tabs.TabLayout;

public class ReferRewardFragment extends Fragment implements View.OnClickListener {

    private View view;
    private TextView heading;
    private ImageView back_topbar;
    private TabLayout tabLayout;
    private ViewPager viewPager;
    private ReferRewardTabAdapter referRewardTabAdapter;

    public ReferRewardFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view= inflater.inflate(R.layout.fragment_refer_reward, container, false);
        findIds();
        setup();
        click();
        return view;
    }
    private void click() {
        back_topbar.setOnClickListener(this);
    }

    private void setup() {
        heading.setText("Refer Rewards");
        referRewardTabAdapter = new ReferRewardTabAdapter(getChildFragmentManager());
        viewPager.setAdapter(referRewardTabAdapter);
        tabLayout.setupWithViewPager(viewPager);
    }

    private void findIds() {
        viewPager = view.findViewById(R.id.viewPager);
        tabLayout = view.findViewById(R.id.tabLayout);
        heading = view.findViewById(R.id.heading);
        back_topbar = view.findViewById(R.id.back_topbar);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.back_topbar:
                getActivity().onBackPressed();
                break;
        }
    }
}