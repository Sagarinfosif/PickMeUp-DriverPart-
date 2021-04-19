package com.drive.pickmeup.fragments;

import android.app.Dialog;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.drive.pickmeup.R;
import com.drive.pickmeup.adapter.AllDocumentsAdapter;

public class AllDocumentUploadFragment extends Fragment implements View.OnClickListener {

    private View view;
    private RecyclerView rv_alldocuments;
    private TextView heading;
    private ImageView back_topbar;
    private String[] allDocumentList = {"Profile Photo", "Driver's Licence (FRONT)", "Driver's Licence (BACK)","Add image of vehicle" ,"Vehicle Insurance Certificate", "Image of Inspection", "Vehicle registration Certificate", "Certificate of character", "Terms And Conditions"};
    private AllDocumentsAdapter allDocumentsAdapter;


    public AllDocumentUploadFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_all_document_upload, container, false);
        ids();
        setup();
        setAdapter();
        return view;
    }

    private void setAdapter() {
        allDocumentsAdapter = new AllDocumentsAdapter(getActivity(), allDocumentList, new AllDocumentsAdapter.Select() {
            @Override
            public void onclick(int position) {
                Dialog dialog=new Dialog(getContext());
                dialog.setContentView(R.layout.dialog_document);
                dialog.getWindow().setLayout(GridLayout.LayoutParams.MATCH_PARENT,GridLayout.LayoutParams.WRAP_CONTENT);
                dialog.show();
            }
        });

        rv_alldocuments.setAdapter(allDocumentsAdapter);
    }

    private void setup() {
        heading.setText("Documents Required");
        back_topbar.setOnClickListener(this);
    }

    private void ids() {
        rv_alldocuments = view.findViewById(R.id.rv_alldocuments);
        back_topbar = view.findViewById(R.id.back_topbar);
        heading = view.findViewById(R.id.heading);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.back_topbar:
                getActivity().onBackPressed();
                break;
        }
    }
}