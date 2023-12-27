package com.example.spring.security.demo.control;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: hanchaowei
 * @date 2023/12/14
 * @description:
 */
@RestController
public class DemoController {

	@GetMapping("/hello")
	public String hello() {
		return "Hello Spring Security";
	}

	@GetMapping("/hello_admin")
	public String helloAdmin() {
		return "Hello Admin";
	}

	@GetMapping("/other")
	public String other() {
		return "Other!";
	}

	@PostMapping(value = "/addUser")
	public String addUser(String name) {
		return name;
	}
}
