package com.nts.pjt5_6.common;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;


public class LoginInterceptor extends HandlerInterceptorAdapter{
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		
		String loginEmail = getCookieEmail(request);
		
		if(loginEmail != null) {
			response.sendRedirect("/myreservation");
		}
		
		return true;
	}
	
	public static String getCookieEmail(HttpServletRequest request) {
		Cookie[] cookies = request.getCookies();

		if (cookies != null) {
			for(Cookie cookie : cookies) {
				if(cookie.getName().equals("loginEmail")) {
					return cookie.getValue();
				}
			}
		}
		return null;
	}

}
