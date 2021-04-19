package com.drive.pickmeup.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.drive.pickmeup.MyViewModel;
import com.drive.pickmeup.Pojo.RegisterPojo;
import com.drive.pickmeup.R;
import com.drive.pickmeup.utils.App;
import com.drive.pickmeup.utils.AppConstants;

public class UpdateEmailFragment extends Fragment implements View.OnClickListener {

    private View view;
    private TextView heading;
    private Button save_email;
    private ImageView back_topbar;
private MyViewModel viewModel;
private  String userId;
private EditText email;
    public UpdateEmailFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view= inflater.inflate(R.layout.fragment_update_email, container, false);
        viewModel= ViewModelProviders.of(UpdateEmailFragment.this).get(MyViewModel.class);
         userId= App.getSharedpref().getString(AppConstants.USER_ID);
        ids();
        setup();
        return view;
    }
    private void setup() {
        save_email.setOnClickListener(this);
        back_topbar.setOnClickListener(this);
        heading.setText("Update Email");
    }

    private void ids() {
        save_email=view.findViewById(R.id.save_email);
        heading=view.findViewById(R.id.heading);
        back_topbar=view.findViewById(R.id.back_topbar);
        email=view.findViewById(R.id.ed_email_update);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.save_email:
                updateEmail();
                break;

                case R.id.back_topbar:
                getActivity().onBackPressed();
                break;
        }
    }

    private void updateEmail() {
        viewModel.updateEmail(getActivity(),userId,email.getText().toString()).observe(getViewLifecycleOwner(), new Observer<RegisterPojo>() {
            @Override
            public void onChanged(RegisterPojo registerPojo) {
                if(registerPojo.getSuccess().equalsIgnoreCase("1")){
                    Navigation.findNavController(view).navigate(R.id.action_updateEmailFragment_to_confirmNumberOtpFragment);
                }
            }
        });
    }
}