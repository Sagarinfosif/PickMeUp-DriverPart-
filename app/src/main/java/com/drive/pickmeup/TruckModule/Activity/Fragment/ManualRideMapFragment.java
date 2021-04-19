package com.drive.pickmeup.TruckModule.Activity.Fragment;

import android.os.Bundle;

import androidx.appcompat.widget.SwitchCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;

import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.Toast;

import com.drive.pickmeup.R;


public class ManualRideMapFragment extends Fragment {

    private View view;
    private ImageView imgNotification;
    private SwitchCompat aSwitch;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_manual_ride_map, container, false);
        findIDs();
        clicks();
        
        if (!aSwitch.isChecked()){
            aSwitch.setTrackTintList(ContextCompat.getColorStateList(getActivity(),R.color.black));
        }
        return view;
    }

    private void rToast() {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Toast.makeText(getActivity(), "qwerty", Toast.LENGTH_SHORT).show();
                rToast();
            }
        },5000);
    }

    private void clicks() {
        aSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (aSwitch.isChecked()){
                    aSwitch.setTrackTintList(ContextCompat.getColorStateList(getActivity(),R.color.white));
                }
                else {
                    aSwitch.setTrackTintList(ContextCompat.getColorStateList(getActivity(),R.color.black));
                }
            }
        });
    }

    private void findIDs() {
        imgNotification = view.findViewById(R.id.done);
        aSwitch = view.findViewById(R.id.trip_check_switch);
    }

    @Override
    public void onResume() {
        super.onResume();
        imgNotification.setImageResource(R.drawable.ic_baseline_notifications_24);
        imgNotification.setVisibility(View.VISIBLE);
        aSwitch.setVisibility(View.VISIBLE);
    }
}