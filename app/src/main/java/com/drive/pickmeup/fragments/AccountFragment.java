package com.drive.pickmeup.fragments;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;

import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.drive.pickmeup.R;

public class AccountFragment extends Fragment implements View.OnClickListener {

    private View view;
    private TextView heading,tv_documents,tv_abn;
    private ImageView back_topbar;
    private Button submit;

    public AccountFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view= inflater.inflate(R.layout.fragment_account, container, false);
        ids();
        setup();
        return view;
    }

    private void setup() {
        heading.setText("Account");
        back_topbar.setOnClickListener(this);
        tv_documents.setOnClickListener(this);
        tv_abn.setOnClickListener(this);
    }

    private void ids() {
        tv_abn=view.findViewById(R.id.tv_abn);
        back_topbar=view.findViewById(R.id.back_topbar);
        tv_documents=view.findViewById(R.id.tv_documents);
        heading=view.findViewById(R.id.heading);
        submit=view.findViewById(R.id.submit_abn);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.back_topbar:
                getActivity().onBackPressed();
                break;
                case R.id.tv_documents:
                    Navigation.findNavController(view).navigate(R.id.action_accountFragment_to_completeDocumentFragment);
                break;
                case R.id.tv_abn:
                    final AlertDialog.Builder dialogBuilder1 = new AlertDialog.Builder(getActivity());
                    LayoutInflater inflater = getLayoutInflater();
                    final View dialogView = inflater.inflate(R.layout.abn_alert, null);
                    dialogBuilder1.setView(dialogView);
                    final AlertDialog alertDialog1 = dialogBuilder1.create();
                    submit = dialogView.findViewById(R.id.submit_abn);
                    alertDialog1.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                    alertDialog1.show();
                    submit.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            alertDialog1.dismiss();
                            Toast.makeText(getActivity(), "Upload Successfully", Toast.LENGTH_SHORT).show();
                        }
                    });
                break;
        }
    }
}