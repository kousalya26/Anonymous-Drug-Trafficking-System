package com.xlukog.reporterserver.controller;

import com.xlukog.reporterserver.model.Report;
import com.xlukog.reporterserver.model.ReportDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ReportController {
    @Autowired
    private ReportDao reportDao;
    @GetMapping("/view/all-reports")
    public List<Report> GetAllReport(){
        return reportDao.GetAllReport();

    }
    @RequestMapping(method = RequestMethod.GET,value = "/view/admin")
    public String Admin(){
        return "admin.html";

    }
    @PostMapping("/report/save-report")
    public void save(@RequestBody Report report){
        reportDao.save(report);
    }
}
