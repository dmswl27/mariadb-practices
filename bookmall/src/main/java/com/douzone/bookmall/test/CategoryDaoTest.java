package com.douzone.bookmall.test;

import com.douzone.bookmall.dao.CategoryDao;
import com.douzone.bookmall.vo.CategoryVo;

public class CategoryDaoTest {
	public static void main(String[] args) {
		// insertTest();
	}

	private static void insertTest() {
		CategoryVo vo = null;
		
		vo = new CategoryVo();
		vo.setCategory("소설");
		new CategoryDao().insert(vo);

		vo = new CategoryVo();
		vo.setCategory("수필");
		new CategoryDao().insert(vo);
		
		vo = new CategoryVo();
		vo.setCategory("컴퓨터/IT");
		new CategoryDao().insert(vo);
		
		vo = new CategoryVo();
		vo.setCategory("인문");
		new CategoryDao().insert(vo);
		
		vo = new CategoryVo();
		vo.setCategory("경제");
		new CategoryDao().insert(vo);
		
		vo = new CategoryVo();
		vo.setCategory("예술");
		new CategoryDao().insert(vo);
	}
}
