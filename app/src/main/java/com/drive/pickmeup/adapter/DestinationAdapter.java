package com.drive.pickmeup.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.drive.pickmeup.R;

public class DestinationAdapter extends RecyclerView.Adapter<DestinationAdapter.ViewHolder> {
    Context context;
    Select select;

    public DestinationAdapter(Context context, Select select) {
        this.context = context;
        this.select = select;
    }

    public interface Select {
        void clickDestination(int position);
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.destination_list, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.ll_destination.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                select.clickDestination(position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return 3;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private LinearLayout ll_destination;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ll_destination = itemView.findViewById(R.id.ll_destination);
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
