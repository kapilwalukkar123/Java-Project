package com.yts.pro.manager;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.yts.pro.idao.IVoterDao;
import com.yts.pro.vo.CandidateForm;
import com.yts.pro.vo.NewElection;
import com.yts.pro.vo.VoterForm;

public class VoterManager {
	
	
	
	@Autowired
	IVoterDao ivoterdao;

	public IVoterDao getIvoterdao() {
		return ivoterdao;
	}

	public void setIvoterdao(IVoterDao ivoterdao) {
		this.ivoterdao = ivoterdao;
	}

	public void saveVoterData(VoterForm voter) {
		// TODO Auto-generated method stub
		
		
		ivoterdao.saveVoterData(voter);
	}

	public List<NewElection> getElectionList() {
		// TODO Auto-generated method stub
		return ivoterdao.getElectionList();
	}

	public List<CandidateForm> getVoterList(String election) {
		// TODO Auto-generated method stub
		return ivoterdao.getVoterList(election);
	}

	public int getVoteCount(String vote, String election_date, String election, String voter_email, String voter_pass) {
		// TODO Auto-generated method stub
	
		return  ivoterdao.getVoteCount(vote,election_date,election,voter_email,voter_pass);
	}

	public int checkUser(VoterForm voter) {
		// TODO Auto-generated method stub
		return ivoterdao.checkUser(voter);
	}

	public int getVoteCount1(String election, String date, String voter_email, String voter_pass) {
		// TODO Auto-generated method stub
		return ivoterdao.getVoteCount1(election,date,voter_email,voter_pass);
	}
	
	
	
	

}
