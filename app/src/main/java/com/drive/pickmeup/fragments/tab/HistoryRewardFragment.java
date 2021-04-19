package com.drive.pickmeup.fragments.tab;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.drive.pickmeup.R;


public class HistoryRewardFragment extends Fragment {

    private View view;

    public HistoryRewardFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view= inflater.inflate(R.layout.fragment_history_reward, container, false);

        return view;
    }
}