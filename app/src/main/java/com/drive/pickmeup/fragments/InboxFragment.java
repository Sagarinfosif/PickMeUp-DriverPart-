package com.drive.pickmeup.fragments;

import android.os.Bundle;

import androidx.appcompat.widget.AppCompatImageView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.drive.pickmeup.R;
import com.drive.pickmeup.adapter.InboxAdapter;

import java.util.ArrayList;

public class InboxFragment extends Fragment {

    private View view;
    ArrayList<String> notifications;
    RecyclerView recycle_inbox;
    private TextView heading;
    private InboxAdapter inboxAdapter;
AppCompatImageView imBack;
    public InboxFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view= inflater.inflate(R.layout.fragment_inbox, container, false);
        init();
        setRecycle();
        return view;
    }
    private void setRecycle() {
        InboxAdapter notificationAdapter=new InboxAdapter(notifications,getActivity());
        recycle_inbox.setAdapter(notificationAdapter);

    }

    private void init() {
        heading=view.findViewById(R.id.heading);
        imBack=view.findViewById(R.id.back_topbar);
        heading.setText("Inbox");
        recycle_inbox=view.findViewById(R.id.recycle_inbox);
        notifications = new ArrayList<>();
        notifications.add("Your Rating is very Good. Keep it up");
        notifications.add("Your Rating is very Good. Keep it up");
        notifications.add("Your Rating is very Good. Keep it up");
        notifications.add("Congratulations. Your Ride Is successfully done");
        notifications.add("Complete 10 Rides and Get Cashback upto Rs.100");


    }
}