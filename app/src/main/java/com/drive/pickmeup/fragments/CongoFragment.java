package com.drive.pickmeup.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.drive.pickmeup.R;

public class CongoFragment extends Fragment implements View.OnClickListener {

    private View view;
    private Button btn_submit_otp;

    public CongoFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view= inflater.inflate(R.layout.fragment_congo, container, false);
        ids();
        setup();
        return view;
    }

    private void setup() {
        btn_submit_otp.setOnClickListener(this);
    }

    private void ids() {
        btn_submit_otp=view.findViewById(R.id.btn_submit_otp);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btn_submit_otp:
                Navigation.findNavController(view).navigate(R.id.action_congoFragment_to_selectCateFragment);
                break;
        }
    }
}