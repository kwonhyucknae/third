package com.nts.pjt3.service;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

import com.nts.pjt3.config.ApplicationConfig;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = ApplicationConfig.class, loader = AnnotationConfigContextLoader.class)
public class CategorieServiceTest {
	@Autowired
	CategoryService categoryService;
	
	
	@Test
	public void testGetCount() {
		int size = categoryService.getCategoryCount();
		assertEquals(5,size);
	}
	
	
	@Test
	public void test() {
		//fail("Not yet implemented");
	}

}