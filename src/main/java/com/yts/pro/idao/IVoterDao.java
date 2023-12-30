package com.yts.pro.idao;

import java.util.List;

import com.yts.pro.vo.CandidateForm;
import com.yts.pro.vo.NewElection;
import com.yts.pro.vo.VoterForm;

public interface IVoterDao {

	 void saveVoterData(VoterForm voter);

	List<NewElection> getElectionList();

	List<CandidateForm> getVoterList(String election);

	int getVoteCount(String vote,  String election_date, String election, String voter_email, String voter_pass);

	int checkUser(VoterForm voter);

	int getVoteCount1(String election, String date, String voter_email, String voter_pass);

}
