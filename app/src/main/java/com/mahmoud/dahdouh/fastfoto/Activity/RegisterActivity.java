package com.mahmoud.dahdouh.fastfoto.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;
import com.mahmoud.dahdouh.fastfoto.Fragment.SigninFragment;
import com.mahmoud.dahdouh.fastfoto.R;

public class RegisterActivity extends AppCompatActivity {
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

// Initialize Firebase Auth
        mAuth = FirebaseAuth.getInstance();

        getSupportFragmentManager().beginTransaction()
                .replace(R.id.register_container, new SigninFragment())
                .commit();
    }

    @Override
    public void onStart() {
        super.onStart();
        // Check if user is signed in (non-null) and update UI accordingly.
        if (mAuth.getCurrentUser() != null) {
            Toast.makeText(this, "There is user", Toast.LENGTH_SHORT).show();
            startActivity(new Intent(RegisterActivity.this, MainActivity.class));
        } else {
            Toast.makeText(this, "There is no user", Toast.LENGTH_SHORT).show();
        }
    }
}
