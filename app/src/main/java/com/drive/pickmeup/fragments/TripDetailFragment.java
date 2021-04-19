package com.drive.pickmeup.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.drive.pickmeup.R;

public class TripDetailFragment extends Fragment implements View.OnClickListener {

    private View view;
    private TextView heading;
    private ImageView back_topbar,helpBtn;

    public TripDetailFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_trip_detail, container, false);
        ids();
        setup();
        return view;
    }

    private void setup() {
        heading.setText("Trip Detail");
        back_topbar.setOnClickListener(this);
        helpBtn.setOnClickListener(this);
    }

    private void ids() {
        heading = view.findViewById(R.id.heading);
        back_topbar = view.findViewById(R.id.back_topbar);
        helpBtn = view.findViewById(R.id.helpBtn);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.back_topbar:
                getActivity().onBackPressed();
                break;
            case R.id.helpBtn:
                Navigation.findNavController(view).navigate(R.id.action_tripDetailFragment_to_helpFragment);
                break;
        }
    }
}