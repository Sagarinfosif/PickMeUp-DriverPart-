package com.drive.pickmeup.TruckModule.Activity.Fragment;

import android.app.AlertDialog;
import android.os.Bundle;

import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.cardview.widget.CardView;
import androidx.core.content.ContextCompat;
import androidx.core.view.GravityCompat;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.drive.pickmeup.R;
import com.drive.pickmeup.TruckModule.Activity.AdapterNew.CategoryAdapter;
import com.drive.pickmeup.TruckModule.Activity.AdapterNew.JobAdapters;
import com.infideap.drawerbehavior.AdvanceDrawerLayout;


public class HomeFragment extends Fragment {


    private AppCompatTextView txtTopBar;
    private View view;
    private AdvanceDrawerLayout advanceDrawerLayout;
    private AppCompatImageView imgNav;
    private RecyclerView recyclerViewJobs, recyclerViewCate;
    private JobAdapters jobAdapters;
    private CategoryAdapter categoryAdapter;
    private AlertDialog alertDialog;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_home2, container, false);
        findIDs();
        txtTopBar.setText("Home");
        clicks();
        setAdapter();
        return view;
    }

    private void setAdapter() {
        jobAdapters = new JobAdapters(getActivity(), new JobAdapters.OpenDialog() {
            @Override
            public void dialogOpen() {
openDialog();
            }
        });
        recyclerViewJobs.setAdapter(jobAdapters);

        categoryAdapter = new CategoryAdapter(getActivity());
        recyclerViewCate.setAdapter(categoryAdapter);
    }

    private void openDialog() {

        final AlertDialog.Builder alert=new AlertDialog.Builder ( getActivity());
        View mview=getLayoutInflater ().inflate ( R.layout.bid_now_dialog,null );
        alert.setView ( mview );
        alertDialog=alert.create ();
        alertDialog.show ();

    }

    private void clicks() {
        imgNav.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                advanceDrawerLayout = getActivity().findViewById(R.id.advance_drawer);
                advanceDrawerLayout.openDrawer(GravityCompat.START);
            }
        });

    }

    private void findIDs() {
        txtTopBar = view.findViewById(R.id.heading);
        imgNav = view.findViewById(R.id.imgNav);
        advanceDrawerLayout = getActivity().findViewById(R.id.advance_drawer);
        recyclerViewJobs = view.findViewById(R.id.jobs_recycler);
        recyclerViewCate = view.findViewById(R.id.categories_recycler);
    }
}