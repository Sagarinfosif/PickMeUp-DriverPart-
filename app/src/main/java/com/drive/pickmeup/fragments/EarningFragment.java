package com.drive.pickmeup.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.drive.pickmeup.R;
import com.drive.pickmeup.adapter.EarningAdapterList;

public class EarningFragment extends Fragment implements View.OnClickListener {

    private View view;
    private RecyclerView rv_earning_menu;
    private TextView heading;
    private ImageView back_topbar;
    private Integer[] images = {R.drawable.ic_money, R.drawable.ic_sports_car, R.drawable.ic_giftbox, R.drawable.ic_bank,R.drawable.ic_invite};
    private String[] listText = {"My Balance", "My Trips", "Rewards", "Bank Information","Refer Rewards"};
    private EarningAdapterList earningAdapterList;

    public EarningFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_earning, container, false);

        ids();
        setup();
        setAdapter();
        return view;
    }

    private void setAdapter() {
        earningAdapterList = new EarningAdapterList(getActivity(), images, listText, new EarningAdapterList.Select() {
            @Override
            public void click(int position) {
                switch (position) {
                    case 0:
                        Navigation.findNavController(view).navigate(R.id.action_earningFragment_to_balanceFragment);
                         break;
                    case 1:
                        Navigation.findNavController(view).navigate(R.id.action_earningFragment_to_allTripFragment);
                        break;
                    case 2:
                        Navigation.findNavController(view).navigate(R.id.action_earningFragment_to_rewardTabFragment);
                        break;
                    case 3:
                        Navigation.findNavController(view).navigate(R.id.action_earningFragment_to_accountDetailFragment);
                        break;
                        case 4:
//                            Toast.makeText(getActivity(), "Under Development", Toast.LENGTH_SHORT).show();
                        Navigation.findNavController(view).navigate(R.id.action_earningFragment_to_referRewardFragment);
                        break;
                }
            }
        });
            rv_earning_menu.setAdapter(earningAdapterList);
    }

    private void setup() {
        heading.setText("Earning");
        back_topbar.setOnClickListener(this);
    }

    private void ids() {
        rv_earning_menu = view.findViewById(R.id.rv_earning_menu);
        heading = view.findViewById(R.id.heading);
        back_topbar = view.findViewById(R.id.back_topbar);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.back_topbar:
                getActivity().onBackPressed();
                break;
        }
    }
}