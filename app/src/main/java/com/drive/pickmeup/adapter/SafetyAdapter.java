package com.drive.pickmeup.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.drive.pickmeup.R;

public class SafetyAdapter extends RecyclerView.Adapter<SafetyAdapter.ViewHolder> {
    Context context;
    private String[] SafetyList;
    Select select;

    public SafetyAdapter(Context context, String[] SafetyList, Select select) {
        this.context = context;
        this.SafetyList = SafetyList;
        this.select = select;
    }

    public interface Select{
        void onclick(int position);
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.safety_related_list,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.tv_itemName.setText(SafetyList[position]);
    }

    @Override
    public int getItemCount() {
        return SafetyList.length;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView tv_itemName;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tv_itemName=itemView.findViewById(R.id.tv_itemName);
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
