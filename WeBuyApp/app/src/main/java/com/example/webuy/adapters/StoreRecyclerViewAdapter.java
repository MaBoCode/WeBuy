package com.example.webuy.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.webuy.R;
import com.example.webuy.models.StoreModel;

import java.util.ArrayList;

public class StoreRecyclerViewAdapter extends RecyclerView.Adapter<StoreRecyclerViewAdapter.StoreItemHolder> {

    private StoreModel storeModel;

    public static class StoreItemHolder extends RecyclerView.ViewHolder {

        public TextView storeNameView;

        public StoreItemHolder(@NonNull View itemView) {
            super(itemView);

            storeNameView = itemView.findViewById(R.id.store_name);
        }
    }

    public StoreRecyclerViewAdapter(StoreModel storeModel) {
        this.storeModel = storeModel;
    }

    @NonNull
    @Override
    public StoreItemHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.store_item, parent, false);

        return new StoreItemHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull StoreItemHolder holder, int position) {
        ArrayList<StoreModel.Store> stores = storeModel.getDataModel();

        holder.storeNameView.setText(stores.get(position).getName());
    }

    @Override
    public int getItemCount() {
        return storeModel.getDataModel().size();
    }
}
