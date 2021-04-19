package com.drive.pickmeup.TruckModule.Activity.AdapterNew;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatButton;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

import com.drive.pickmeup.R;

public class AssignedJobAdapter extends RecyclerView.Adapter<AssignedJobAdapter.ViewHolder> {

    Context context;

    public AssignedJobAdapter(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.assigned_jobs_list, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
holder.list_btn_accept.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        Navigation.findNavController(view).navigate(R.id.action_myBidsFragment_to_inProgressBidFragment);
    }
});
    }

    @Override
    public int getItemCount() {
        return 4;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        AppCompatButton list_btn_accept;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            list_btn_accept=itemView.findViewById(R.id.list_btn_accept);
        }
    }
}
