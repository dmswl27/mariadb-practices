package com.douzone.bookmall.test;

import com.douzone.bookmall.dao.BookDao;
import com.douzone.bookmall.vo.BookVo;

public class BookDaoTest {

	public static void main(String[] args) {
		//insertTest();
	}

	private static void insertTest() {
		BookVo vo = null;
		
		vo = new BookVo();
		vo.setTitle("트와일라잇");
		vo.setPrice(15000);
		vo.setCategory_num(1);
		new BookDao().insert(vo);

		vo = new BookVo();
		vo.setTitle("뉴문");
		vo.setPrice(20000);
		vo.setCategory_num(2);
		new BookDao().insert(vo);

		vo = new BookVo();
		vo.setTitle("이클립스");
		vo.setPrice(28000);
		vo.setCategory_num(3);
		new BookDao().insert(vo);

		vo = new BookVo();
		vo.setTitle("브레이킹던");
		vo.setPrice(10000);
		vo.setCategory_num(6);
		new BookDao().insert(vo);
		
		vo = new BookVo();
		vo.setTitle("아리랑");
		vo.setPrice(30000);
		vo.setCategory_num(1);
		new BookDao().insert(vo);
		
		vo = new BookVo();
		vo.setTitle("젊은그들");
		vo.setPrice(15000);
		vo.setCategory_num(4);
		new BookDao().insert(vo);

		vo = new BookVo();
		vo.setTitle("아프니깐 청춘이다");
		vo.setPrice(17000);
		vo.setCategory_num(5);
		new BookDao().insert(vo);

		vo = new BookVo();
		vo.setTitle("귀천");
		vo.setPrice(22000);
		vo.setCategory_num(2);
		new BookDao().insert(vo);

		vo = new BookVo();
		vo.setTitle("태백산맥");
		vo.setPrice(15000);
		vo.setCategory_num(5);
		new BookDao().insert(vo);
	}

}
