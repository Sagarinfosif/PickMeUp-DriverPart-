package com.drive.pickmeup.fragments;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;

import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.drive.pickmeup.R;
import com.drive.pickmeup.adapter.RatingFeedbackAdapter;
import com.google.android.material.bottomsheet.BottomSheetBehavior;

import in.shadowfax.proswipebutton.ProSwipeButton;

public class UserGoDestinationFragment extends Fragment implements View.OnClickListener {

    private View view;
    private BottomSheetBehavior<LinearLayout> behavior;
    private LinearLayout bottomsheeet,bottom_distance;
    private ProSwipeButton complete_ride;
    private String[] feedback={"Late for pickup","Disrespectful","Conversation","Bad Pickup Location","Wanted new route","Cleanliness","Other"};
    private RecyclerView rv_ratting;
    private RatingFeedbackAdapter ratingFeedbackAdapter;
    private ImageView img_side_menu;

    public UserGoDestinationFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view= inflater.inflate(R.layout.fragment_user_go_destination, container, false);
        ids();
        setup();

        return view;
    }

    private void setAdapter() {
        ratingFeedbackAdapter=new RatingFeedbackAdapter(getActivity(), feedback);
        rv_ratting.setAdapter(ratingFeedbackAdapter);
    }

    private void setup() {
        img_side_menu.setOnClickListener(this);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                bottom_distance.setVisibility(View.GONE);
                behavior.setState(BottomSheetBehavior.STATE_EXPANDED);
            }
        }, 6000);

        complete_ride.setOnSwipeListener(new ProSwipeButton.OnSwipeListener() {
            @Override
            public void onSwipeConfirm() {
                // user has swiped the btn. Perform your async operation now
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        complete_ride.showResultIcon(true);
                        Toast.makeText(getActivity(), "Ride Finish Now", Toast.LENGTH_SHORT).show();
                        final AlertDialog.Builder dialogBuilder1 = new AlertDialog.Builder(getActivity());
                        LayoutInflater inflater = getLayoutInflater();
                        final View dialogView = inflater.inflate(R.layout.ratebar_alert, null);
                        dialogBuilder1.setView(dialogView);
                        Button rating_rider;
                        rating_rider = dialogView.findViewById(R.id.rating_rider);
                        rv_ratting = dialogView.findViewById(R.id.rv_ratting);
                        setAdapter();
                        final AlertDialog alertDialog1 = dialogBuilder1.create();
                        alertDialog1.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                        alertDialog1.show();
                        rating_rider.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                alertDialog1.dismiss();
                                Navigation.findNavController(getView()).navigate(R.id.action_userGoDestinationFragment_to_homeFragment);
                                Toast.makeText(getActivity(), "Rating Successfully", Toast.LENGTH_SHORT).show();
                            }
                        });
                    }
                }, 2000);
            }
        });
    }

    private void ids() {
        //bottom
        bottomsheeet = view.findViewById(R.id.bottomsheet);
        behavior = BottomSheetBehavior.from(bottomsheeet);
        complete_ride = view.findViewById(R.id.complete_ride);
        bottom_distance = view.findViewById(R.id.bottom_distance);
        img_side_menu = view.findViewById(R.id.img_side_menu);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.img_side_menu:
                getActivity().onBackPressed();
                break;
        }
    }
}