package com.douzone.bookmall.vo;

public class OrderVo {
	private int num;
	private int order_num;
	private int price;
	private String address;
	private int member_num;
	
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
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public int getMember_num() {
		return member_num;
	}
	public void setMember_num(int member_num) {
		this.member_num = member_num;
	}
	@Override
	public String toString() {
		return "OrderVo [num=" + num + ", order_num=" + order_num + ", price=" + price + ", address="
				+ address + ", member_num=" + member_num + "]";
	}
	

}
