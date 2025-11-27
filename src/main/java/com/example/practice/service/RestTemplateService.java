package com.example.practice.service;

import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class RestTemplateService {

	public String get() {
		final RestTemplate restTemplate = new RestTemplate();
		final String url = "https://jsonplaceholder.typicode.com/photos?albumId=1";
		final ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET, null, String.class);

		//結果の取得
		final HttpStatusCode status = response.getStatusCode();
		final String body = response.getBody();

		System.out.println("status: " + status);
		System.out.println("body: " + body);

		return body;
	}

}
