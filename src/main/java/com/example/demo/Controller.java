package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RefreshScope
@RestController
public class Controller {

	@Value("${greetings}")
	private String greetings;
	
	@Autowired
	private Environment env;
	
	@GetMapping("/greetings")
	public String greetingsMethod() {
		return env.getRequiredProperty("greetings");
	}
}
