package com.drive.pickmeup.TruckModule.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.core.view.GravityCompat;
import androidx.navigation.Navigation;

import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.TextView;

import com.drive.pickmeup.R;
import com.infideap.drawerbehavior.AdvanceDrawerLayout;

public class TruckActivity extends AppCompatActivity {

    private AdvanceDrawerLayout advanceDrawerLayout;
    private TextView navTxtProfile, navTxtHome, navTxtFeedback, navTxtAbout,navTxtTerms,navTxtManualRide,navTxtRefer,txtMyVechical,txtMyDocument,
            txtMyDeliveries,txtMyBids,txtHelp,txtSettings;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_truck);
        findIDs();
        performActions();
        clicks();

    }

    private void clicks() {
        navTxtProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                advanceDrawerLayout.closeDrawer(GravityCompat.START);
//                Navigation.findNavController(view).navigate(R.id.profileFragment2);
                Navigation.findNavController(TruckActivity.this, R.id.nav_host_fragment).navigate(R.id.profileFragment2);
            }
        });

        navTxtHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                advanceDrawerLayout.closeDrawer(GravityCompat.START);
                Navigation.findNavController(TruckActivity.this, R.id.nav_host_fragment).navigate(R.id.homeFragment2);
            }
        });

        navTxtFeedback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                advanceDrawerLayout.closeDrawer(GravityCompat.START);
                Navigation.findNavController(TruckActivity.this, R.id.nav_host_fragment).navigate(R.id.feedbackFragment);
            }
        });


        navTxtAbout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                advanceDrawerLayout.closeDrawer(GravityCompat.START);
                Navigation.findNavController(TruckActivity.this, R.id.nav_host_fragment).navigate(R.id.aboutUsFragment);

            }
        });

        navTxtTerms.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                advanceDrawerLayout.closeDrawer(GravityCompat.START);
                Navigation.findNavController(TruckActivity.this, R.id.nav_host_fragment).navigate(R.id.termsConditionFragment );
            }
        });

        navTxtManualRide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                advanceDrawerLayout.closeDrawer(GravityCompat.START);
                Navigation.findNavController(TruckActivity.this, R.id.nav_host_fragment).navigate(R.id.manualRideFragment );

            }
        });

        navTxtRefer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                advanceDrawerLayout.closeDrawer(GravityCompat.START);
                Navigation.findNavController(TruckActivity.this, R.id.nav_host_fragment).navigate(R.id.referEarnFragment );
            }
        });

        txtMyVechical.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                advanceDrawerLayout.closeDrawer(GravityCompat.START);
                Navigation.findNavController(TruckActivity.this, R.id.nav_host_fragment).navigate(R.id.myVehiclesFragment );

            }
        });

        txtMyDocument.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                advanceDrawerLayout.closeDrawer(GravityCompat.START);
                Navigation.findNavController(TruckActivity.this, R.id.nav_host_fragment).navigate(R.id.myDocumentFragment );

            }
        });

        txtMyDeliveries.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                advanceDrawerLayout.closeDrawer(GravityCompat.START);
                Navigation.findNavController(TruckActivity.this, R.id.nav_host_fragment).navigate(R.id.myDeliveriesFragment );
            }
        });

         txtMyBids.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                advanceDrawerLayout.closeDrawer(GravityCompat.START);
                Navigation.findNavController(TruckActivity.this, R.id.nav_host_fragment).navigate(R.id.myBidsFragment );
            }
        });

         txtHelp.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View view) {

                 advanceDrawerLayout.closeDrawer(GravityCompat.START);
                 Navigation.findNavController(TruckActivity.this, R.id.nav_host_fragment).navigate(R.id.helpFragment2 );
             }
         });

         txtSettings.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View view) {

                 advanceDrawerLayout.closeDrawer(GravityCompat.START);
                 Navigation.findNavController(TruckActivity.this, R.id.nav_host_fragment).navigate(R.id.settingFragment3 );
             }
         });

    }

    private void findIDs() {
        advanceDrawerLayout = findViewById(R.id.advance_drawer);
        navTxtProfile = findViewById(R.id.navTxtProfile);
        navTxtHome = findViewById(R.id.navTxtHome);
        navTxtFeedback = findViewById(R.id.navTxtFeedback);
        navTxtAbout = findViewById(R.id.nav_about);
        navTxtTerms=findViewById(R.id.nav_terms);
        navTxtManualRide=findViewById(R.id.nav_manual_ride);
        navTxtRefer=findViewById(R.id.nav_share);
        txtMyVechical=findViewById(R.id.txtMyVechical);
        txtMyDocument=findViewById(R.id.txtMyDocument);
        txtMyDeliveries=findViewById(R.id.txtMyDeliveries);
        txtMyBids=findViewById(R.id.txtMyBids);
        txtHelp=findViewById(R.id.txtHelp);
        txtSettings=findViewById(R.id.txtSetting);
    }

    private void performActions() {

        advanceDrawerLayout.useCustomBehavior(Gravity.START);
        advanceDrawerLayout.setRadius(Gravity.START, 35);//set end container's corner radius (dimension)
        advanceDrawerLayout.setViewScale(Gravity.START, 0.9f);
        advanceDrawerLayout.setViewElevation(Gravity.START, 20);
    }
}