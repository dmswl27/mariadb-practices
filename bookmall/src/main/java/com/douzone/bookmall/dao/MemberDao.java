package com.douzone.bookmall.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.douzone.bookmall.vo.MemberVo;

public class MemberDao {
	public Boolean insert(MemberVo vo) {
		Connection conn = null;
		PreparedStatement mstmt = null;
		boolean result = false;
		
		try {
			conn = getConnection();
			
			String sql = "insert into member values(null, ?, ?, ? , ?)";
			mstmt = conn.prepareStatement(sql);
			mstmt.setString(1, vo.getName());
			mstmt.setString(2, vo.getPhon_num());
			mstmt.setString(3, vo.getPassword());
			mstmt.setString(4, vo.getEmail());
			
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

	public List<MemberVo> findAll() {
		List<MemberVo> result = new ArrayList<>();

		Connection conn = null;
		PreparedStatement mstmt = null;
		ResultSet rs = null;
		
		try {
			conn = getConnection();
			
			String sql ="select DISTINCT name, phon_num, password, email from Member";
			mstmt = conn.prepareStatement(sql);
			rs = mstmt.executeQuery();

			while(rs.next()) {
				String name = rs.getString(1);
				String phone_num = rs.getString(2);
				String password = rs.getString(3);
				String email = rs.getString(4);
			
				
				MemberVo vo = new MemberVo();
				vo.setName(name);
				vo.setPhon_num(phone_num);
				vo.setPassword(password);
				vo.setEmail(email);
				
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
