package com.nts.pjt5_6.controller.api;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.*;

import static org.mockito.Mockito.*;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.nts.pjt5_6.config.ApplicationConfig;
import com.nts.pjt5_6.controller.api.ProductImageApiController;
import com.nts.pjt5_6.dto.ProductImages;
import com.nts.pjt5_6.service.ImageService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes= {ApplicationConfig.class}, loader = AnnotationConfigContextLoader.class)
@WebAppConfiguration
public class ProductImageApiControllerTest {
	
	@Mock
	private ImageService imageService;

	@InjectMocks
	private ProductImageApiController productImageApiController;
	
	
	private MockMvc mockMvc;
	@Before
	public void setUp() throws Exception{
		MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(productImageApiController).build();
	}
	
	@Test
	public void connectStatustest() throws Exception{
		 mockMvc.perform(get("/api/productImages/1")).andExpect(status().isOk());
	}
	
	@Test
	public void connectWithParameter() throws Exception{
		ProductImages testProductImages = new ProductImages();
		testProductImages.setSaveFileName("img/test_location.png");;
		testProductImages.setType("ma");
		List<ProductImages> imageTestData = new ArrayList<>();
		imageTestData.add(testProductImages);
		
		when(imageService.getProductImagesInfoByIdAndType(1, "ma")).thenReturn(imageTestData);
		
		MvcResult result = mockMvc.perform(get("/api/productImages/1")
				.accept(MediaType.APPLICATION_JSON)
				.param("type", "ma"))
				.andExpect(status().isOk())
				.andDo(print())
				.andReturn();
		
		String content = result.getResponse().getContentAsString();
		System.out.println(content);
							
		verify(imageService, atLeast(1)).getProductImagesInfoByIdAndType(1, "ma");

	}

}
