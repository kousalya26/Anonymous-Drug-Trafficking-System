package com.xlukog.reporterserver.model;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
@Entity
public class Report {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String ReportName;
    private String ReportContent;
    private String Location;

    public int getId() {
        return id;
    }

    public String getReportName() {
        return ReportName;
    }

    public String getReportContent() {
        return ReportContent;
    }

    public String getLocation() {
        return Location;
    }
    public void setId(int id) {
        this.id = id;
    }

    public void setReportName(String reportName) {
        ReportName = reportName;
    }

    public void setReportContent(String reportContent) {
        ReportContent = reportContent;
    }

    public void setLocation(String location) {
        Location = location;
    }

}
