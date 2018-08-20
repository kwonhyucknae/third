package com.nts.pjt5_6.common;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * @description service 패키지에서 발생하는 RuntimeException 및 모든 오류에 대한 예외처리를 해주는 Aop 클래스입니다.
 * @description PJT.6 이후 개선할 사항 -> sysout 을 로그로 변경 
 * @author "Hyeoknae.Kwon"
 *
 */
@Component
@Aspect
public class ExceptionAop {
	@Pointcut("within(com.nts.pjt5_6.service.impl.*)")
	private void pointcutMethod() {
	}

	
	@AfterThrowing(pointcut = "pointcutMethod()", throwing = "exceptObj")
	public void exception(JoinPoint joinpoint, Exception exceptObj) {
		String method = joinpoint.getSignature().getName();
		System.out.println(method + "() 메소드 수행 중 예외 발생!");

		if (exceptObj instanceof RuntimeException) {
			System.out.println("예외 발생");
			exceptObj.getMessage();
		} else {
			System.out.println("기타 예외 발생");
		}
	}

}
