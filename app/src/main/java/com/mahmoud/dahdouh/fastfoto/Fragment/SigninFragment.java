package com.mahmoud.dahdouh.fastfoto.Fragment;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.mahmoud.dahdouh.fastfoto.Activity.MainActivity;
import com.mahmoud.dahdouh.fastfoto.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class SigninFragment extends Fragment {

    // firebase
    private FirebaseAuth mAuth;

    private TextInputLayout ed_email;
    private TextInputLayout ed_password;

    private Button btn_sign_in;
    private CheckBox cb_remember_me;
    private ImageView img_sign_with_google;
    private ImageView img_sign_with_facebook;
    private TextView tv_forget_password;
    private TextView tv_sign_up;

    public SigninFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        // Inflate the layout for this fragment
        View layout = inflater.inflate(R.layout.fragment_signin, container, false);

        // inflate
        tv_sign_up = layout.findViewById(R.id.tv_sign_up_dont);

        btn_sign_in = layout.findViewById(R.id.btn_sign_in);
        ed_email = layout.findViewById(R.id.ed_sign_in_email);
        ed_password = layout.findViewById(R.id.ed_sign_in_password);
        img_sign_with_google = layout.findViewById(R.id.img_sign_in_with_google);


        getActivity().getWindow()
                .setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);

        return layout;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        tv_sign_up.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToSignUp();
            }
        });

        btn_sign_in.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                signIn();
            }
        });
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        mAuth = FirebaseAuth.getInstance();
    }


    // Methods
    // sign in
    private void signIn() {
        if (validEmail() & validPassword()) {
            String email = ed_email.getEditText().getText().toString().trim();
            String password = ed_password.getEditText().getText().toString().trim();


            mAuth.signInWithEmailAndPassword(email, password)
                    .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()) {
                                startActivity(new Intent(getContext(), MainActivity.class));
                                getActivity().finish();
                                Toast.makeText(getContext(), "Welcome", Toast.LENGTH_SHORT).show();
                            } else {
                                // If sign in fails, display a message to the user.
                                System.out.println(task.getException().getMessage());
                                Toast.makeText(getContext(), "Authentication failed.\n"
                                                + task.getException().getMessage(),
                                        Toast.LENGTH_LONG).show();
                            }
                        }
                    });
        }
    }


    // go to sign up activity
    private void goToSignUp() {
        getFragmentManager().beginTransaction()
                .setCustomAnimations(
                        R.anim.enter_left_to_right,
                        R.anim.exit_right_to_left)

                .replace(R.id.register_container, new SignupFragment())
                .addToBackStack(null)
                .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                .commit();
    }

    // valid methods
    private boolean validEmail() {
        String email = ed_email.getEditText().getText().toString().trim();

        if (email.isEmpty()) {
            ed_email.setError("* Field can't be empty");
            return false;
        } else if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            ed_email.setError("* Please enter a valid email address");
            return false;
        } else {
            ed_email.setError(null);
            return true;
        }
    }

    private boolean validPassword() {
        String password = ed_password.getEditText().getText().toString().trim();

        if (password.isEmpty()) {
            ed_password.setError("* Field can't be empty");
            return false;
        } else if (password.length() < 6) {
            ed_password.setError("* Password should be at least 6 characters");
            return false;
        } else {
            ed_password.setError(null);
            return true;
        }
    }
}
