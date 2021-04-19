package com.drive.pickmeup.fragments;

import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;


import com.bumptech.glide.Glide;
import com.drive.pickmeup.Pojo.RegisterPojo;
import com.drive.pickmeup.R;
import com.drive.pickmeup.utils.App;
import com.drive.pickmeup.utils.AppConstants;
import com.drive.pickmeup.MyViewModel;
import com.github.dhaval2404.imagepicker.ImagePicker;


import java.io.File;

import de.hdodenhof.circleimageview.CircleImageView;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;

public class EditProfileFragment extends Fragment implements View.OnClickListener {

    private View view;
    private ImageView back_topbar;
    private TextView heading, text_Register_number, text_register_email, update_password;
    private EditText txtName, txtAddress;
    private MyViewModel viewModel;
    private RegisterPojo userDetail;
    private CircleImageView userImage;
    private int check = 0;
    private Uri imageUri;
    private String imgPath;
    private TextView done;
    private TextView phoneVerify, emailVerify;

    public EditProfileFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_edit_profile, container, false);
        viewModel = ViewModelProviders.of(EditProfileFragment.this).get(MyViewModel.class);
        userDetail = App.getSharedpref().getModel(AppConstants.LOGIN_DETAIL, RegisterPojo.class);

        ids();
        if (!userDetail.getDetails().getImage().equals("")) {
            Glide.with(getContext()).load(userDetail.getDetails().getImage()).into(userImage);
        }

        if (userDetail.getDetails().getPhoneVerifyStatus().equalsIgnoreCase("1")) {
            phoneVerify.setText("Verified");
            phoneVerify.setTextColor(Color.parseColor("#008000"));
        } else {
            phoneVerify.setText("Unverified");
            phoneVerify.setTextColor(Color.parseColor("#d32f2f"));
        }

        setup();
        setData();
        return view;
    }

    private void setData() {
        txtName.setText(userDetail.getDetails().getUsername());
        txtAddress.setText(userDetail.getDetails().getAddress());
        text_Register_number.setText(userDetail.getDetails().getPhone());
        text_register_email.setText(userDetail.getDetails().getEmail());
    }

    private void setup() {
        heading.setText("Edit Profile");
        text_Register_number.setOnClickListener(this);
        text_register_email.setOnClickListener(this);
        back_topbar.setOnClickListener(this);
        update_password.setOnClickListener(this);
        userImage.setOnClickListener(this);
        done.setOnClickListener(this);
    }


    private void ids() {
        heading = view.findViewById(R.id.heading);
        text_Register_number = view.findViewById(R.id.text_Register_number);
        text_register_email = view.findViewById(R.id.text_register_email);
        back_topbar = view.findViewById(R.id.back_topbar);
        update_password = view.findViewById(R.id.update_password);
        txtName = view.findViewById(R.id.txt_name);
        txtAddress = view.findViewById(R.id.txt_address);
        userImage = view.findViewById(R.id.user_pic);
        done = view.findViewById(R.id.txt_done);
        phoneVerify = view.findViewById(R.id.txt_phoneverify);
        emailVerify = view.findViewById(R.id.txt_emailverify);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.text_Register_number:
                Navigation.findNavController(view).navigate(R.id.action_editProfileFragment_to_updateNumberFragment);
                break;
            case R.id.text_register_email:
                Navigation.findNavController(view).navigate(R.id.action_editProfileFragment_to_updateEmailFragment);
                break;
            case R.id.update_password:
                Navigation.findNavController(view).navigate(R.id.action_editProfileFragment_to_updatePasswordFragment);
                break;
            case R.id.back_topbar:
                getActivity().onBackPressed();
                break;
            case R.id.user_pic:
                ImagePicker.Companion.with(EditProfileFragment.this).crop().compress(512).maxResultSize(1080, 1080).start();
                break;
            case R.id.txt_done:
                updateProfileData();
                break;

        }
    }



    private void updateProfileData() {
        String userId = App.getSharedpref().getString(AppConstants.USER_ID);
        MultipartBody.Part image;
        if (imgPath != null) {
            File file = new File(imgPath);
            RequestBody requestBody = RequestBody.create(MediaType.parse("multipart/form-data"), file);
            image = MultipartBody.Part.createFormData("image", file.getName(), requestBody);
        } else {
            RequestBody requestBody = RequestBody.create(MediaType.parse("multipart/form-data"), "");
            image = MultipartBody.Part.createFormData("image", "", requestBody);
        }

        RequestBody id = RequestBody.create(MultipartBody.FORM, userId);
        RequestBody userName = RequestBody.create(MultipartBody.FORM, txtName.getText().toString());
        RequestBody address = RequestBody.create(MultipartBody.FORM, txtAddress.getText().toString());


        viewModel.profileUpdate(getActivity(), id, userName, address, image).observe(getViewLifecycleOwner(), new Observer<RegisterPojo>() {
            @Override
            public void onChanged(RegisterPojo registerPojo) {
                if (registerPojo.getSuccess().equalsIgnoreCase("1")) {
                    Toast.makeText(getActivity(), registerPojo.getDetails().getImage(), Toast.LENGTH_SHORT).show();
                    App.getSharedpref().saveModel(AppConstants.LOGIN_DETAIL, registerPojo);
                    Toast.makeText(getActivity(), registerPojo.getMessage(), Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(getActivity(), registerPojo.getMessage(), Toast.LENGTH_SHORT).show();
                }
            }
        });

    }


    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        imageUri = data.getData();
        imgPath = imageUri.getPath();
        userImage.setImageURI(imageUri);


    }
}