package com.drive.pickmeup.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.drive.pickmeup.OnSwipeTouchListener;
import com.drive.pickmeup.R;

import java.util.ArrayList;

public class InboxAdapter extends RecyclerView.Adapter<InboxAdapter.ViewHolder> {

    ArrayList<String> inbox;
    Context context;

    public InboxAdapter(ArrayList<String> inbox, Context context) {
        this.inbox = inbox;
        this.context = context;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public int getItemViewType(int position) {
        return position;
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.inbox_list, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        ViewHolder myviewholder=(ViewHolder)holder;
        myviewholder.tvSwipNotification.setText(inbox.get(position));
        holder.itemView.setOnTouchListener(new OnSwipeTouchListener(context) {
            public void onSwipeRight() {
                inbox.remove(position);
                notifyItemRemoved(position);
                notifyItemRangeChanged(position, inbox.size());
                Toast.makeText(context, "Remove Successfully", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return inbox.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView tvSwipNotification;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvSwipNotification = itemView.findViewById(R.id.tvSwipNotification);
        }
    }
}
