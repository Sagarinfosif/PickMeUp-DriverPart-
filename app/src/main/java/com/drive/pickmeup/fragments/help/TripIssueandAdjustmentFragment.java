package com.drive.pickmeup.fragments.help;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.drive.pickmeup.R;
import com.drive.pickmeup.adapter.TripIssueAdapter;

public class TripIssueandAdjustmentFragment extends Fragment implements View.OnClickListener {

    private View view;
    private TextView tv_text_title, heading;
    private String[] TripList = {"Found an Item", "Vehicle Damaged", "Getting Trip Request Issue", "Issue face with Rider"};
    private ImageView back_topbar;
    private TripIssueAdapter tripIssueAdapter;
    private RecyclerView rv_tripissue;

    public TripIssueandAdjustmentFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_trip_issueand_adjustment, container, false);
        ids();
        setup();
        setAdapter();
        return view;
    }

    private void setAdapter() {
        tripIssueAdapter = new TripIssueAdapter(getActivity(), TripList, new TripIssueAdapter.Select() {
            @Override
            public void onclick(int position) {
                switch (position) {
                    case 0:
                        Toast.makeText(getActivity(), "Under Development", Toast.LENGTH_SHORT).show();
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
        rv_tripissue.setAdapter(tripIssueAdapter);
    }

    private void setup() {
        Bundle bundle = getArguments();
        tv_text_title.setText(bundle.getString("trip_issue"));
        heading.setText("Help");
        back_topbar.setOnClickListener(this);
    }

    private void ids() {
        rv_tripissue = view.findViewById(R.id.rv_tripissue);
        tv_text_title = view.findViewById(R.id.tv_text_title);
        heading = view.findViewById(R.id.heading);
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