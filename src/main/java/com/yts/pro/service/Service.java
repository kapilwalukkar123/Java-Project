package com.yts.pro.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.multipart.MultipartFile;

import com.yts.pro.manager.Manager;
import com.yts.pro.vo.CandidateForm;
import com.yts.pro.vo.NewElection;
import com.yts.pro.vo.QuoteVO;
import com.yts.pro.vo.VO;
import com.yts.pro.vo.VoterForm;

public class Service  {
	
	@Autowired
	Manager manager;
	
	public Manager getManager() {
		return manager;
	}

	public void setManager(Manager manager) {
		this.manager = manager;
	}

	public int getValue(String name) {
		
		return 0;
	}

	

	public List<VO> getData() {
		
		return manager.getData();
	}


	public void saveData(VO formData) {
		
		manager.saveData(formData);
}

	public List<QuoteVO> getQuote() {
		
		return manager.getQuote();
		}

	public void saveElection(NewElection newelect) {
		// TODO Auto-generated method stub
		
		manager.saveElection(newelect);
		
	}

	public void saveCandidate(CandidateForm candidate) {
		// TODO Auto-generated method stub
		
		manager.saveCandidate(candidate);
		
	}

	public List<VoterForm> getVoterList() {
		// TODO Auto-generated method stub
		return manager.getVoterList();
	}

	public List<CandidateForm> getResult(String election) {
		// TODO Auto-generated method stub
		return manager.getResult(election);
	}

	public List<String> getElectionList() {
		// TODO Auto-generated method stub
		return manager.getElectionList();
	}

	public void updateStatus(String name, String email) {
		// TODO Auto-generated method stub
		manager.updateStatus(name,email);
	}
	
}
