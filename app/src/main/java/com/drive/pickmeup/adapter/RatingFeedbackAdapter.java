package com.drive.pickmeup.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.drive.pickmeup.R;

public class RatingFeedbackAdapter extends RecyclerView.Adapter<RatingFeedbackAdapter.ViewHolder> {

    Context context;
    private String[] feedback;


    private int checkedPosition = -1;

    public RatingFeedbackAdapter(Context context, String[] feedback) {
        this.context = context;
        this.feedback = feedback;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.rating_list_feedback,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.text_feed.setText(feedback[position]);

        holder.text_feed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checkedPosition = position;
                notifyDataSetChanged();
            }
        });

        if (checkedPosition == position) {
            holder.text_feed.setBackgroundResource(R.drawable.lightgreen_button_back);
            Toast.makeText(context, "Select Successfully", Toast.LENGTH_SHORT).show();
        } else {
            holder.text_feed.setBackgroundResource(R.drawable.outline);

        }
    }

    @Override
    public int getItemCount() {
        return feedback.length;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView text_feed;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            text_feed=itemView.findViewById(R.id.text_feed);
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
