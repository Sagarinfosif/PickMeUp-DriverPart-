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


public class DrivingHoursFragment extends Fragment implements View.OnClickListener {

    private View view;
    private TextView heading, learn_more;
    private ImageView back_topbar;


    public DrivingHoursFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_driving_hours, container, false);
        ids();
        setup();
        return view;
    }

    private void setup() {
        heading.setText("Driving Hours");
        back_topbar.setOnClickListener(this);
        learn_more.setOnClickListener(this);
    }

    private void ids() {
        learn_more=view.findViewById(R.id.learn_more);
        heading=view.findViewById(R.id.heading);
        back_topbar=view.findViewById(R.id.back_topbar);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.back_topbar:
                getActivity().onBackPressed();
                break;
            case R.id.learn_more:
                Toast.makeText(getActivity(), "Under Development", Toast.LENGTH_SHORT).show();
                break;
        }
    }
}