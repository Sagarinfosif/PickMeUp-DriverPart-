package com.drive.pickmeup.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.drive.pickmeup.R;

public class UpdatePasswordFragment extends Fragment implements View.OnClickListener {

    private View view;
    private Button save_password;
    private TextView heading;
    private ImageView back_topbar;

    public UpdatePasswordFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view= inflater.inflate(R.layout.fragment_update_password, container, false);
        ids();
        setup();
        return view;
    }
    private void setup() {
        heading.setText("Update Password");
        save_password.setOnClickListener(this);
        back_topbar.setOnClickListener(this);
    }

    private void ids() {
        save_password = view.findViewById(R.id.save_password);
        heading = view.findViewById(R.id.heading);
        back_topbar = view.findViewById(R.id.back_topbar);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.save_password:
                Toast.makeText(getActivity(), "Update Successfully", Toast.LENGTH_SHORT).show();
                Navigation.findNavController(view).navigate(R.id.action_updatePasswordFragment_to_editProfileFragment);
                break;
            case R.id.back_topbar:
                getActivity().onBackPressed();
                break;
        }
    }
}