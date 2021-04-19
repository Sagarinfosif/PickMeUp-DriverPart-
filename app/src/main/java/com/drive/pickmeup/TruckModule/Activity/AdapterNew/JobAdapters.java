package com.drive.pickmeup.TruckModule.Activity.AdapterNew;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.drive.pickmeup.R;

public class JobAdapters extends RecyclerView.Adapter<JobAdapters.ViewHolder> {

    Context context;
    OpenDialog openDialog;


    public JobAdapters(Context context, OpenDialog openDialog) {
        this.context = context;
        this.openDialog = openDialog;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.jobs_list, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.txt_bid_now.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openDialog.dialogOpen();
            }
        });
    }

    @Override
    public int getItemCount() {
        return 6;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView txt_bid_now;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            txt_bid_now = itemView.findViewById(R.id.txt_bid_now);
        }
    }

    public interface OpenDialog {
        void dialogOpen();
    }
}
