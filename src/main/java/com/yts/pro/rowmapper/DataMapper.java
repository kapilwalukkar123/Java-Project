package com.yts.pro.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.yts.pro.vo.VO;

public class DataMapper implements org.springframework.jdbc.core.RowMapper<VO> {

	@Override
	public VO mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		
VO data=new VO();
data.setId(rs.getInt("id"));
data.setAdmission_date(rs.getString("admission_date"));
data.setUsername(rs.getString("username"));
data.setLastname(rs.getString("lastname"));
data.setEmail(rs.getString("email"));
data.setContact_no(rs.getString("contact_no"));
data.setAddress(rs.getString("address"));
data.setCoursename_1(rs.getString("coursename_1"));
data.setFees_paid(rs.getString("fees_paid"));
data.setFees_remaining(rs.getString("fees_remaining"));
data.setTotal_fees(rs.getString("total_fees"));

return data;
	
	}

}
