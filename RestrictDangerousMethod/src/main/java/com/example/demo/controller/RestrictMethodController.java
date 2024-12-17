package com.example.demo.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.annotation.RestrictMethod;

@RestController
@RestrictMethod
@RequestMapping("/api")
public class RestrictMethodController {
	@PostMapping("/post")
	public String postMapping() {
		System.out.println("Inside Allowed Method");
		return "Post Mappinggg";
	}

	@GetMapping("/get")
	public String getMapping() {
		return "Get Mappinggg";
	}

	@PutMapping("/put")
	public String putMapping() {
		return "Put Mappinggg";
	}
 
	@DeleteMapping("/delete")
	public String deleteMapping() {
		return "Delete Mappinggg";
	}
}
