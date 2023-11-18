package com.xlukog.reporterserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.xlukog.reporterserver")
@EnableAutoConfiguration
public class ReporterServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(ReporterServerApplication.class, args);
	}

}
