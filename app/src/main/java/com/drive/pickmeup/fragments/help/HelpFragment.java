package com.drive.pickmeup.fragments.help;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

import com.drive.pickmeup.R;
import com.drive.pickmeup.adapter.Adapter_HelpMenu;
import com.drive.pickmeup.adapter.DestinationAdapter;


public class HelpFragment extends Fragment implements View.OnClickListener {

    private View view;
    private TextView heading;
    private int[] images = {R.drawable.ic_shield_1, R.drawable.ic_help_destination, R.drawable.ic_i_button,
            R.drawable.ic_user, R.drawable.ic_document, R.drawable.ic_document, R.drawable.ic_track, R.drawable.ic_list_help};
    private String[] listText = {"Safety Related", "Trip Issue and Adjustment", "Using the App", "Account and Payment", "Uploading Documents", "Updating Account Information", "Tracking Acceptance and Cancellation Rate", "More"};
    private Adapter_HelpMenu adapter_helpMenu;
    private LinearLayout trip_detail_list;
    private RecyclerView rv_helpMenu;

    private DestinationAdapter destinationAdapter;

    public HelpFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_help, container, false);

        findIds();
        setAdapter();
        return view;
    }


    private void setAdapter() {

        adapter_helpMenu = new Adapter_HelpMenu(getActivity(), listText, images, new Adapter_HelpMenu.Select() {
            @Override
            public void onCLick(int pos) {
                switch (pos) {
                    case 0:
                        Navigation.findNavController(view).navigate(R.id.action_helpFragment_to_safetyRelatedFragment);
                        break;
                    case 1:
                        Bundle bundle = new Bundle();
                        bundle.putString("trip_issue", "Trip Issue and Adjustment");
                        Navigation.findNavController(view).navigate(R.id.action_helpFragment_to_tripIssueandAdjustmentFragment,bundle);
                        break;
                    case 2:
                        Bundle bundle1 = new Bundle();
                        bundle1.putString("using_app", "Using The App");
                        Navigation.findNavController(view).navigate(R.id.action_helpFragment_to_usingTheAppFragment,bundle1);
                        break;
                    case 3:
                        Bundle bundle2=new Bundle();
                        bundle2.putString("account_payment","Account & Payment");
                        Navigation.findNavController(view).navigate(R.id.action_helpFragment_to_accountAndPaymentFragment,bundle2);
                        break;
                    case 4:
                        Bundle bundle5=new Bundle();
                        bundle5.putString("upload_document","Uploading Documents");
                        Navigation.findNavController(view).navigate(R.id.action_helpFragment_to_uploadingDocumentFragment,bundle5);
                        break;
                    case 5:
                        Bundle bundle6=new Bundle();
                        bundle6.putString("account_info","Updating Account Information");
                        Navigation.findNavController(view).navigate(R.id.action_helpFragment_to_updatingAccountFragment,bundle6);
                        break;
                    case 6:
                        Bundle bundle4=new Bundle();
                        bundle4.putString("acceptance","Tracking Acceptance and Cancellation Rate");
                        Navigation.findNavController(view).navigate(R.id.action_helpFragment_to_trackingAndCancelFragment,bundle4);
                        break;
                    case 7:
                        Bundle bundle3=new Bundle();
                        bundle3.putString("more_help","More");
                        Navigation.findNavController(view).navigate(R.id.action_helpFragment_to_moreHelpFragment,bundle3);
                        break;
                }
            }
        });
        rv_helpMenu.setAdapter(adapter_helpMenu);


    }

    private void findIds() {

        rv_helpMenu = view.findViewById(R.id.rv_helpMenu);
        trip_detail_list = view.findViewById(R.id.trip_detail_list);
        heading = view.findViewById(R.id.heading);
        heading.setText(getString(R.string.help3));
        view.findViewById(R.id.back_topbar).setOnClickListener(this);
        view.findViewById(R.id.trip_detail_list).setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {

        switch (view.getId()) {
            case R.id.back_topbar:
                getActivity().onBackPressed();
                break;
            case R.id.trip_detail_list:
                Navigation.findNavController(view).navigate(R.id.action_helpFragment_to_allTripFragment);
                break;
        }
    }
}