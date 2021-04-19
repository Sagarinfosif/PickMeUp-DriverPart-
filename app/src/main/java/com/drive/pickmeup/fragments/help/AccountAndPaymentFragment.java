package com.drive.pickmeup.fragments.help;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.drive.pickmeup.R;
import com.drive.pickmeup.adapter.AccountAndPaymentAdapter;

public class AccountAndPaymentFragment extends Fragment implements View.OnClickListener {

    private View view;
    private TextView tv_text_title, heading;
    private String[] account_paymentList = {"I can't Sign in or Go Online", "Changing Account Setting", "Updating Vehicle & Documents", "Improving Rating", "Getting Paid", "fares", "Promotions", "Wallets", "Refferals", "Delete my Account"};
    private ImageView back_topbar;
    private RecyclerView rv_account_payment;
    private AccountAndPaymentAdapter accountAndPaymentAdapter;


    public AccountAndPaymentFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_account_and_payment, container, false);
        ids();
        setup();
        setadapter();
        return view;
    }

    private void setadapter() {
        accountAndPaymentAdapter = new AccountAndPaymentAdapter(getActivity(), account_paymentList, new AccountAndPaymentAdapter.Select() {
            @Override
            public void onclick(int position) {
                switch (position) {
                    case 0:

                        break;
                    case 1:

                        break;
                    case 2:

                        break;
                    case 3:

                        break;
                    case 4:

                        break;
                    case 5:

                        break;
                    case 6:

                        break;
                    case 7:

                        break;
                    case 8:

                        break;
                    case 9:

                        break;
                }
            }
        });
        rv_account_payment.setAdapter(accountAndPaymentAdapter);
    }

    private void setup() {
        heading.setText("Help");
        back_topbar.setOnClickListener(this);
        Bundle bundle = getArguments();
        tv_text_title.setText(bundle.getString("account_payment"));
    }

    private void ids() {
        tv_text_title = view.findViewById(R.id.tv_text_title);
        heading = view.findViewById(R.id.heading);
        back_topbar = view.findViewById(R.id.back_topbar);
        rv_account_payment = view.findViewById(R.id.rv_account_payment);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.back_topbar:
                getActivity().onBackPressed();
                break;
        }
    }
}