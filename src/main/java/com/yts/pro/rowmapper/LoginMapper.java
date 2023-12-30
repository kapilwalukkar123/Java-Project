package com.yts.pro.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;


import com.yts.pro.vo.VO2;

public class LoginMapper implements org.springframework.jdbc.core.RowMapper<VO2> {

	@Override
	public VO2 mapRow(ResultSet rs, int rowNum) throws SQLException {
	
		VO2  info=new VO2();
		
		
		info.setUsername(rs.getString("username"));
		info.setPassword(rs.getString("password"));
		
		
		return info;
	}

}
