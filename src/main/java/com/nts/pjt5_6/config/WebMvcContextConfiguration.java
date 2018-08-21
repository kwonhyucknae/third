package com.nts.pjt5_6.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import com.nts.pjt5_6.common.LogInterceptor;
import com.nts.pjt5_6.common.LoginInterceptor;

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
@ComponentScan(basePackages = { "com.nts.pjt5_6.controller" })
public class WebMvcContextConfiguration extends WebMvcConfigurerAdapter {
	
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/assets/**").addResourceLocations("classpath:/META-INF/resources/webjars/")
				.setCachePeriod(31556926);
		registry.addResourceHandler("/css/**").addResourceLocations("/css/").setCachePeriod(31556926);
		registry.addResourceHandler("/img/**").addResourceLocations("/img/").setCachePeriod(31556926);
		registry.addResourceHandler("/js/**").addResourceLocations("/js/").setCachePeriod(31556926);
	}

	@Override
	public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
		configurer.enable();
	}

	@Override
	public void addViewControllers(final ViewControllerRegistry registry) {
		System.out.println("addViewControllers가 호출됩니다. ");
		registry.addViewController("/").setViewName("main");
	}

	@Bean
    public MultipartResolver multipartResolver() {
        org.springframework.web.multipart.commons.CommonsMultipartResolver multipartResolver = new org.springframework.web.multipart.commons.CommonsMultipartResolver();
        multipartResolver.setMaxUploadSize(10485760); // 1024 * 1024 * 10
        return multipartResolver;
    }
	
	@Bean
	public InternalResourceViewResolver getInternalResourceViewResolver() {
		InternalResourceViewResolver resolver = new InternalResourceViewResolver();
		resolver.setPrefix("/WEB-INF/views/");
		resolver.setSuffix(".jsp");
		return resolver;
	}
	
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
    		registry.addInterceptor(new LoginInterceptor())
    				.addPathPatterns("/bookingLogin");
    		
    		registry.addInterceptor(new LogInterceptor())
    				.addPathPatterns("/categories")
    				.addPathPatterns("/api/reservationUserComments")
    				.addPathPatterns("/products")
    				.addPathPatterns("/api/productImages")
    				.addPathPatterns("/promotions")
    				.addPathPatterns("/api/reservationInfos");
	}
	
	
}
