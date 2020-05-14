package com.example.webuy.fragments.auth;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.webuy.R;
import com.example.webuy.activities.DrawerActivity;
import com.example.webuy.interfaces.IFragment;
import com.example.webuy.services.FirebaseService;
import com.example.webuy.utils.DebugHelper;
import com.google.android.material.button.MaterialButton;

public class SignupFragment extends Fragment implements IFragment {

    private FirebaseService firebaseService;

    private EditText emailEditText, passwordEditText;
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
        emailEditText = view.findViewById(R.id.email_edit_text);
        passwordEditText = view.findViewById(R.id.password_edit_text);
        submitButton = view.findViewById(R.id.signup_submit_button);

        submitButton.setOnClickListener(submitButtonListener);
    }

    public void onSubmitButtonClicked() {
        if (signUpUser()) {
            Intent intent = new Intent(getContext(), DrawerActivity.class);
            startActivity(intent);
        }
    }

    public boolean signUpUser() {
        if(isUserInputValid()) {
            firebaseService = FirebaseService.getInstance();
            firebaseService.signUpUser(emailEditText.getText().toString(), passwordEditText.getText().toString());
            return true;
        } else {
            return false;
        }
    }

    public boolean isUserInputValid() {
        boolean isValid = true;

        String email = emailEditText.getText().toString();
        String password = passwordEditText.getText().toString();

        if (email.isEmpty()) {
            emailEditText.setError(getString(R.string.field_required));
            isValid = false;
        }

        if(password.isEmpty()) {
            passwordEditText.setError(getString(R.string.field_required));
            isValid = false;
        }

        return isValid;
    }

    @Override
    public void setStyles() {
        submitButton.setText(R.string.signup_action);
    }

    @Override
    public void link() {

    }
}
