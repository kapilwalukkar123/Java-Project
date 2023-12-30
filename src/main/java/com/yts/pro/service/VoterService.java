package com.yts.pro.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.yts.pro.manager.Manager;
import com.yts.pro.manager.VoterManager;
import com.yts.pro.vo.CandidateForm;
import com.yts.pro.vo.NewElection;
import com.yts.pro.vo.VoterForm;

public class VoterService {

	@Autowired
	VoterManager votemanager;
	
	

	public VoterManager getVotemanager() {
		return votemanager;
	}



	public void setVotemanager(VoterManager votemanager) {
		this.votemanager = votemanager;
	}



	public void saveVoterData(VoterForm voter) {
		// TODO Auto-generated method stub
	
		
		
		votemanager.saveVoterData(voter);
	}



	public List<NewElection> getElectionList() {
		// TODO Auto-generated method stub
		return votemanager.getElectionList();
	}



	public List<CandidateForm> getVoterList(String election) {
		// TODO Auto-generated method stub
		return votemanager.getVoterList(election);
	}



	public int getVoteCount(String vote, String election_date, String election, String voter_email, String voter_pass) {
		// TODO Auto-generated method stub
		
		return votemanager.getVoteCount(vote,election_date,election,voter_email,voter_pass);
	}



	public int checkUser(VoterForm voter) {
		// TODO Auto-generated method stub
		return votemanager.checkUser(voter);
	}



	public int getVoteCount1(String election, String date, String voter_email, String voter_pass) {
		// TODO Auto-generated method stub
		return votemanager.getVoteCount1(election,date,voter_email,voter_pass);
	}
	
	
	
	
}
