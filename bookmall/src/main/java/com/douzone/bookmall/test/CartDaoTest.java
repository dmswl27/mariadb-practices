package com.douzone.bookmall.test;

import com.douzone.bookmall.dao.CartDao;
import com.douzone.bookmall.vo.CartVo;

public class CartDaoTest {
	public static void main(String[] args) {
		insertTest();
	}
//    4. 카트 리스트 – 2개
	private static void insertTest() {
		CartVo vo = null;
		
		vo = new CartVo();
		vo.setCount(5);
		vo.setMember_num(1);
		vo.setBook_num(2);
		new CartDao().insert(vo);
		
		vo.setCount(1);
		vo.setMember_num(2);
		vo.setBook_num(3);
		new CartDao().insert(vo);
	}
}
