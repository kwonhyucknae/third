package com.nts.pjt3.service;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.is;
import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.nts.pjt5_6.dao.ImageMapper;
import com.nts.pjt5_6.dto.ProductImages;
import com.nts.pjt5_6.service.impl.ImageServiceImpl;

import static org.mockito.Mockito.*;

public class ImageServiceTest {

	@Mock
	ImageMapper imageMapper;
	
	@InjectMocks
	ImageServiceImpl imageServiceImpl;
	
	@Before
	public void setUp() throws Exception{
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void testGetProductImagesInfoByIdAndType() {
		List<ProductImages> selectAllProductImagesInfoTestDataList = new ArrayList<>();
		List<ProductImages> selectProductImagesInfoByTypeTestDataList = new ArrayList<>();
		
		when(imageMapper.selectProductImagesInfoByIdAndType(1, "all")).thenReturn(selectAllProductImagesInfoTestDataList);
		when(imageMapper.selectProductImagesInfoByIdAndType(1, "ma")).thenReturn(selectAllProductImagesInfoTestDataList);
		
		assertThat(imageServiceImpl.getProductImagesInfoByIdAndType(1, "all"),is(selectAllProductImagesInfoTestDataList));
		assertThat(imageServiceImpl.getProductImagesInfoByIdAndType(1, "ma"), is(selectProductImagesInfoByTypeTestDataList));
		
		verify(imageMapper , atLeast(1)).selectProductImagesInfoByIdAndType(1 ,"all");
		verify(imageMapper , atLeast(1)).selectProductImagesInfoByIdAndType(1, "ma");
	}
	
	@Test
	public void testGetProductImagesInfoByProductImageId() {
		ProductImages productImagesInfoByImageId = new ProductImages();
		
		when(imageMapper.selectProductImagesInfoByProductImageId(1)).thenReturn(productImagesInfoByImageId);
		assertThat(imageServiceImpl.getProductImagesInfoByProductImageId(1), is(productImagesInfoByImageId));
	}
}
