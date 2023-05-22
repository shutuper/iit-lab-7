package com.shutuper.iitlab7.controller;

import com.shutuper.iitlab7.dto.LoginDto;
import org.fluentd.logger.FluentLogger;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class LoginController {

	private static final FluentLogger LOG = FluentLogger.getLogger("my-app", "127.0.0.1", 24224);

	@PostMapping("/login")
	public String login(LoginDto loginDto) {
		LOG.log("login-data", Map.of("username", loginDto.getUsername(), "password", loginDto.getPassword()));
		return loginDto.getUsername() + " " + loginDto.getPassword();
	}

}
