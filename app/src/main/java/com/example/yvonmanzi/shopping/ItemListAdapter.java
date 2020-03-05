package com.example.yvonmanzi.shopping;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.LinkedList;

public class ItemListAdapter extends RecyclerView.Adapter<ItemListAdapter.ItemViewHolder> {
    private LayoutInflater mInflater;
    private final LinkedList<String> mItemList;


    public ItemListAdapter(Context context, LinkedList<String> itemList){
        mInflater = LayoutInflater.from(context);
        this.mItemList = itemList;
    }

    @NonNull
    @Override
    public ItemListAdapter.ItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View mItemView = mInflater.inflate(R.layout.shopping_item, parent, false);
        return new ItemViewHolder(mItemView, this);
    }

    @Override
    public void onBindViewHolder(@NonNull ItemListAdapter.ItemViewHolder holder, int position) {
        String currentItem = mItemList.get(position);
        holder.itemView.setText(currentItem);

    }

    @Override
    public int getItemCount() {
        return mItemList.size();
    }
    public class ItemViewHolder extends RecyclerView.ViewHolder{
        public final TextView itemView;
        public final ItemListAdapter adapter;

        public ItemViewHolder(View itemView, ItemListAdapter adapter) {
            super(itemView);
            this.adapter = adapter;
            this.itemView = itemView.findViewById(R.id.item);
            this.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    CommonItemsActivity o = new CommonItemsActivity();
                    int position = getLayoutPosition();
                    o.sendExtra(position, mItemList);

                }
            });

        }
    }
}
