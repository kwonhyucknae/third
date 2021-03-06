package com.nts.pjt5_6.common;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class LogInterceptor extends HandlerInterceptorAdapter{
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		Calendar calendar = Calendar.getInstance();
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy:MM:dd HH:mm:ss");
		
		logger.info(
				"요청된 URL : {} \n"
				+ "현재시간 : {} \n"
				+ "Client IP : {} \n"
				,request.getRequestURI()
				,dateFormat.format(calendar.getTime())
				,request.getRemoteAddr()
				);
		logger.debug("{} 를 호출했습니다.", handler.toString());
		return true;
	}

}
