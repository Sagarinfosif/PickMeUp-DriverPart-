package com.drive.pickmeup.fragments.help;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.drive.pickmeup.R;

public class VehicleDocumentAdapter extends RecyclerView.Adapter<VehicleDocumentAdapter.ViewHolder> {
    Context context;
    private String[] documentsList;
    Select select;

    public VehicleDocumentAdapter(Context context, String[] documentsList, Select select) {
        this.context = context;
        this.documentsList = documentsList;
        this.select = select;
    }

    public interface Select{
        void onclick(int position);
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.document_list,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
    holder.tv_itemName.setText(documentsList[position]);
    holder.ll_document_list.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            select.onclick(position);
        }
    });
    }

    @Override
    public int getItemCount() {
        return documentsList.length;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView tv_itemName;
        private LinearLayout ll_document_list;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tv_itemName=itemView.findViewById(R.id.tv_itemName);
            ll_document_list=itemView.findViewById(R.id.ll_list);
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
