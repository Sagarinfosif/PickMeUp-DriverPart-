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

public class MyVehiclesAdapter extends RecyclerView.Adapter<MyVehiclesAdapter.ViewHolder> {

    Context context;

    public MyVehiclesAdapter(Context context) {

        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.vehicles_list, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.btnSeeMore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
Navigation.findNavController(view).navigate(R.id.action_myVehiclesFragment_to_vehiclesDetailFragment);
            }
        });
    }

    @Override
    public int getItemCount() {
        return 10;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        AppCompatButton btnSeeMore;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            btnSeeMore = itemView.findViewById(R.id.btn_see_more);
        }
    }
}
