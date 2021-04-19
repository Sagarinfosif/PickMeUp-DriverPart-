package com.drive.pickmeup.fragments.refertab;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.drive.pickmeup.R;


public class ReferToRideFragment extends Fragment implements View.OnClickListener {

    private View view;
    private TextView refer_code;
    private ImageView more_refer, refer_fb;


    public ReferToRideFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_refer_to_ride, container, false);
        id();
        setup();
        return view;
    }

    private void setup() {
        refer_code.setOnClickListener(this);
        more_refer.setOnClickListener(this);
        refer_fb.setOnClickListener(this);
    }

    private void id() {
        refer_code = view.findViewById(R.id.refer_code);
        more_refer = view.findViewById(R.id.more_refer);
        refer_fb = view.findViewById(R.id.refer_fb);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.refer_code:
                Intent sendIntent = new Intent();
                sendIntent.setAction(Intent.ACTION_SEND);
                sendIntent.putExtra(Intent.EXTRA_TEXT, "https://link-network.com/online-demo/");
                sendIntent.setType("text/plain");
                startActivity(sendIntent);
                break;
            case R.id.more_refer:
                Intent moreReferIntent = new Intent();
                moreReferIntent.setAction(Intent.ACTION_SEND);
                moreReferIntent.putExtra(Intent.EXTRA_TEXT, "https://link-network.com/online-demo/");
                moreReferIntent.setType("text/plain");
                startActivity(moreReferIntent);
                break;
            case R.id.refer_fb:
                Uri fb_uri = Uri.parse("http://facebook.com/");
                Intent fb = new Intent(Intent.ACTION_VIEW, fb_uri);
                fb.setPackage("com.facebook.android");

                try {
                    startActivity(fb);
                } catch (ActivityNotFoundException e) {
                    startActivity(new Intent(Intent.ACTION_VIEW,
                            Uri.parse("http://facebook.com/")));
                }
                break;

        }
    }
}