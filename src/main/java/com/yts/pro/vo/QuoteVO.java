package com.yts.pro.vo;

public class QuoteVO {

	private int id;
	


	private String user_name;
	private String user_contact;
	private String user_email;
	private String user_enquiry;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUser_name() {
		return user_name;
	}
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	public String getUser_contact() {
		return user_contact;
	}
	public void setUser_contact(String user_contact) {
		this.user_contact = user_contact;
	}
	public String getUser_email() {
		return user_email;
	}
	public void setUser_email(String user_email) {
		this.user_email = user_email;
	}
	public String getUser_enquiry() {
		return user_enquiry;
	}
	public void setUser_enquiry(String user_enquiry) {
		this.user_enquiry = user_enquiry;
	}
	@Override
	public String toString() {
		return "QuoteVO [id=" + id + ", user_name=" + user_name
				+ ", user_contact=" + user_contact + ", user_email="
				+ user_email + ", user_enquiry=" + user_enquiry + "]";
	}
	
	
	
	
	
	
}

