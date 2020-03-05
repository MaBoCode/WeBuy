package com.example.webuy.utils;

import android.graphics.Rect;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class PromotionMarginDecoration extends RecyclerView.ItemDecoration {
    private final int margin;

    public PromotionMarginDecoration(int margin) {
        this.margin = margin;
    }

    @Override
    public void getItemOffsets(@NonNull Rect outRect, @NonNull View view, @NonNull RecyclerView parent, @NonNull RecyclerView.State state) {

        if(parent.getChildAdapterPosition(view) == 0) outRect.top = margin;

        if(parent.getChildAdapterPosition(view) != parent.getAdapter().getItemCount() - 1) outRect.bottom = margin;
    }
}
