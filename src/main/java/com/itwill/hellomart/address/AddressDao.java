package com.itwill.hellomart.address;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import javax.sql.DataSource;

import org.apache.tomcat.dbcp.dbcp2.BasicDataSource;

import com.itwill.hellomart.common.DataSourceFactory;

public class AddressDao {
	private DataSource dataSource;
	
	public AddressDao() throws Exception {
		
		dataSource = DataSourceFactory.getDataSource();
	}
	public int addressInsert(Address address) throws Exception{
		Connection con = dataSource.getConnection();
		PreparedStatement pstmt = con.prepareStatement(AddressSQL.ADDRESS_INSERT);
		pstmt.setString(1, address.getUserid());
		pstmt.setString(2, address.getLoc());
		int rowCount = pstmt.executeUpdate();
		pstmt.close();
		con.close();
		return rowCount;
	}
	
	
	public int addressUpdate(Address address) throws Exception{
		Connection con = dataSource.getConnection();
		PreparedStatement pstmt = con.prepareStatement(AddressSQL.ADDRESS_UPDATE);
		pstmt.setString(1, address.getLoc());
		pstmt.setInt(2, address.getAddr_no());
		int rowCount = pstmt.executeUpdate();
		pstmt.close();
		con.close();
		return rowCount;
	}
	public int addressDelete(int addr_no)throws Exception{
		Connection con = dataSource.getConnection();
		PreparedStatement pstmt = con.prepareStatement(AddressSQL.ADDRESS_DELETE);
		pstmt.setInt(1, addr_no);
		int rowCount = pstmt.executeUpdate();
		pstmt.close();
		con.close();
		return rowCount;
	}
	public List<Address> addressfindAll(String userId) throws Exception{
		List<Address> addressList= new ArrayList<Address>();
		Connection con = dataSource.getConnection();
		PreparedStatement pstmt = con.prepareStatement(AddressSQL.ADDRESS_SELECT_ALL);
		pstmt.setString(1, userId);
		ResultSet rs=pstmt.executeQuery();
		while(rs.next()) {
					Address address = new Address(
						rs.getInt("addr_no"),
						rs.getString("userid"),
						rs.getString("loc"));
					addressList.add(address);
		}
		rs.close();
		pstmt.close();
		con.close();
		return addressList;
		
	}
}
