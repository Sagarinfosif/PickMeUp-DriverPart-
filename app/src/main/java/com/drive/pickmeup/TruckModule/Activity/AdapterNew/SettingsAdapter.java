package com.drive.pickmeup.TruckModule.Activity.AdapterNew;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.drive.pickmeup.R;

import java.util.ArrayList;
import java.util.List;

public class SettingsAdapter extends RecyclerView.Adapter<SettingsAdapter.ViewHolder> {

    private Context context;
    private List<String> list = new ArrayList<>();
    int images[];
    private Click click;

    public SettingsAdapter(Context context, List<String> list, int[] images, Click click) {
        this.context = context;
        this.list = list;
        this.images = images;
        this.click = click;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.settings_list, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {


        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                click.onClick(position);
            }
        });

        holder.txtSettings.setText(list.get(position));
        holder.imgProfile.setImageResource(images[position]);


    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView txtSettings;
        ImageView imgProfile;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            txtSettings = itemView.findViewById(R.id.txt_settings);
            imgProfile = itemView.findViewById(R.id.img_setting);
        }
    }

    public interface Click {
        void onClick(int position);
    }
}
