package com.drive.pickmeup.TruckModule.Activity.Fragment;

import android.app.AlertDialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
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


public class ManualRideFragment extends Fragment {

    private View view;
    private TextView txtTopBar;
    private ImageView imgBack;
    private AppCompatButton btnCreateRider;
    private View mView;
    private AlertDialog alertDialog;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_manual_ride, container, false);
        findIDs();
        txtTopBar.setText("Manual Ride");
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

        btnCreateRider.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showDialog();
            }
        });
    }

    private void showDialog() {
        final AlertDialog.Builder alert = new AlertDialog.Builder(getActivity());
        mView = getLayoutInflater().inflate(R.layout.dialog_success, null);

        AppCompatButton btnOk;

        btnOk = mView.findViewById(R.id.btnOk);
        alert.setView(mView);
        alertDialog = alert.create();
        alertDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        alertDialog.show();

        btnOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                alertDialog.dismiss();
                Navigation.findNavController(getView()).navigate(R.id.action_manualRideFragment_to_manualRideMapFragment);
            }
        });

    }

    private void findIDs() {
        txtTopBar = view.findViewById(R.id.heading);
        imgBack = view.findViewById(R.id.back_topbar);
        btnCreateRider = view.findViewById(R.id.btnCreateRider);
    }
}