package com.drive.pickmeup.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.drive.pickmeup.Pojo.RegisterPojo;
import com.drive.pickmeup.R;
import com.drive.pickmeup.utils.App;
import com.drive.pickmeup.utils.AppConstants;

import de.hdodenhof.circleimageview.CircleImageView;

public class ProfileMinorFragment extends Fragment implements View.OnClickListener {

    private View view;
    private TextView heading;
private  TextView username1,username2;
private CircleImageView image;
RegisterPojo userDetail;
    public ProfileMinorFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view= inflater.inflate(R.layout.fragment_profile_minor, container, false);
//        userDetail= App.getSharedpref().getModel(AppConstants.LOGIN_DETAIL,RegisterPojo.class);
        findIds();
//        username1.setText(userDetail.getDetails().getUsername());
//        username2.setText(userDetail.getDetails().getUsername());
//        if(!userDetail.getDetails().getImage().equals(""))
//        {
//            Glide.with(getContext()).load(userDetail.getDetails().getImage()).into(image);
//        }

        return view;
    }

    private void findIds() {
image=view.findViewById(R.id.img_userimage);
username1=view.findViewById(R.id.txt_username);
username2=view.findViewById(R.id.txt_userName);
        view.findViewById(R.id.back_topbar).setOnClickListener(this);
        view.findViewById(R.id.card_userInfo).setOnClickListener(this);

        heading=view.findViewById(R.id.heading);
        heading.setText(getString(R.string.myProfile13));

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.back_topbar:
                getActivity().onBackPressed();
                break;

            case R.id.card_userInfo:
                Navigation.findNavController(view).navigate(R.id.action_profileMinorFragment_to_profileFragment);
                break;
        }
    }
}