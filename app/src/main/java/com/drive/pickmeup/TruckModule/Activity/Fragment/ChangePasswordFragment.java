package com.drive.pickmeup.TruckModule.Activity.Fragment;

import android.os.Bundle;

import androidx.appcompat.widget.AppCompatButton;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.drive.pickmeup.R;


public class ChangePasswordFragment extends Fragment {

   private View view;
   private ImageView imgBack;
   private TextView txtTopBar;
   private AppCompatButton btnSave;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view= inflater.inflate(R.layout.fragment_change_password, container, false);
    findIDs();
    clicks();
        return view;
    }

    private void clicks() {
        imgBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getActivity().onBackPressed();
            }
        });

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getActivity(), "Change password", Toast.LENGTH_SHORT).show();
                getActivity().onBackPressed();
            }
        });

    }

    private void findIDs() {
        imgBack=view.findViewById(R.id.back_topbar);
        txtTopBar=view.findViewById(R.id.heading);
        txtTopBar.setText("Change Password");
        btnSave=view.findViewById(R.id.btnSave);
    }
}