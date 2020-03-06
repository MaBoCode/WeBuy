package com.example.webuy.activities;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.ViewCompat;

import android.graphics.Color;
import android.transition.Transition;

import android.os.Build;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.webuy.R;
import com.squareup.picasso.Picasso;

public class PromotionDetailsActivity extends AppCompatActivity {

    private String title, description, oldPrice, newPrice;
    private TextView titleView, descriptionView, oldPriceView, newPriceView;
    private ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_promotion_details);

        Toolbar toolbar = findViewById(R.id.toolbar);

        setSupportActionBar(toolbar);
        toolbar.setBackgroundColor(Color.TRANSPARENT);

        getSupportActionBar().setDisplayShowTitleEnabled(false);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_close);

        setAttributes();

        //ViewCompat.setTransitionName(titleView, getString(R.string.title_transition));
        //ViewCompat.setTransitionName(imageView, getString(R.string.image_transition));

        setStyles();

        //loadItem();
    }

    public void loadItem() {
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP && addTransitionListener()) {
            loadThumbNail();
        } else {
            loadFullSizeImage();
        }
    }

    private void loadThumbNail() {
        Picasso.get().load(R.drawable.promotion).noFade().into(imageView);
    }

    private void loadFullSizeImage() {
        Picasso.get().load(R.drawable.promotion).noFade().noPlaceholder().into(imageView);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    private boolean addTransitionListener() {
        final Transition transition = getWindow().getSharedElementEnterTransition();

        if(transition != null) {
            transition.addListener(new Transition.TransitionListener() {
                @Override
                public void onTransitionStart(Transition transition) {
                    loadFullSizeImage();
                    transition.removeListener(this);
                }

                @Override
                public void onTransitionEnd(Transition transition) {

                }

                @Override
                public void onTransitionCancel(Transition transition) {
                    transition.removeListener(this);
                }

                @Override
                public void onTransitionPause(Transition transition) {

                }

                @Override
                public void onTransitionResume(Transition transition) {

                }
            });

            return true;
        }

        return false;
    }

    public void setAttributes() {
        Bundle bundle = getIntent().getExtras();

        title = bundle.getString("card_title");
        description = bundle.getString("card_description");
        oldPrice = bundle.getString("card_old_price");
        newPrice = bundle.getString("card_new_price");

        titleView = findViewById(R.id.title_view);
        descriptionView = findViewById(R.id.description_view);
        oldPriceView = findViewById(R.id.old_price_view);
        newPriceView = findViewById(R.id.new_price_view);
        imageView = findViewById(R.id.product_image);
    }

    public void setStyles() {
        titleView.setText(title);
        descriptionView.setText(description);
        oldPriceView.setText(oldPrice);
        newPriceView.setText(newPrice);
    }

    @Override
    public boolean onSupportNavigateUp() {
        supportFinishAfterTransition();
        return true;
    }
}
