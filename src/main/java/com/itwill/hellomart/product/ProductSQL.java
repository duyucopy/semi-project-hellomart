package com.itwill.hellomart.product;

public class ProductSQL {
	public final static String PRODUCT_SELECT_ALL=
			"select * from product";
	public final static String PRODUCT_SELECT_BY_NO=
			"select * from product where p_no=?";
	public final static String PRODUCT_INSERT=
			"insert into product values(product_p_no_SEQ.nextval,?,?,?,?,?)";
	public final static String PRODUCT_UPDATE=
			"update product set p_name = ? , p_price = ? ,p_image = ?  , p_desc = ? , ct_no = ? where p_no = ?";
	public final static String PRODUCT_DELETE =
			"delete from product where p_no = ?";
	public final static String PRODUCT_SELECT_BY_NAME=
			"select * from product where p_name=?";
	public final static String PRODUCT_SEARCH_BY_NAME=
			"select * from product where p_name like '%'||?||'%'";
}
