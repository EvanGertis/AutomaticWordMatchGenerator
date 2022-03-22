package com.company.app.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
	private static final Logger logger = LogManager.getLogger(HomeController.class);

	@RequestMapping("/home")
	public String showHome() {
		return "home";
	}
}
