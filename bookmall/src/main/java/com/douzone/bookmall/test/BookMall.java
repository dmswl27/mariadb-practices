package com.douzone.bookmall.test;

import java.util.List;
import java.util.Scanner;

import com.douzone.bookmall.dao.BookDao;
import com.douzone.bookmall.dao.CartDao;
import com.douzone.bookmall.dao.CategoryDao;
import com.douzone.bookmall.dao.MemberDao;
import com.douzone.bookmall.dao.OrderDao;
import com.douzone.bookmall.dao.OrderTableDao;
import com.douzone.bookmall.vo.BookVo;
import com.douzone.bookmall.vo.CartVo;
import com.douzone.bookmall.vo.CategoryVo;
import com.douzone.bookmall.vo.MemberVo;
import com.douzone.bookmall.vo.OrderTableVo;
import com.douzone.bookmall.vo.OrderVo;

public class BookMall {

	public static void main(String[] args) {
//	    1. 회원 리스트 – 2명
		MemberDao member = new MemberDao();
		List<MemberVo> list = member.findAll();
		
		for(MemberVo vo : list) {
			System.out.println(vo);
		}
//	    2. 카테고리 리스트 – 3개
		CategoryDao category = new CategoryDao();
		List<CategoryVo> list1 = category.findAll();
		
		for(CategoryVo vo : list1) {
			System.out.println(vo);
		}
//	    3. 상품리스트 – 3개
		BookDao book = new BookDao();
		List<BookVo> list2 = book.findAll();
		
		for(BookVo vo : list2) {
			System.out.println(vo);
		}
//	    4. 카트 리스트 – 2개
		CartDao cart = new CartDao();
		List<CartVo> list3 = cart.findAll();
		
		for(CartVo vo : list3) {
			System.out.println(vo);
		}
//	    5. 주문 리스트 – 1개
		OrderDao order = new OrderDao();
		List<OrderVo> list4 = order.findAll();
		
		for(OrderVo vo : list4) {
			System.out.println(vo);
		}
//	    6. 주문 도서 리스트 – 2개
		OrderTableDao table = new OrderTableDao();
		List<OrderTableVo> list5 = table.findAll();
		
		for(OrderTableVo vo : list5) {
			System.out.println(vo);
		}

		
		
		
	
	}

		
}


