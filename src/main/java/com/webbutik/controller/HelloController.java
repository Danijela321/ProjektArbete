package com.webbutik.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Halsning
 * @author Danijela
 *
 */
@RestController
public class HelloController {
	/**
	 * Halsning
	 * @return String Hello
	 */
	@RequestMapping("/")
	public String sayHello() {
		return "Hello";
	}
	

}
