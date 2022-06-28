package com.cts.sbdjwd.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class DefaultController {

	@GetMapping({"","/"})
	public String defaultRequestHandlerAction() {
		return "home";
	}
	
	@RequestMapping("/header")
	public String getHeaderAction() {
		return "header-segment";
	}
}
