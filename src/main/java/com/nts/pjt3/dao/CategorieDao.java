package com.nts.pjt3.dao;

import java.util.Collections;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import com.nts.pjt3.dto.Category;

import static com.nts.pjt3.dao.CategorieDaoSqls.*;

@Repository
public class CategorieDao {
	private NamedParameterJdbcTemplate jdbc;
	private SimpleJdbcInsert insertAction;
	private RowMapper<Category> rowMapper = BeanPropertyRowMapper.newInstance(Category.class);
	
	public CategorieDao(DataSource dataSource) {
		this.jdbc = new NamedParameterJdbcTemplate(dataSource);
		this.insertAction = new SimpleJdbcInsert(dataSource)
				.withTableName("category")
				.usingGeneratedKeyColumns("id");
		
	}
	
	public List<Category> selectAll(){
		return jdbc.query(SELECT_ALL, rowMapper);
	}
	
	public int selectCategorieCount() {
		return jdbc.queryForObject(SELECT_CATEGORIE_COUNT, Collections.emptyMap() ,Integer.class);
	}
}
