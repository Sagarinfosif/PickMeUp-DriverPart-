package com.drive.pickmeup.fragments.help;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.drive.pickmeup.R;
import com.drive.pickmeup.adapter.SafetyAdapter;

public class SafetyRelatedFragment extends Fragment implements View.OnClickListener {

    private View view;
    private String[] SafetyList = {"I was Involved in an accident", "The Rider was aggressive towards me", "The rider was discriminating againts me", "Contacting DRIVE to Report Safety Related Incidents"};
    private RecyclerView rv_safety_related;
    private TextView heading;
    private SafetyAdapter safetyAdapter;
    private ImageView back_topbar;

    public SafetyRelatedFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_safety_related, container, false);
        ids();
        setup();
        setadapter();
        return view;
    }

    private void setadapter() {
        safetyAdapter = new SafetyAdapter(getActivity(), SafetyList, new SafetyAdapter.Select() {
            @Override
            public void onclick(int position) {
                switch (position) {
                    case 0:

                        break;
                    case 1:

                        break;
                }
            }
        });
        rv_safety_related.setAdapter(safetyAdapter);
    }

    private void setup() {
        heading.setText("Safety Related");
        back_topbar.setOnClickListener(this);
    }

    private void ids() {
        heading = view.findViewById(R.id.heading);
        rv_safety_related = view.findViewById(R.id.rv_safety_related);
        back_topbar = view.findViewById(R.id.back_topbar);
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