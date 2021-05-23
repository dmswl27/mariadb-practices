package com.douzone.bookmall.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.douzone.bookmall.vo.CategoryVo;

public class CategoryDao {
	public Boolean insert(CategoryVo vo) {
		Connection conn = null;
		PreparedStatement cstmt = null;
		boolean result = false;
		
		try {
			conn = getConnection();
			
			String sql = "insert into category values(null, ?)";
			cstmt = conn.prepareStatement(sql);
			cstmt.setString(1, vo.getCategory());
			
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

	public List<CategoryVo> findAll() {
		List<CategoryVo> result = new ArrayList<>();

		Connection conn = null;
		PreparedStatement cstmt = null;
		ResultSet rs = null;
		
		try {
			conn = getConnection();
			
			String sql ="select category from category";
			cstmt = conn.prepareStatement(sql);
			rs = cstmt.executeQuery();

			while(rs.next()) {
				String category = rs.getString(1);
			
				
				CategoryVo vo = new CategoryVo();
				vo.setCategory(category);
				
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
