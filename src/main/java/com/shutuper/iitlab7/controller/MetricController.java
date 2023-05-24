package com.shutuper.iitlab7.controller;

import io.micrometer.prometheus.PrometheusMeterRegistry;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class MetricController {

	PrometheusMeterRegistry prometheusMeterRegistry;

	@GetMapping("/metrics")
	public String login() {
		return prometheusMeterRegistry.scrape();
	}

}
