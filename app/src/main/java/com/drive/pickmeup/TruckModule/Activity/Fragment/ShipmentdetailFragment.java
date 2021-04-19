package com.drive.pickmeup.TruckModule.Activity.Fragment;

import android.os.Bundle;

import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.drive.pickmeup.R;


public class ShipmentdetailFragment extends Fragment {

    private View view;
   private AppCompatTextView txtTopBar;
    private AppCompatImageView imgBack;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_shipmentdetail, container, false);
        findIDs();
        txtTopBar.setText("Current Shipment");
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
    }
}