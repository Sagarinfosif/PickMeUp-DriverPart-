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
import com.drive.pickmeup.R;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.hbb20.CountryCodePicker;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.Map;


public class RegisterPhoneFragment extends Fragment {

    private View view;
    private TextView heading;
    private ImageView back_topbar;
    private Button next;
    private EditText edtMobile;
    private MyViewModel viewModel;
    private CountryCodePicker countryCodePicker;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_register_phone, container, false);
        viewModel = ViewModelProviders.of(RegisterPhoneFragment.this).get(MyViewModel.class);
        findIds();
        clicks();
        return view;
    }

    private void clicks() {
        back_topbar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().onBackPressed();
            }
        });
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String mobil=edtMobile.getText().toString();
                if (mobil.isEmpty()){
                    edtMobile.setError("Enter Mobile number");
                }
                else {
                    hitApi();

                }

//                Navigation.findNavController(view).navigate(R.id.action_registerPhoneFragment_to_otpFragment);
            }
        });
    }

    private void hitApi() {
        JsonObject data = ApiJsonMap();
        viewModel.phoneRegister(getActivity(), data).observe(getActivity(), new Observer<Map>() {
            @Override
            public void onChanged(Map map) {
                if (map.get("status").equals(true)) {
                    Toast.makeText(getActivity(), ""+map.get("message"), Toast.LENGTH_SHORT).show();
                    Bundle bundle = new Bundle();
                    bundle.putString("otp", map.get("result").toString());
                    bundle.putString("phone", countryCodePicker.getSelectedCountryCode() + edtMobile.getText().toString());
                    Toast.makeText(getActivity(), map.get("result").toString(), Toast.LENGTH_SHORT).show();
                    Navigation.findNavController(view).navigate(R.id.action_registerPhoneFragment_to_otpFragment, bundle);
                }
                else {
                    Toast.makeText(getActivity(), ""+map.get("result"), Toast.LENGTH_SHORT).show();
                }
            }
        });


    }

    private JsonObject ApiJsonMap() {

        JsonObject gsonObject = new JsonObject();
        try {
            JSONObject jsonObj_ = new JSONObject();
            jsonObj_.put("phone", countryCodePicker.getSelectedCountryCode() + edtMobile.getText().toString());


            JsonParser jsonParser = new JsonParser();
            gsonObject = (JsonObject) jsonParser.parse(jsonObj_.toString());
            //print parameter
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return gsonObject;
    }


    private void findIds() {
        heading = view.findViewById(R.id.heading);
        heading.setText("Register");
        back_topbar = view.findViewById(R.id.back_topbar);
        next = view.findViewById(R.id.btn_next);
        countryCodePicker = view.findViewById(R.id.ccp);
        edtMobile = view.findViewById(R.id.edt_mobile);
    }
}