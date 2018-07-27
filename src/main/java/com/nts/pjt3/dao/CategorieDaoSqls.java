package com.nts.pjt3.dao;

public class CategorieDaoSqls {
	public static final String SELECT_ALL = "SELECT category_id as id,name,count(*) as count FROM category,product WHERE category.id = product.category_id GROUP BY category_id,name";
	public static final String SELECT_CATEGORIE_COUNT = "SELECT count(*) as count FROM category";
}
