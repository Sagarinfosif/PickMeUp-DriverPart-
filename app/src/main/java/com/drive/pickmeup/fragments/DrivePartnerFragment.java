package com.drive.pickmeup.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.drive.pickmeup.R;
import com.google.android.material.card.MaterialCardView;

public class DrivePartnerFragment extends Fragment implements View.OnClickListener {

    private View view;
    private ImageView back_topbar;
    private TextView heading;
    private MaterialCardView card_userInfo_verified;

    public DrivePartnerFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view= inflater.inflate(R.layout.fragment_drive_partner, container, false);
        ids();
        setup();
        return view;
    }

    private void setup() {
        heading.setText("Drive Partner Club");
        back_topbar.setOnClickListener(this);
        card_userInfo_verified.setOnClickListener(this);
    }

    private void ids() {
        heading=view.findViewById(R.id.heading);
        back_topbar=view.findViewById(R.id.back_topbar);
        card_userInfo_verified=view.findViewById(R.id.card_userInfo_verified);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.back_topbar:
                getActivity().onBackPressed();
                break;
                case R.id.card_userInfo_verified:
                    Navigation.findNavController(view).navigate(R.id.action_drivePartnerFragment_to_profileFragment);
                break;
        }
    }
}