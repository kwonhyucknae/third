package com.nts.pjt3.service;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.nts.pjt5_6.dao.PromotionMapper;
import com.nts.pjt5_6.dto.Promotion;
import com.nts.pjt5_6.service.impl.PromotionServiceImpl;

public class PromotionServiceTest {

	@Mock
	PromotionMapper promotionMapper;
	
	@InjectMocks
	PromotionServiceImpl promotionServiceImpl;
	
	@Before
	public void setUp() throws Exception{
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void testGetAllPromotionItems() {
		List<Promotion> testPromotionData = new ArrayList<>();
		
		when(promotionMapper.selectAllPromotionItems()).thenReturn(testPromotionData);
		
		assertThat(promotionServiceImpl.getAllPromotionItemsInfo(),is(testPromotionData));
		verify(promotionMapper, atLeast(1)).selectAllPromotionItems();
	}
	
	@Test
	public void testCountTotalPromotion() {
		int testCountData = 1;
		
		when(promotionMapper.selectCountTotalPromotionItem()).thenReturn(testCountData);
		
		assertThat(promotionServiceImpl.getTotalPromotionCount(),is(testCountData));
		verify(promotionMapper, atLeast(1)).selectCountTotalPromotionItem();
	}

}
