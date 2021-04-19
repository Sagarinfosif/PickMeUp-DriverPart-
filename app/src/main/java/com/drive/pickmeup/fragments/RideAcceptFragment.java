package com.drive.pickmeup.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.drive.pickmeup.R;
import com.google.android.material.bottomsheet.BottomSheetBehavior;

public class RideAcceptFragment extends Fragment implements View.OnClickListener {

    private View view;
    private BottomSheetBehavior<LinearLayout> behavior;
    private LinearLayout bottomsheeet;
    private ImageView img_side_menu;

    public RideAcceptFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_ride_accept, container, false);
        ids();
        setup();
        return view;
    }

    private void setup() {
        img_side_menu.setOnClickListener(this);
        behavior.setState(BottomSheetBehavior.STATE_EXPANDED);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                Navigation.findNavController(view).navigate(R.id.action_rideAcceptFragment_to_destinationFragment);
            }
        }, 4000);
    }

    private void ids() {
        img_side_menu = view.findViewById(R.id.img_side_menu);
        bottomsheeet = view.findViewById(R.id.bottomsheet);
        behavior = BottomSheetBehavior.from(bottomsheeet);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.img_side_menu:
                getActivity().onBackPressed();
                break;
        }
    }
}