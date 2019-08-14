package com.verizon.searchservice.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class SearchController {
	
	public String customerMessage() {
		RestTemplate restTemplate = new RestTemplate();
		String response = restTemplate.getForObject("http://localhost:1356/customer/all", String.class);
		return response;
	}
}
