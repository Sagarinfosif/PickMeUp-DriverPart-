package com.drive.pickmeup.TruckModule.Activity.Fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.drive.pickmeup.R;

public class InProgressBidFragment extends Fragment {

    private View view;
    private TextView txtTopBar;
    private ImageView imgBack;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_in_progress_bid, container, false);
        findIDs();
        clicks();
        return view;
    }

    private void clicks() {
        imgBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getActivity().onBackPressed();
            }
        });


    }

    private void findIDs() {
        txtTopBar = view.findViewById(R.id.heading);
        imgBack = view.findViewById(R.id.back_topbar);
        txtTopBar.setText("In Progress bids");
    }
}