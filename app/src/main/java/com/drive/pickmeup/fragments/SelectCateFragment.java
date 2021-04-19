package com.drive.pickmeup.fragments;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.widget.AppCompatTextView;
import androidx.cardview.widget.CardView;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;

import com.drive.pickmeup.HomeActivity;
import com.drive.pickmeup.R;
import com.drive.pickmeup.TruckModule.Activity.TruckActivity;
import com.ncorti.slidetoact.SlideToActView;


public class SelectCateFragment extends Fragment {

    private View view;
    private AppCompatTextView txtTopBar;
    private SlideToActView slideTruck, slideTaxi;
    private CardView cardTruck, cardTaxi;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_select_cate, container, false);
        findIDs();
        clicks();
        return view;
    }

    private void clicks() {

        slideTruck.setOnSlideCompleteListener(new SlideToActView.OnSlideCompleteListener() {
            @Override
            public void onSlideComplete(SlideToActView slideToActView) {
                Intent intent = new Intent(getActivity(), TruckActivity.class);
                getActivity().finish();
                startActivity(intent);
            }
        });


        cardTruck.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

//                Intent intent = new Intent(getActivity(), TruckActivity.class);
//                getActivity().finish();
//                startActivity(intent);

                Navigation.findNavController(view).navigate(R.id.action_selectCateFragment_to_truckRegistrationFragment);

            }
        });


        cardTaxi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), HomeActivity.class);
                getActivity().finish();
                startActivity(intent);
            }
        });

        slideTruck.setOnSlideToActAnimationEventListener(new SlideToActView.OnSlideToActAnimationEventListener() {
            @Override
            public void onSlideCompleteAnimationStarted(SlideToActView slideToActView, float v) {
                slideTruck.setOuterColor(ContextCompat.getColor(getActivity(), R.color.black));
            }

            @Override
            public void onSlideCompleteAnimationEnded(SlideToActView slideToActView) {
                slideTruck.setOuterColor(ContextCompat.getColor(getActivity(), R.color.black));
            }

            @Override
            public void onSlideResetAnimationStarted(SlideToActView slideToActView) {
                slideTruck.setOuterColor(ContextCompat.getColor(getActivity(), R.color.black));
            }

            @Override
            public void onSlideResetAnimationEnded(SlideToActView slideToActView) {
                slideTruck.setOuterColor(ContextCompat.getColor(getActivity(), R.color.black));
            }
        });

        slideTaxi.setOnSlideCompleteListener(new SlideToActView.OnSlideCompleteListener() {
            @Override
            public void onSlideComplete(SlideToActView slideToActView) {
                Intent intent = new Intent(getActivity(), HomeActivity.class);
                getActivity().finish();
                startActivity(intent);
            }
        });


        slideTaxi.setOnSlideToActAnimationEventListener(new SlideToActView.OnSlideToActAnimationEventListener() {
            @Override
            public void onSlideCompleteAnimationStarted(SlideToActView slideToActView, float v) {
                slideTaxi.setOuterColor(ContextCompat.getColor(getActivity(), R.color.black));
            }

            @Override
            public void onSlideCompleteAnimationEnded(SlideToActView slideToActView) {

            }

            @Override
            public void onSlideResetAnimationStarted(SlideToActView slideToActView) {


            }

            @Override
            public void onSlideResetAnimationEnded(SlideToActView slideToActView) {

            }
        });


    }

    private void findIDs() {
        slideTruck = view.findViewById(R.id.sliderTruck);
        slideTaxi = view.findViewById(R.id.sliderTaxi);
        cardTaxi = view.findViewById(R.id.cardTaxi);
        cardTruck = view.findViewById(R.id.cardTruck);
    }
}