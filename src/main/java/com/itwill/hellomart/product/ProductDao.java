package com.itwill.hellomart.product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import javax.sql.DataSource;

import org.apache.tomcat.dbcp.dbcp2.BasicDataSource;

public class ProductDao {
	/*
	 * 데이타소스, 생성자 , 프로퍼티 로드,어파치 데이타,굿
	 */
	private DataSource dataSource;
	public ProductDao() throws Exception{
	Properties properties = new Properties();
	properties.load(this.getClass().getResourceAsStream("/jdbc.properties"));
	//어파치 데이타소스
	BasicDataSource basicDataSource=new BasicDataSource();
	basicDataSource.setDriverClassName(properties.getProperty("drivaerClassName"));
	basicDataSource.setUrl(properties.getProperty("url"));
	basicDataSource.setUsername(properties.getProperty("username"));
	basicDataSource.setPassword(properties.getProperty("password"));
	dataSource=basicDataSource;
	}
	/*
	 * selectByPK : 상품번호로 검색
	 */
	/*
	 * 프로덕트,커넥션,프리페어스테이트먼트 , 리절트셋
	 */
	public Product findByPrimartKey(int p_no) throws Exception{
		Product product = null;
		Connection con= dataSource.getConnection();
		PreparedStatement pstmt=con.prepareStatement(ProductSQL.PRODUCT_SELECT_BY_NO);
		pstmt.setInt(1, p_no);
		ResultSet rs=pstmt.executeQuery();
		if(rs.next()) {
			product=new Product(
						rs.getInt("p_no"),
						rs.getString("p_name"),
						rs.getInt("p_number"),
						rs.getString("p_image"),
						rs.getString("p_desc"));
		}
		return product;
	}
	/*
	 * selectAll : 상품전체검색
	 */
	public List<Product> findAll() throws Exception{
		List<Product> productList=new ArrayList<Product>();
		Connection con = dataSource.getConnection();
		PreparedStatement pstmt = con.prepareStatement(ProductSQL.PRODUCT_SELECT_ALL);
		ResultSet rs=pstmt.executeQuery();
		while(rs.next()) {
			Product product = new Product()
		}
		return productList;
	}
}
