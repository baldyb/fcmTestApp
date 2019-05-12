package com.kernowdev.fcmApp;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class ItemAdapter extends RecyclerView.Adapter<ItemAdapter.ViewHolder> {

    private ItemData[] data;

    public ItemAdapter(ItemData[] data) {
        this.data = data;
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View listItem= layoutInflater.inflate(R.layout.list_item, parent, false);
        ViewHolder viewHolder = new ViewHolder(listItem);
        return viewHolder;
    }


    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.textView.setText(data[position].getNotificationText());
        holder.notificationDateView.setText(data[position].getNotificationDate());
    }

    @Override
    public int getItemCount() {
        return data.length;
    }


    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView notificationDateView;
        public TextView textView;
        public ViewHolder(View itemView) {
            super(itemView);
            this.notificationDateView = (TextView) itemView.findViewById(R.id.notificationDateView);
            this.textView = (TextView) itemView.findViewById(R.id.textView);
        }
    }
}
