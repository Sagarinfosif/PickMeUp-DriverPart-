package com.drive.pickmeup.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.drive.pickmeup.R;

public class EarningAdapterList extends RecyclerView.Adapter<EarningAdapterList.ViewHolder> {
    Context context;
    private Integer[] images;
    private String[] listText;
    Select select;

    public interface Select {
        void click(int position);
    }

    public EarningAdapterList(Context context, Integer[] images, String[] listText, Select select) {
        this.context = context;
        this.images = images;
        this.listText = listText;
        this.select = select;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.list_help_menu_list, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.iv_image.setImageResource(images[position]);
        holder.tv_itemName.setText(listText[position]);

        holder.tv_itemName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                select.click(position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return listText.length;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView tv_itemName;
        private ImageView iv_image;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tv_itemName = itemView.findViewById(R.id.tv_itemName);
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
