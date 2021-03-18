package com.example.bloodbanksystem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class SignUp extends AppCompatActivity {
    private FirebaseAuth mAuth;
    private EditText mStaffID, mName, mEmail, mPwd;
    private Button mSignUp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        mAuth = FirebaseAuth.getInstance();
        mStaffID = findViewById(R.id.editStaffID);
        mName = findViewById(R.id.editName);
        mEmail = findViewById(R.id.editTextEmailAddress);
        mPwd = findViewById(R.id.editTextPassword);
        mSignUp = findViewById(R.id.button3);

        mSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String StaffID = mStaffID.getText().toString().trim();
                String Name = mName.getText().toString().trim();
                String Email = mEmail.getText().toString().trim();
                String Password = mPwd.getText().toString().trim();

                if (StaffID.isEmpty()){
                    mStaffID.setError("Staff ID is required !");
                    mStaffID.requestFocus();
                    return;
                }
                if (Name.isEmpty()){
                    mName.setError("Name with initials is required !");
                    mName.requestFocus();
                    return;
                }

                if (Email.isEmpty()) {
                    mEmail.setError("Please enter your email");
                    mEmail.requestFocus();

                } else if (Password.isEmpty()) {
                    mPwd.setError("Please enter your password");
                    mPwd.requestFocus();
                } else if (Email.isEmpty() && Password.isEmpty()) {
                    Toast.makeText(SignUp.this, "Fields Are Empty!", Toast.LENGTH_SHORT
                    );
                } else if (!(Email.isEmpty() && Password.isEmpty())) {
                    mAuth.createUserWithEmailAndPassword(Email,Password).addOnCompleteListener(SignUp.this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (!task.isSuccessful()){
                                Toast.makeText(SignUp.this,"SignUp Unsuccessful, Please try again",Toast.LENGTH_SHORT);


                            }
                            else {
                                startActivity(new Intent(SignUp.this,Login.class));

                            }
                        }

                    });
                }

                else {
                    Toast.makeText(SignUp.this,"Error Occurred",Toast.LENGTH_SHORT);

                }
            }


        });


    }
}