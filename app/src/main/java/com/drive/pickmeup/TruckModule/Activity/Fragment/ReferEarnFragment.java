package com.drive.pickmeup.TruckModule.Activity.Fragment;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.drive.pickmeup.R;

public class ReferEarnFragment extends Fragment {

    private View view;
    private AppCompatImageView imgBack;
    private AppCompatTextView txtTopBar;
    private LinearLayout layoutMore;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_refer_earn, container, false);
        findIDs();
        clicks();
        return view;

    }

    private void clicks() {
        imgBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getActivity().onBackPressed();
            }
        });

        layoutMore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent sharingIntent = new Intent(android.content.Intent.ACTION_SEND);
                sharingIntent.setType("text/plain");
                String shareBody = "Here is the share content body";
                sharingIntent.putExtra(android.content.Intent.EXTRA_SUBJECT, "Subject Here");
                sharingIntent.putExtra(android.content.Intent.EXTRA_TEXT, shareBody);
                startActivity(Intent.createChooser(sharingIntent, "Share via"));
            }
        });
    }

    private void findIDs() {
        imgBack = view.findViewById(R.id.back_topbar);
        txtTopBar = view.findViewById(R.id.heading);
        txtTopBar.setText("Refer & Earn");
        layoutMore=view.findViewById(R.id.layoutMore);
    }
}