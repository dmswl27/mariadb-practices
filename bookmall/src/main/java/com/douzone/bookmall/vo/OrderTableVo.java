package com.douzone.bookmall.vo;

public class OrderTableVo {
	private int book_count;
	private int price;
	private int num;
	private int order_num;
	public int getBook_count() {
		return book_count;
	}
	public void setBook_count(int book_count) {
		this.book_count = book_count;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public int getOrder_num() {
		return order_num;
	}
	public void setOrder_num(int order_num) {
		this.order_num = order_num;
	}
	@Override
	public String toString() {
		return "OrderTableVo [book_count=" + book_count + ", price=" + price + ", num=" + num + ", order_num="
				+ order_num + "]";
	}
	

}
