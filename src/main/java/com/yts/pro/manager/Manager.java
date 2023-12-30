package com.yts.pro.manager;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.multipart.MultipartFile;

import com.yts.pro.idao.IDao;
import com.yts.pro.vo.CandidateForm;
import com.yts.pro.vo.NewElection;
import com.yts.pro.vo.QuoteVO;
import com.yts.pro.vo.VO;
import com.yts.pro.vo.VoterForm;

public class Manager {
	
	@Autowired
	IDao dao;

	public IDao getDao() {
		return dao;
	}

	public void setDao(IDao dao) {
		this.dao = dao;
	}

	public List<VO> getData() {
		
	return dao.getData();
	}



	public void saveData(VO formData) {
		
		dao.saveData(formData);
	}

	public List<QuoteVO> getQuote() {
		
	return dao.getQuote();
	}

	public void saveVoterData(VoterForm voter) {
		// TODO Auto-generated method stub
		
		
		
	}

	public void saveElection(NewElection newelect) {
		// ODO Auto-generated method stub
		
		dao.saveElection(newelect);
		
	}

	public void saveCandidate(CandidateForm candidate) {
		// TODO Auto-generated method stub
		dao.saveCandidate(candidate);
	}

	public List<VoterForm> getVoterList() {
		// TODO Auto-generated method stub
		return dao.getVoterList();
	}

	public List<CandidateForm> getResult(String election) {
		// TODO Auto-generated method stub
		return dao.getResult(election);
	}

	public List<String> getElectionList() {
		// TODO Auto-generated method stub
		return dao.getElectionList();
	}

	public void updateStatus(String name, String email) {
		// TODO Auto-generated method stub
		dao.updateStatus(name,email);
	}

	
}
