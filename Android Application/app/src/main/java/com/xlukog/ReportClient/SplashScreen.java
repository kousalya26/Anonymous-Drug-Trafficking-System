package com.xlukog.ReportClient;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import androidx.appcompat.app.AppCompatActivity;

public class SplashScreen extends AppCompatActivity {
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        new Handler().postDelayed(new Runnable(){
            @Override
            public void run() {
                Intent pass = new Intent(SplashScreen.this,MainActivity.class);
                startActivity(pass);
                finish();
            }
        },2000);
    }
}
