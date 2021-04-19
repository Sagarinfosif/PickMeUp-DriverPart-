package com.drive.pickmeup.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.drive.pickmeup.R;
import com.drive.pickmeup.adapter.TripAdapter;

public class AllTripFragment extends Fragment implements View.OnClickListener {

    private View view;
    private TextView heading;
    private ImageView back_topbar;
    private RecyclerView trips_recyclerView;
    private TripAdapter tripAdapter;

    public AllTripFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_all_trip, container, false);
        ids();
        setup();
        return view;
    }

    private void setup() {
        back_topbar.setOnClickListener(this);

        heading.setText("Your Trips");
        tripAdapter = new TripAdapter(getActivity(), new TripAdapter.Select() {
            @Override
            public void Position(int position) {
                Navigation.findNavController(view).navigate(R.id.action_allTripFragment_to_tripDetailFragment);
            }

            @Override
            public void clikHelp(int position) {
                getActivity().onBackPressed();
            }
        });

        trips_recyclerView.setAdapter(tripAdapter);
    }

    private void ids() {
        trips_recyclerView = view.findViewById(R.id.trips_recyclerView);
        heading = view.findViewById(R.id.heading);
        back_topbar = view.findViewById(R.id.back_topbar);
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