package com.example.PayMe.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

	
	@RequestMapping ("/")
	public String getHome(Model model) {
		return ("home");
	}
	
	
	@GetMapping("/testLog")
	public String getTestLog(Model model) {
		return ("home");
	}

}
