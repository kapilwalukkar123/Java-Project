package com.yts.pro.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.yts.pro.vo.VoterForm;

public class VoterRowmapper implements RowMapper<VoterForm> {

	@Override
	public VoterForm mapRow(ResultSet rs, int rowNum) throws SQLException {
		// TODO Auto-generated method stub
		
		VoterForm voter = new VoterForm();
		
		voter.setFullname(rs.getString("fullname"));
		voter.setAdhar(rs.getString("adhar"));
		voter.setDob(rs.getString("dob"));
		voter.setEmail(rs.getString("email"));
		voter.setGender(rs.getString("gender"));
		voter.setPassword(rs.getString("password"));
		voter.setPhone(rs.getString("phone"));
		voter.setVoterid(rs.getString("voterid"));
		voter.setStatus(rs.getString("status"));	
		
		
		return voter;
	}

}
