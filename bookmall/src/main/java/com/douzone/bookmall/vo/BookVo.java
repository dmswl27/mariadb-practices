package com.douzone.bookmall.vo;

public class BookVo {
	private int book_num;
	private String title;
	private int price;
	private int category_num;
	public int getBook_num() {
		return book_num;
	}
	public void setBook_num(int book_num) {
		this.book_num = book_num;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getCategory_num() {
		return category_num;
	}
	public void setCategory_num(int category_num) {
		this.category_num = category_num;
	}
	@Override
	public String toString() {
		return "BookVo [book_num=" + book_num + ", title=" + title + ", price=" + price + ", category_num="
				+ category_num + "]";
	}
	
}
