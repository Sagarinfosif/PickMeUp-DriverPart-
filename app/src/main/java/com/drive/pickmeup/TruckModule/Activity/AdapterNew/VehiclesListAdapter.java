package com.drive.pickmeup.TruckModule.Activity.AdapterNew;

import android.content.Context;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.cardview.widget.CardView;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.drive.pickmeup.R;

public class VehiclesListAdapter extends RecyclerView.Adapter<VehiclesListAdapter.ViewHolder> {

    Context context;
    int pos;

    public VehiclesListAdapter(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.vechiles_list, parent, false);

        return new ViewHolder(view);
    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pos = position;
                notifyDataSetChanged();

            }
        });

        if (pos == position) {
            holder.relativeLayout.setBackgroundColor(context.getResources().getColor(R.color.black));
            holder.cardView.setCardBackgroundColor(context.getResources().getColor(R.color.black));
            holder.imgVehicles.setImageTintList(context.getColorStateList(R.color.white));
            holder.txtVehiclesTitle.setTextColor(context.getColorStateList(R.color.white));
        } else {
            holder.cardView.setCardBackgroundColor(ContextCompat.getColor(context, R.color.white));
            holder.relativeLayout.setBackgroundColor(context.getResources().getColor(R.color.white));
            holder.imgVehicles.setImageTintList(context.getColorStateList(R.color.black));
            holder.txtVehiclesTitle.setTextColor(context.getColorStateList(R.color.black));
        }
    }

    @Override
    public int getItemCount() {
        return 10;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        CardView cardView;
        RelativeLayout relativeLayout;
        ImageView imgVehicles;
        TextView txtVehiclesTitle;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            cardView = itemView.findViewById(R.id.card_vehicles);
            relativeLayout = itemView.findViewById(R.id.relativeLayout);
            imgVehicles=itemView.findViewById(R.id.img_vehicle);
            txtVehiclesTitle=itemView.findViewById(R.id.txt_vehicle_title);
        }
    }
}
