package com.drive.pickmeup.fragments;

import android.os.Bundle;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.drive.pickmeup.R;
import com.theartofdev.edmodo.cropper.CropImage;
import com.theartofdev.edmodo.cropper.CropImageView;

public class AddVehicleFragment extends Fragment implements View.OnClickListener {

    private View view;
    private TextView heading;
    private CardView upload_car_img;
    private Button continue_btn;
    private ImageView back_topbar;

    public AddVehicleFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_add_vehicle, container, false);
        ids();
        setup();
        return view;
    }

    private void setup() {
        continue_btn.setOnClickListener(this);
        back_topbar.setOnClickListener(this);
        upload_car_img.setOnClickListener(this);
        heading.setText("Add Vehicle");
    }

    private void ids() {
        continue_btn = view.findViewById(R.id.continue_btn);
        heading = view.findViewById(R.id.heading);
        upload_car_img = view.findViewById(R.id.upload_car_img);
        back_topbar = view.findViewById(R.id.back_topbar);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.continue_btn:
                Navigation.findNavController(view).navigate(R.id.action_addVehicleFragment_to_vehicleDocumentFragment);
                break;
            case R.id.upload_car_img:
                CropImage.activity().setGuidelines(CropImageView.Guidelines.ON);
                CropImage.activity().start(getActivity());
                break;
            case R.id.back_topbar:
                getActivity().onBackPressed();
                break;
        }
    }
}