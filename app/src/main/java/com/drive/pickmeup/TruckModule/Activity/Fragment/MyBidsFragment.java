package com.drive.pickmeup.TruckModule.Activity.Fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.drive.pickmeup.R;
import com.drive.pickmeup.TruckModule.Activity.AdapterNew.AssignedJobAdapter;
import com.drive.pickmeup.TruckModule.Activity.AdapterNew.UpcomingAdapter;
import com.drive.pickmeup.TruckModule.Activity.AdapterNew.UpcomingJobAdapter;

public class MyBidsFragment extends Fragment {

    private View view;
    private ImageView imgBack;
    private TextView txtTopBar;
    private RecyclerView recyclerViewUpcoming,recyclerViewAssigned;
    private AssignedJobAdapter assignedJobAdapter;

    private UpcomingJobAdapter upcomingJobAdapter;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view= inflater.inflate(R.layout.fragment_my_bids, container, false);
        findIDs();
        clicks();
        setAdapter();
        return view;
    }

    private void setAdapter() {
        assignedJobAdapter=new AssignedJobAdapter(getActivity());

        recyclerViewAssigned.setAdapter(assignedJobAdapter);

        upcomingJobAdapter=new UpcomingJobAdapter(getActivity());
        recyclerViewUpcoming.setAdapter(upcomingJobAdapter);
    }

    private void clicks() {
        imgBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getActivity().onBackPressed();
            }
        });

    }

    private void findIDs() {
        imgBack=view.findViewById(R.id.back_topbar);
        txtTopBar=view.findViewById(R.id.heading);
        txtTopBar.setText("My Bids");
        recyclerViewAssigned=view.findViewById(R.id.assigned_recycler);
        recyclerViewUpcoming=view.findViewById(R.id.inprogress_recycler);
    }
}