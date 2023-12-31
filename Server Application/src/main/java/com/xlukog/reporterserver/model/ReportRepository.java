package com.xlukog.reporterserver.model;

import com.xlukog.reporterserver.model.Report;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReportRepository extends CrudRepository<Report, Integer> {

}
