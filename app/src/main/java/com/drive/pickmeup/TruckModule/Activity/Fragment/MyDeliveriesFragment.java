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
import com.drive.pickmeup.TruckModule.Activity.AdapterNew.CompletedJobAdapter;
import com.drive.pickmeup.TruckModule.Activity.AdapterNew.UpcomingAdapter;

public class MyDeliveriesFragment extends Fragment {

    private View view;
    private ImageView imgBack;
    private TextView txtTopBar;
    private RecyclerView recyclerViewUpcoming,recyclerViewCompleted;
    private UpcomingAdapter upcomingAdapter;
    private CompletedJobAdapter completedJobAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_my_deliveries, container, false);
        findIDs();
        clicks();
        setAdapter();
        return view;
    }

    private void setAdapter() {
        upcomingAdapter=new UpcomingAdapter(getActivity());

        recyclerViewUpcoming.setAdapter(upcomingAdapter);

        completedJobAdapter=new CompletedJobAdapter(getActivity());

        recyclerViewCompleted.setAdapter(completedJobAdapter);
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
        imgBack = view.findViewById(R.id.back_topbar);
        txtTopBar = view.findViewById(R.id.heading);
        txtTopBar.setText("My Deliveries");

        recyclerViewCompleted=view.findViewById(R.id.completed_recycler);
        recyclerViewUpcoming=view.findViewById(R.id.upcoming_recycler);
    }
}