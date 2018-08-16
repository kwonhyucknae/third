package com.nts.pjt5_6.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.Import;

@Configuration
@ComponentScan(basePackages = { "com.nts.pjt5_6.dao",  "com.nts.pjt5_6.service" , "com.nts.pjt5_6.controller" , "com.nts.pjt5_6.common"})
@Import({ DBConfig.class })
@EnableAspectJAutoProxy
public class ApplicationConfig {

}
