package com.nts.pjt3.controller.api;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.nts.pjt5_6.config.ApplicationConfig;
import com.nts.pjt5_6.controller.api.PromotionApiController;
import com.nts.pjt5_6.service.PromotionService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes= {ApplicationConfig.class}, loader = AnnotationConfigContextLoader.class)
@WebAppConfiguration
public class PromotionApiControllerTest {
	
	@Mock
	private PromotionService promotionService;

	@InjectMocks
	private PromotionApiController promotionApiController;
	
	
	private MockMvc mockMvc;
	@Before
	public void setUp() throws Exception{
		MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(promotionApiController).build();
	}
	
	@Test
	public void testConnectStatus() throws Exception{
		 mockMvc.perform(get("/promotions")).andExpect(status().isOk());
	}
}
