package com.drive.pickmeup.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.drive.pickmeup.R;

public class BalanceFragment extends Fragment implements View.OnClickListener {

    private View view;
    private TextView heading;
    private Button btn_withdraw;
    private ImageView help, back_topbar;

    public BalanceFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_balance, container, false);
        ids();
        setup();
        return view;
    }

    private void setup() {
        heading.setText("Available Balance");
        help.setVisibility(View.VISIBLE);
        help.setOnClickListener(this);
        back_topbar.setOnClickListener(this);
        btn_withdraw.setOnClickListener(this);
    }

    private void ids() {
        help = view.findViewById(R.id.help);
        back_topbar = view.findViewById(R.id.back_topbar);
        heading = view.findViewById(R.id.heading);
        btn_withdraw = view.findViewById(R.id.btn_withdraw);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.help:
                Navigation.findNavController(view).navigate(R.id.action_balanceFragment_to_helpFragment);
                break;

            case R.id.back_topbar:
                getActivity().onBackPressed();
                break;

            case R.id.btn_withdraw:
                Toast.makeText(getActivity(), "Under Development", Toast.LENGTH_SHORT).show();
                break;
        }
    }
}