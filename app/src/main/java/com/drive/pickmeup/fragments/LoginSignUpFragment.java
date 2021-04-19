package com.drive.pickmeup.fragments;

import android.os.Bundle;

import androidx.appcompat.widget.AppCompatButton;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.drive.pickmeup.R;


public class LoginSignUpFragment extends Fragment {


    private View view;
    AppCompatButton btnLogin, btnSignup;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view= inflater.inflate(R.layout.fragment_login_sign_up, container, false);
    FINDDIS();
    CLICKS();
        return view;
    }

    private void CLICKS() {
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Navigation.findNavController(view).navigate(R.id.action_loginSignUpFragment_to_loginFragment);
            }
        });

        btnSignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Navigation.findNavController(view).navigate(R.id.action_loginSignUpFragment_to_registerPhoneFragment);
            }
        });
    }

    private void FINDDIS() {
        btnLogin=view.findViewById(R.id.btnLogin);
        btnSignup=view.findViewById(R.id.btnSignUp);
    }
}