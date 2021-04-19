package com.drive.pickmeup.fragments;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.drive.pickmeup.HomeActivity;
import com.drive.pickmeup.utils.App;
import com.drive.pickmeup.utils.AppConstants;
import com.drive.pickmeup.MyViewModel;
import com.drive.pickmeup.Pojo.RegisterPojo;
import com.drive.pickmeup.R;

import java.util.Map;

public class LoginFragment extends Fragment implements View.OnClickListener {

    private View view;
    private Button btn_login;
    private TextView signup;
    private EditText email, password;
    private MyViewModel viewModel;
    private TextView forgot;
    private EditText otp;
    private EditText phone;
    Dialog dialog;
    View view1, view2;
    EditText newpassword;

    private int i = 0;

    public LoginFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_login, container, false);
        viewModel = ViewModelProviders.of(LoginFragment.this).get(MyViewModel.class);
        ids();
        setup();

        return view;
    }

    private void setup() {
        signup.setOnClickListener(this);
        btn_login.setOnClickListener(this);
        forgot.setOnClickListener(this);
    }

    private void ids() {
        signup = view.findViewById(R.id.signup);
        btn_login = view.findViewById(R.id.btn_login);
        email = view.findViewById(R.id.edt_email);
        password = view.findViewById(R.id.edt_password);
        forgot = view.findViewById(R.id.txt_forgot);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.signup:
                Navigation.findNavController(view).navigate(R.id.action_loginFragment_to_registerPhoneFragment);
                break;
            case R.id.btn_login:
                if(email.getText().toString().equals("rohit@gmail.com") && password.getText().toString().equals("123")){
                App.getSharedpref().saveString(AppConstants.USER_ID, "1");
                Intent intent = new Intent(getActivity(), HomeActivity.class);
                getActivity().finish();
                startActivity(intent);
            }else if (!email.getText().toString().equals("") && !password.getText().toString().equals("")) {
                    login(email.getText().toString(), password.getText().toString());
                }else {
                    Toast.makeText(getActivity(), "Please fill both fields.", Toast.LENGTH_SHORT).show();
                }
                break;

            case R.id.txt_forgot:
                forgotPassword();
                break;
        }
    }

    private void forgotPassword() {
        i = 0;

        dialog = new Dialog(getActivity());
        dialog.setContentView(R.layout.dialog_forgot_password);

        phone = dialog.findViewById(R.id.edt_phone);
        Button next = dialog.findViewById(R.id.btn_next);
        view1 = dialog.findViewById(R.id.myview);
        otp = dialog.findViewById(R.id.edt_otp);
        view1.setVisibility(View.GONE);
        otp.setVisibility(View.GONE);
        newpassword = dialog.findViewById(R.id.edt_new_password);
        view2 = dialog.findViewById(R.id.myview2);
        view2.setVisibility(View.GONE);
        newpassword.setVisibility(View.GONE);
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (i == 0) {
                    hitForgotPassword(phone.getText().toString());
                } else if (i == 1) {
                    if(!phone.getText().toString().equals("") && !otp.getText().toString().equals("") && !newpassword.getText().toString().equals("")){
                        hitUpdatePassword();
                    }else{
                        Toast.makeText(getActivity(), "Please enter all fields.", Toast.LENGTH_SHORT).show();
                    }

                }
            }
        });
        dialog.show();
    }

    private void hitUpdatePassword() {
        String id = App.getSharedpref().getString(AppConstants.USER_ID);
        viewModel.changePassword(getActivity(), id, otp.getText().toString(),newpassword.getText().toString()).observe(getViewLifecycleOwner(), new Observer<Map>() {
            @Override
            public void onChanged(Map map) {
                if (map.get("success").toString().equalsIgnoreCase("1")) {
                  dialog.dismiss();
                    Toast.makeText(getActivity(), map.get("message").toString(), Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(getActivity(), map.get("otp not matched").toString(), Toast.LENGTH_SHORT).show();
                }
            }
        });
    }


    private void hitForgotPassword(String phone) {
//        String userId = App.getSharedpref().getString(AppConstants.USER_ID);
        viewModel.forgotPassword(getActivity(), "+91", phone).observe(getViewLifecycleOwner(), new Observer<RegisterPojo>() {
            @Override
            public void onChanged(RegisterPojo registerPojo) {
                if (registerPojo.getSuccess().equalsIgnoreCase("1")) {
                    i = 1;
                    otp.setVisibility(View.VISIBLE);
                    view1.setVisibility(View.VISIBLE);
                    view2.setVisibility(View.VISIBLE);
                    newpassword.setVisibility(View.VISIBLE);
                    App.getSharedpref().saveString(AppConstants.USER_ID, registerPojo.getDetails().getId());
                    Toast.makeText(getActivity(), registerPojo.getDetails().getOtp(), Toast.LENGTH_SHORT).show();


                } else {
                    Toast.makeText(getActivity(), registerPojo.getMessage(), Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void login(String email, String password) {
        viewModel.login(getActivity(), email, password, "fwfw", "Mobile", "vjsv", "fwhf").observe(getViewLifecycleOwner(), new Observer<RegisterPojo>() {
            @Override
            public void onChanged(RegisterPojo registerPojo) {
                if (registerPojo.getSuccess().equals("1")) {
                    App.getSharedpref().saveString(AppConstants.USER_ID, registerPojo.getDetails().getId());
                    App.getSharedpref().saveModel(AppConstants.LOGIN_DETAIL, registerPojo);
                    Intent intent = new Intent(getActivity(), HomeActivity.class);
                    startActivity(intent);
                } else {
                    Toast.makeText(getActivity(), registerPojo.getMessage(), Toast.LENGTH_SHORT).show();
                }
            }
        });


    }
}