package com.drive.pickmeup.TruckModule.Activity.Fragment;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatButton;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.drive.pickmeup.R;
import com.drive.pickmeup.TruckModule.Activity.TruckActivity;
import com.github.dhaval2404.imagepicker.ImagePicker;
import com.google.android.material.bottomsheet.BottomSheetBehavior;

import javax.xml.transform.Result;


public class MyDocumentFragment extends Fragment {

    private AppCompatButton btnSubmit;
    private View view;
    private ImageView imgBack;
    private TextView txtTopBar;
    private LinearLayout layout;
    private AppCompatButton btnDone;
    private BottomSheetBehavior bottomSheetBehavior;
    private TextView txtLicence, txtPassport, txtCertificate, txtVisa, txtResidence, txtMedicare, txtBankCard, txtFedral, txtDriving;
    private String selectedImage = "";

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_my_document, container, false);
        findIDs();
        clicks();
        return view;
    }

    private void clicks() {
        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                bottomSheetBehavior.setState(BottomSheetBehavior.STATE_EXPANDED);
//                view.isClickable();
                view.setClickable(false);
                view.setBackgroundColor(ContextCompat.getColor(getActivity(), R.color.darkGray));
            }
        });

        imgBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getActivity().onBackPressed();
            }
        });

        btnDone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), TruckActivity.class);
                getActivity().finish();
                startActivity(intent);
            }
        });

        txtDriving.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                selectedImage = "driving";
                openGallery();
            }
        });

        txtFedral.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                selectedImage = "fedral";
                openGallery();
            }
        });

        txtMedicare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                selectedImage = "medicare";
                openGallery();
            }
        });

        txtResidence.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                selectedImage = "residence";
                openGallery();
            }
        });

        txtVisa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                selectedImage = "visa";
                openGallery();
            }
        });

        txtPassport.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                selectedImage = "passport";
                openGallery();
            }
        });

        txtLicence.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                selectedImage = "licence";
                openGallery();
            }
        });

        txtCertificate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                selectedImage = "certificate";
                openGallery();
            }
        });

        txtBankCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                selectedImage = "bankCard";
                openGallery();
            }
        });


        txtTopBar.setText("My Document");
    }

    private void findIDs() {
        imgBack = view.findViewById(R.id.back_topbar);
        txtTopBar = view.findViewById(R.id.heading);
        btnSubmit = view.findViewById(R.id.btn_submit);
        layout = view.findViewById(R.id.bottomsheet);
        bottomSheetBehavior = bottomSheetBehavior.from(layout);
        btnDone = view.findViewById(R.id.btn_done);

        txtBankCard = view.findViewById(R.id.txt_bank_card);
        txtCertificate = view.findViewById(R.id.txt_certificate);
        txtLicence = view.findViewById(R.id.txt_licence);
        txtPassport = view.findViewById(R.id.txt_passport);
        txtVisa = view.findViewById(R.id.txt_visa);
        txtResidence = view.findViewById(R.id.txt_residence);
        txtMedicare = view.findViewById(R.id.txt_medicare);
        txtFedral = view.findViewById(R.id.txt_fedral);
        txtDriving = view.findViewById(R.id.txt_driving_history);
    }


    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (selectedImage.equals("driving")) {
            if (resultCode == Activity.RESULT_OK && requestCode == ImagePicker.REQUEST_CODE) {
                Toast.makeText(getActivity(), "driving", Toast.LENGTH_SHORT).show();
            }
        } else if (selectedImage.equals("fedral")) {
            if (resultCode == Activity.RESULT_OK && requestCode == ImagePicker.REQUEST_CODE) {
                Toast.makeText(getActivity(), "fedral", Toast.LENGTH_SHORT).show();
            }
        }
    }


    private void openGallery() {
        ImagePicker.Companion.with(this)
                .crop()                    //Crop image(Optional), Check Customization for more option
                .compress(1024)            //Final image size will be less than 1 MB(Optional)
                .maxResultSize(1080, 1080)    //Final image resolution will be less than 1080 x 1080(Optional)
                .start();

    }


}

