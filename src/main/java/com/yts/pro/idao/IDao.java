package com.yts.pro.idao;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.yts.pro.vo.CandidateForm;
import com.yts.pro.vo.NewElection;
import com.yts.pro.vo.QuoteVO;
import com.yts.pro.vo.VO;
import com.yts.pro.vo.VoterForm;


public interface IDao {
	
	

	List<VO> getData();

	void saveData(VO formData);
	
	List<QuoteVO> getQuote();
	void saveQuote(QuoteVO quoteData);

	void saveElection(NewElection newelect);

	void saveCandidate(CandidateForm candidate);

	List<VoterForm> getVoterList();

	List<CandidateForm> getResult(String election);

	List<String> getElectionList();

	void updateStatus(String name, String email);

}
