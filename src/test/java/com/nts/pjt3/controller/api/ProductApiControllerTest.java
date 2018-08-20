package com.nts.pjt3.controller.api;


import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import static org.mockito.Mockito.*;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.nts.pjt5_6.config.ApplicationConfig;
import com.nts.pjt5_6.controller.api.ProductApiController;
import com.nts.pjt5_6.dto.Product;
import com.nts.pjt5_6.service.ProductService;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes= {ApplicationConfig.class}, loader = AnnotationConfigContextLoader.class)
@WebAppConfiguration
public class ProductApiControllerTest{
	
	@Mock
	private ProductService productService;

	@InjectMocks
	private ProductApiController productApiController;
	
	
	private MockMvc mockMvc;
	@Before
	public void setUp() throws Exception{
		MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(productApiController).build();
	}
	
	@Test
	public void connectStatustest() throws Exception{
		 mockMvc.perform(get("/products")).andExpect(status().isOk());
	}
	
	@Test
	public void connectWithParameter() throws Exception{
		Product testData = new Product();
		testData.setId(1);
		List<Product> product = new ArrayList<>();
		product.add(testData);
		int prod = 10;
		
		when(productService.getProducts(1,0)).thenReturn(product);
		when(productService.getTotalCount(1)).thenReturn(prod);
		
		MvcResult result =	mockMvc.perform(get("/products")
									.accept(MediaType.APPLICATION_JSON)
									.param("categoryId","1")
									.param("start", "0"))
									.andExpect(status().isOk())
									.andDo(print())
									.andReturn();
		String content = result.getResponse().getContentAsString();
		System.out.println(content);
	
		
		verify(productService, atLeast(1)).getProducts(1,0);
		verify(productService, atLeast(1)).getTotalCount(1);
 	}
	
	
	
	
}
