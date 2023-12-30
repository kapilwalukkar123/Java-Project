package com.yts.pro.vo;

public class NewElection {

	
	private String election_name;
	
	private String election_date;

	public String getElection_name() {
		return election_name;
	}

	public void setElection_name(String election_name) {
		this.election_name = election_name;
	}

	public String getElection_date() {
		return election_date;
	}

	public void setElection_date(String election_date) {
		this.election_date = election_date;
	}

	@Override
	public String toString() {
		return "NewElection [election_name=" + election_name + ", election_date=" + election_date + "]";
	}
	
	
	
	
	
}
