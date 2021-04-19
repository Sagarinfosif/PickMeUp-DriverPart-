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
import com.drive.pickmeup.TruckModule.Activity.Adapter.TermsConditionAdapter;
import com.infideap.drawerbehavior.AdvanceDrawerLayout;


public class TermsConditionFragment extends Fragment {

    private View view;
    private RecyclerView recyclerView;
    private TermsConditionAdapter termsConditionAdapter;
    private TextView txTopBar;
    private ImageView imgNav;
    private AdvanceDrawerLayout advanceDrawerLayout;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_terms_condition, container, false);
        findIDs();
        txTopBar.setText("Terms & Condition");
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
        termsConditionAdapter = new TermsConditionAdapter(getActivity());

        recyclerView.setAdapter(termsConditionAdapter);
    }

    private void findIDs() {
        recyclerView = view.findViewById(R.id.recyclerTerms);
        txTopBar = view.findViewById(R.id.heading);
        imgNav = view.findViewById(R.id.imgNav);
    }
}