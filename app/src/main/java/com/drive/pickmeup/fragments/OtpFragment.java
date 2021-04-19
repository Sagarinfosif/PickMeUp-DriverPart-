package com.drive.pickmeup.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.drive.pickmeup.MyViewModel;
import com.drive.pickmeup.R;
import com.drive.pickmeup.utils.App;

import in.aabhasjindal.otptextview.OtpTextView;

public class OtpFragment extends Fragment implements View.OnClickListener {

    private View view;
    private Button btn_submit;
    private OtpTextView otpView;
    private MyViewModel viewModel;
    private TextView resendOtp;
    private String phone = "";
    private TextView heading;
    private ImageView back_topbar;
    private String otp;
    private String number;

    public OtpFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_otp, container, false);
        viewModel = ViewModelProviders.of(OtpFragment.this).get(MyViewModel.class);
        getData();
        ids();
        setup();
        return view;
    }

    private void getData() {
        otp = getArguments().getString("otp");
        number = getArguments().getString("phone");

    }


    private void setup() {
        btn_submit.setOnClickListener(this);
        resendOtp.setOnClickListener(this);
        back_topbar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().onBackPressed();
            }
        });
    }

    private void ids() {
        btn_submit = view.findViewById(R.id.btn_submit);
        otpView = view.findViewById(R.id.otp_view);
        resendOtp = view.findViewById(R.id.txt_resendOtp);
        heading = view.findViewById(R.id.heading);
        heading.setText("Otp Verification");
        back_topbar = view.findViewById(R.id.back_topbar);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_submit:
                checkOtp();
//                    Bundle bundle=new Bundle();
//                    bundle.putString("phone",mobile);
//
//                    Toast.makeText(getActivity(), "Incorrect OTP", Toast.LENGTH_SHORT).show();
                break;

            case R.id.txt_resendOtp:
//                resend_otp();
                break;
        }
    }

    private void checkOtp() {
        if (otpView.getOTP().matches(otp)){
            App.getSingleton().setMobileNumber(number);
            Navigation.findNavController(view).navigate(R.id.action_otpFragment_to_registerFragment);
            Toast.makeText(getContext(), "Success", Toast.LENGTH_SHORT).show();
        }
        else {
            Toast.makeText(getActivity(), "otp not match", Toast.LENGTH_SHORT).show();
        }
    }

//    private void resend_otp() {
//        viewModel.otpResend(getActivity(),getArguments().getString("phone"),"+91").observe(getViewLifecycleOwner(), new Observer<RegisterPojo>() {
//            @Override
//            public void onChanged(RegisterPojo registerPojo) {
//                if(registerPojo.getSuccess().equalsIgnoreCase("1")){
//                    Toast.makeText(getActivity(), registerPojo.getDetails().getOtp(), Toast.LENGTH_SHORT).show();
//                }else{
//                    Toast.makeText(getActivity(), registerPojo.getMessage(), Toast.LENGTH_SHORT).show();
//                }
//            }
//        });
//    }
//
//    private void matchOtp() {
//        String otp=otpView.getOTP();
//        Toast.makeText(getActivity(), phone+" "+otp, Toast.LENGTH_SHORT).show();
//        viewModel.otpMatch(getActivity(),phone,otp,"+91").observe(getViewLifecycleOwner(), new Observer<RegisterPojo>() {
//            @Override
//            public void onChanged(RegisterPojo registerPojo) {
//
//                    if (registerPojo.getSuccess().equalsIgnoreCase("1")) {
//                        Toast.makeText(getActivity(), "OTP Match Successfully.", Toast.LENGTH_SHORT).show();
//                        Navigation.findNavController(view).navigate(R.id.action_otpFragment_to_registerFragment);
//                    } else {
//                        Toast.makeText(getActivity(), registerPojo.getMessage(), Toast.LENGTH_SHORT).show();
//                    }
//            }
//        });
//
//    }
}