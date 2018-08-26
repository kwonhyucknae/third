package com.nts.pjt5_6.service;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.is;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import static org.mockito.Mockito.*;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

import com.nts.pjt5_6.config.ApplicationConfig;
import com.nts.pjt5_6.dao.CategoryMapper;
import com.nts.pjt5_6.dto.Category;
import com.nts.pjt5_6.service.impl.CategoryServiceImpl;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = ApplicationConfig.class, loader = AnnotationConfigContextLoader.class)
public class CategorieServiceTest {
	
	@Mock
	CategoryMapper categoryMapper;
	
	@InjectMocks
	CategoryServiceImpl categoryServiceImpl;
	
	
	@Before
	public void setUp() throws Exception{
		MockitoAnnotations.initMocks(this);
	}
	
	
	@Test
	public void testGetCount() {
		when(categoryMapper.selectCountCategory()).thenReturn(5);
		assertEquals(5,categoryServiceImpl.getCategoryCount());
	}
	
	
	@Test
	public void testGetCategoryCount() {
		Category category = new Category();
		category.setId(1);
		category.setName("test");
		List<Category> categories = new ArrayList<>();
		categories.add(category);
		
		when(categoryMapper.selectAllCategoryItems()).thenReturn(categories);
		assertThat(categoryServiceImpl.getCategorie(),is(categories));
	}
	
	
}
