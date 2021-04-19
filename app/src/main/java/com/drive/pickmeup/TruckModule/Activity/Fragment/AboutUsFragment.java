package com.drive.pickmeup.TruckModule.Activity.Fragment;

import android.os.Bundle;

import androidx.appcompat.widget.AppCompatTextView;
import androidx.core.view.GravityCompat;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.drive.pickmeup.R;
import com.drive.pickmeup.TruckModule.Activity.Adapter.AboutAdapter;
import com.infideap.drawerbehavior.AdvanceDrawerLayout;


public class AboutUsFragment extends Fragment {

    private View view;
    private AppCompatTextView txtTopBar;
    private RecyclerView recyclerView;
    private AboutAdapter aboutAdapter;
    private ImageView imgNav;
private AdvanceDrawerLayout advanceDrawerLayout;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_about_us, container, false);
        findIDs();
        txtTopBar.setText("About Us");
        setAdapter();
        clicks();
        return view;
    }

    private void clicks() {
        imgNav.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                advanceDrawerLayout=getActivity().findViewById(R.id.advance_drawer);
                advanceDrawerLayout.openDrawer(GravityCompat.START);
            }
        });
    }

    private void setAdapter() {
        aboutAdapter = new AboutAdapter(getActivity());
        recyclerView.setAdapter(aboutAdapter);
    }

    private void findIDs() {
        txtTopBar = view.findViewById(R.id.heading);
        recyclerView = view.findViewById(R.id.recyclerAbout);
        imgNav = view.findViewById(R.id.imgNav);
    }
}