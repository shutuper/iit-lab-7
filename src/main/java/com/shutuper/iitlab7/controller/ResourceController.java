package com.shutuper.iitlab7.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ResourceController {

	@GetMapping("/")
	public String getLoginPage() {
		return "login";
	}

}
