package com.nts.pjt3.dao;

public class PromotionDaoSqls {
	public static final String SELECT_PROMOTION_ITEMS_INFO = "SELECT promotion.id,promotion.product_id,category_id,name AS category_name,description,prodImg.id AS product_image_id"
			+ " FROM promotion,product,category, product_image AS prodImg"
			+ " WHERE promotion.product_id = product.id AND product.category_id = category.id AND prodImg.product_id = product.id AND prodImg.type='ma'";

	public static final String SELECT_COUNT_ALL_PROMOTION = "SELECT count(*) AS size"
			+ " FROM promotion,product,category, product_image AS prodImg"
			+ " WHERE promotion.product_id = product.id AND product.category_id = category.id AND prodImg.product_id = product.id AND prodImg.type='ma'";

}
