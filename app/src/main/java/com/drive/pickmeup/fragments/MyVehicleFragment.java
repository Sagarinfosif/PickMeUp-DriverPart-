package com.drive.pickmeup.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.drive.pickmeup.R;
import com.drive.pickmeup.adapter.VehicleAdapter;

public class MyVehicleFragment extends Fragment implements View.OnClickListener {

    private View view;
    private TextView heading;
    private RecyclerView recycle_vehicle;
    private VehicleAdapter vehicleAdapter;
    private ImageView back_topbar;
    private Button add_vehicle;

    public MyVehicleFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view= inflater.inflate(R.layout.fragment_my_vehicle, container, false);
        ids();
        setup();
        return view;
    }

    private void ids() {
        heading = view.findViewById(R.id.heading);
        back_topbar = view.findViewById(R.id.back_topbar);
        recycle_vehicle = view.findViewById(R.id.recycle_vehicle);
        add_vehicle = view.findViewById(R.id.add_vehicle);
    }

    private void setup() {
        heading.setText("My Vehicle");
        add_vehicle.setOnClickListener(this);
        back_topbar.setOnClickListener(this);
        vehicleAdapter=new VehicleAdapter(getActivity());
        recycle_vehicle.setAdapter(vehicleAdapter);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.add_vehicle:
                Navigation.findNavController(view).navigate(R.id.action_myVehicleFragment_to_addVehicleFragment);
                break;
                case R.id.back_topbar:
                    getActivity().onBackPressed();
//                Navigation.findNavController(view).navigate(R.id.action_myVehicleFragment_to_addVehicleFragment);
                break;
        }
    }
}