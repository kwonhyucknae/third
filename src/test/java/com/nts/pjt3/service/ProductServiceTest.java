package com.nts.pjt3.service;

import static org.hamcrest.CoreMatchers.is;
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
import com.nts.pjt5_6.dao.ProductMapper;
import com.nts.pjt5_6.dto.Product;
import com.nts.pjt5_6.service.impl.ProductServiceImpl;

import static org.mockito.Mockito.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = ApplicationConfig.class, loader = AnnotationConfigContextLoader.class)
public class ProductServiceTest {

	@Mock
	ProductMapper productMapper;
	
	@InjectMocks
	ProductServiceImpl productServiceImpl;
	
	@Before
	public void setUp() throws Exception{
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void testGetProducts() {
		List<Product> productPagingTestData = new ArrayList<>();
		List<Product> productByCategoryTestData = new ArrayList<>();
		
		when(productMapper.selectProductsPaging(0, 4, 0)).thenReturn(productPagingTestData);
		when(productMapper.selectProductsPaging(0, 4, 1)).thenReturn(productByCategoryTestData);
		
		
		assertThat(productServiceImpl.getProducts(0, 0),is(productPagingTestData));
		assertThat(productServiceImpl.getProducts(1, 0),is(productByCategoryTestData));
		
		verify(productMapper, atLeast(1)).selectProductsPaging(0, 4 ,0);
		verify(productMapper, atLeast(1)).selectProductsPaging(0, 4 ,1);
	}
	
//	@Test
//	public void testGetTotalCount() {
//		int CountAllTestData = 1;
//		int CountDisplayInfoByCategoryIdTestData = 2;
//		
//		when(productMapper.selectCountDisplayInfo(0)).thenReturn(CountAllTestData);
//		when(productMapper.selectCountDisplayInfo(1)).thenReturn(CountDisplayInfoByCategoryIdTestData);
//		
//		assertThat(productServiceImpl.getTotalCount(0),is(CountAllTestData));
//		assertThat(productServiceImpl.getTotalCount(1),is(CountDisplayInfoByCategoryIdTestData));
//	}
//	
}
