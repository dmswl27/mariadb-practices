package com.douzone.bookmall.test;

import com.douzone.bookmall.dao.OrderDao;
import com.douzone.bookmall.dao.OrderTableDao;
import com.douzone.bookmall.vo.BookVo;
import com.douzone.bookmall.vo.OrderTableVo;
import com.douzone.bookmall.vo.OrderVo;

public class OrderTableDaoTest {
//    6. 주문 도서 리스트 – 2개
	//book_count, price, num, order_num
	public static void main(String[] args) {
		insertTest();
	}

	private static void insertTest() {
		OrderTableVo vo = null;
		
		vo = new OrderTableVo();
		vo.setBook_count(2);
		vo.setPrice(12000);
		vo.setNum(2);
		vo.setOrder_num(1);
		new OrderTableDao().insert(vo);
		
		vo = new OrderTableVo();
		vo.setBook_count(1);
		vo.setPrice(25000);
		vo.setNum(1);
		vo.setOrder_num(2);
		new OrderTableDao().insert(vo);
	}
}
