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
import com.drive.pickmeup.TruckModule.Activity.AdapterNew.HelpAdapter;

public class HelpFragment extends Fragment {

    private View view;
    private ImageView imgBack;
    private TextView txtTopBar;
    private RecyclerView helpRecycler;
    private HelpAdapter helpAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_help2, container, false);
        findIDs();
        clicks();
        setAdapter();
        return view;
    }

    private void setAdapter() {
        helpAdapter=new HelpAdapter(getActivity());

        helpRecycler.setAdapter(helpAdapter);
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
        helpRecycler=view.findViewById(R.id.all_topics_recycler);
        txtTopBar = view.findViewById(R.id.heading);
        txtTopBar.setText("Help");
    }
}
