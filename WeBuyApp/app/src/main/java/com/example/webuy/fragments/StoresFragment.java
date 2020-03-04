package com.example.webuy.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;

import com.example.webuy.R;
import com.example.webuy.activities.DrawerActivity;
import com.example.webuy.utils.DebugHelper;

public class StoresFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        changeTitle();

        return inflater.inflate(R.layout.stores_fragment, container, false);
    }

    public void changeTitle() {
        ((DrawerActivity)getActivity()).setToolbarTitle(getString(R.string.shops_title));
    }
}
