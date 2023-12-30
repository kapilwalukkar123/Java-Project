package com.yts.pro.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.yts.pro.vo.NewElection;

public class ElectionDataRowMapper implements RowMapper<NewElection>{

	@Override
	public NewElection mapRow(ResultSet rs, int rowNum) throws SQLException {
		// TODO Auto-generated method stub
		
		NewElection election_data = new NewElection();
		
		election_data.setElection_name(rs.getString("election_name"));
		election_data.setElection_date(rs.getString("election_date"));
		
		
		
		
		
		
		
		return election_data;
	}

}
