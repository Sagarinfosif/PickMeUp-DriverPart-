package com.drive.pickmeup.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.drive.pickmeup.R;

public class AccountAndPaymentAdapter extends RecyclerView.Adapter<AccountAndPaymentAdapter.ViewHolder> {

    Context context;
    private String[] account_paymentList;
    Select select;

    public interface Select {
        void onclick(int position);
    }

    public AccountAndPaymentAdapter(Context context, String[] account_paymentList, Select select) {
        this.context = context;
        this.account_paymentList = account_paymentList;
        this.select = select;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.list_help_menu_list,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        holder.tv_itemName.setText(account_paymentList[position]);
        holder.tv_itemName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                select.onclick(position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return account_paymentList.length;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView tv_itemName;
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
