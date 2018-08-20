package com.nts.pjt5_6.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nts.pjt5_6.dao.CategoryMapper;
import com.nts.pjt5_6.dto.Category;
import com.nts.pjt5_6.service.CategoryService;

@Service
public class CategoryServiceImpl implements CategoryService {
	@Autowired
	CategoryMapper categoryMapper;
	
	@Override
	public List<Category> getCategorie() {
		return categoryMapper.selectAllCategoryItems();
	}

	@Override
	public int getCategoryCount() {
		return categoryMapper.selectCountCategory();
	}
}
