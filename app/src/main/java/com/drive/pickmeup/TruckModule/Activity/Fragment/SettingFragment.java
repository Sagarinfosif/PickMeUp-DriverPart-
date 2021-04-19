package com.drive.pickmeup.TruckModule.Activity.Fragment;

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
import com.drive.pickmeup.TruckModule.Activity.AdapterNew.SettingsAdapter;

import java.util.ArrayList;
import java.util.List;


public class SettingFragment extends Fragment {

    private View view;
    private RecyclerView recyclerView;
    private SettingsAdapter settingsAdapter;
    private TextView txtTopBar;
    private ImageView imgBack;
    private int[] images = {R.drawable.ic_baseline_navigation_24, R.drawable.ic_password, R.drawable.ic_music_application, R.drawable.ic_reading_mode, R.drawable.ic_authentication};
    private List<String> list = new ArrayList<>();


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_setting2, container, false);
        findIDs();
        clicks();
        setAdapter();
        return view;
    }

    private void setAdapter() {
        settingsAdapter = new SettingsAdapter(getActivity(),list,images, new SettingsAdapter.Click() {
            @Override
            public void onClick(int position) {
                switch (position) {
                    case 0:
                        Navigation.findNavController(view).navigate(R.id.action_settingFragment3_to_navigationFragment2);
                        break;
                    case 1:
                        Navigation.findNavController(view).navigate(R.id.action_settingFragment3_to_accessibilityFragment);
                        break;

                    case 2:
                        Navigation.findNavController(view).navigate(R.id.action_settingFragment3_to_appSoundFragment);
                        break;

                    case 3:
                        Navigation.findNavController(view).navigate(R.id.action_settingFragment3_to_screenModeFragment);
                        break;
                    case 4:
                        Navigation.findNavController(view).navigate(R.id.action_settingFragment3_to_authenticationFragment);
                        break;


                }
            }
        });
        recyclerView.setAdapter(settingsAdapter);
    }

    private void clicks() {
        imgBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getActivity().onBackPressed();
            }
        });
    }

    private void findIDs() {
        recyclerView = view.findViewById(R.id.setting_recycler);
        txtTopBar = view.findViewById(R.id.heading);
        imgBack = view.findViewById(R.id.back_topbar);
        txtTopBar.setText("Settings");
        list.add("Navigation");
        list.add("Accessibility");
        list.add("App Sound");
        list.add("Screen Mode");
        list.add("Authentication");

    }
}