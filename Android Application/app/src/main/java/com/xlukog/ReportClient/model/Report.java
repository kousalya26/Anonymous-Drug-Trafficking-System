package com.xlukog.ReportClient.model;

public class Report {
    private int id;
    private String reportName;
    private String reportContent;
    private String location;

    public int getId() {
        return id;
    }

    public String getReportName() {
        return reportName;
    }

    public String getReportContent() {
        return reportContent;
    }

    public String getLocation() {
        return location;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setReportName(String reportName) {
        this.reportName = reportName;
    }

    public void setReportContent(String reportContent) {
        this.reportContent = reportContent;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}
