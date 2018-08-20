package com.nts.pjt3.service;

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

import com.nts.pjt5_6.config.ApplicationConfig;
import com.nts.pjt5_6.dao.DisplayInfoMapper;
import com.nts.pjt5_6.dto.Comments;
import com.nts.pjt5_6.dto.DisplayInfoImages;
import com.nts.pjt5_6.dto.Product;
import com.nts.pjt5_6.dto.ProductImages;
import com.nts.pjt5_6.dto.ProductPrices;
import com.nts.pjt5_6.dto.ReservationUserCommentImages;
import com.nts.pjt5_6.service.impl.DisplayInfoServiceImpl;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes= {ApplicationConfig.class}, loader = AnnotationConfigContextLoader.class)
@WebAppConfiguration
public class DisplayInfoServiceTest {
	
	@Mock
	DisplayInfoMapper displayInfoMapper;
	
	@InjectMocks
	DisplayInfoServiceImpl displayServiceImpl;
	
	
	@Before
	public void setUp() throws Exception{
		MockitoAnnotations.initMocks(this);
	}
	
//	@Test(expected = RuntimeException.class)
//	public void testGetDisplayInfo_throwsException() {
//		
//	}
	
	
	@Test
	public void testGetProductById() {
		Product testProductData = new Product();
		when(displayInfoMapper.selectProductById(1)).thenReturn(testProductData);
		
		assertThat(displayInfoMapper.selectProductById(1),is(testProductData));
		verify(displayInfoMapper, atLeast(1)).selectProductById(1);
	}
	
	@Test
	public void testGetProductImagesInfo() {
		List<ProductImages> testProductImageData = new ArrayList<>();
		
		when(displayInfoMapper.selectProductImagesInfo(1)).thenReturn(testProductImageData);
		
		assertThat(displayInfoMapper.selectProductImagesInfo(1),is(testProductImageData));
		verify(displayInfoMapper, atLeast(1)).selectProductImagesInfo(1);
	}
	
	@Test
	public void testGetDisplayImagesInfo() {
		List<DisplayInfoImages> testDisplayInfoImagesData = new ArrayList<>();
		
		when(displayInfoMapper.selectDisplayImagesInfo(1)).thenReturn(testDisplayInfoImagesData);
		
		assertThat(displayInfoMapper.selectDisplayImagesInfo(1),is(testDisplayInfoImagesData));
		verify(displayInfoMapper, atLeast(1)).selectDisplayImagesInfo(1);
	}
	
	@Test
	public void testGetCommentImgesInfo() {
		List<ReservationUserCommentImages> testCommentImageData = new ArrayList<>();
		
		when(displayInfoMapper.selectCommentImagesByCommentId(1)).thenReturn(testCommentImageData);
		
		assertThat(displayInfoMapper.selectCommentImagesByCommentId(1),is(testCommentImageData));
		verify(displayInfoMapper, atLeast(1)).selectCommentImagesByCommentId(1);
	}
	
	@Test
	public void testGetComments() {
		List<Comments> testCommentData = new ArrayList<>();
		
		when(displayInfoMapper.selectCommentsByDisplayId(1)).thenReturn(testCommentData);
		assertThat(displayInfoMapper.selectCommentsByDisplayId(1),is(testCommentData));
		verify(displayInfoMapper, atLeast(1)).selectCommentsByDisplayId(1);
	}
	
	@Test
	public void testGetAvgScore() {
		double testDoubleData = 1.1;
		
		when(displayInfoMapper.selectAvgScore(1)).thenReturn(testDoubleData);
		assertThat(displayInfoMapper.selectAvgScore(1),is(testDoubleData));
		verify(displayInfoMapper, atLeast(1)).selectAvgScore(1);
	}
	
	@Test
	public void testGetProductPrices() {
		List<ProductPrices> testProductPricesData = new ArrayList<>();
		
		when(displayInfoMapper.selectProductPrices(1)).thenReturn(testProductPricesData);
		assertThat(displayInfoMapper.selectProductPrices(1),is(testProductPricesData));
		verify(displayInfoMapper, atLeast(1)).selectProductPrices(1);
	
	}
	
}
