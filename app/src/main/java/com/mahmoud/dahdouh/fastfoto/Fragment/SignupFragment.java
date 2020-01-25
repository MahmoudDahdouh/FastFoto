package com.mahmoud.dahdouh.fastfoto.Fragment;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

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
public class SignupFragment extends Fragment {

    // firebase
    private FirebaseAuth mAuth;

    private TextInputLayout ed_name;
    private TextInputLayout ed_email;
    private TextInputLayout ed_password;

    private ImageView img_sign_with_google;
    private ImageView img_sign_with_facebook;
    private TextView tv_sign_in;

    private Button btn_sign_up;

    public SignupFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View layout = inflater.inflate(R.layout.fragment_signup, container, false);

        // inflate
        tv_sign_in = layout.findViewById(R.id.tv_sign_in_have_account);

        ed_name = layout.findViewById(R.id.ed_sign_up_name);
        ed_email = layout.findViewById(R.id.ed_sign_up_email);
        ed_password = layout.findViewById(R.id.ed_sign_up_password);

        btn_sign_up = layout.findViewById(R.id.btn_sign_up);

        tv_sign_in.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(), "go", Toast.LENGTH_SHORT).show();

                getFragmentManager().beginTransaction()
                        .setCustomAnimations(
                                R.anim.enter_right_to_left,
                                R.anim.exit_left_to_right)
                        .replace(R.id.register_container, new SigninFragment())
                        .addToBackStack(null)
                        .commit();
            }
        });

        btn_sign_up.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                signUp();
                Toast.makeText(getContext(), "Click", Toast.LENGTH_SHORT).show();
            }
        });
        return layout;

    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        mAuth = FirebaseAuth.getInstance();
    }


    // sign in
    private void signUp() {
        if (validEmail() & validPassword() & validName()) {

            String name = ed_name.getEditText().getText().toString().trim();
            String email = ed_email.getEditText().getText().toString().trim();
            String password = ed_password.getEditText().getText().toString().trim();

            mAuth.createUserWithEmailAndPassword(email, password)
                    .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()) {
                                startActivity(new Intent(getContext(), MainActivity.class));
                                getActivity().finish();
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

    private boolean validName() {
        String name = ed_name.getEditText().getText().toString().trim();

        if (name.isEmpty()) {
            ed_name.setError("* Field can't be empty");
            return false;
        } else {
            ed_name.setError(null);
            return true;
        }
    }
}
