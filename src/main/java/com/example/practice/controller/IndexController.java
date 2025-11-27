package com.example.practice.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.practice.service.RestTemplateService;
import com.example.practice.service.UserService;

@Controller
public class IndexController {

	private static final Logger logger = LoggerFactory.getLogger(IndexController.class);

	private final UserService userService;
	private final RestTemplateService restTemplateService;

	public IndexController(final UserService userService, final RestTemplateService restTemplateService) {
		this.userService = userService;
		this.restTemplateService = restTemplateService;
	}

	@GetMapping("/")
	public ModelAndView index(final ModelAndView model) {
		System.out.println("インデックスです");
		logger.debug("== デバッグログ ==");

		logger.info("== 情報ログ ==");

		model.setViewName("index");

		final String user = userService.getUserName(1);
		System.out.println("User: " + user);

		final String data = restTemplateService.get();

		model.addObject("data", data);

		return model;
	}
}
