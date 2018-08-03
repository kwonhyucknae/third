package com.nts.pjt3.dao;

import java.util.Collections;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.nts.pjt3.dto.Promotion;

import static com.nts.pjt3.dao.PromotionDaoSqls.*;

@Repository
public class PromotionDao {
	private NamedParameterJdbcTemplate jdbc;
	private RowMapper<Promotion> promotionMapper = BeanPropertyRowMapper.newInstance(Promotion.class);
	
	public PromotionDao(DataSource dataSource) {
		this.jdbc = new NamedParameterJdbcTemplate(dataSource);
	}
	
	public List<Promotion> selectAllPromotionItems(){
		return jdbc.query(SELECT_PROMOTION_ITEMS_INFO, Collections.emptyMap() ,promotionMapper);
	}
	
	public int selectCountTotalPromotionItem() {
		return jdbc.queryForObject(SELECT_COUNT_ALL_PROMOTION, Collections.emptyMap() ,Integer.class);
	}
}
