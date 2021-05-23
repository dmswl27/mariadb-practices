package com.douzone.bookmall.test;

import com.douzone.bookmall.dao.MemberDao;
import com.douzone.bookmall.vo.MemberVo;

public class MemberDaoTest {
	public static void main(String[] args) {
		//insertTest();
	}
//    1. 회원 리스트 – 2명
	private static void insertTest() {
		
		MemberVo vo = null;
		
		vo = new MemberVo();
		vo.setName("한은지");
		vo.setPhon_num("010-4145-5450");
		vo.setPassword("****");
		vo.setEmail("****@*****");
		new MemberDao().insert(vo);
		
		vo.setName("김류준");
		vo.setPhon_num("***-****-****");
		vo.setPassword("****");
		vo.setEmail("****@*****");
		new MemberDao().insert(vo);
	}
	
}
