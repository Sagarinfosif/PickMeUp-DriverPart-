package com.drive.pickmeup;

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

import com.drive.pickmeup.ModelClass.UserRegisterModel;
import com.drive.pickmeup.Pojo.RegisterationPojo;
import com.drive.pickmeup.utils.App;
import com.drive.pickmeup.utils.AppConstants;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import org.json.JSONException;
import org.json.JSONObject;


public class PasswordRegisterFragment extends Fragment {

    View view;
    TextView heading;
    ImageView back;
    Button btnContinue;
    MyViewModel viewModel;
    EditText password, confirmPassword;

    public PasswordRegisterFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_password_register, container, false);
        viewModel = ViewModelProviders.of(PasswordRegisterFragment.this).get(MyViewModel.class);
        findIds();
        return view;
    }

    private void findIds() {
        heading = view.findViewById(R.id.heading);
        back = view.findViewById(R.id.back_topbar);
        heading.setText("Create Password");
        btnContinue = view.findViewById(R.id.btn_continue);
        password = view.findViewById(R.id.edt_password);
        confirmPassword = view.findViewById(R.id.edt_confirm_password);


        btnContinue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {



                if (password.getText().toString().equalsIgnoreCase(confirmPassword.getText().toString())) {

                    JsonObject data = ApiJsonMap();
                    viewModel.registration(getActivity(), data).observe(getViewLifecycleOwner(), new Observer<UserRegisterModel>() {
                        @Override
                        public void onChanged(UserRegisterModel registerationPojo) {
                            if (registerationPojo.getStatus().equals(true)) {
                                App.getSharedpref().saveModel(AppConstants.LOGIN_DETAIL,registerationPojo.getResult());
                                App.getSharedpref().saveString("token",registerationPojo.getResult().getToken());
                                Toast.makeText(getActivity(), registerationPojo.getMessage(), Toast.LENGTH_SHORT).show();
                                Navigation.findNavController(view).navigate(R.id.action_passwordRegisterFragment_to_congoFragment);
                            } else {
                                Toast.makeText(getActivity(), "Something went wrong", Toast.LENGTH_SHORT).show();
                            }
                        }
                    });

                } else {
                    Toast.makeText(getActivity(), "Password not matched", Toast.LENGTH_SHORT).show();
                }
            }
        });

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().onBackPressed();
            }
        });
    }


    private JsonObject ApiJsonMap() {

        JsonObject gsonObject = new JsonObject();
        try {
            JSONObject jsonObj_ = new JSONObject();
            jsonObj_.put("firstName", getArguments().get("name").toString());
            jsonObj_.put("lastName", getArguments().get("last").toString());
            jsonObj_.put("email", getArguments().get("email").toString());
            jsonObj_.put("phone", getArguments().get("mobilenumber").toString());
            jsonObj_.put("dob", getArguments().get("dateofbirth").toString());
//            jsonObj_.put("password", password.getText().toString());
//            jsonObj_.put("location", getArguments().get("location").toString());
            jsonObj_.put("licenseNo", getArguments().get("licenseno").toString());
            jsonObj_.put("abn_no", getArguments().get("abnno").toString());
            jsonObj_.put("address", getArguments().get("address").toString());
            jsonObj_.put("city", getArguments().get("city").toString());
//            jsonObj_.put("stateId", "1");
            jsonObj_.put("postalCode", getArguments().get("postalcode").toString());

            jsonObj_.put("vehcleType", "");
            jsonObj_.put("password", password.getText().toString());
//            jsonObj_.put("device_type", "android");
//            jsonObj_.put("device_id", getArguments().get("mobilenumber").toString());
            jsonObj_.put("reg_id", "jqfqjf");
            jsonObj_.put("login_type", "normal");
            jsonObj_.put("device_type", "android");

            JsonParser jsonParser = new JsonParser();
            gsonObject = (JsonObject) jsonParser.parse(jsonObj_.toString());

            //print parameter


        } catch (JSONException e) {
            e.printStackTrace();
        }

        return gsonObject;
    }
}