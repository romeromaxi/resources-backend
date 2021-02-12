package com.aninfo.recursos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@RestController
public class RecursosApplication {

	public static void main(String[] args) {
		SpringApplication.run(RecursosApplication.class, args);
	}

	@GetMapping("/resources")
	public String getResources() {
		RestTemplate restTemplate = new RestTemplate();
		String result = restTemplate.getForObject("https://anypoint.mulesoft.com/mocking/api/v1/sources/exchange/assets/754f50e8-20d8-4223-bbdc-56d50131d0ae/recursos-psa/1.0.0/m/api/recursos", String.class);
		return result;
	}

}

