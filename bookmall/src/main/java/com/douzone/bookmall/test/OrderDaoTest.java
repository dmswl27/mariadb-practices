package com.douzone.bookmall.test;

import com.douzone.bookmall.dao.OrderDao;
import com.douzone.bookmall.vo.BookVo;
import com.douzone.bookmall.vo.OrderVo;

public class OrderDaoTest {
	public static void main(String[] args) {
		insertTest();
	}

	private static void insertTest() {
		OrderVo vo = null;

		vo = new OrderVo();
		vo.setOrder_num(1);
		vo.setPrice(12000);
		vo.setAddress("부산시 남구 수영로");
		vo.setMember_num(1);
		new OrderDao().insert(vo);
		
		vo = new OrderVo();
		vo.setOrder_num(2);
		vo.setPrice(24000);
		vo.setAddress("부산시 남구 수영로");
		vo.setMember_num(1);
		new OrderDao().insert(vo);
	}
}
