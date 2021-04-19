package com.drive.pickmeup.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.drive.pickmeup.R;
import com.theartofdev.edmodo.cropper.CropImage;
import com.theartofdev.edmodo.cropper.CropImageView;

public class VehicleInsuranceFragment extends Fragment implements View.OnClickListener {

    private View view;
    private TextView heading;
    private ImageView back_topbar,done;
    private Button take_photo;


    public VehicleInsuranceFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view= inflater.inflate(R.layout.fragment_vehicle_insurance, container, false);
        ids();
        setup();
        return view;
    }

    private void setup() {
        heading.setText("Insurance Certificate");
        back_topbar.setOnClickListener(this);
        done.setOnClickListener(this);
        take_photo.setOnClickListener(this);
    }

    private void ids() {
    heading=view.findViewById(R.id.heading);
    back_topbar=view.findViewById(R.id.back_topbar);
        done=view.findViewById(R.id.done);
    take_photo=view.findViewById(R.id.take_photo);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.back_topbar:
                getActivity().onBackPressed();
                break;
            case R.id.take_photo:
                done.setVisibility(View.VISIBLE);
                CropImage.activity().setGuidelines(CropImageView.Guidelines.ON);
                CropImage.activity().start(getActivity());
                break;
            case R.id.done:
                getActivity().onBackPressed();
                break;
        }
    }
}