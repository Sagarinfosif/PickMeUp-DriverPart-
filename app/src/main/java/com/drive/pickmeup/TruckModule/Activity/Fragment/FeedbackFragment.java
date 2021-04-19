package com.drive.pickmeup.TruckModule.Activity.Fragment;

import android.os.Bundle;

import androidx.core.view.GravityCompat;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.drive.pickmeup.R;
import com.drive.pickmeup.TruckModule.Activity.Adapter.AdapterFeedBack;
import com.infideap.drawerbehavior.AdvanceDrawerLayout;


public class FeedbackFragment extends Fragment {


    private View view;
    private RecyclerView recyclerViewFeedBack;
    private AdapterFeedBack adapterFeedBack;
    private TextView txtTopBar;
    private ImageView imgNav;
    private AdvanceDrawerLayout advanceDrawerLayout;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_feedback, container, false);
        findIDs();
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
        adapterFeedBack = new AdapterFeedBack(getActivity());
        recyclerViewFeedBack.setAdapter(adapterFeedBack);
    }

    private void findIDs() {
        recyclerViewFeedBack = view.findViewById(R.id.recyclerFeedBack);
        txtTopBar=view.findViewById(R.id.heading);
        txtTopBar.setText("Feedback");
        imgNav=view.findViewById(R.id.imgNav);
    }
}
