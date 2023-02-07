package com.example.hostelmanagement;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.biometric.BiometricManager;
import androidx.biometric.BiometricPrompt;
import androidx.core.content.ContextCompat;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.concurrent.Executor;

public class Main1 extends AppCompatActivity implements View.OnClickListener {

    BiometricPrompt biometricPrompt;
    BiometricPrompt.PromptInfo promptInfo;
    LinearLayout mMainLayout;
    Button login,signup,contact;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main1);
        mMainLayout=findViewById(R.id.main_Layout);
        login=findViewById(R.id.login);
        signup=findViewById(R.id.signup);
        contact=findViewById(R.id.contact);

        login.setOnClickListener(this);
        contact.setOnClickListener(this);
        signup.setOnClickListener(this);

        BiometricManager biometricManager=BiometricManager.from(this);
        switch (biometricManager.canAuthenticate()) {
            case BiometricManager.BIOMETRIC_ERROR_NO_HARDWARE:
                Toast.makeText(getApplicationContext(), "Device Doesnt have fingerprint", Toast.LENGTH_SHORT).show();
                break;
            case BiometricManager.BIOMETRIC_ERROR_HW_UNAVAILABLE:
                Toast.makeText(getApplicationContext(), "Not Working", Toast.LENGTH_SHORT).show();

            case BiometricManager.BIOMETRIC_ERROR_NONE_ENROLLED:
                Toast.makeText(getApplicationContext(), "No fingerprint Assigned", Toast.LENGTH_SHORT).show();
            case BiometricManager.BIOMETRIC_SUCCESS:
                break;
        }
        Executor executor= ContextCompat.getMainExecutor(this);

        biometricPrompt=new BiometricPrompt(Main1.this,executor,new BiometricPrompt.AuthenticationCallback(){
            public void onAuthenticationError(int errorcode, @NonNull CharSequence errString){
                super.onAuthenticationError(errorcode,errString);
            }
            public void onAuthenticationSucceeded(@NonNull BiometricPrompt.AuthenticationResult result) {
                super.onAuthenticationSucceeded(result);
                mMainLayout.setVisibility(View.VISIBLE);
            }
            public void onAuthenticationFailed() {
                super.onAuthenticationFailed();
            }
        });

        promptInfo=new BiometricPrompt.PromptInfo.Builder().setTitle("MAD1C")
                .setDescription("Use Fingerprint to login").setDeviceCredentialAllowed(true).build();

        biometricPrompt.authenticate(promptInfo);
    }

    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.login:
                Toast.makeText(this,"login",Toast.LENGTH_SHORT).show();
                startActivity(new Intent(Main1.this, LoginActivity.class));
                break;
            case R.id.signup:
                Toast.makeText(this,"signup",Toast.LENGTH_SHORT).show();
                startActivity(new Intent(Main1.this, SignupActivity.class));
                break;
            case R.id.contact:
                Toast.makeText(this,"Contact Us!",Toast.LENGTH_SHORT).show();
                startActivity(new Intent(Main1.this, Contact.class));
                break;
        }
    }
}