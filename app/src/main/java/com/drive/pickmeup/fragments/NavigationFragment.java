package com.drive.pickmeup.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.drive.pickmeup.R;
import com.suke.widget.SwitchButton;

public class NavigationFragment extends Fragment implements View.OnClickListener {

    private View view;
    private TextView heading;
    private ImageView back_topbar;
    private SwitchButton switch_button_navigation;

    public NavigationFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view= inflater.inflate(R.layout.fragment_navigation, container, false);
        ids();
        setup();
        setswitch();
        return view;
    }

    private void setswitch() {
        switch_button_navigation.setOnCheckedChangeListener(new SwitchButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(SwitchButton view, boolean isChecked) {
                if (switch_button_navigation.isChecked()) {
                    Toast.makeText(getActivity(), "Set Successfully", Toast.LENGTH_SHORT).show();
                }
                else
                    Toast.makeText(getActivity(), "off", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void setup() {
    heading.setText("Navigation");
    back_topbar.setOnClickListener(this);
    }

    private void ids() {
        switch_button_navigation=view.findViewById(R.id.switch_button_navigation);
        heading=view.findViewById(R.id.heading);
        back_topbar=view.findViewById(R.id.back_topbar);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.back_topbar:
                getActivity().onBackPressed();
                break;
        }
    }
}