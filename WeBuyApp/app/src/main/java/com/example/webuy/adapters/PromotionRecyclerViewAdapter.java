package com.example.webuy.adapters;

import android.content.Context;
import android.content.res.Resources;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.webuy.R;
import com.example.webuy.models.Product;
import com.example.webuy.models.Promotion;
import com.example.webuy.models.PromotionModel;
import com.example.webuy.utils.DebugHelper;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class PromotionRecyclerViewAdapter extends RecyclerView.Adapter<PromotionRecyclerViewAdapter.PromotionItemHolder> {

    private PromotionModel dataModel;
    private ArrayList<Promotion> promotions = new ArrayList<>();
    private Context context;
    private OnItemClickListener onItemClickListener;

    public static class PromotionItemHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        public ImageView productImageView;
        public TextView titleView, descriptionView, oldPriceView, newPriceView;
        public OnItemClickListener onItemClickListener;

        public PromotionItemHolder(View itemView, OnItemClickListener onItemClickListener) {
            super(itemView);

            productImageView = itemView.findViewById(R.id.product_image);
            titleView = itemView.findViewById(R.id.title_view);
            descriptionView = itemView.findViewById(R.id.description_view);
            oldPriceView = itemView.findViewById(R.id.old_price_view);
            newPriceView = itemView.findViewById(R.id.new_price_view);
            this.onItemClickListener = onItemClickListener;

            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            onItemClickListener.onPromotionCardClick(itemView, getAdapterPosition());
        }
    }

    public PromotionRecyclerViewAdapter(Context context, PromotionModel dataModel, OnItemClickListener onItemClickListener) {
        this.context = context;
        this.dataModel = dataModel;
        this.onItemClickListener = onItemClickListener;
    }

    public PromotionRecyclerViewAdapter(Context context, ArrayList<Promotion> promotions, OnItemClickListener onItemClickListener) {
        this.context = context;
        this.promotions = promotions;
        this.onItemClickListener = onItemClickListener;
    }

    @NonNull
    @Override
    public PromotionItemHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.promotion_item, parent, false);

        return  new PromotionItemHolder(view, onItemClickListener);
    }

    @Override
    public void onBindViewHolder(PromotionItemHolder holder, int position) {

        if(!promotions.isEmpty()) {
            Promotion entry = promotions.get(position);

            Resources res = context.getResources();

            String oldPrice = "<strike><font color=\'#232323\'>" + entry.getOldPrice() + "€</font></strike>" ;
            String newPrice = entry.getNewPrice() + "€";

            Picasso.get().load(entry.getProduct().getImage()).fit().into(holder.productImageView);
            holder.titleView.setText(entry.getProduct().getLabel());
            holder.descriptionView.setText(entry.getProduct().getDescription());
            holder.oldPriceView.setText(Html.fromHtml(oldPrice));
            holder.newPriceView.setText(newPrice);
        }
    }

    @Override
    public int getItemCount() {
        return promotions.size();
    }

    public Context getContext() {
        return context;
    }

    public interface OnItemClickListener {
        void onPromotionCardClick(View view, int position);
    }

}
