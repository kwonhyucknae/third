package com.nts.pjt5_6.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.nts.pjt5_6.dto.Category;

@Mapper
public interface CategoryMapper {
	public List<Category> selectAllCategoryItems();
	public int selectCountCategory();
}
