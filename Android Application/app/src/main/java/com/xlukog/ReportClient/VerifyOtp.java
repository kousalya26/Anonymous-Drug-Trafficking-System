package com.xlukog.ReportClient;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.FirebaseException;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.PhoneAuthOptions;
import com.google.firebase.auth.PhoneAuthProvider;

import java.util.concurrent.TimeUnit;

    public class VerifyOtp extends AppCompatActivity {
        private PhoneAuthProvider.ForceResendingToken forceResendingToken;
        private PhoneAuthProvider.OnVerificationStateChangedCallbacks mCallbacks;
        private FirebaseAuth firebaseAuth;
        private String mVerificationId;
        private ProgressDialog pd;
        private static final String TAG = "MAIN_TAG";
        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.verifyotp);
            Button Resend = (Button) findViewById(R.id.Resend_button);
            Button Submit = (Button) findViewById(R.id.otp_button_submit);
            String ph_no = getIntent().getStringExtra("ph_no");
            firebaseAuth = FirebaseAuth.getInstance();
            pd = new ProgressDialog(this);
            pd.setTitle("Please Wait ...");
            pd.setCanceledOnTouchOutside(false);
            mCallbacks= new PhoneAuthProvider.OnVerificationStateChangedCallbacks() {
                @Override
                public void onVerificationCompleted(@NonNull PhoneAuthCredential phoneAuthCredential) {
                    signInWithPhoneAuthCredential(phoneAuthCredential);
                    pd.dismiss();
                    Intent reporter = new Intent(VerifyOtp.this,Reporter.class);
                    startActivity(reporter);
                }

                @Override
                public void onVerificationFailed(@NonNull FirebaseException e) {
                    pd.dismiss();
                    Toast.makeText(VerifyOtp.this,e.getMessage(),Toast.LENGTH_SHORT).show();
                }
                @Override
                public void onCodeSent(@NonNull String verificationId, @NonNull PhoneAuthProvider.ForceResendingToken token){
                    super.onCodeSent(verificationId, forceResendingToken);
                    Log.d(TAG,"onCodeSent"+verificationId);
                    mVerificationId=verificationId;
                    forceResendingToken= token;
                    pd.dismiss();
                    Toast.makeText(VerifyOtp.this,"OTP Sent !!!",Toast.LENGTH_SHORT).show();
                }
            };
            startPhoneNumberVerification("+91"+ph_no);
            Resend.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    resendPhoneVerification(ph_no,forceResendingToken);
                }
            });
            Submit.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    String otp = Submit.getText().toString().trim();
                    if(otp.isEmpty()){
                        Toast.makeText(VerifyOtp.this,"OTP is empty !!!",Toast.LENGTH_SHORT).show();
                    }
                    else {
                        verifyOtp(mVerificationId,otp);
                    }
                }
            });
        }

        private void startPhoneNumberVerification(String ph_no) {
            pd.setMessage("Checking your number");
            pd.show();
            PhoneAuthOptions options=
                    PhoneAuthOptions.newBuilder(firebaseAuth)
                            .setPhoneNumber(ph_no)
                            .setTimeout(60L, TimeUnit.SECONDS)
                            .setCallbacks(mCallbacks)
                            .setActivity(this)
                            .build();
            PhoneAuthProvider.verifyPhoneNumber(options);
        }
        private void resendPhoneVerification(String ph_no,PhoneAuthProvider.ForceResendingToken token) {
            pd.setMessage("Resending Code");
            pd.show();
            PhoneAuthOptions options=
                    PhoneAuthOptions.newBuilder(firebaseAuth)
                            .setPhoneNumber(ph_no)
                            .setTimeout(60L, TimeUnit.SECONDS)
                            .setCallbacks(mCallbacks)
                            .setActivity(this)
                            .build();
            PhoneAuthProvider.verifyPhoneNumber(options);
        }
        private void verifyOtp(String verificationId, String otp){
            pd.setMessage("Verifying OTP .... !");
            pd.show();
            PhoneAuthCredential credential = PhoneAuthProvider.getCredential(verificationId,otp);
            signInWithPhoneAuthCredential(credential);
        }

        private void signInWithPhoneAuthCredential(PhoneAuthCredential credential) {
            pd.setMessage("Verified Successfully");
            pd.show();
            firebaseAuth.signInWithCredential(credential)
                    .addOnSuccessListener(new OnSuccessListener<AuthResult>() {
                        @Override
                        public void onSuccess(AuthResult authResult) {
                            pd.dismiss();
                            String phone = firebaseAuth.getCurrentUser().getPhoneNumber();
                            Toast.makeText(VerifyOtp.this,"Your Phone is "+phone,Toast.LENGTH_SHORT).show();
                        }
                    })
                    .addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) {
                            Toast.makeText(VerifyOtp.this,"Something went wrong",Toast.LENGTH_SHORT).show();
                        }
                    });
        }
    }


