package com.yts.pro.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.yts.pro.vo.QuoteVO;


public class QuoteMapper implements org.springframework.jdbc.core.RowMapper<QuoteVO>{

	@Override
	public QuoteVO mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		QuoteVO quote=new QuoteVO();
		
		quote.setId(rs.getInt("id"));
		quote.setUser_name(rs.getString("user_name"));
		quote.setUser_contact(rs.getString("user_contact"));
		quote.setUser_email(rs.getString("user_email"));
		quote.setUser_enquiry(rs.getString("user_enquiry"));
		
		return quote;
	}

	
	
}
