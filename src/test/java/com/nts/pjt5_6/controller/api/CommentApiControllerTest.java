package com.nts.pjt5_6.controller.api;

import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.nts.pjt5_6.dto.CommentWrite;
import com.nts.pjt5_6.service.CommentService;

public class CommentApiControllerTest {

	@Mock
	CommentService commentService;

	@InjectMocks
	CommentApiController commentApiController;
	
	private MockMvc mockMvc;
	@Before
	public void setUp() throws Exception{
		MockitoAnnotations.initMocks(this);
		mockMvc = MockMvcBuilders.standaloneSetup(commentApiController).build();
	}
	
	@Test
	public void 한줄평_추가_테스트() throws Exception {
		ObjectMapper objectMapper = new ObjectMapper();
		CommentWrite 추가할_한줄평 = new CommentWrite();
		String Json변환_한줄평 = objectMapper.writeValueAsString(추가할_한줄평);
		
		MvcResult result = mockMvc.perform(post("/api/reservationUserComments")
				.accept(MediaType.APPLICATION_JSON_UTF8)
				.contentType(MediaType.APPLICATION_JSON_UTF8)
				.content(Json변환_한줄평))
				.andExpect(status().isOk())
				.andDo(print())
				.andReturn();
		
	}
}
