package com.nts.pjt3.dao;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.nts.pjt3.dto.Comments;
import com.nts.pjt3.dto.DisplayInfoImages;
import com.nts.pjt3.dto.Product;
import com.nts.pjt3.dto.ProductImages;
import com.nts.pjt3.dto.ProductPrices;
import com.nts.pjt3.dto.ReservationUserCommentImages;

import static com.nts.pjt3.dao.ProductDaoSqls.*;

@Repository
public class ProductDao {

	private NamedParameterJdbcTemplate jdbc;
	private RowMapper<Product> productMapper = BeanPropertyRowMapper.newInstance(Product.class);
	private RowMapper<ProductImages> productImagesMapper = BeanPropertyRowMapper.newInstance(ProductImages.class);
	private RowMapper<DisplayInfoImages> displayImagesMapper = BeanPropertyRowMapper.newInstance(DisplayInfoImages.class);
	private RowMapper<ProductPrices> productPricesMapper = BeanPropertyRowMapper.newInstance(ProductPrices.class);
	private RowMapper<ReservationUserCommentImages> commentImagesByCommentIdMapper = BeanPropertyRowMapper.newInstance(ReservationUserCommentImages.class);
	private RowMapper<Comments> commentsMapper = BeanPropertyRowMapper.newInstance(Comments.class);
	
	public ProductDao(DataSource dataSource) {
		this.jdbc = new NamedParameterJdbcTemplate(dataSource);
	}

	public List<Product> selectProductsPaging(Integer start, Integer limit) {
		Map<String, Integer> params = new HashMap<>();
		params.put("start", start);
		params.put("limit", limit);
		return jdbc.query(SELECT_PRODUCTS_PAGING, params, productMapper);
	}
	
	public List<Product> selectProductsByCategory(Integer start,Integer limit,Integer categoryId){
		Map<String, Integer> params = new HashMap<>();
		params.put("categoryId", categoryId);
		params.put("start", start);
		params.put("limit", limit);
		return jdbc.query(SELECT_PRODUCTS_BY_CATEGORY, params, productMapper);
	}
	
	public int selectCountAllDisplayInfo() {
		return jdbc.queryForObject(SELECT_COUNT_ALL_DISPLAYINFO, Collections.emptyMap() ,Integer.class);

	}
	
	public int selectCountDisplayInfoByCategory(Integer categoryId) {
		Map<String, Integer> params = new HashMap<>();
		params.put("categoryId", categoryId);
		return jdbc.queryForObject(SELECT_COUNT_DISPLAYINFO_BY_CATEGORY, params ,Integer.class);
	}
	
	public Product selectProductById(int dpInfoId){
		Map<String,Integer> params = new HashMap<>();
		params.put("dpInfoId", dpInfoId);
		return jdbc.queryForObject(SELECT_PRODUCT_BY_DISPLAYINFO_ID, params ,productMapper);
	}
	// queryForObject 바꾸기
	public List<ProductImages> selectProductImagesInfo(int dpInfoId){
		Map<String,Integer> params = new HashMap<>();
		params.put("dpInfoId", dpInfoId);
		return jdbc.query(SELECT_PRODUCT_IMAGES_INFO_BY_DISPLAYINFO_ID, params ,productImagesMapper);

	}
	
	public List<DisplayInfoImages> selectDisplayImagesInfo(int dpInfoId){
		Map<String,Integer> params = new HashMap<>();
		params.put("dpInfoId", dpInfoId);
		return jdbc.query(SELECT_DISPLAY_IMAGES_INFO_BY_DISPLAYINFO_ID, params ,displayImagesMapper);
	}
	
	public List<ReservationUserCommentImages> selectCommentImagesByCommentId(int commentID){
		Map<String,Integer> params = new HashMap<>();
		params.put("commentID", commentID);
		return jdbc.query(SELECT_COMMENT_IMAGES_BY_COMMENT_ID, params ,commentImagesByCommentIdMapper);
	}
	
	public List<Comments> selectComments(int dpInfoId){
		Map<String,Integer> params = new HashMap<>();
		params.put("dpInfoId", dpInfoId);
		return jdbc.query(SELECT_COMMENTS_BY_DISPLAYINFO_ID, params ,commentsMapper);
	}
	
	public long selectAvgScore(int dpInfoId) {
		Map<String,Integer> params = new HashMap<>();
		params.put("dpInfoId", dpInfoId);
		return jdbc.queryForObject(SELECT_AVG_SCORE, params ,Long.class);
	}
	
	public List<ProductPrices> selectProductPrices(int dpInfoId){
		Map<String,Integer> params = new HashMap<>();
		params.put("dpInfoId", dpInfoId);
		return jdbc.query(SELECT_PRODUCT_PRICES_BY_DISPLAYINFO_ID, params ,productPricesMapper);
	}
	
}
