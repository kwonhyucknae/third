package com.nts.pjt5_6.service;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

import com.nts.pjt5_6.config.ApplicationConfig;
import com.nts.pjt5_6.dao.ReservationInfoMapper;
import com.nts.pjt5_6.dao.ReservationInfoPriceMapper;
import com.nts.pjt5_6.dto.ReservationInfo;
import com.nts.pjt5_6.dto.ReservationInfoByEmail;
import com.nts.pjt5_6.dto.ReservationPrices;
import com.nts.pjt5_6.service.impl.ReservationServiceImpl;

import static org.mockito.Mockito.*;
import static org.hamcrest.CoreMatchers.is;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = ApplicationConfig.class, loader = AnnotationConfigContextLoader.class)
public class ReservationServiceTest {

	@Mock
	ReservationInfoMapper reservationMapper;
	
	@Mock
	ReservationInfoPriceMapper reservInfoPriceMapper;
	
	@InjectMocks
	ReservationServiceImpl reservationService;
	
	@Before
	public void setUp() throws Exception{
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void 예약정보_추가_테스트() {
		ReservationInfo 등록할_예약정보 = new ReservationInfo();
		List<ReservationPrices> 등록할_예약정보의_가격들 = new ArrayList<>();
		ReservationInfo 등록된_예약정보_데이터 = new ReservationInfo();
		
		when(reservationMapper.insertReservationInfo(등록할_예약정보)).thenReturn(1);
		when(reservInfoPriceMapper.insertReservationInfoPrice(등록할_예약정보의_가격들)).thenReturn(1);
		when(reservationMapper.selectReservationInfo(1)).thenReturn(등록된_예약정보_데이터);
		
		assertThat(reservationMapper.insertReservationInfo(등록할_예약정보),is(1));
		assertThat(reservInfoPriceMapper.insertReservationInfoPrice(등록할_예약정보의_가격들),is(1));
		assertThat(reservationMapper.selectReservationInfo(1),is(등록된_예약정보_데이터));
		
		verify(reservationMapper, atLeast(1)).insertReservationInfo(등록할_예약정보);
		verify(reservInfoPriceMapper, atLeast(1)).insertReservationInfoPrice(등록할_예약정보의_가격들);
		verify(reservationMapper, atLeast(1)).selectReservationInfo(1);
	}
	
	
	@Test
	public void 이메일아이디로_예약정보_확인_테스트() {
		List<ReservationInfoByEmail> 기대값 = new ArrayList<>();
		
		when(reservationMapper.selectReservationInfoByEmail("test@nts-corp.com")).thenReturn(기대값);
		
		assertThat(reservationMapper.selectReservationInfoByEmail("test@nts-corp.com"),is(기대값));
		verify(reservationMapper, atLeast(1)).selectReservationInfoByEmail("test@nts-corp.com");
	}
	
	@Test
	public void 예약취소정보_업데이트_테스트() {
		int 업데이트_성공 = 1;
		
		when(reservationMapper.updateReservationCancel(1)).thenReturn(업데이트_성공);
		
		assertThat(reservationMapper.updateReservationCancel(1),is(업데이트_성공));
		verify(reservationMapper, atLeast(1)).updateReservationCancel(1);
	}
}
