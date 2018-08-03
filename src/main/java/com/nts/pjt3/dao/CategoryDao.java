package com.nts.pjt3.dao;

import java.util.Collections;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.nts.pjt3.dto.Category;

import static com.nts.pjt3.dao.CategoryDaoSqls.*;

@Repository
public class CategoryDao {
	private NamedParameterJdbcTemplate jdbc;
	private RowMapper<Category> categoryMapper = BeanPropertyRowMapper.newInstance(Category.class);
	
	public CategoryDao(DataSource dataSource) {
		this.jdbc = new NamedParameterJdbcTemplate(dataSource);
	}
	
	public List<Category> selectAllCategoryItems(){
		return jdbc.query(SELECT_ALL_CATEGORY_ITEMS, categoryMapper);
	}
	
	public int selectCountCategory() {
		return jdbc.queryForObject(SELECT_COUNT_CATEGORY, Collections.emptyMap() ,Integer.class);
	}
}
