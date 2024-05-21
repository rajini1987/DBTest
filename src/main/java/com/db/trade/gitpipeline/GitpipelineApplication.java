package com.db.trade.gitpipeline;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class GitpipelineApplication {

	@RequestMapping("/pipeline")
	public String pipeline()
	{
		return "Welcome to git pipeline";
	}

	public static void main(String[] args) {
		SpringApplication.run(GitpipelineApplication.class, args);
	}

}
