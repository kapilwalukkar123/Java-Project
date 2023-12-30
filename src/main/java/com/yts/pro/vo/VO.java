package com.yts.pro.vo;

public class VO {
	
	
	private int id;
	private String username;
	private String lastname;
	private String coursename_1;	
	private String email;
	private String  contact_no;
	private String  address ;
	private String admission_date ;
	private String fees_paid ;
	private String fees_remaining ;
	private String total_fees;
	
	public String getTotal_fees() {
		return total_fees;
	}
	public void setTotal_fees(String total_fees) {
		this.total_fees = total_fees;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getCoursename_1() {
		return coursename_1;
	}
	public void setCoursename_1(String coursename_1) {
		this.coursename_1 = coursename_1;
	}
	
		
	public String getContact_no() {
		return contact_no;
	}
	public void setContact_no(String contact_no) {
		this.contact_no = contact_no;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getAdmission_date() {
		return admission_date;
	}
	public void setAdmission_date(String admission_date) {
		this.admission_date = admission_date;
	}
	public String getFees_paid() {
		return fees_paid;
	}
	public void setFees_paid(String fees_paid) {
		this.fees_paid = fees_paid;
	}
	public String getFees_remaining() {
		return fees_remaining;
	}
	public void setFees_remaining(String fees_remaining) {
		this.fees_remaining = fees_remaining;
	}
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		// TODO Auto-generated method stub
		this.id = id;
	}
	
	
	
	@Override
	public String toString() {
		return "VO [id=" + id + ", username=" + username + ", lastname="
				+ lastname + ", coursename_1=" + coursename_1 + ", email="
				+ email + ", contact_no=" + contact_no + ", address=" + address
				+ ", admission_date=" + admission_date + ", fees_paid="
				+ fees_paid + ", fees_remaining=" + fees_remaining
				+ ", total_fees=" + total_fees + "]";
	}
	
	

	
	
	
	
	
}
