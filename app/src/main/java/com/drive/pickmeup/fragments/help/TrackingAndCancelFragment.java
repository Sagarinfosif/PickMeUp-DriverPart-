package com.drive.pickmeup.fragments.help;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.drive.pickmeup.R;
import com.hsalf.smilerating.BaseRating;
import com.hsalf.smilerating.SmileRating;

public class TrackingAndCancelFragment extends Fragment implements View.OnClickListener {

    private View view;
    private TextView heading, tv_text_title,feedback_description,helpelse;
    private ImageView back_topbar;
    private Button yes_btn,no_btn;
    private SmileRating smile_rating;

    public TrackingAndCancelFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_tracking_and_cancel, container, false);
        ids();
        setup();
        feedback();
        return view;
    }

    private void feedback() {
        smile_rating.setOnSmileySelectionListener(new SmileRating.OnSmileySelectionListener() {
            @Override
            public void onSmileySelected(@BaseRating.Smiley int smiley, boolean reselected) {
                switch (smiley) {
                    case SmileRating.BAD:
                        Toast.makeText(getActivity(), "Bad", Toast.LENGTH_SHORT).show();
                        break;
                    case SmileRating.GOOD:
                        Toast.makeText(getActivity(), "Good", Toast.LENGTH_SHORT).show();
                        break;
                    case SmileRating.GREAT:
                        Toast.makeText(getActivity(), "Great", Toast.LENGTH_SHORT).show();
                        break;
                    case SmileRating.OKAY:
                        Toast.makeText(getActivity(), "Okay", Toast.LENGTH_SHORT).show();
                        break;
                    case SmileRating.TERRIBLE:
                        Toast.makeText(getActivity(), "Terrible", Toast.LENGTH_SHORT).show();
                        break;
                }
            }
        });
    }

    private void setup() {
        heading.setText("Help");
        Bundle bundle = getArguments();
        tv_text_title.setText(bundle.getString("acceptance"));
        back_topbar.setOnClickListener(this);
        yes_btn.setOnClickListener(this);
        no_btn.setOnClickListener(this);
    }

    private void ids() {
        heading = view.findViewById(R.id.heading);
        tv_text_title = view.findViewById(R.id.tv_text_title);
        back_topbar = view.findViewById(R.id.back_topbar);
        yes_btn = view.findViewById(R.id.yes_btn);
        no_btn = view.findViewById(R.id.no_btn);
        smile_rating = view.findViewById(R.id.smile_rating);
        feedback_description = view.findViewById(R.id.feedback_description);
        helpelse = view.findViewById(R.id.helpelse);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.back_topbar:
                getActivity().onBackPressed();
                break;
            case R.id.yes_btn:
                getActivity().onBackPressed();
                break;
            case R.id.no_btn:
                helpelse.setVisibility(View.GONE);
                yes_btn.setVisibility(View.GONE);
                no_btn.setVisibility(View.GONE);
                feedback_description.setVisibility(View.VISIBLE);
                smile_rating.setVisibility(View.VISIBLE);
                break;
        }
    }
}