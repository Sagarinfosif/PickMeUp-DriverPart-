package com.drive.pickmeup.TruckModule.Activity.Fragment;

import android.os.Bundle;

import androidx.appcompat.widget.AppCompatButton;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.drive.pickmeup.R;


public class VehiclesDetailFragment extends Fragment {


    private View view;
    private ImageView imgBack;
    private TextView txtTopBar;
    private AppCompatButton btnDone;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view= inflater.inflate(R.layout.fragment_add_vehicles, container, false);
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

        btnDone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Navigation.findNavController(view).navigate(R.id.action_vehiclesDetailFragment_to_myVehiclesFragment);
            }
        });
    }

    private void findIDs() {

        imgBack = view.findViewById(R.id.back_topbar);
        txtTopBar = view.findViewById(R.id.heading);
        txtTopBar.setText("Vehicle Detail");

        btnDone=view.findViewById(R.id.btn_done);
    }
}