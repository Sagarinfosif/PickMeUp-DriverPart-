package com.drive.pickmeup.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.drive.pickmeup.R;

public class TripSettingDestinationAdapter extends RecyclerView.Adapter<TripSettingDestinationAdapter.ViewHolder> {
    Context context;
    Select select;

    public interface  Select{
        void onclick(int position);
    }


    public TripSettingDestinationAdapter(Context context, Select select) {
        this.context = context;
        this.select = select;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
       View view= LayoutInflater.from(context).inflate(R.layout.destination_list_items,parent,false);
       return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
    holder.rl_location.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            select.onclick(position);
        }
    });
    }

    @Override
    public int getItemCount() {
        return 2;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private RelativeLayout rl_location;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            rl_location=itemView.findViewById(R.id.rl_location);
        }
    }
}
