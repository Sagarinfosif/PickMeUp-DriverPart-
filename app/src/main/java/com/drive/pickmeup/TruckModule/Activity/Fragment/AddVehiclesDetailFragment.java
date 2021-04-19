package com.drive.pickmeup.TruckModule.Activity.Fragment;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatButton;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.drive.pickmeup.R;
import com.github.dhaval2404.imagepicker.ImagePicker;


public class AddVehiclesDetailFragment extends Fragment {

    private View view;
    private ImageView imgBack;
    private TextView txtTopBar,txtReg,txtInsurance,txtInspection;
    private ImageView imgAddRC, imgAddIc, imgAddCI;
    private int selectedImage;
    private AppCompatButton btnSubmit;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_add_vehicles_detail, container, false);
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

        imgAddRC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                selectedImage = 1;
                openGallery();
            }
        });

        imgAddCI.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                selectedImage = 2;
                openGallery();
            }
        });

        imgAddIc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                selectedImage = 3;
                openGallery();
            }
        });

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Navigation.findNavController(view).navigate(R.id.action_addVehiclesDetailFragment_to_vehiclesDetailFragment);
            }
        });
    }

    private void openGallery() {
        ImagePicker.Companion.with(this)
                .crop()                    //Crop image(Optional), Check Customization for more option
                .compress(1024)            //Final image size will be less than 1 MB(Optional)
                .maxResultSize(1080, 1080)    //Final image resolution will be less than 1080 x 1080(Optional)
                .start();

    }

    private void findIDs() {

        imgBack = view.findViewById(R.id.back_topbar);
        txtTopBar = view.findViewById(R.id.heading);
        txtTopBar.setText("Add Vehicle Detail");
        imgAddRC = view.findViewById(R.id.imgAddRC);
        imgAddIc = view.findViewById(R.id.imgAddIC);
        imgAddCI = view.findViewById(R.id.imgAddCI);

        txtInspection=view.findViewById(R.id.txt_inspection_certificate);
        txtInsurance=view.findViewById(R.id.txt_insurance);
        txtReg=view.findViewById(R.id.txt_reg);
        btnSubmit=view.findViewById(R.id.btn_submit);
    }


    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (selectedImage == 1) {
            if (resultCode == Activity.RESULT_OK && requestCode == ImagePicker.REQUEST_CODE) {
                Toast.makeText(getActivity(), "set RC Picture successfully", Toast.LENGTH_SHORT).show();
                txtReg.setText(" RC Picture add successfully");
            }
        } else if (selectedImage == 2) {

            if (resultCode == Activity.RESULT_OK && requestCode == ImagePicker.REQUEST_CODE) {
                Toast.makeText(getActivity(), "set CI Picture successfully", Toast.LENGTH_SHORT).show();
                txtInspection.setText(" CI Picture add successfully");
            }

        } else if (selectedImage == 3) {

            if (resultCode == Activity.RESULT_OK && requestCode == ImagePicker.REQUEST_CODE) {
                Toast.makeText(getActivity(), "set IC Picture successfully", Toast.LENGTH_SHORT).show();
                txtInsurance.setText(" IC Picture add successfully");
            }
        }

    }
}