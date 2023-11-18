package com.xlukog.ReportClient.retrofit;

import com.xlukog.ReportClient.model.Report;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface ReportAPI {

    @POST("/report/save-report")
    Call<Report> save(@Body Report report);
}
