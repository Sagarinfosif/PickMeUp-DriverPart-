package com.drive.pickmeup.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.drive.pickmeup.R;
import com.drive.pickmeup.fragments.help.VehicleDocumentAdapter;

public class VehicleDocumentFragment extends Fragment implements View.OnClickListener {

    private View view;
    private String[] documentsList = {"Vehicle Insurance Certificate", "Vehicle Registration Certificate", "Certificate of Inspection", "Booked Hire Service Licence"};
    private RecyclerView rv_vehicle_document;
    private TextView heading,tv_remove_vehicle;
    private ImageView back_topbar;
    private VehicleDocumentAdapter vehicleDocumentAdapter;

    public VehicleDocumentFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_vehicle_document, container, false);
        ids();
        setup();
        setAdapter();
        return view;
    }

    private void setAdapter() {
        vehicleDocumentAdapter = new VehicleDocumentAdapter(getActivity(), documentsList, new VehicleDocumentAdapter.Select() {
            @Override
            public void onclick(int position) {
                switch (position) {
                    case 0:
                        Navigation.findNavController(view).navigate(R.id.action_vehicleDocumentFragment_to_vehicleInsuranceFragment);
                        break;
                    case 1:
                        Navigation.findNavController(view).navigate(R.id.action_vehicleDocumentFragment_to_registrationCertificateFragment);
                        break;
                    case 2:
                        Navigation.findNavController(view).navigate(R.id.action_vehicleDocumentFragment_to_inspectionCertificateFragment);
                        break;
                    case 3:
                        Navigation.findNavController(view).navigate(R.id.action_vehicleDocumentFragment_to_bookedHireServiceFragment);
                        break;
                }
            }
        });
            rv_vehicle_document.setAdapter(vehicleDocumentAdapter);
    }

    private void setup() {
        heading.setText("Vehicle Documents");
        back_topbar.setOnClickListener(this);
        tv_remove_vehicle.setOnClickListener(this);
    }

    private void ids() {
        rv_vehicle_document = view.findViewById(R.id.rv_vehicle_document);
        heading = view.findViewById(R.id.heading);
        back_topbar = view.findViewById(R.id.back_topbar);
        tv_remove_vehicle = view.findViewById(R.id.tv_remove_vehicle);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.back_topbar:
                getActivity().onBackPressed();
                break;
            case R.id.tv_remove_vehicle:
                Navigation.findNavController(view).navigate(R.id.action_vehicleDocumentFragment_to_myVehicleFragment);
                Toast.makeText(getActivity(), "Remove Successfully", Toast.LENGTH_SHORT).show();
                break;
        }
    }
}