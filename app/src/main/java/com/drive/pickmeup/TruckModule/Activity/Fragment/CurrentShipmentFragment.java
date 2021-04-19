package com.drive.pickmeup.TruckModule.Activity.Fragment;

import android.os.Bundle;

import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.drive.pickmeup.R;
import com.drive.pickmeup.TruckModule.Activity.Adapter.CurrentShipmentAdapter;


public class CurrentShipmentFragment extends Fragment {

    private View view;
    private CurrentShipmentAdapter currentShipmentAdapter;
    private RecyclerView recyclerView;
    AppCompatTextView txtTopbar;
    AppCompatImageView imgBack;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_current_shipment, container, false);
        FINDIDS();
        txtTopbar.setText("Current Shipment");
        CLICKS();
        SETADAPTER();
        return view;

    }

    private void CLICKS() {
        imgBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getActivity().onBackPressed();
            }
        });
    }

    private void SETADAPTER() {

        currentShipmentAdapter = new CurrentShipmentAdapter(getActivity(), new CurrentShipmentAdapter.Click() {
            @Override
            public void onClick(int position) {

            }
        });

        recyclerView.setAdapter(currentShipmentAdapter);

    }

    private void FINDIDS() {
        txtTopbar = view.findViewById(R.id.heading);
        imgBack=view.findViewById(R.id.back_topbar);
        recyclerView = view.findViewById(R.id.recyclerCurrentShipment);
    }
}