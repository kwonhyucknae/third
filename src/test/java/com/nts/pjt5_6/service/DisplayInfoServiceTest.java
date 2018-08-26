package com.nts.pjt5_6.service;

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
import com.nts.pjt5_6.dao.DisplayInfoImageMapper;
import com.nts.pjt5_6.dao.DisplayInfoMapper;
import com.nts.pjt5_6.dao.ProductImageMapper;
import com.nts.pjt5_6.dao.ProductMapper;
import com.nts.pjt5_6.dao.ProductPriceMapper;
import com.nts.pjt5_6.dao.ReservationUserCommentImageMapper;
import com.nts.pjt5_6.dao.ReservationUserCommentMapper;
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
	@Mock
	DisplayInfoImageMapper dispInfoImgMapper;
	@Mock
	ProductMapper prodMapper;
	@Mock
	ProductImageMapper prodImgMapper;
	@Mock
	ReservationUserCommentImageMapper reservCommentImg;
	@Mock
	ReservationUserCommentMapper commentMapper;
	@Mock
	ProductPriceMapper prodPriceMapper;

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
		when(prodMapper.selectProductByDisplayId(1)).thenReturn(testProductData);
		
		assertThat(prodMapper.selectProductByDisplayId(1),is(testProductData));
		verify(prodMapper, atLeast(1)).selectProductByDisplayId(1);
	}
	
	@Test
	public void testGetProductImagesInfo() {
		List<ProductImages> testProductImageData = new ArrayList<>();
		
		when(prodImgMapper.selectProductImagesInfoByDispId(1)).thenReturn(testProductImageData);
		
		assertThat(prodImgMapper.selectProductImagesInfoByDispId(1),is(testProductImageData));
		verify(prodImgMapper, atLeast(1)).selectProductImagesInfoByDispId(1);
	}
	
	@Test
	public void testGetDisplayImagesInfo() {
		List<DisplayInfoImages> testDisplayInfoImagesData = new ArrayList<>();
		
		when(dispInfoImgMapper.selectDisplayImagesInfo(1)).thenReturn(testDisplayInfoImagesData);
		
		assertThat(dispInfoImgMapper.selectDisplayImagesInfo(1),is(testDisplayInfoImagesData));
		verify(dispInfoImgMapper, atLeast(1)).selectDisplayImagesInfo(1);
	}
	
	@Test
	public void testGetCommentImgesInfo() {
		List<ReservationUserCommentImages> testCommentImageData = new ArrayList<>();
		
		when(reservCommentImg.selectCommentImagesByCommentId(1)).thenReturn(testCommentImageData);
		
		assertThat(reservCommentImg.selectCommentImagesByCommentId(1),is(testCommentImageData));
		verify(reservCommentImg, atLeast(1)).selectCommentImagesByCommentId(1);
	}
	
	@Test
	public void testGetComments() {
		List<Comments> testCommentData = new ArrayList<>();
		
		when(commentMapper.selectCommentsByDisplayId(1)).thenReturn(testCommentData);
		assertThat(commentMapper.selectCommentsByDisplayId(1),is(testCommentData));
		verify(commentMapper, atLeast(1)).selectCommentsByDisplayId(1);
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
		
		when(prodPriceMapper.selectProductPrices(1)).thenReturn(testProductPricesData);
		assertThat(prodPriceMapper.selectProductPrices(1),is(testProductPricesData));
		verify(prodPriceMapper, atLeast(1)).selectProductPrices(1);
	
	}
	
}
