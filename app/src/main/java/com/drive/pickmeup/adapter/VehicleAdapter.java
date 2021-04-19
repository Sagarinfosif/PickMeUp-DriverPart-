package com.drive.pickmeup.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.drive.pickmeup.R;


public class VehicleAdapter extends RecyclerView.Adapter<VehicleAdapter.ViewHolder> {
    Context context;

    private int checkedPosition = 0;

    public VehicleAdapter(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.vehicle, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checkedPosition = position;
                notifyDataSetChanged();
            }
        });

        if (checkedPosition == position) {
            holder.vehicle_select.setBackgroundResource(R.drawable.bg_selected);
//            Toast.makeText(context, "Vehicle Selected Successfully", Toast.LENGTH_SHORT).show();
        } else {
            holder.vehicle_select.setBackgroundColor(context.getResources().getColor(R.color.white));
        }

    }

    @Override
    public int getItemCount() {
        return 2;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private RelativeLayout vehicle_select;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            vehicle_select = itemView.findViewById(R.id.vehicle_select);
        }
    }

    @Override
    public int getItemViewType(int position) {
        return (position);
    }

    @Override
    public long getItemId(int position) {
        return (position);
    }
}
