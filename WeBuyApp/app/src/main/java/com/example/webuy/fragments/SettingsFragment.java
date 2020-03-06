package com.example.webuy.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.webuy.R;
import com.example.webuy.activities.DrawerActivity;
import com.example.webuy.interfaces.IFragment;

public class SettingsFragment extends Fragment implements IFragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        setTitle();

        return inflater.inflate(R.layout.settings_fragment, container, false);
    }

    public void setTitle() {
        ((DrawerActivity)getActivity()).setToolbarTitle(getString(R.string.settings_title));
    }

    @Override
    public void setAttributes(View view) {

    }

    @Override
    public void setStyles() {

    }

    @Override
    public void link() {

    }
}
