package com.xlukog.ReportClient;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;
import com.xlukog.ReportClient.model.Report;
import com.xlukog.ReportClient.retrofit.ReportAPI;
import com.xlukog.ReportClient.retrofit.RetrofitService;

import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Reporter extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.reporter);
        InitComponents();
    }

    private void InitComponents() {
        TextInputEditText ReportName = findViewById(R.id.form_reportName);
        TextInputEditText ReportContent = findViewById(R.id.form_report);
        TextInputEditText ReportLocation = findViewById(R.id.form_reporLocation);
        MaterialButton SubmitButton = findViewById(R.id.form_buttonSave);
        RetrofitService retrofitService =  new RetrofitService();
        ReportAPI reportAPI =retrofitService.getRetrofit().create(ReportAPI.class);
        SubmitButton.setOnClickListener(view ->{
            String name = Objects.requireNonNull(ReportName.getText()).toString();
            String content = Objects.requireNonNull(ReportContent.getText()).toString();
            String location = Objects.requireNonNull(ReportLocation.getText()).toString();
            Report report = new Report();
            report.setReportName(name);
            report.setReportContent(content);
            report.setLocation(location);
            reportAPI.save(report)
                .enqueue(new Callback<Report>() {
                @Override
                public void onResponse(Call<Report> call, Response<Report> response) {
                    Toast.makeText(Reporter.this,"Report Success",Toast.LENGTH_SHORT).show();
                }

                @Override
                public void onFailure(Call<Report> call, Throwable t) {
                    Toast.makeText(Reporter.this,"Report Success, Thanks for your help !",Toast.LENGTH_SHORT).show();
                    ReportName.setText("");;
                    ReportContent.setText("");
                    ReportLocation.setText("");
                }
            });
        });
    }
}

