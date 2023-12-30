package com.yts.pro.vo;

import org.springframework.web.multipart.MultipartFile;

import com.mysql.cj.jdbc.Blob;

public class CandidateForm {

	private String candidate_name;
	private String election_name;
	private String party_name;
	private String address;	
	private String contact;
	private int vote;
	private String image; 
	//private String file;
	
	//private Blob file;
	
	
	private MultipartFile file;
	
	
	
	
	
	
	
	public MultipartFile getFile() {
		return file;
	}
	public void setFile(MultipartFile file) {
		this.file = file;
	}
	public String getCandidate_name() {
		return candidate_name;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public void setCandidate_name(String candidate_name) {
		this.candidate_name = candidate_name;
	}
	public String getElection_name() {
		return election_name;
	}
	public void setElection_name(String election_name) {
		this.election_name = election_name;
	}
	public String getParty_name() {
		return party_name;
	}
	public void setParty_name(String party_name) {
		this.party_name = party_name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getContact() {
		return contact;
	}
	public void setContact(String contact) {
		this.contact = contact;
	}
	public int getVote() {
		return vote;
	}
	public void setVote(int vote) {
		this.vote = vote;
	}
	
	@Override
	public String toString() {
		return "CandidateForm [candidate_name=" + candidate_name + ", election_name=" + election_name + ", party_name="
				+ party_name + ", address=" + address + ", contact=" + contact + ", vote=" + vote + ", image=" + image
				+ ", file=" + file + "]";
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
}
