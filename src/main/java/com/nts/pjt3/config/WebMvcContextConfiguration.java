package com.nts.pjt3.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

/**
 * DispatcherServlet 이 실행 될 때 읽어들이는 설정 파일
 * 이 밑에 설정들을 읽어들여서 DispatcherSerlvet 이 동작
 * 
 * 이후 -> DispatcherServlet 을 FrontController로 설정 Web.xml 에 설정
 * 이걸 해야 실제 FrontControler의 역할을 할 수 있다.
 * 
 * @author "Hyeoknae.Kwon"
 *
 */
@Configuration
@EnableWebMvc
@ComponentScan(basePackages = { "com.nts.pjt3.controller" })
public class WebMvcContextConfiguration extends WebMvcConfigurerAdapter {
	
	/* 
	 * 컨트롤러의 URL이 매핑되어있는 요청만 들어오는게 아니라 css, 이미지 , 자바스크립트 이런 등등의 것들도 / 때문에 모든 요청을 다 받는다
	 * css/~~ 등등 이렇게 시작하는 URL 요청을 애플리케이션 루트 디렉터리 아래에 있는 각각에 이런 디렉터리들을 만들어 놓고
	 * 거기에다가 알맞게 사용하게 해줄 거다.
	 */
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/assets/**").addResourceLocations("classpath:/META-INF/resources/webjars/")
				.setCachePeriod(31556926);
		registry.addResourceHandler("/css/**").addResourceLocations("/css/").setCachePeriod(31556926);
		registry.addResourceHandler("/img/**").addResourceLocations("/img/").setCachePeriod(31556926);
		registry.addResourceHandler("/js/**").addResourceLocations("/js/").setCachePeriod(31556926);
	}

	// default servlet handler를 사용하게 합니다.
	/* 파라미터로 받은 Defa~ 객체의 enable 이라는 메서드를 호출함으로써 DefaultServletHandler 를 사용하도록 해준다.
	 * 매핑 정보가 없는 URL 요청은 스프링의 DefaultServletHttpRequestHandler 가 처리해준다.
	 */
	@Override
	public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
		configurer.enable();
	}

	/* 
	 * 특정 url에 대한 처리를 컨트롤러 클래스를 작성하지 않고 매핑 할 수 있도록 해준다. 
	 * / 하고 들어오면 main 이라고 하는 이름의 뷰로 보여준다.
	 * view name 은 ViewResolver 라는 객체를 이용해서 찾는다
	 * 실제 main 이라는 이름만 가지고서는 뷰 정보를 찾아낼 수가 없고
	 * 뷰 정보는 getInternalResourceViewResolver 메서드에서 설정된 형태로 뷰를 사용
	 * 
	 */
	@Override
	public void addViewControllers(final ViewControllerRegistry registry) {
		System.out.println("addViewControllers가 호출됩니다. ");
		registry.addViewController("/").setViewName("main");
	}

	@Bean
	public InternalResourceViewResolver getInternalResourceViewResolver() {
		InternalResourceViewResolver resolver = new InternalResourceViewResolver();
		resolver.setPrefix("/WEB-INF/views/");
		resolver.setSuffix(".jsp");
		return resolver;
	}
}
