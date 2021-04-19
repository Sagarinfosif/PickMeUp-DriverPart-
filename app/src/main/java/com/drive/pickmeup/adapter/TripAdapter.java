package com.drive.pickmeup.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.drive.pickmeup.R;

public class TripAdapter extends RecyclerView.Adapter<TripAdapter.ViewHolder> {
    Context context;
    Select select;

    public interface Select{
        void Position(int position);
        void clikHelp(int position);
    }

    public TripAdapter(Context context, Select select) {
        this.context = context;
        this.select = select;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.trip,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.helpBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                select.clikHelp(position);
            }
        });
        holder.trip_detail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                select.Position(position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return 3;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        LinearLayout trip_detail;
        ImageView helpBtn;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            trip_detail=itemView.findViewById(R.id.trip_detail);
            helpBtn=itemView.findViewById(R.id.helpBtn);
        }
    }
}
