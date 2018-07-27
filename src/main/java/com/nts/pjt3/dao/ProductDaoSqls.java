package com.nts.pjt3.dao;

public class ProductDaoSqls {
	public static final String SELECT_PRODUCT_PAGING = "SELECT product.id,category_id,category.name,description,content,event,opening_hours,place_name,place_lot,place_street,tel,homepage,email,product.create_date,product.modify_date\r\n"
			+ "FROM product,display_info,category\r\n"
			+ "WHERE product.id= display_info.product_id and category_id = category.id "
			+ "ORDER BY product.id LIMIT :start, :limit";

	public static final String SELECT_PRODUCT_CATEGORY = "SELECT product.id,category_id,category.name,description,content,event,opening_hours,place_name,place_lot,place_street,tel,homepage,email,product.create_date,product.modify_date\r\n"
			+ "FROM product,display_info,category\r\n"
			+ "WHERE product.id= display_info.product_id AND category_id = category.id AND category_id = :categoryId\r\n"
			+ "ORDER BY product.id LIMIT :start, :limit";

	public static final String SELECT_TOTAL_COUNT = "SELECT count(*) FROM display_info";

	public static final String SELECT_PRODUCT_IMAGES_INFO = "SELECT p.id,pi.id,type,file_id,file_name,save_file_name,content_type,delete_flag,fi.create_date,fi.modify_date\r\n"
			+ "FROM product AS p,product_image AS pi,file_info AS fi\r\n"
			+ "WHERE p.id = pi.product_id AND pi.file_id = fi.id AND type = 'ma'\r\n";

	public static final String SELECT_DISPLAY_IMAGES_INFO = "SELECT p.id,di.id,fi.id,file_name,save_file_name,content_type,delete_flag,fi.create_date,fi.modify_date\r\n"
			+ "FROM product AS p,display_info AS di,display_info_image AS dii,file_info AS fi\r\n"
			+ "WHERE p.id = di.product_id AND di.id = dii.display_info_id AND dii.file_id = fi.id\r\n";

	public static final String SELECT_COMMENTS = "SELECT comment\r\n"
			+ "FROM product AS p,reservation_user_comment AS ruc\r\n" 
			+ "WHERE p.id = ruc.product_id";
	
	public static final String SELECT_AVG_SCORE ="SELECT avg(score) as avgScore\r\n" + 
			"FROM product AS p,reservation_user_comment AS ruc\r\n" + 
			"WHERE p.id = ruc.product_id;\r\n";
	
	public static final String SELECT_PRODUCT_PRICES="SELECT pp.id,p.id,price_type_name,price,discount_rate,p.create_date,p.modify_date\r\n" + 
			"FROM product AS p , product_price AS pp\r\n" + 
			"WHERE p.id = pp.product_id AND p.id=1";
	
}
