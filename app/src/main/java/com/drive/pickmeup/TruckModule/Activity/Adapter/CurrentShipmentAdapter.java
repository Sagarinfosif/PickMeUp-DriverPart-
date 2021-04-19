package com.drive.pickmeup.TruckModule.Activity.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

import com.drive.pickmeup.R;

public class CurrentShipmentAdapter extends RecyclerView.Adapter<CurrentShipmentAdapter.Viewholder> {

    Context context;
Click click;

    public CurrentShipmentAdapter(Context context, Click click) {
        this.context = context;
        this.click = click;
    }

    @NonNull
    @Override
    public Viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view=LayoutInflater.from(parent.getContext()).inflate(R.layout.item_currentshipment, parent, false);

        return new Viewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Viewholder holder, int position) {

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Navigation.findNavController(view).navigate(R.id.action_currentShipmentFragment_to_shipmentdetailFragment);
            }
        });

    }

    @Override
    public int getItemCount() {
        return 7;
    }

    public class Viewholder extends RecyclerView.ViewHolder {
        public Viewholder(@NonNull View itemView) {
            super(itemView);
        }
    }


    public interface Click{
        void onClick(int position);
    }
}
