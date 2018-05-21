package com.application.initiatives_platform.InitiativesPlatformServer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class InitiativesPlatformServerApplication extends SpringBootServletInitializer {
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(InitiativesPlatformServerApplication.class);
	}

	public static void main(String[] args) throws Exception {
		SpringApplication.run(InitiativesPlatformServerApplication.class, args);
	}
}
