package com.example.demo.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.config.AppConfig;
import com.example.demo.service.HelloService;

@RestController
public class Hello {
	
	@Autowired
	HelloService service;	

	@Autowired
	Environment environment;
	
	
	@Autowired
	AppConfig appConfig;
	
	@Value("${test}")
	String strValue;
	
	@GetMapping("/Hello")
	public String sayHello() {
		return "Hello! welocme to Sprin boot!";
	}

	@GetMapping("/Hello/{name}")
	public String sayName(@PathVariable String name) {
		return "Hello " + name + ". Good Evening!";
	}
	
	//queryparam
	
	@GetMapping("/Hi")
	public String sayHi(@RequestParam String name) {
		return "Hello " + name +" is from QueryParam";
	}
	
	@GetMapping("/JsonResp")
	public Map<String,String> JsonResponse () {
		
		Map<String,String> mp = new HashMap<String,String>();
		
		mp.put("Message", "This is JSON which is converted from MAP by Spring Boot");
		
		return mp;
	}

	@GetMapping("/service/{name}")
	public String fromService(@PathVariable String name) {
		return service.getMessage(name);
	}
	
	@GetMapping("/Val")
	public String getValue() {
		return strValue;
	}
	
	@GetMapping("/Config")
	public String getConfigValues() {
		return appConfig.getName();
	}
	
	@GetMapping("/EnvInfo")
	public String getEnvInfo() {
		 int len = 0;
		if(environment.getActiveProfiles() != null) 
			 len = environment.getActiveProfiles().length;
		
		if (len <= 1) 
			return environment.getActiveProfiles()[0];
		else 
			return environment.getActiveProfiles()[1];
		//return environment.getActiveProfiles()[0];
	}
}
