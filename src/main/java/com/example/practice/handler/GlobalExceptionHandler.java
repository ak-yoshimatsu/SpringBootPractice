package com.example.practice.handler;

import org.apache.commons.lang3.exception.ExceptionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class GlobalExceptionHandler {

	private final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

	@ExceptionHandler(Exception.class)
	public void handlerGlobalException(final Exception ex, final WebRequest request) {
		System.out.println("▼ハンドリング▼");
		//        logger.warn(ExceptionUtils.getMessage(ex));
		//        logger.warn(ExceptionUtils.getStackTrace(ex));
		logger.warn(ExceptionUtils.getMessage(ex), ex);
	}

}
