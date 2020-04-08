package com.example.webuy.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.webuy.R;
import com.example.webuy.models.Store;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class StoreRecyclerViewAdapter extends RecyclerView.Adapter<StoreRecyclerViewAdapter.StoreItemHolder> {
    private final String API_URL = "https://webuy.sciences.univ-tours.fr/api/v1/magasins";
    private ArrayList<Store> stores;
    private OnItemClickListener onItemClickListener;

    public static class StoreItemHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        public ImageView storeImageView;
        public OnItemClickListener onItemClickListener;

        public StoreItemHolder(@NonNull View itemView, OnItemClickListener onItemClickListener) {
            super(itemView);
            this.onItemClickListener = onItemClickListener;
            storeImageView = itemView.findViewById(R.id.store_image);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            onItemClickListener.onStoreItemClick(itemView, getAdapterPosition());
        }
    }

    public StoreRecyclerViewAdapter(ArrayList<Store> stores, OnItemClickListener onItemClickListener) {
        this.stores = stores;
        this.onItemClickListener = onItemClickListener;
    }

    @NonNull
    @Override
    public StoreItemHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.store_item, parent, false);

        return new StoreItemHolder(view, onItemClickListener);
    }

    @Override
    public void onBindViewHolder(@NonNull StoreItemHolder holder, int position) {
        Picasso.get().load(stores.get(position).getLogo()).fit().into(holder.storeImageView);
    }

    @Override
    public int getItemCount() {
        return stores.size();
    }

    public interface OnItemClickListener {
        void onStoreItemClick(View view, int position);
    }
}
