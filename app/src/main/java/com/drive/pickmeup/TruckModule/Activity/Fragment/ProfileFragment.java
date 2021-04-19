package com.drive.pickmeup.TruckModule.Activity.Fragment;

import android.os.Bundle;

import androidx.appcompat.widget.AppCompatButton;
import androidx.core.view.GravityCompat;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.drive.pickmeup.R;
import com.infideap.drawerbehavior.AdvanceDrawerLayout;


public class ProfileFragment extends Fragment {

    private View view;
    private TextView txtTopBar;
    private ImageView imgNav;
    private AdvanceDrawerLayout advanceDrawerLayout;
    private AppCompatButton btnChangePassword;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view= inflater.inflate(R.layout.fragment_profile2, container, false);
        findIDs();
        txtTopBar.setText("Profile");
        clicks();
        return view;
    }

    private void clicks() {
        imgNav.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               advanceDrawerLayout= getActivity().findViewById(R.id.advance_drawer);
               advanceDrawerLayout.openDrawer(GravityCompat.START);
            }
        });

        btnChangePassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Navigation.findNavController(view).navigate(R.id.action_profileFragment2_to_changePasswordFragment);
            }
        });
    }

    private void findIDs() {
        txtTopBar=view.findViewById(R.id.heading);
        imgNav=view.findViewById(R.id.imgNav);
        btnChangePassword=view.findViewById(R.id.btnChangePassword);
    }
}