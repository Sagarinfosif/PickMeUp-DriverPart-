package com.drive.pickmeup.fragments;

import android.app.DatePickerDialog;
import android.os.Build;
import android.os.Bundle;

import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import com.drive.pickmeup.MyViewModel;
import com.drive.pickmeup.Pojo.CityPojo;
import com.drive.pickmeup.Pojo.StatesPojo;
import com.drive.pickmeup.R;
import com.drive.pickmeup.utils.App;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

//implements View.OnClickListener

public class RegisterFragment extends Fragment {

    private View view;
    private TextView signin, txtDateOfBirth;
    private Button btnContinue;
    private MyViewModel viewModel;
    private Switch btnSwitch;
    private TextView heading;
    private ImageView back_topbar;
    private Spinner spinCity, spinState;
    private List<CityPojo.Result> citiesList = new ArrayList<>();
    private List<String> arraySpinner = new ArrayList<>();
    private List<String> arraySpinner2 = new ArrayList<>();
    private List<StatesPojo.Result> stateList = new ArrayList<>();
    private EditText edtName, edtLastName, edtEmail, edtMobile, edtLocation, edtLicense, edtAbn, edtAddress, edtCity, edtState, edtPostalCode;
    private String mobileNumber;
    private int mYear, mMonth, mDay;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_register, container, false);
        viewModel = ViewModelProviders.of(RegisterFragment.this).get(MyViewModel.class);
        mobileNumber = App.getSingleton().getMobileNumber();
        ids();
        getStates();
        return view;
    }

    private void setStatesAdapter() {
        ArrayAdapter<String> adapter = new ArrayAdapter<>(getActivity(),
                android.R.layout.simple_spinner_item, arraySpinner);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinState.setAdapter(adapter);


        spinState.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                setCities(position);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    private void setCities(int position) {
        JsonObject data = sendStateData(position);
        viewModel.getCities(getActivity(), data).observe(getViewLifecycleOwner(), new Observer<CityPojo>() {
            @Override
            public void onChanged(CityPojo cityPojo) {
                citiesList = cityPojo.getResult();
                arraySpinner2.clear();
                for (int i = 0; i < citiesList.size(); i++) {
                    arraySpinner2.add(citiesList.get(i).getTitle());
                }
//                setCitiesAdapter();
            }
        });

    }

    private void setCitiesAdapter() {
        ArrayAdapter<String> adapter = new ArrayAdapter<>(getActivity(),
                android.R.layout.simple_spinner_item, arraySpinner2);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinCity.setAdapter(adapter);

    }

    private void getStates() {
        viewModel.getStates(getActivity()).observe(getViewLifecycleOwner(), new Observer<StatesPojo>() {
            @Override
            public void onChanged(StatesPojo statesPojo) {
                stateList = statesPojo.getResult();

                for (int i = 0; i < stateList.size(); i++) {
                    arraySpinner.add(stateList.get(i).getTitle());
                }
//                setStatesAdapter();
            }
        });
    }


    private JsonObject sendStateData(int position) {

        JsonObject gsonObject = new JsonObject();
        try {
            JSONObject jsonObj_ = new JSONObject();
            jsonObj_.put("stateId", stateList.get(position).getId());
            JsonParser jsonParser = new JsonParser();
            gsonObject = (JsonObject) jsonParser.parse(jsonObj_.toString());
            //print parameter
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return gsonObject;
    }


    private void ids() {
        edtName = view.findViewById(R.id.edt_first_name);
        edtLastName = view.findViewById(R.id.edt_last_name);
        edtEmail = view.findViewById(R.id.edt_email);
        edtMobile = view.findViewById(R.id.edt_mobile);
        txtDateOfBirth = view.findViewById(R.id.edt_dateofbirth);
        edtLicense = view.findViewById(R.id.edt_license);
        edtAbn = view.findViewById(R.id.edt_abnNo_);
        edtAddress = view.findViewById(R.id.edt_address);
        edtMobile.setText(mobileNumber);
        edtPostalCode = view.findViewById(R.id.edt_postalcode);
        heading = view.findViewById(R.id.heading);
        heading.setText("Register");
        back_topbar = view.findViewById(R.id.back_topbar);
        btnContinue = view.findViewById(R.id.btn_continue);
        edtCity=view.findViewById(R.id.edtCity);

        back_topbar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().onBackPressed();
            }
        });
        btnContinue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!edtName.getText().toString().equals("")
                        && !edtEmail.getText().toString().equals("")
                        && !edtMobile.getText().toString().equals("")
                        && !txtDateOfBirth.getText().toString().equals("")
                        && !edtLicense.getText().toString().equals("")
                        && !edtAbn.getText().toString().equals("")
                        && !edtAddress.getText().toString().equals("")
                        && !edtCity.getText().toString().equals("")
                        && !edtPostalCode.getText().toString().equals("")
                        && !edtLastName.getText().toString().equals("")
                ) {
                    Bundle bundle = new Bundle();
                    bundle.putString("name", edtName.getText().toString());
                    bundle.putString("last", edtLastName.getText().toString());
                    bundle.putString("email", edtEmail.getText().toString());
                    bundle.putString("mobilenumber", edtMobile.getText().toString());
                    bundle.putString("dateofbirth", txtDateOfBirth.getText().toString());
                    bundle.putString("licenseno", edtLicense.getText().toString());
                    bundle.putString("abnno", edtAbn.getText().toString());
                    bundle.putString("address", edtAddress.getText().toString());
                    bundle.putString("city", edtCity.getText().toString());
                    bundle.putString("postalcode", edtPostalCode.getText().toString());

                    Navigation.findNavController(view).navigate(R.id.passwordRegisterFragment, bundle);

//                Navigation.findNavController(view).navigate(R.id.passwordRegisterFragment);
                } else {
                    Toast.makeText(getActivity(), "Please fill all fields", Toast.LENGTH_SHORT).show();
                }
            }
        });


        txtDateOfBirth.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.N)
            @Override
            public void onClick(View view) {
                openDatePicker();
            }
        });

    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    private void openDatePicker() {
        DatePickerDialog datePickerDialo = new DatePickerDialog(getActivity(), new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int year,
                                  int monthOfYear, int dayOfMonth) {
                txtDateOfBirth.setText(year + "/" + (monthOfYear + 1) + "/" + dayOfMonth);
            }
        }, mYear, mMonth, mDay);
        datePickerDialo.show();
    }
}