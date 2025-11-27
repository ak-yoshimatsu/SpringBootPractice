package com.example.practice.controller.interceptor;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

@Component // HTTPログを出力する
public class HttpLogInterceptor implements HandlerInterceptor {

	private static final Logger logger = LoggerFactory.getLogger(HttpLogInterceptor.class);

	private static final String START_TIME_ATTRIBUTE = "startTime";

	@Override
	public boolean preHandle(final HttpServletRequest request, final HttpServletResponse response, final Object handler)
			throws Exception {

		// 処理開始時間
		final long startTime = System.currentTimeMillis();
		request.setAttribute(START_TIME_ATTRIBUTE, startTime);

		// ログ出力：リクエスト開始
		final String uri = request.getRequestURI();
		final String method = request.getMethod();
		logger.info(">>> [REQUEST START] Method: {}, URI: {}", method, uri);

		// true を返すと後続のControllerの処理が実行される
		return true;
	}

	@Override
	public void afterCompletion(final HttpServletRequest request, final HttpServletResponse response,
			final Object handler, final Exception ex) throws Exception {

		// 1. 開始時刻の取得
		final Long startTime = (Long) request.getAttribute(START_TIME_ATTRIBUTE);
		final long endTime = System.currentTimeMillis();
		final long executionTime = endTime - startTime;

		// 2. ログ出力
		final int status = response.getStatus();
		final String uri = request.getRequestURI();

		if (ex != null) {
			// 例外が発生した場合
			logger.error("<<< [REQUEST ERROR] URI: {}, Status: {}, Time: {}ms, Exception: {}", uri, status,
					executionTime, ex.getMessage());
		} else {
			// 正常終了した場合
			logger.info("<<< [REQUEST END] URI: {}, Status: {}, Time: {}ms", uri, status, executionTime);
		}
	}
}
