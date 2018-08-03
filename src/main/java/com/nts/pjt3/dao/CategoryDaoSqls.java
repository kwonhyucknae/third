package com.nts.pjt3.dao;

public class CategoryDaoSqls {
	public static final String SELECT_ALL_CATEGORY_ITEMS = "SELECT category_id AS id,name,count(*) AS count FROM category,product WHERE category.id = product.category_id GROUP BY category_id,name";
	public static final String SELECT_COUNT_CATEGORY = "SELECT count(*) AS count FROM category";
}
