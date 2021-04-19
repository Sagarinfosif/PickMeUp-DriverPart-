package com.drive.pickmeup.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.drive.pickmeup.R;

public class AllDocumentsAdapter extends RecyclerView.Adapter<AllDocumentsAdapter.ViewHolder> {
    Context context;
    String[] allDocumentList;
    Select select;

    private int checkedPosition = 0;

    public interface Select {
        void onclick(int position);
    }

    public AllDocumentsAdapter(Context context, String[] allDocumentList,Select select) {
        this.context = context;
        this.select=select;
        this.allDocumentList = allDocumentList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.all_documents_vehicle_list, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.tv_itemName.setText(allDocumentList[position]);
        holder.rl_list.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                select.onclick(position);
                checkedPosition = position;
                notifyDataSetChanged();
            }
        });
        if (checkedPosition == position) {
            holder.rl_list.setBackgroundResource(R.drawable.bg_selected);
            holder.iv_image.setImageResource(R.drawable.ic_upload_check);
//            Toast.makeText(context, "Vehicle Selected Successfully", Toast.LENGTH_SHORT).show();
        } else {
            holder.rl_list.setBackgroundResource(R.drawable.unselect_red_back);
            holder.iv_image.setImageResource(R.drawable.ic_cancel_red);
        }

    }

    @Override
    public int getItemCount() {
        return allDocumentList.length;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView tv_itemName;
        private RelativeLayout rl_list;
        private ImageView iv_image;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tv_itemName = itemView.findViewById(R.id.tv_itemName);
            rl_list = itemView.findViewById(R.id.rl_list);
            iv_image = itemView.findViewById(R.id.iv_image);
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
