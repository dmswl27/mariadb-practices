package com.douzone.bookmall.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.douzone.bookmall.vo.CartVo;

public class CartDao {
	public Boolean insert(CartVo vo) {
		Connection conn = null;
		PreparedStatement cstmt = null;
		boolean result = false;
		
		try {
			conn = getConnection();
			
			String sql = "insert into cart values(?, ?, ?)";
			cstmt = conn.prepareStatement(sql);
			cstmt.setInt(1, vo.getCount());
			cstmt.setInt(2, vo.getMember_num());
			cstmt.setInt(3, vo.getBook_num());
			
			int count = cstmt.executeUpdate();
			result = count == 1;
			
		} catch (SQLException e) {
			System.out.println("error:" + e);
		} finally {
			try {
				// 자원정리(clean-up)
				if(cstmt != null) {
					cstmt.close();
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

	public List<CartVo> findAll() {
		List<CartVo> result = new ArrayList<>();

		Connection conn = null;
		PreparedStatement cstmt = null;
		ResultSet rs = null;
		
		try {
			conn = getConnection();
			
			String sql ="select count, member_num, book_num from cart";
			cstmt = conn.prepareStatement(sql);
			rs = cstmt.executeQuery();

			while(rs.next()) {
				int count = rs.getInt(1);
				int member_num = rs.getInt(2);
				int book_num = rs.getInt(3);
			
				
				CartVo vo = new CartVo();
				vo.setCount(count);
				vo.setMember_num(member_num);
				vo.setBook_num(book_num);
				
				result.add(vo);
			}
		} catch (SQLException e) {
			System.out.println("error:" + e);
		} finally {
			try {
				if(rs != null) {
					rs.close();
				}
				if(cstmt != null) {
					cstmt.close();
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
