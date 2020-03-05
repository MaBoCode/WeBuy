package com.example.webuy.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.webuy.R;

import java.util.ArrayList;

public class ProfileInfoListAdapter extends BaseAdapter {
    private final ArrayList<String> items;
    private Context context;

    public ArrayList<String> getItems() {
        return items;
    }

    public Context getContext() {
        return context;
    }

    public ProfileInfoListAdapter(Context context, ArrayList<String> items) {
        this.items = items;
        this.context = context;
    }

    @Override
    public int getCount() {
        return items.size();
    }

    @Override
    public Object getItem(int position) {
        return items.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if(convertView == null) convertView = LayoutInflater.from(getContext()).inflate(R.layout.profile_info_item, parent, false);

        ((TextView) convertView.findViewById(R.id.profile_item_text_view)).setText((String) getItem(position));

        return convertView;
    }
}
