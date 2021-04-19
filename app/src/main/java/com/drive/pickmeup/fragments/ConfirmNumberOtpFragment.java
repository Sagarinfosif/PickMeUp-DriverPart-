package com.drive.pickmeup.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.drive.pickmeup.MyViewModel;
import com.drive.pickmeup.Pojo.RegisterPojo;
import com.drive.pickmeup.R;
import com.drive.pickmeup.utils.App;
import com.drive.pickmeup.utils.AppConstants;

import in.aabhasjindal.otptextview.OtpTextView;

public class ConfirmNumberOtpFragment extends Fragment implements View.OnClickListener {

    private View view;
    private Button otp_button_confirm;
private MyViewModel viewModel;
private RegisterPojo userDetails;
private OtpTextView otp;
    public ConfirmNumberOtpFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_confirm_number_otp, container, false);
        viewModel= ViewModelProviders.of(ConfirmNumberOtpFragment.this).get(MyViewModel.class);
        userDetails= App.getSharedpref().getModel(AppConstants.LOGIN_DETAIL,RegisterPojo.class);
        Toast.makeText(getActivity(), userDetails.getDetails().getOtp(), Toast.LENGTH_SHORT).show();
        ids();
        setup();
        return view;
    }

    private void setup() {
        otp_button_confirm.setOnClickListener(this);
    }

    private void ids() {
        otp_button_confirm = view.findViewById(R.id.otp_button_confirm);
        otp=view.findViewById(R.id.otp_view);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.otp_button_confirm:
                matchOtp();
                break;
        }
    }

    private void matchOtp() {
        String phone=userDetails.getDetails().getPhone();
        String countryCode=userDetails.getDetails().getCountryCode();
       String myotp=otp.getOTP();
        viewModel.otpMatch(getActivity(),phone,myotp,countryCode).observe(getViewLifecycleOwner(), new Observer<RegisterPojo>() {
            @Override
            public void onChanged(RegisterPojo registerPojo) {
                if(registerPojo.getSuccess().equalsIgnoreCase("1")){
                    Toast.makeText(getActivity(), registerPojo.getMessage(), Toast.LENGTH_SHORT).show();
                    App.getSharedpref().saveModel(AppConstants.LOGIN_DETAIL, registerPojo);
                    Navigation.findNavController(view).navigate(R.id.action_confirmNumberOtpFragment_to_editProfileFragment);
                }else{
                    Toast.makeText(getActivity(), registerPojo.getMessage(), Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}