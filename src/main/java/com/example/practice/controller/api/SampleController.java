package com.example.practice.controller.api;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class SampleController {

	@GetMapping
	public ResponseEntity<Map<String, Object>> index() {
		final Map<String, String> data = new HashMap<>();

		data.put("user", "taro");

		final Map<String, Object> map = Map.of("code", 5006, "message", "SUCCESS", "data", data);

		//        return new ResponseEntity<>(map, HttpStatus.OK);
		return ResponseEntity.ok(map);
	}
}
