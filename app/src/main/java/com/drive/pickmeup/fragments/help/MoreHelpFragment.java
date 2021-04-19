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
import com.drive.pickmeup.adapter.MoreHelpAdapter;

public class MoreHelpFragment extends Fragment implements View.OnClickListener {

    private View view;
    private String[] morehelpList = {"Common Phone and App Issues", "Unable to Contact Riders", "Legal", "Community Guidelines"};
    private TextView heading, tv_text_title;
    private RecyclerView rv_more_help;
    private ImageView back_topbar;
    private MoreHelpAdapter moreHelpAdapter;

    public MoreHelpFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_more_help, container, false);
        ids();
        setup();
        setadapter();
        return view;
    }

    private void setadapter() {
        moreHelpAdapter = new MoreHelpAdapter(getActivity(), morehelpList, new MoreHelpAdapter.Select() {
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
                }
            }
        });
        rv_more_help.setAdapter(moreHelpAdapter);
    }

    private void setup() {
        back_topbar.setOnClickListener(this);
        heading.setText("Help");
        Bundle bundle = getArguments();
        tv_text_title.setText(bundle.getString("more_help"));
    }

    private void ids() {
        heading = view.findViewById(R.id.heading);
        tv_text_title = view.findViewById(R.id.tv_text_title);
        rv_more_help = view.findViewById(R.id.rv_more_help);
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