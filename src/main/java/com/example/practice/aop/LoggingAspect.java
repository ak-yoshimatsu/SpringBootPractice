package com.example.practice.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {

	private static final Logger logger = LoggerFactory.getLogger(LoggingAspect.class);

	/**
	 * ポイントカット定義
	 * com.example.practice.service パッケージ内のすべてのクラスのすべてのメソッドを対象とする
	 */
	@Pointcut("execution(* com.example.practice.service.*.*(..))")
	public void serviceMethods() {
	}

	@Before("serviceMethods()")
	public void logBefore(final JoinPoint joinPoint) {
		final String methodName = joinPoint.getSignature().toShortString();
		final Object[] args = joinPoint.getArgs();

		logger.info(">>> AOP: [処理開始] メソッド: {}, 引数: {}", methodName, args);
	}

}
