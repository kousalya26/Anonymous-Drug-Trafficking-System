package com.xlukog.reporterserver.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.util.Streamable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ReportDao {
    @Autowired
    private ReportRepository repository;

    public void save(Report report){
        repository.save(report);
    }

    public List<Report> GetAllReport(){
        List<Report> reports= new ArrayList<>();
        Streamable.of(repository.findAll())
                .forEach(reports::add);
        return reports;
    }
}
