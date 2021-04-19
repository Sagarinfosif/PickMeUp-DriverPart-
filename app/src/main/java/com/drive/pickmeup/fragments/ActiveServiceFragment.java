package com.drive.pickmeup.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.drive.pickmeup.R;
import com.suke.widget.SwitchButton;

public class ActiveServiceFragment extends Fragment implements View.OnClickListener {

    private View view;
    private SwitchButton switch_drive_idel, switch_drive_link, switch_drive;
    private ImageView back_topbar;
    private Button reset_button;
    private TextView heading;

    public ActiveServiceFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_active_service, container, false);
        ids();
        setup();
        setswitch();
        return view;
    }

    private void setswitch() {
        switch_drive_idel.setOnCheckedChangeListener(new SwitchButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(SwitchButton view, boolean isChecked) {
                if (switch_drive_idel.isChecked()) {
                    Toast.makeText(getActivity(), "Drive Idel On", Toast.LENGTH_SHORT).show();
                } else
                    Toast.makeText(getActivity(), "off", Toast.LENGTH_SHORT).show();
            }
        });
        switch_drive_link.setOnCheckedChangeListener(new SwitchButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(SwitchButton view, boolean isChecked) {
                if (switch_drive_link.isChecked()) {
                    Toast.makeText(getActivity(), "Drive Link On", Toast.LENGTH_SHORT).show();
                } else
                    Toast.makeText(getActivity(), "off", Toast.LENGTH_SHORT).show();
            }
        });
        switch_drive.setOnCheckedChangeListener(new SwitchButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(SwitchButton view, boolean isChecked) {
                if (switch_drive.isChecked()) {
                    Toast.makeText(getActivity(), "Drive On", Toast.LENGTH_SHORT).show();
                } else
                    Toast.makeText(getActivity(), "off", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void setup() {
        heading.setText("Active Service");
        back_topbar.setOnClickListener(this);
        reset_button.setOnClickListener(this);
    }

    private void ids() {
        back_topbar = view.findViewById(R.id.back_topbar);
        heading = view.findViewById(R.id.heading);
        switch_drive = view.findViewById(R.id.switch_drive);
        switch_drive_link = view.findViewById(R.id.switch_drive_link);
        switch_drive_idel = view.findViewById(R.id.switch_drive_idel);
        reset_button = view.findViewById(R.id.reset_button);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.back_topbar:
                getActivity().onBackPressed();
                break;
                case R.id.reset_button:
                    if (switch_drive_idel.isChecked()) {
                        switch_drive_idel.setChecked(false);

                        if (switch_drive_link.isChecked()) {
                            switch_drive_link.setChecked(false);
                        }
                        if (switch_drive.isChecked()) {
                            switch_drive.setChecked(false);
                        }
                    }
                    Toast.makeText(getActivity(), "All Services Reset Successfully", Toast.LENGTH_SHORT).show();
                break;
        }
    }
}