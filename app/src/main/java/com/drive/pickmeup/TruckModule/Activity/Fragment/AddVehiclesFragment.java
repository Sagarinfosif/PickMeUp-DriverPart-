package com.drive.pickmeup.TruckModule.Activity.Fragment;

import android.os.Bundle;

import androidx.appcompat.widget.AppCompatButton;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.drive.pickmeup.R;
import com.drive.pickmeup.TruckModule.Activity.AdapterNew.VehiclesListAdapter;


public class AddVehiclesFragment extends Fragment {


    private View view;
    private ImageView imgBack;
    private TextView txtTopBar;
    private RecyclerView recyclerView;
    private VehiclesListAdapter vehiclesListAdapter;
    private AppCompatButton btnContinue;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_add_vehicles2, container, false);
        findIDs();
        clicks();
        setAdapter();
        return view;
    }

    private void setAdapter() {
        vehiclesListAdapter=new VehiclesListAdapter(getActivity());
        recyclerView.setAdapter(vehiclesListAdapter);
    }


    private void clicks() {
        imgBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getActivity().onBackPressed();
            }
        });

        btnContinue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Navigation.findNavController(view).navigate(R.id.action_addVehiclesFragment_to_addVehiclesDetailFragment);
            }
        });
    }

    private void findIDs() {

        imgBack = view.findViewById(R.id.back_topbar);
        txtTopBar = view.findViewById(R.id.heading);
        txtTopBar.setText("Add Vehicle");
        recyclerView=view.findViewById(R.id.vehicles_recycler);
        btnContinue=view.findViewById(R.id.btn_conti);
    }
}