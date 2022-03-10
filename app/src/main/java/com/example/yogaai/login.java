package com.example.yogaai;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class login extends AppCompatActivity{
    EditText mailid,password;
    Button login,signup;
    FirebaseAuth fAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        mailid = findViewById(R.id.yourname);
        password = findViewById(R.id.yourpass);
        login = findViewById(R.id.loginbutton);
        signup = findViewById(R.id.signupbutton);

        fAuth = FirebaseAuth.getInstance();

        login.setOnClickListener(view -> {
            loginUser();
        });



        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(login.this,signup.class);
                startActivity(i);
            }
        });
    }

    private void loginUser() {
        String email = mailid.getText().toString();
        String pass = password.getText().toString();

        if(TextUtils.isEmpty(email)){
            mailid.setError("EMail cannot be empty");
            mailid.requestFocus();
        }
        else if(TextUtils.isEmpty(pass)){
            password.setError("Password cannot be empty");
            password.requestFocus();
        }
        else{
            fAuth.signInWithEmailAndPassword(email,pass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if(task.isSuccessful()){
                        Toast.makeText(login.this, "Login Successful", Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(login.this,MainActivity.class));
                    }else{
                        Toast.makeText(login.this, "Login Error", Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }
    }
}