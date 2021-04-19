package com.drive.pickmeup.fragments;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;

import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.cardiomood.android.controls.gauge.SpeedometerGauge;
import com.drive.pickmeup.Pojo.RegisterPojo;
import com.drive.pickmeup.R;
import com.drive.pickmeup.utils.App;
import com.drive.pickmeup.utils.AppConstants;
import com.drive.pickmeup.MyViewModel;
import com.google.android.material.card.MaterialCardView;
import com.taufiqrahman.reviewratings.BarLabels;
import com.taufiqrahman.reviewratings.RatingReviews;

import java.util.Random;

import de.hdodenhof.circleimageview.CircleImageView;

public class ProfileFragment extends Fragment implements View.OnClickListener {

    private View view;
    private TextView heading;
    private ImageView edit,back_topbar;
    private RelativeLayout rl_acceptance,rl_completion_rate;
    private SpeedometerGauge acceptanceRate,completion_rate;
    private MaterialCardView card_completion;
    private RatingReviews ratingReviews;
    private TextView txtName;
    private MyViewModel viewModel;
    private RegisterPojo userDetail;
    private CircleImageView userPic;

//    private HorizontalBarChart chart;

    public ProfileFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_profile, container, false);
//        viewModel= ViewModelProviders.of(ProfileFragment.this).get(MyViewModel.class);
//        userDetail= App.getSharedpref().getModel(AppConstants.LOGIN_DETAIL,RegisterPojo.class);
        ids();
//        txtName.setText(userDetail.getDetails().getUsername());
//
//        if(!userDetail.getDetails().getImage().equals(""))
//        {
//            Glide.with(getContext()).load(userDetail.getDetails().getImage()).into(userPic);
//        }
        setup();
        setRating();
//        setChart();

        return view;
    }

    private void setRating() {
        int colors[] = new int[]{
                Color.parseColor("#0e9d58"),
                Color.parseColor("#bfd047"),
                Color.parseColor("#ffc105"),
                Color.parseColor("#ef7e14"),
                Color.parseColor("#d36259")};

        int raters[] = new int[]{
                new Random().nextInt(100),
                new Random().nextInt(100),
                new Random().nextInt(100),
                new Random().nextInt(100),
                new Random().nextInt(100)
        };

        ratingReviews.createRatingBars(100, BarLabels.STYPE1, colors, raters);

    }

