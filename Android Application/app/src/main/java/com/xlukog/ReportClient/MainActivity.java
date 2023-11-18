package com.xlukog.ReportClient;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        EditText ph = (EditText) findViewById(R.id.phonenumber);
        Button otpbutton = (Button) findViewById(R.id.otp_button);
        otpbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String Phone_number = ph.getText().toString().trim();
                if(Phone_number.isEmpty() || (Phone_number.length()<10)){
                    Toast.makeText(MainActivity.this,"Phone Number is empty or less than 10 digits",Toast.LENGTH_LONG).show();
                }
                else {
                    Intent verifotp = new Intent(MainActivity.this,VerifyOtp.class);
                    verifotp.putExtra("ph_no",Phone_number);
                    startActivity(verifotp);
                }

            }
        });

    }
}