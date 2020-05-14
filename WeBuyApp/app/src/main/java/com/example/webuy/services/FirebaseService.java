package com.example.webuy.services;

import android.content.Context;
import android.util.Log;

import androidx.annotation.NonNull;

import com.example.webuy.utils.DebugHelper;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class FirebaseService implements OnCompleteListener<AuthResult>{
    private static FirebaseService instance = null;
    private FirebaseAuth firebaseAuth;

    public static FirebaseService getInstance() {
        if(instance == null) {
            instance = new FirebaseService();
        }
        return instance;
    }

    private FirebaseService() {
        init();
    };

    private void init() {
        firebaseAuth = FirebaseAuth.getInstance();
    }

    public boolean isUserSignedIn() {
        return firebaseAuth.getCurrentUser() != null;
    }

    public void signUpUser(String email, String password) {
        firebaseAuth.createUserWithEmailAndPassword(email, password)
        .addOnCompleteListener(this);
    }

    public void logInUser(String email, String password) {
        firebaseAuth.signInWithEmailAndPassword(email, password);
    }

    @Override
    public void onComplete(@NonNull Task<AuthResult> task) {
        if (task.isSuccessful()) {
            FirebaseUser user = firebaseAuth.getCurrentUser();
            DebugHelper.console(user.getEmail());
        } else {
            DebugHelper.console(task.getException().getMessage());
        }
    }

    public FirebaseUser getCurrentUser() {
        return firebaseAuth.getCurrentUser();
    }
}
