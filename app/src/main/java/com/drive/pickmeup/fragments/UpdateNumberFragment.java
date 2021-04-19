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
import android.widget.Toast;

import com.drive.pickmeup.MyViewModel;
import com.drive.pickmeup.Pojo.RegisterPojo;
import com.drive.pickmeup.R;
import com.drive.pickmeup.utils.App;
import com.drive.pickmeup.utils.AppConstants;
import com.hbb20.CountryCodePicker;


public class UpdateNumberFragment extends Fragment implements View.OnClickListener {
    private View view;
    private TextView heading;
    private Button save_number;
    private ImageView back_topbar;
    private MyViewModel viewModel;
    private CountryCodePicker countryCodePicker;
    private EditText mobile;

    public UpdateNumberFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_update_number, container, false);
        viewModel = ViewModelProviders.of(UpdateNumberFragment.this).get(MyViewModel.class);
        ids();
        setup();
        return view;
    }

    private void setup() {
        heading.setText("Update Number");
        save_number.setOnClickListener(this);
        back_topbar.setOnClickListener(this);

    }

    private void ids() {
        heading = view.findViewById(R.id.heading);
        save_number = view.findViewById(R.id.save_number);
        back_topbar = view.findViewById(R.id.back_topbar);
        countryCodePicker = view.findViewById(R.id.ccp);
        mobile = view.findViewById(R.id.edt_mobile);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.save_number:
                hitApi();

                break;
            case R.id.back_topbar:
                getActivity().onBackPressed();
//                Navigation.findNavController(view).navigate(R.id.action_updateNumberFragment_to_confirmNumberOtpFragment);
                break;
        }
    }

    private void hitApi() {
        String userId = App.getSharedpref().getString(AppConstants.USER_ID);
        viewModel.updatePhoneNumber(getActivity(), userId, countryCodePicker.getSelectedCountryCode(), mobile.getText().toString()).observe(getViewLifecycleOwner(), new Observer<RegisterPojo>() {
            @Override
            public void onChanged(RegisterPojo registerPojo) {
                if (registerPojo.getSuccess().equalsIgnoreCase("1")) {
                    App.getSharedpref().saveModel(AppConstants.LOGIN_DETAIL, registerPojo);
                    Navigation.findNavController(view).navigate(R.id.action_updateNumberFragment_to_confirmNumberOtpFragment);
                } else {
                    Toast.makeText(getActivity(), registerPojo.getMessage(), Toast.LENGTH_SHORT).show();
                }

            }
        });
    }
}