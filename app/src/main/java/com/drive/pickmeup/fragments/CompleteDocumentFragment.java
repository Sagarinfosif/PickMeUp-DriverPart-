package com.drive.pickmeup.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.drive.pickmeup.R;
import com.drive.pickmeup.adapter.CompleteDocumentAdapter;

public class CompleteDocumentFragment extends Fragment implements View.OnClickListener {

    private View view;
    private String[] completeDocumentList = {"Profile Photo", "Driver's Licence (FRONT)", "Driver's Licence (BACK)", "Queenland Driver Authorisation", "Vehicle Insurance Certificate", "Certificate of Inspection", "Booked Hire Service Licence", "Vehicle registration Certificate", "E-TAG Number", "Terms And Conditions"};
    private RecyclerView rv_completedocuments;
    private TextView heading;
    private ImageView back_topbar;
    private CompleteDocumentAdapter completeDocumentAdapter;

    public CompleteDocumentFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_complete_document, container, false);
        ids();
        setup();
        setAdapter();
        return view;
    }

    private void setAdapter() {
        completeDocumentAdapter = new CompleteDocumentAdapter(getActivity(), completeDocumentList);
        rv_completedocuments.setAdapter(completeDocumentAdapter);
    }

    private void setup() {
        heading.setText("Uploaded Documents");
        back_topbar.setOnClickListener(this);
    }

    private void ids() {
        rv_completedocuments = view.findViewById(R.id.rv_completedocuments);
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