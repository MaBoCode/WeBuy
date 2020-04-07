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

    public static class StoreItemHolder extends RecyclerView.ViewHolder {

        public ImageView storeImageView;

        public StoreItemHolder(@NonNull View itemView) {
            super(itemView);

            storeImageView = itemView.findViewById(R.id.store_image);
        }
    }

    public StoreRecyclerViewAdapter(ArrayList<Store> stores) {
        this.stores = stores;
    }

    @NonNull
    @Override
    public StoreItemHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.store_item, parent, false);

        return new StoreItemHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull StoreItemHolder holder, int position) {
        Picasso.get().load(stores.get(position).getLogo()).fit().into(holder.storeImageView);
    }

    @Override
    public int getItemCount() {
        return stores.size();
    }
}
