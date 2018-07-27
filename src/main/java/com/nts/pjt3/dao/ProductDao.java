package com.nts.pjt3.dao;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import com.nts.pjt3.dto.Product;

import static com.nts.pjt3.dao.CategorieDaoSqls.SELECT_CATEGORIE_COUNT;
import static com.nts.pjt3.dao.ProductDaoSqls.*;

@Repository
public class ProductDao {

	private NamedParameterJdbcTemplate jdbc;
	private SimpleJdbcInsert insertAction;
	private RowMapper<Product> rowMapper = BeanPropertyRowMapper.newInstance(Product.class);

	public ProductDao(DataSource dataSource) {
		this.jdbc = new NamedParameterJdbcTemplate(dataSource);
		//this.insertAction = new SimpleJdbcInsert(dataSource).withTableName("guestbook").usingGeneratedKeyColumns("id");
	}

	public List<Product> selectAllProducts(Integer start, Integer limit) {
		Map<String, Integer> params = new HashMap<>();
		params.put("start", start);
		params.put("limit", limit);
		return jdbc.query(SELECT_PRODUCT_PAGING, params, rowMapper);
	}
	
	public List<Product> selectCategoryProducts(Integer start,Integer limit,Integer categoryId){
		Map<String, Integer> params = new HashMap<>();
		params.put("categoryId", categoryId);
		params.put("start", start);
		params.put("limit", limit);
		return jdbc.query(SELECT_PRODUCT_CATEGORY, params, rowMapper);
	}
	
	public int selectTotalCount() {
		return jdbc.queryForObject(SELECT_TOTAL_COUNT, Collections.emptyMap() ,Integer.class);

	}
	
	
	
	
}
