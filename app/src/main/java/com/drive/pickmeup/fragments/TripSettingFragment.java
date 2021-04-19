package com.drive.pickmeup.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.drive.pickmeup.R;
import com.drive.pickmeup.adapter.TripSettingDestinationAdapter;

public class TripSettingFragment extends Fragment implements View.OnClickListener {

    private View view;
    private TripSettingDestinationAdapter settingDestinationAdapter;
    private RecyclerView rv_setting_trip;
    private ImageView back_topbar;
    private TextView heading;

    public TripSettingFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_trip_setting, container, false);
        ids();
        setup();
        setAdapter();
        return view;
    }

    private void setAdapter() {
        settingDestinationAdapter=new TripSettingDestinationAdapter(getActivity(), new TripSettingDestinationAdapter.Select() {
            @Override
            public void onclick(int position) {
                Toast.makeText(getActivity(), "Under Development", Toast.LENGTH_SHORT).show();
            }
        });
        rv_setting_trip.setAdapter(settingDestinationAdapter);
    }

    private void setup() {
    heading.setText("Trip Setting");
    back_topbar.setOnClickListener(this);
    }

    private void ids() {
        heading = view.findViewById(R.id.heading);
        back_topbar = view.findViewById(R.id.back_topbar);
        rv_setting_trip = view.findViewById(R.id.rv_setting_trip);
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