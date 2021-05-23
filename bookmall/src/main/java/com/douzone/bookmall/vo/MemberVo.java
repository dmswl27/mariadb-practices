package com.douzone.bookmall.vo;

public class MemberVo {
	private int member_num;
	private String name;
	private String phon_num;
	private String password;
	private String email;
	public int getMember_num() {
		return member_num;
	}
	public void setMember_num(int member_num) {
		this.member_num = member_num;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhon_num() {
		return phon_num;
	}
	public void setPhon_num(String phon_num) {
		this.phon_num = phon_num;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	@Override
	public String toString() {
		return "MemberVo [member_num=" + member_num + ", name=" + name + ", phon_num=" + phon_num + ", password="
				+ password + ", email=" + email + "]";
	}
	
}
