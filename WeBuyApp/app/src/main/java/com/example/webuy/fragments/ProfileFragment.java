package com.example.webuy.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.webuy.R;
import com.example.webuy.activities.DrawerActivity;
import com.example.webuy.adapters.ProfileInfoListAdapter;
import com.example.webuy.interfaces.IFragment;

import java.util.ArrayList;
import java.util.Arrays;

public class ProfileFragment extends Fragment implements IFragment {

    private ListView profileInfoListView;
    private ProfileInfoListAdapter profileInfoListAdapter;

    private ArrayList<String> profileInfoItems;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        setTitle();

        return inflater.inflate(R.layout.profile_fragment, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        setAttributes(view);

        link();
    }

    public void setTitle() {
        ((DrawerActivity)getActivity()).setToolbarTitle(getString(R.string.profile_title));
    }

    @Override
    public void setAttributes(View view) {
        profileInfoListView = view.findViewById(R.id.profile_info_list_view);
        profileInfoItems = new ArrayList<>(Arrays.asList("Account information"));

        profileInfoListAdapter = new ProfileInfoListAdapter(getContext(), profileInfoItems);
    }

    @Override
    public void setStyles() {

    }

    @Override
    public void link() {
        profileInfoListView.setAdapter(profileInfoListAdapter);
    }
}
