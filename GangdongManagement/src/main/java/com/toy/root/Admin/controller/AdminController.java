package com.toy.root.Admin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AdminController {

	@GetMapping("/")
	public String mainPage() {		
		return "index";
	}
	
}