//    private void setChart() {
//
//        BarDataSet set1;
//        set1 = new BarDataSet(getDataSet(), "The year 2017");
//
//        set1.setColors(Color.parseColor("#F78B5D"), Color.parseColor("#FCB232"), Color.parseColor("#FDD930"), Color.parseColor("#ADD137"), Color.parseColor("#A0C25A"));
//
//        ArrayList<IBarDataSet> dataSets = new ArrayList<IBarDataSet>();
//        dataSets.add(set1);
//
//        BarData data = new BarData(dataSets);
//
//        // hide Y-axis
//        YAxis left = chart.getAxisLeft();
//        left.setDrawLabels(false);
//
//        // custom X-axis labels
//        String[] values = new String[] { "1 star", "2 stars", "3 stars", "4 stars", "5 stars"};
//        XAxis xAxis = chart.getXAxis();
//        xAxis.setValueFormatter(new MyXAxisValueFormatter(values));
//
//        chart.setData(data);
//
//        // custom description
//        Description description = new Description();
//        description.setText("Rating");
//        chart.setDescription(description);
//
//        // hide legend
//        chart.getLegend().setEnabled(false);
//
//        chart.animateY(1000);
//        chart.invalidate();
//
//
//    }
//        private ArrayList<BarEntry> getDataSet() {
//
//            ArrayList<BarEntry> valueSet1 = new ArrayList<>();
//
//            BarEntry v1e2 = new BarEntry(1, 4341f);
//            valueSet1.add(v1e2);
//            BarEntry v1e3 = new BarEntry(2, 3121f);
//            valueSet1.add(v1e3);
//            BarEntry v1e4 = new BarEntry(3, 5521f);
//            valueSet1.add(v1e4);
//            BarEntry v1e5 = new BarEntry(4, 10421f);
//            valueSet1.add(v1e5);
//            BarEntry v1e6 = new BarEntry(5, 27934f);
//            valueSet1.add(v1e6);
//
//            return valueSet1;
//        }

    private void setup() {
        heading.setText("My Profile");
        edit.setVisibility(View.VISIBLE);
        edit.setOnClickListener(this);
        rl_acceptance.setOnClickListener(this);
        rl_completion_rate.setOnClickListener(this);
        back_topbar.setOnClickListener(this);
    }

    private void ids() {
        heading = view.findViewById(R.id.heading);
        edit = view.findViewById(R.id.edit);
        rl_acceptance = view.findViewById(R.id.rl_acceptance);
        rl_completion_rate = view.findViewById(R.id.rl_completion_rate);
        ratingReviews =view.findViewById(R.id.rating_reviews);
        back_topbar =view.findViewById(R.id.back_topbar);
        txtName=view.findViewById(R.id.txt_name);
        userPic=view.findViewById(R.id.user_pic);
//        chart=view.findViewById(R.id.chart);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.edit:
                Navigation.findNavController(view).navigate(R.id.action_profileFragment_to_editProfileFragment);
                break;

            case R.id.rl_acceptance:
                final AlertDialog.Builder dialogBuilder1 = new AlertDialog.Builder(getActivity());
                LayoutInflater inflater = getLayoutInflater();
                final View dialogView = inflater.inflate(R.layout.acceptance_alert, null);
                dialogBuilder1.setView(dialogView);
                final AlertDialog alertDialog1 = dialogBuilder1.create();
                acceptanceRate = dialogView.findViewById(R.id.acceptanceRate);
                alertDialog1.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                alertDialog1.show();
                acceptanceRate.setLabelConverter(new SpeedometerGauge.LabelConverter() {
                    @Override
                    public String getLabelFor(double progress, double maxProgress) {
                        return String.valueOf((int) Math.round(progress));
                    }
                });
                acceptanceRate.setMaxSpeed(100);
                acceptanceRate.setMajorTickStep(5);
                acceptanceRate.setMinorTicks(4);
                acceptanceRate.addColoredRange(0, 50, Color.GREEN);
                acceptanceRate.addColoredRange(50, 80, Color.YELLOW);
                acceptanceRate.addColoredRange(80, 100, Color.RED);
                acceptanceRate.setSpeed(33, 1000, 300);
                break;

            case R.id.rl_completion_rate:
                final AlertDialog.Builder dialogBuilder2 = new AlertDialog.Builder(getActivity());
                LayoutInflater inflater2 = getLayoutInflater();
                final View dialogView2 = inflater2.inflate(R.layout.completion_alert, null);
                dialogBuilder2.setView(dialogView2);
                final AlertDialog alertDialog2 = dialogBuilder2.create();
                completion_rate = dialogView2.findViewById(R.id.completion_rate);
                card_completion = dialogView2.findViewById(R.id.card_completion);
                alertDialog2.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                Animation animation_alert = AnimationUtils.loadAnimation(getActivity(), R.anim.fade_in);
                card_completion.setAnimation(animation_alert);
                alertDialog2.show();
                completion_rate.setLabelConverter(new SpeedometerGauge.LabelConverter() {
                    @Override
                    public String getLabelFor(double progress, double maxProgress) {
                        return String.valueOf((int) Math.round(progress));
                    }
                });
                completion_rate.setMaxSpeed(100);
                completion_rate.setMajorTickStep(5);
                completion_rate.setMinorTicks(4);
                completion_rate.addColoredRange(0, 50, Color.GREEN);
                completion_rate.addColoredRange(50, 80, Color.YELLOW);
                completion_rate.addColoredRange(80, 100, Color.RED);
                completion_rate.setSpeed(33, 1000, 300);
                break;
            case R.id.back_topbar:
                getActivity().onBackPressed();
                break;
        }
    }
}