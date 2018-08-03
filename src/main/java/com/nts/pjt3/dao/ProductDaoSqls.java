package com.nts.pjt3.dao;

public class ProductDaoSqls {
	public static final String SELECT_PRODUCTS_PAGING = "SELECT product.id,category_id,dpInfo.id AS display_info_id,category.name,description,content,event,opening_hours,place_name,place_lot,place_street,tel,homepage,email,product.create_date,product.modify_date"
			+ " FROM product,display_info AS dpInfo,category"
			+ " WHERE product.id= dpInfo.product_id AND product.category_id = category.id"
			+ " ORDER BY product.id LIMIT :start, :limit";

	public static final String SELECT_PRODUCTS_BY_CATEGORY = "SELECT product.id,category_id,dpInfo.id AS display_info_id,category.name,description,content,event,opening_hours,place_name,place_lot,place_street,tel,homepage,email,product.create_date,product.modify_date"
			+ " FROM product,display_info AS dpInfo,category"
			+ " WHERE product.id= dpInfo.product_id AND category_id = category.id AND category_id = :categoryId"
			+ " ORDER BY product.id LIMIT :start,:limit";

	public static final String SELECT_COUNT_ALL_DISPLAYINFO = "SELECT count(*) FROM display_info";
	
	public static final String SELECT_COUNT_DISPLAYINFO_BY_CATEGORY ="SELECT count(*) AS count" 
			+ 	" FROM category,product,display_info AS dpInfo" 
			+	" WHERE category.id = product.category_id AND product.id = dpInfo.product_id AND category_id = :categoryId";
	
	public static final String SELECT_PRODUCT_BY_DISPLAYINFO_ID = "SELECT product.id,category_id,dpInfo.id AS display_info_id,category.name,description,content,event,opening_hours,place_name,place_lot,place_street,tel,homepage,email,dpInfo.create_date,dpInfo.modify_date"
			+ " FROM product,display_info AS dpInfo,category"
			+ " WHERE product.id= dpInfo.product_id AND category_id = category.id AND dpInfo.id = :dpInfoId";

	public static final String SELECT_PRODUCT_IMAGES_INFO_BY_DISPLAYINFO_ID = "SELECT product.id,prodImage.id,type,file_id,file_name,save_file_name,content_type,delete_flag,flInfo.create_date,flInfo.modify_date"
			+ " FROM product,product_image AS prodImage,file_info AS flInfo,display_info AS dpInfo"
			+ " WHERE product.id = prodImage.product_id AND product.id = dpInfo.product_id AND prodImage.file_id = flInfo.id AND type = 'ma' AND dpInfo.id = :dpInfoId";

	public static final String SELECT_DISPLAY_IMAGES_INFO_BY_DISPLAYINFO_ID = "SELECT product.id,display_info_id,file_id,file_name,save_file_name,content_type,delete_flag,flInfo.create_date,flInfo.modify_date"
			+ " FROM product,display_info AS dpInfo,display_info_image AS dpInfoImg,file_info AS flInfo"
			+ " WHERE product.id = dpInfo.product_id AND dpInfo.id = dpInfoImg.display_info_id AND dpInfoImg.file_id = flInfo.id AND dpInfo.id = :dpInfoId";

	public static final String SELECT_COMMENTS_BY_DISPLAYINFO_ID = "SELECT reservUserComment.id,product.id AS product_id,reservation_info_id,score,comment,reservUserComment.create_date,reservUserComment.modify_date"
			+ " FROM product,reservation_user_comment AS reservUserComment,display_info AS diInfo"
			+ " WHERE product.id = reservUserComment.product_id AND diInfo.product_id = product.id AND diInfo.id = :dpInfoId";

	public static final String SELECT_COMMENT_IMAGES_BY_COMMENT_ID = "SELECT reservUserCommentImg.id,reservation_info_id,reservation_user_comment_id,file_id,file_name,save_file_name,content_type,delete_flag,create_date,modify_date"
			+ " FROM reservation_user_comment_image AS reservUserCommentImg,file_info AS flInfo"
			+ " WHERE reservUserCommentImg.file_id = flInfo.id AND reservUserCommentImg.reservation_user_comment_id = :commentID";

	public static final String SELECT_AVG_SCORE = "SELECT COALESCE(AVG(score),0) AS avgScore"
			+ " FROM product,display_info AS dpInfo,reservation_user_comment AS reservUserComment"
			+ " WHERE product.id = reservUserComment.product_id AND dpInfo.product_id = product.id AND dpInfo.id = :dpInfoId";

	public static final String SELECT_PRODUCT_PRICES_BY_DISPLAYINFO_ID = "SELECT prodPrice.id,product.id,price_type_name,price,discount_rate,product.create_date,product.modify_date"
			+ " FROM product,display_info AS dpInfo, product_price AS prodPrice" + " WHERE product.id = prodPrice.product_id AND dpInfo.id = product.id AND dpInfo.id = :dpInfoId";

}
