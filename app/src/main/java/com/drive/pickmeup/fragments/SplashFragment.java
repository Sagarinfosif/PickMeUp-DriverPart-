package com.drive.pickmeup.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.drive.pickmeup.R;

public class SplashFragment extends Fragment {

    private View view;

    public SplashFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view= inflater.inflate(R.layout.fragment_splash, container, false);
        return view;
    }
    public void onResume() {
        super.onResume();

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
               Navigation.findNavController(view).navigate(R.id.action_splashFragment_to_loginSignUpFragment);
            }
        }, 3000);
    }
}