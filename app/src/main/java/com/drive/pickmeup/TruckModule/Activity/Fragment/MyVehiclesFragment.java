package com.drive.pickmeup.TruckModule.Activity.Fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.drive.pickmeup.R;
import com.drive.pickmeup.TruckModule.Activity.AdapterNew.MyVehiclesAdapter;


public class MyVehiclesFragment extends Fragment {

    private View view;
    private ImageView imgBack;
    private TextView txtTopBar;
    private RecyclerView recyclerView;
    private MyVehiclesAdapter myVehiclesAdapter;
    private TextView txtAddVehicles;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_my_vehicles, container, false);
        findIDs();
        clicks();
        setAdapter();
        return view;
    }

    private void setAdapter() {
        myVehiclesAdapter = new MyVehiclesAdapter(getActivity());
        recyclerView.setAdapter(myVehiclesAdapter);
    }

    private void clicks() {
        imgBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getActivity().onBackPressed();
            }
        });

        txtAddVehicles.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
Navigation.findNavController(view).navigate(R.id.action_myVehiclesFragment_to_addVehiclesFragment);
            }
        });
    }

    private void findIDs() {
        imgBack = view.findViewById(R.id.back_topbar);
        txtTopBar = view.findViewById(R.id.heading);
        txtTopBar.setText("My Vehicles");
        recyclerView = view.findViewById(R.id.vehicles_recycler);
        txtAddVehicles = view.findViewById(R.id.tst_addmore_veh);
    }
}