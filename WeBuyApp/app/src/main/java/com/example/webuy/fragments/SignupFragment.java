package com.example.webuy.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatButton;
import androidx.fragment.app.Fragment;

import com.example.webuy.R;
import com.example.webuy.activities.DrawerActivity;
import com.example.webuy.interfaces.IFragment;
import com.google.android.material.button.MaterialButton;

public class SignupFragment extends Fragment implements IFragment {

    private MaterialButton submitButton;

    public static SignupFragment newInstance() {

        Bundle args = new Bundle();

        SignupFragment fragment = new SignupFragment();
        fragment.setArguments(args);
        return fragment;
    }

    View.OnClickListener submitButtonListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            onSubmitButtonClicked();
        }
    };

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.signup_fragment, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        setAttributes(view);

        setStyles();
    }

    @Override
    public void setAttributes(View view) {
        submitButton = view.findViewById(R.id.signup_submit_button);

        submitButton.setOnClickListener(submitButtonListener);
    }

    public void onSubmitButtonClicked() {
        Intent intent = new Intent(getContext(), DrawerActivity.class);
        startActivity(intent);
    }

    @Override
    public void setStyles() {
        submitButton.setText(R.string.signup_action);
    }

    @Override
    public void link() {

    }
}
