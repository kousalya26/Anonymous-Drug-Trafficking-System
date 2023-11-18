package com.xlukog.reporterserver;

import com.xlukog.reporterserver.model.Report;
import com.xlukog.reporterserver.model.ReportDao;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class ReporterServerApplicationTests {
	@Autowired
	private ReportDao reportDao;
	//@Test
	void addReportTest(){
		Report report = new Report();
		report.setReportName("Drugs2");
		report.setReportContent("this is test report2");
		report.setLocation("Vellore2");
		reportDao.save(report);
	}
//	@Test
	void getallreports(){
		List<Report> reportList =  reportDao.GetAllReport();
		for (Report report: reportList) {
			System.out.println(report.getId()+report.getReportName()+report.getReportContent());
		}
	}

}
