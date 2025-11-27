package com.example.practice.config;

import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.example.practice.controller.interceptor.HttpLogInterceptor;

public class WebMvcConfig implements WebMvcConfigurer {

	private final HttpLogInterceptor httpLogInterceptor;

	// コンストラクタインジェクションでInterceptorを取得
	public WebMvcConfig(final HttpLogInterceptor httpLogInterceptor) {
		this.httpLogInterceptor = httpLogInterceptor;
	}

	// InterceptorをMVCの設定に登録
	@Override
	public void addInterceptors(final InterceptorRegistry registry) {
		// すべてのパス ("/**") にHttpLogInterceptorを適用
		registry.addInterceptor(httpLogInterceptor).addPathPatterns("/**");
	}
}
