package com.douzone.bookmall.vo;

public class CategoryVo {
	private int category_num;
	private String category;
	public int getCategory_num() {
		return category_num;
	}
	public void setCategory_num(int category_num) {
		this.category_num = category_num;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	@Override
	public String toString() {
		return "CategoryVo [category_num=" + category_num + ", category=" + category + "]";
	}
	
}
