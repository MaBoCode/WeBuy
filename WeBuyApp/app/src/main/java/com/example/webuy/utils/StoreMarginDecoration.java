package com.example.webuy.utils;

import android.graphics.Rect;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class StoreMarginDecoration extends RecyclerView.ItemDecoration {
    private final int marginHorizontal, marginVertical;

    public StoreMarginDecoration(int marginHorizontal, int marginVertical) {
        this.marginHorizontal = marginHorizontal;
        this.marginVertical = marginVertical;
    }

    @Override
    public void getItemOffsets(@NonNull Rect outRect, @NonNull View view, @NonNull RecyclerView parent, @NonNull RecyclerView.State state) {
        if(parent.getChildAdapterPosition(view) == 0 || parent.getChildAdapterPosition(view) == 1) {
            outRect.top = marginVertical;
        }

        if((parent.getChildAdapterPosition(view) != parent.getAdapter().getItemCount() - 1) && parent.getChildAdapterPosition(view) != parent.getAdapter().getItemCount() - 2) {
            outRect.bottom = marginVertical;
        }

        if(parent.getChildAdapterPosition(view) == 0) {
            outRect.left = marginHorizontal;
        }

        if(parent.getChildAdapterPosition(view) == 1) {
            outRect.right = marginHorizontal;
        }

        if((parent.getChildAdapterPosition(view) % 2 == 0) && (parent.getChildAdapterPosition(view) != 0)) {
            outRect.left = marginHorizontal;
        }

        if((parent.getChildAdapterPosition(view) % 2 != 0) && (parent.getChildAdapterPosition(view) != 1)) {
            outRect.right = marginHorizontal;
        }


    }
}
