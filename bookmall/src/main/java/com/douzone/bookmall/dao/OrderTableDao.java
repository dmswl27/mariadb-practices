package com.douzone.bookmall.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.douzone.bookmall.vo.OrderTableVo;

public class OrderTableDao {
	public Boolean insert(OrderTableVo vo) {
		Connection conn = null;
		PreparedStatement ostmt = null;
		boolean result = false;
		
		try {
			conn = getConnection();
			
			String sql = "insert into order_table values(?, ?, ? , ?)";
			ostmt = conn.prepareStatement(sql);
			ostmt.setInt(1, vo.getBook_count());
			ostmt.setInt(2, vo.getPrice());
			ostmt.setInt(3, vo.getNum());
			ostmt.setInt(4, vo.getOrder_num());
			
			int count = ostmt.executeUpdate();
			result = count == 1;
			
		} catch (SQLException e) {
			System.out.println("error:" + e);
		} finally {
			try {
				// 자원정리(clean-up)
				if(ostmt != null) {
					ostmt.close();
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

	public List<OrderTableVo> findAll() {
		List<OrderTableVo> result = new ArrayList<>();

		Connection conn = null;
		PreparedStatement ostmt = null;
		ResultSet rs = null;
		
		try {
			conn = getConnection();
			
			String sql ="select book_count, price, num, order_num from order_table";
			ostmt = conn.prepareStatement(sql);
			rs = ostmt.executeQuery();

			while(rs.next()) {
				int book_count = rs.getInt(1);
				int price = rs.getInt(2);
				int num = rs.getInt(3);
				int order_num = rs.getInt(4);
			
				
				OrderTableVo vo = new OrderTableVo();
				vo.setBook_count(book_count);
				vo.setPrice(price);
				vo.setNum(num);
				vo.setOrder_num(order_num);
				
				result.add(vo);
			}
		} catch (SQLException e) {
			System.out.println("error:" + e);
		} finally {
			try {
				if(rs != null) {
					rs.close();
				}
				if(ostmt != null) {
					ostmt.close();
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
