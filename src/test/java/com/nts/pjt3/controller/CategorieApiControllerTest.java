//package com.nts.pjt3.controller;
//
//import org.junit.Before;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.MockitoAnnotations;
//import org.mockito.runners.MockitoJUnitRunner;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.MessageSource;
//import org.springframework.test.context.ContextConfiguration;
//import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
//import org.springframework.test.context.support.AnnotationConfigContextLoader;
//import org.springframework.test.context.web.WebAppConfiguration;
//import org.springframework.test.web.servlet.MockMvc;
//import org.springframework.test.web.servlet.setup.MockMvcBuilders;
//import org.springframework.web.context.WebApplicationContext;
//
//import com.nts.pjt3.config.WebMvcContextConfiguration;
//import com.nts.pjt3.service.CategorieService;
//import com.nts.pjt3.service.impl.CategorieServiceImpl;
//
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
//import junit.framework.TestCase;
//
//
//@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(classes= {WebMvcContextConfiguration.class}, loader = AnnotationConfigContextLoader.class)
//@WebAppConfiguration
//public class CategorieApiControllerTest extends TestCase {
//	
////	@Mock
////	CategorieService categorieService;
////	
////    @InjectMocks
////	private CategorieApiController categorieApiController;
////    
//    @InjectMocks
//    private WebApplicationContext wac;
//	private MockMvc mockMvc;
//	
//	@Before
//	public void setUp() throws Exception{
//		//MockitoAnnotations.initMocks(this);
////        mockMvc = MockMvcBuilders.standaloneSetup(categorieService).build();
//		this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build();
//	}
//	
//	@Test
//	public void testCategoryApiController() throws Exception{
//		mockMvc.perform(get("/categories")).andExpect(status().isOk());	
//	}
//	
//}
