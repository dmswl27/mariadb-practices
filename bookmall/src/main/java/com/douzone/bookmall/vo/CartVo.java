package com.douzone.bookmall.vo;

public class CartVo {
	private int count;
	private int member_num;
	private int book_num;
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public int getMember_num() {
		return member_num;
	}
	public void setMember_num(int member_num) {
		this.member_num = member_num;
	}
	public int getBook_num() {
		return book_num;
	}
	public void setBook_num(int book_num) {
		this.book_num = book_num;
	}
	@Override
	public String toString() {
		return "CartVo [count=" + count + ", member_num=" + member_num + ", book_num=" + book_num + "]";
	}
	
}
