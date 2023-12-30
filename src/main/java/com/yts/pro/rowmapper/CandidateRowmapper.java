 package com.yts.pro.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.yts.pro.vo.CandidateForm;

public class CandidateRowmapper implements RowMapper<CandidateForm >{

	@Override
	public CandidateForm mapRow(ResultSet rs, int rowNum) throws SQLException {
		// TODO Auto-generated method stub
		
		CandidateForm  candidate = new CandidateForm();
		
		candidate.setCandidate_name(rs.getString("candidate_name"));
		candidate.setParty_name(rs.getString("party_name"));
		candidate.setVote(rs.getInt("vote"));
		candidate.setImage(rs.getString("image"));
		
		
		
		
		
		return candidate;
	}

}
