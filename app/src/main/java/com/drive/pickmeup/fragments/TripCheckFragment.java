package com.drive.pickmeup.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.drive.pickmeup.R;
import com.suke.widget.SwitchButton;


public class TripCheckFragment extends Fragment implements View.OnClickListener {

    private View view;
    private TextView heading;
    private ImageView back_topbar;
    private SwitchButton switch_trip_check;


    public TripCheckFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_trip_check, container, false);
        ids();
        setup();
        setswitch();
        return view;
    }

    private void setswitch() {
        switch_trip_check.setOnCheckedChangeListener(new SwitchButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(SwitchButton view, boolean isChecked) {
                if (switch_trip_check.isChecked()) {
                    Toast.makeText(getActivity(), "Set Successfully", Toast.LENGTH_SHORT).show();
                }
                else
                    Toast.makeText(getActivity(), "off", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void setup() {
        heading.setText("Trip Check");
        back_topbar.setOnClickListener(this);


    }

        private void ids () {
            heading = view.findViewById(R.id.heading);
            back_topbar = view.findViewById(R.id.back_topbar);
            switch_trip_check=view.findViewById(R.id.switch_trip_check);

        }

        @Override
        public void onClick (View view){
            switch (view.getId()) {
                case R.id.back_topbar:
                    getActivity().onBackPressed();
                    break;
            }
        }
    }