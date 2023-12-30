package com.yts.pro.vo;



public class VoterForm {

	
	private String fullname;
	private String email;
	private String password;
	private String dob;
	private String phone;
	private String adhar;
	private String voterid;
	private String gender;
	private String status;
	
	
	
	
	public String getFullname() {
		return fullname;
	}
	public void setFullname(String fullname) {
		this.fullname = fullname;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getDob() {
		return dob;
	}
	public void setDob(String dob) {
		this.dob = dob;
	}
	
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getGender() {
		return gender;
	}
	public String getAdhar() {
		return adhar;
	}
	public void setAdhar(String adhar) {
		this.adhar = adhar;
	}
	public String getVoterid() {
		return voterid;
	}
	public void setVoterid(String voterid) {
		this.voterid = voterid;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	
	@Override
	public String toString() {
		return "VoterForm [fullname=" + fullname + ", email=" + email + ", password=" + password + ", dob=" + dob
				+ ", phone=" + phone + ", adhar=" + adhar + ", voterid=" + voterid + ", gender=" + gender + ", status="
				+ status + "]";
	}
	
	

	
	
	
	
	
	
}
