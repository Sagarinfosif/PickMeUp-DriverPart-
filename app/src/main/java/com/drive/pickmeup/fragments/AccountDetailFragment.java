package com.drive.pickmeup.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.drive.pickmeup.R;

public class AccountDetailFragment extends Fragment implements View.OnClickListener {

    private View view;
    private TextView heading;
    private ImageView back_topbar;

    public AccountDetailFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view= inflater.inflate(R.layout.fragment_account_detail, container, false);
        ids();
        setup();
        return view;
    }

    private void setup() {
        back_topbar.setOnClickListener(this);
    }

    private void ids() {
        heading=view.findViewById(R.id.heading);
        heading.setText("Bank Detail");
        back_topbar=view.findViewById(R.id.back_topbar);
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