package com.drive.pickmeup.fragments;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;

import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.os.CountDownTimer;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.drive.pickmeup.R;
import com.google.android.material.bottomsheet.BottomSheetBehavior;

import in.shadowfax.proswipebutton.ProSwipeButton;

public class DestinationFragment extends Fragment implements View.OnClickListener {

    private View view;
    private BottomSheetBehavior<LinearLayout> behavior;
    private LinearLayout bottomsheeet, contact_img, bottom_distance;
    private TextView time_remaining_left, sec_lft;
    private ProSwipeButton start_ride;
    private ImageView cancel_ride,img_side_menu;
    private TextView message,call;


    public DestinationFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_destination, container, false);
        ids();
        setup();
        click();
        return view;
    }

    private void click() {
        cancel_ride.setOnClickListener(this);
        img_side_menu.setOnClickListener(this);

        contact_img.setOnClickListener(this);
        bottomsheeet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }

    private void setup() {

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                bottom_distance.setVisibility(View.GONE);
                behavior.setState(BottomSheetBehavior.STATE_EXPANDED);
                new CountDownTimer(60000, 1000) {
                    @Override
                    public void onTick(long millisUntilFinished) {
                        time_remaining_left.setText("" + millisUntilFinished / 1000);
                    }

                    @Override
                    public void onFinish() {
                        cancel_ride.setVisibility(View.VISIBLE);
                        time_remaining_left.setVisibility(View.GONE);
                        sec_lft.setVisibility(View.GONE);
                    }
                }.start();
                behavior.setPeekHeight(400);
            }
        }, 6000);

        start_ride.setOnSwipeListener(new ProSwipeButton.OnSwipeListener() {
            @Override
            public void onSwipeConfirm() {
                // user has swiped the btn. Perform your async operation now
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        start_ride.showResultIcon(true);
                        Navigation.findNavController(view).navigate(R.id.action_destinationFragment_to_userGoDestinationFragment);
                        Toast.makeText(getActivity(), "Ride Start Now", Toast.LENGTH_SHORT).show();
                    }
                }, 2000);
            }
        });
    }

    private void ids() {
        contact_img = view.findViewById(R.id.contact_img);
        img_side_menu = view.findViewById(R.id.img_side_menu);
        start_ride = view.findViewById(R.id.start_ride);
        bottom_distance = view.findViewById(R.id.bottom_distance);
        cancel_ride = view.findViewById(R.id.cancel_ride);
        sec_lft = view.findViewById(R.id.sec_lft);
        time_remaining_left = view.findViewById(R.id.time_remaining_left);
        //bottom
        bottomsheeet = view.findViewById(R.id.bottomsheet);
        behavior = BottomSheetBehavior.from(bottomsheeet);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.cancel_ride:
                final AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(getActivity());
                LayoutInflater inflater = getLayoutInflater();
                final View dialogView = inflater.inflate(R.layout.dialog_cancel_ride, null);
                dialogBuilder.setView(dialogView);
                TextView yesText;
                yesText = dialogView.findViewById(R.id.yesText);
                final AlertDialog alertDialog = dialogBuilder.create();
                alertDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                alertDialog.show();
                yesText.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        alertDialog.dismiss();
                        Toast.makeText(getActivity(), "Cancel Ride Successfully", Toast.LENGTH_SHORT).show();
                    }
                });

                break;
            case R.id.contact_img:
                final AlertDialog.Builder dialogBuilder1 = new AlertDialog.Builder(getActivity());
                LayoutInflater inflater1 = getLayoutInflater();
                final View dialogView1 = inflater1.inflate(R.layout.dialog_contact_user, null);
                dialogBuilder1.setView(dialogView1);
                message = dialogView1.findViewById(R.id.message);
                call = dialogView1.findViewById(R.id.call);
                final AlertDialog alertDialog1 = dialogBuilder1.create();
                alertDialog1.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                alertDialog1.show();
                message.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        alertDialog1.dismiss();
                        Toast.makeText(getActivity(), "Under Process", Toast.LENGTH_SHORT).show();
                    }
                });
                call.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        alertDialog1.dismiss();
                        Toast.makeText(getActivity(), "Under Process", Toast.LENGTH_SHORT).show();
                    }
                });
                break;

            case R.id.img_side_menu:
                getActivity().onBackPressed();
                break;
        }
    }

}
