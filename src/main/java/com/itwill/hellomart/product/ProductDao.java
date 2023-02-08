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
	
	 
	private DataSource dataSource;
	public ProductDao() throws Exception{
	Properties properties = new Properties();
	properties.load(this.getClass().getResourceAsStream("/jdbc.properties"));
	
	BasicDataSource basicDataSource=new BasicDataSource();
	basicDataSource.setDriverClassName(properties.getProperty("drivaerClassName"));
	basicDataSource.setUrl(properties.getProperty("url"));
	basicDataSource.setUsername(properties.getProperty("username"));
	basicDataSource.setPassword(properties.getProperty("password"));
	dataSource=basicDataSource;
	}
	public int insert(Product product) throws Exception{
		Connection con = null;
		PreparedStatement pstmt = null;
		int rowCount =0;
		
		try {
			con = dataSource.getConnection();
			pstmt = con.prepareStatement(ProductSQL.PRODUCT_INSERT);
			pstmt.setString(1,product.getP_name());
			pstmt.setInt(2,product.getP_price());
			pstmt.setString(3,product.getP_image());
			pstmt.setString(4,product.getP_desc());
			pstmt.setInt(5,product.getCt_no());
			rowCount = pstmt.executeUpdate();
			return rowCount;
		}finally {
			if(pstmt != null) {
				pstmt.close();
			}
			if(con != null) {
				con.close();
			}
		}
		
	}
	public int update(Product product) throws Exception{
		Connection con = null;
		PreparedStatement pstmt = null;
		int rowCount =0;
		try {
			con = dataSource.getConnection();
			pstmt = con.prepareStatement(ProductSQL.PRODUCT_UPDATE);
			pstmt.setString(1,product.getP_name());
			pstmt.setInt(2,product.getP_price());
			pstmt.setString(3,product.getP_image());
			pstmt.setString(4,product.getP_desc());
			pstmt.setInt(5,product.getCt_no());
			pstmt.setInt(6,product.getP_no());
			rowCount = pstmt.executeUpdate();
			return rowCount;
		}finally {
			if(pstmt != null) {
				pstmt.close();
			}
			if(con != null) {
				con.close();
			}
		}
	}
	public int delete(int p_no)throws Exception{
		Connection con = dataSource.getConnection();
		PreparedStatement pstmt = con.prepareStatement(ProductSQL.PRODUCT_DELETE);
		int deleteRowCount = 0;
		
		try {
		pstmt.setInt(1, p_no);
		deleteRowCount = pstmt.executeUpdate();
		return deleteRowCount;
		} finally {
			if(pstmt != null) {
				pstmt.close();
			}
			if(con != null) {
				con.close();
			}
		}
	}
	/*
	 * selectByPK : 상품번호로 검색
	 */
	public Product findByPrimaryKey(int p_no) throws Exception{
		Product product = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
	try {
		con=dataSource.getConnection();
		pstmt=con.prepareStatement(ProductSQL.PRODUCT_SELECT_BY_NO);
		pstmt.setInt(1, p_no);
		rs=pstmt.executeQuery();
		if(rs.next()) {
			product=new Product(
						rs.getInt("p_no"),
						rs.getString("p_name"),
						rs.getInt("p_price"),
						rs.getString("p_image"),
						rs.getString("p_desc"),
						rs.getInt("ct_no"));
		}
	} finally {
		if(rs != null) {
			rs.close();
		}
		if(pstmt != null) {
			pstmt.close();
		}
		if(con != null) {
			rs.close();
		}
	}
		return product;
	}
	/*
	 * selectAll : 상품전체검색
	 */
	public List<Product> findAll() throws Exception{
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<Product> productList=new ArrayList<Product>();
		
	try {
		con = dataSource.getConnection();
		pstmt = con.prepareStatement(ProductSQL.PRODUCT_SELECT_ALL);
		rs=pstmt.executeQuery();
		while(rs.next()) {
			productList.add(new Product(
					rs.getInt("p_no"),
					rs.getString("p_name"),
					rs.getInt("p_price"),
					rs.getString("p_image"),
					rs.getString("p_desc"),
					rs.getInt("ct_no")));
		}
	} finally {
		if(rs != null) {
			rs.close();
		}
		if(pstmt != null) {
			pstmt.close();
		}
		if(con != null) {
			con.close();
		}
	}
		return productList;
	}
	/*
	 * 이름으로 찾기
	 */
	public Product findByName(String p_name)throws Exception{
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Product product =null;
	try {
		con = dataSource.getConnection();
		pstmt = con.prepareStatement(ProductSQL.PRODUCT_SELECT_BY_NAME);
		pstmt.setString(1, p_name);
		rs= pstmt.executeQuery();
		if(rs.next()) {
			product=new Product(
						rs.getInt("p_no"),
						rs.getString("p_name"),
						rs.getInt("p_price"),
						rs.getString("p_image"),
						rs.getString("p_desc"),
						rs.getInt("ct_no"));
		}
	} finally {
		if(rs != null) {
			rs.close();
		}
		if(pstmt != null) {
			pstmt.close();
		}
		if(con != null) {
			rs.close();
		}
	}
		return product;
	}
	public List<Product> searchByName(String p_name) throws Exception{
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<Product> productList=new ArrayList<Product>();
	try{	
		con = dataSource.getConnection();
		pstmt = con.prepareStatement(ProductSQL.PRODUCT_SEARCH_BY_NAME);
		pstmt.setString(1, p_name);
		rs=pstmt.executeQuery();
		while(rs.next()) {
			productList.add(new Product(
					rs.getInt("p_no"),
					rs.getString("p_name"),
					rs.getInt("p_price"),
					rs.getString("p_image"),
					rs.getString("p_desc"),
					rs.getInt("ct_no")));
		}
	} finally {
		if(rs != null) {
			rs.close();
		}
		if(pstmt != null) {
			pstmt.close();
		}
		if(con != null) {
			rs.close();
		}
	}
		return productList;
	}
}