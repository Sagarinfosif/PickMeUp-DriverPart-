package com.drive.pickmeup.fragments;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.widget.AppCompatButton;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.drive.pickmeup.R;
import com.drive.pickmeup.TruckModule.Activity.TruckActivity;


public class TruckRegistrationFragment extends Fragment {

    private View view;
private AppCompatButton btnSign;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view= inflater.inflate(R.layout.fragment_truck_registration, container, false);
    findIDs();
    clicks();
        return view;
    }

    private void clicks() {
        btnSign.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), TruckActivity.class);
                getActivity().finish();
                startActivity(intent);
            }
        });
    }

    private void findIDs() {
btnSign=view.findViewById(R.id.btnSave);
    }
}