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


public class Adapter_HelpMenu extends RecyclerView.Adapter<Adapter_HelpMenu.ViewHolder> {


    private Context context;
    private String[] listText;
    private int[] imagesList;
    private Select select;


    public Adapter_HelpMenu(Context context, String[] listText, int[] imagesList, Select select) {
        this.context = context;
        this.listText = listText;
        this.imagesList = imagesList;
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

        holder.tv_itemName.setText(listText[position]);
        holder.iv_image.setImageResource(imagesList[position]);

        holder.tv_itemName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                select.onCLick(position);
            }
        });


    }

    @Override
    public int getItemCount() {
        return listText.length;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView tv_itemName;
        ImageView iv_image;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            tv_itemName = itemView.findViewById(R.id.tv_itemName);
            iv_image = itemView.findViewById(R.id.iv_image);

        }
    }


    public interface Select {
        void onCLick(int pos);
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
