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
import com.drive.pickmeup.adapter.UsingAppAdapter;

public class UsingTheAppFragment extends Fragment implements View.OnClickListener {

    private View view;
    private TextView tv_text_title, heading;
    private String[] usingAppList = {"Going online", "Receiving Trip Request", "Navigation to a Rider", "From Pickup to Dropoff", "Airport Trip", "Personal Accident Insurance"};
    private RecyclerView rv_usingApp;
    private UsingAppAdapter usingAppAdapter;
    private ImageView back_topbar;

    public UsingTheAppFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_using_the_app, container, false);
        ids();
        setup();
        setAdapter();
        return view;
    }

    private void setAdapter() {
        usingAppAdapter = new UsingAppAdapter(getActivity(), usingAppList, new UsingAppAdapter.Select() {
            @Override
            public void onclick(int position) {
                switch (position) {
                    case 0:

                        break;
                    case 1:

                        break;
                    case 2:

                        break;
                    case 3:

                        break;
                    case 4:

                        break;
                    case 5:

                        break;
                }
            }
        });
        rv_usingApp.setAdapter(usingAppAdapter);
    }

    private void setup() {
        Bundle bundle = getArguments();
        tv_text_title.setText(bundle.getString("using_app"));
        heading.setText("Help");
        back_topbar.setOnClickListener(this);
    }

    private void ids() {
        rv_usingApp = view.findViewById(R.id.rv_usingApp);
        back_topbar = view.findViewById(R.id.back_topbar);
        tv_text_title = view.findViewById(R.id.tv_text_title);
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