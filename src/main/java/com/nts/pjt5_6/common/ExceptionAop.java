package com.nts.pjt5_6.common;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * @description service 패키지에서 발생하는 RuntimeException 및 모든 오류에 대한 예외처리를 해주는 Aop 클래스입니다.
 * @author "Hyeoknae.Kwon"
 *
 */

@Component
@Aspect
public class ExceptionAop {
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Pointcut("within(com.nts.pjt5_6.service.impl.*)")
	private void pointcutMethod() {
	}

	
	@AfterThrowing(pointcut = "pointcutMethod()", throwing = "exceptObj")
	public void exception(JoinPoint jp, Exception exceptObj) {
		String method = jp.getSignature().getName();
		logger.error("{} 메소드 수행중 예외 발생",method);
		
		if (exceptObj instanceof RuntimeException) {
			logger.error(
					"Runtime 예외 발생 에러 메시지 : {} \n 에러 클래스 : {} \n {}"
					,exceptObj.getMessage()
					,exceptObj.getClass()
					,exceptObj.getCause()
					);
		} else {
			logger.error(
					"기타 예외 발생\n"
					+ "에러 메시지 : {} \n"
					+ "에러 클래스 : {} \n"
					+ "{}"
					,exceptObj.getMessage()
					,exceptObj.getClass()
					,exceptObj.getCause());
		}
	}

}
