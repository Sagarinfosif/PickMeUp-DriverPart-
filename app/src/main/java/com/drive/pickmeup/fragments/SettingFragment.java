package com.drive.pickmeup.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.drive.pickmeup.R;

public class SettingFragment extends Fragment implements View.OnClickListener {

    private View view;
    private TextView tv_navigation,heading;
    private ImageView back_topbar;

    public SettingFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view= inflater.inflate(R.layout.fragment_setting, container, false);
        ids();
        setup();
        return view;
    }

    private void ids() {
        tv_navigation=view.findViewById(R.id.tv_navigation);
        heading=view.findViewById(R.id.heading);
        back_topbar=view.findViewById(R.id.back_topbar);
    }

    private void setup() {
       heading.setText("Settings");
        back_topbar.setOnClickListener(this);
        tv_navigation.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.tv_navigation:
                Navigation.findNavController(view).navigate(R.id.action_settingFragment_to_navigationFragment);
                break;
            case R.id.back_topbar:
                getActivity().onBackPressed();
                break;
        }
    }
}