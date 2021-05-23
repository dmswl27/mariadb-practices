package com.douzone.bookmall.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.douzone.bookmall.vo.OrderVo;

public class OrderDao {
	public Boolean insert(OrderVo vo) {
		Connection conn = null;
		PreparedStatement mstmt = null;
		boolean result = false;
		
		try {
			conn = getConnection();
			
			String sql = "insert into `order` values(null, ?, ?, ? , ?)";
			mstmt = conn.prepareStatement(sql);
			mstmt.setInt(1, vo.getOrder_num());
			mstmt.setInt(2, vo.getPrice());
			mstmt.setString(3, vo.getAddress());
			mstmt.setInt(4, vo.getMember_num());
			
			int count = mstmt.executeUpdate();
			result = count == 1;
			
		} catch (SQLException e) {
			System.out.println("error:" + e);
		} finally {
			try {
				// 자원정리(clean-up)
				if(mstmt != null) {
					mstmt.close();
				}
				if(conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return result;		
	}

	public List<OrderVo> findAll() {
		List<OrderVo> result = new ArrayList<>();

		Connection conn = null;
		PreparedStatement mstmt = null;
		ResultSet rs = null;
		
		try {
			conn = getConnection();
			
			String sql ="select order_num, price, address, member_num from `order`";
			mstmt = conn.prepareStatement(sql);
			rs = mstmt.executeQuery();

			while(rs.next()) {
				int order_num = rs.getInt(1);
				int price = rs.getInt(2);
				String address = rs.getString(3);
				int member_num = rs.getInt(4);
			
				
				OrderVo vo = new OrderVo();
				vo.setOrder_num(order_num);
				vo.setPrice(price);
				vo.setAddress(address);
				vo.setMember_num(member_num);
				
				result.add(vo);
			}
		} catch (SQLException e) {
			System.out.println("error:" + e);
		} finally {
			try {
				if(rs != null) {
					rs.close();
				}
				if(mstmt != null) {
					mstmt.close();
				}
				if(conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return result;
	}
	
	private Connection getConnection() throws SQLException {
		Connection conn = null;
		try {
			Class.forName("org.mariadb.jdbc.Driver");
//			String url = "jdbc:mysql://192.168.254.36:3307/bookmall?charset=utf8";
//			conn = DriverManager.getConnection(url, "bookmall", "bookmall");
			String url = "jdbc:mysql://127.0.0.1:3306/bookmall_local";
			conn = DriverManager.getConnection(url, "bookmall_local", "bookmall_local");
		} catch (ClassNotFoundException e) {
			System.out.println("드라이버 로딩 실패:" + e);
		} 
		
		return conn;
	}	
}
