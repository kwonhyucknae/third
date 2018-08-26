package com.nts.pjt5_6.controller.api;

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

import com.fasterxml.jackson.databind.ObjectMapper;
import com.nts.pjt5_6.config.ApplicationConfig;
import com.nts.pjt5_6.dto.ReservationInfo;
import com.nts.pjt5_6.dto.ReservationInfoByEmail;
import com.nts.pjt5_6.dto.ReservationPrices;
import com.nts.pjt5_6.service.ReservationService;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import java.util.ArrayList;
import java.util.List;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes= {ApplicationConfig.class}, loader = AnnotationConfigContextLoader.class)
@WebAppConfiguration
public class ReservationInfoApiControllerTest {

	@Mock
	ReservationService reservationService;

	@InjectMocks
	ReservationInfoApiController reservApiController;
	
	private MockMvc mockMvc;
	@Before
	public void setUp() throws Exception{
		MockitoAnnotations.initMocks(this);
		mockMvc = MockMvcBuilders.standaloneSetup(reservApiController).build();
	}
	@Test
	public void 예약정보_추가_Api_테스트() throws Exception {
		ObjectMapper objectMapper = new ObjectMapper();
		ReservationInfo 추가할_예약정보 = new ReservationInfo();
		List<ReservationPrices> 예약정보_가격 = new ArrayList<>();
		ReservationPrices 가격테스트 = new ReservationPrices.Builder()
									.setId(1)
									.setCount(1)
									.setProductPriceId(1)
									.setReservationInfoId(1)
									.build();
		예약정보_가격.add(가격테스트);
		추가할_예약정보.setId(1);
		추가할_예약정보.setPrices(예약정보_가격);
		
		String Json변환_예약정보 = objectMapper.writeValueAsString(추가할_예약정보);
		
		MvcResult result = mockMvc.perform(post("/api/reservationInfos")
									.accept(MediaType.APPLICATION_JSON_UTF8)
									.contentType(MediaType.APPLICATION_JSON_UTF8)
									.content(Json변환_예약정보))
									.andExpect(status().isOk())
									.andDo(print())
									.andReturn();
		
		String content = result.getResponse().getContentAsString();
		System.out.println(content);
	}
	
	@Test
	public void 이메일로_예약정보_확인_테스트() throws Exception {
		List<ReservationInfoByEmail> 반환될_이메일_데이터 = new ArrayList<>();
		when(reservationService.selectReservationInfoByEmail("테스트_이메일_주소")).thenReturn(반환될_이메일_데이터);
		
		MvcResult result = mockMvc.perform(get("/api/reservationInfos")
									.accept(MediaType.APPLICATION_JSON_UTF8)
									.contentType(MediaType.APPLICATION_JSON_UTF8)
									.param("reservationEmail","테스트_이메일_주소"))
									.andExpect(status().isOk())
									.andDo(print())
									.andReturn();
		
		String content = result.getResponse().getContentAsString();
		System.out.println(content);
		verify(reservationService, atLeast(1)).selectReservationInfoByEmail("테스트_이메일_주소");
		
	}
}
