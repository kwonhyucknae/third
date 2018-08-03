package com.nts.pjt3.common;


import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class ExceptionAop {
	
	 @Pointcut("within(com.nts.pjt3.service.impl.*)")
	    private void pointcutMethod(){       
	    }
	 
	 @AfterThrowing(pointcut="pointcutMethod()", throwing = "exceptObj")
	 public void exception(JoinPoint jp ,Exception exceptObj) {
	        String method = jp.getSignature().getName();
	        System.out.println(method + "() 메소드 수행 중 예외 발생!");

	        if (exceptObj instanceof RuntimeException) {
	            System.out.println("예외 발생");
	            exceptObj.getMessage();
	        } else {
	            System.out.println("기타 예외 발생");
	        }
	 }
}
