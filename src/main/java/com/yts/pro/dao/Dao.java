package com.yts.pro.dao;


import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.multipart.MultipartFile;

import com.yts.pro.idao.IDao;
import com.yts.pro.rowmapper.CandidateRowmapper;
import com.yts.pro.rowmapper.DataMapper;
import com.yts.pro.rowmapper.LoginMapper;
import com.yts.pro.rowmapper.QuoteMapper;
import com.yts.pro.rowmapper.VoterRowmapper;
import com.yts.pro.vo.CandidateForm;
import com.yts.pro.vo.NewElection;
import com.yts.pro.vo.QuoteVO;
import com.yts.pro.vo.VO;
import com.yts.pro.vo.VO2;
import com.yts.pro.vo.VoterForm;

public class Dao implements IDao {

	
@Autowired	
DataSource datasource;	

@Autowired
JdbcTemplate jdbcTemplate;

public void setDataSource(DataSource dataSource)
{
	 this.jdbcTemplate=new JdbcTemplate(dataSource);
}

@Override
public List<QuoteVO> getQuote() {
	
	List<QuoteVO> quoteList =null;
	
	String qry="SELECT id, user_name, user_contact, user_email, user_enquiry  FROM user_quote;";
	try {
		quoteList=jdbcTemplate.query(qry, new QuoteMapper());
	} catch (Exception e) {
		System.out.println(e);
	}
	
	return quoteList;
}



@Override
public void saveQuote(QuoteVO quoteData) {
String qry=	"INSERT INTO user_quote(user_name, user_contact, user_email, user_enquiry) VALUES ('"+quoteData.getUser_name()+"', '"+quoteData.getUser_contact()+"', '"+quoteData.getUser_email()+"', '"+quoteData.getUser_enquiry()+"')";

try {
	jdbcTemplate.execute(qry);
} catch (Exception e) {
	System.err.println(e);
}

}

@Override
public List<VO> getData() {
	
	
	List<VO> dataList =null;
	/*String qry=" SELECT  user_details.username,user_details.lastname,user_details.email,user_details.contact_no,user_details.address from user_details  JOIN  user_course  ON user_details.id=user_course.id";*/
	String qry=" SELECT  u.id,u.email ,u.coursename_1,u.fees_paid ,u.fees_remaining,u.admission_date,u.total_fees,c.username,c.lastname,c.contact_no,c.address from user_course u  JOIN  user_details c ON u.id=c.id";
//	String name="";
	try {
		dataList=jdbcTemplate.query(qry, new DataMapper());
	} catch (Exception e) {
		System.out.println(e);
	}	
	
	return dataList;
}



@Override
public void saveData(VO formData) {
	
	
	
	String qry="insert into temp (username,lastname, email,contact_no,address) values('"+formData.getUsername()+"','"+formData.getLastname()+"','"+formData.getEmail()+"','"+formData.getContact_no()+"','"+formData.getAddress()+"')";
	
	try {
		jdbcTemplate.execute(qry);
	} catch (Exception e) {
		System.err.println(e);
	}
	String qry1="insert into temp1 (coursename_1,fees_paid,fees_remaining,admission_date, total_fees) values('"+formData.getCoursename_1()+"','"+formData.getFees_paid()+"','"+formData.getFees_remaining()+"','"+formData.getAdmission_date()+"','"+formData.getTotal_fees()+"')";
	
	try {
		jdbcTemplate.execute(qry1);
	} catch (Exception e) {
		System.err.println(e);
	}
	
			
	
}

/*public void saveDataQ(QuoteVO quoteData) {
	 
	String qry1="insert into user_quote (user_name,user_contact, user_email,user_enquiry) values('"+quoteData.getUser_name()+"','"+quoteData.getUser_contact()+"','"+quoteData.getUser_email()+"','"+quoteData.getUser_enquiry()+"')";
	
	try{
		jdbcTemplate.execute(qry1);
	}
	catch(Exception e){
		
		System.out.println(e);
		
	}
	
}*/

public boolean delete(int id){    

    String sql="DELETE from user_details  where user_details.id="+id+""; 
    
    String sql1="DELETE from user_course  where user_course.id="+id+""; 

	try{
		jdbcTemplate.execute(sql);
		
	} catch(Exception e){
		
		System.err.println(e);
	}

	try{
		jdbcTemplate.execute(sql1);
		
	} catch(Exception e){
		
		System.err.println(e);
	}
   
   return true; 
}

public VO getStudentById(int id) {
	
	System.out.println("get id");
	
	
	String sql="SELECT  u.id,u.email ,u.coursename_1,u.fees_paid ,u.fees_remaining,u.admission_date,u.total_fees,c.username,c.lastname,c.contact_no,c.address from user_course u  JOIN  user_details c ON u.id=c.id WHERE u.id=? order by u.id";
	
	return  jdbcTemplate.queryForObject(sql, new Object[]{id},new BeanPropertyRowMapper<VO>(VO.class));   
	
}


public boolean update( VO formData){
	String sql="UPDATE user_details SET username='"+formData.getUsername()+"',lastname='"+formData.getLastname()+"',email='"+formData.getEmail()+"',contact_no='"+formData.getContact_no()+"',address='"+formData.getAddress()+"' WHERE id="+formData.getId()+"";

	try{
		jdbcTemplate.execute(sql);
		
	} catch(Exception e){
		
		System.err.println(e);
	}
	String sql1="UPDATE user_course SET email='"+formData.getEmail()+"',coursename_1='"+formData.getCoursename_1()+"',total_fees='"+formData.getTotal_fees()+"',fees_paid='"+formData.getFees_paid()+"',fees_remaining='"+formData.getFees_remaining()+"',admission_date='"+formData.getAdmission_date()+"'  WHERE id="+formData.getId()+"";
   try{
		jdbcTemplate.execute(sql1);
		
	} catch(Exception e){
		
		System.err.println(e);
	}
   
   return true;
}


public int validate(VO2 logInfo) {

	
	
		String sql="SELECT * FROM fun_drawing_login_form('"+logInfo.getUsername()+"', '"+logInfo.getPassword()+"')";
		
		System.out.println(sql +"is here");
		
		int flag=0;
		
		
		try {
			System.out.println("try block");
			flag=jdbcTemplate.queryForObject(sql, Integer.class);
		
		} catch (Exception e) {
			System.out.println(e);
		}
				
		return flag;
	}

@Override
public void saveElection(NewElection newelect) {
	// TODO Auto-generated method stub
	String qry = "Insert into ElectionDeails(election_name,election_date) values('"+newelect.getElection_name()+"','"+newelect.getElection_date()+"')";
	
	try {
		System.out.println("Add Election="+qry);
		jdbcTemplate.execute(qry);
		
		
	}catch (Exception e) {
		// TODO: handle exception
		System.out.println("Error in add election query==+"+e+"\n");
	}
}

@Override
public void saveCandidate(CandidateForm candidate) {
	// TODO Auto-generated method stub
		
		/*
		 * try { byte[] photoBytes = candidate.getImage().getBytes(); } catch
		 * (IOException e1) { // TODO Auto-generated catch block e1.printStackTrace(); }
		 */
		
String qry = "";
	
	try {
		
			/* byte[] photoBytes = photo.getBytes(); */
		qry = "Insert into CandidateDeails(candidate_name,election_name,party_name,address,contact,vote,image,file) values('"+candidate.getCandidate_name()+"','"+candidate.getElection_name()+"','"+candidate.getParty_name()+"','"+candidate.getAddress()+"',"+candidate.getContact()+",0,'"+candidate.getImage()+"','"+candidate.getFile()+"')";
		System.out.println("Add Election="+qry);
		jdbcTemplate.execute(qry);	
		
	}catch (Exception e) {
		// TODO: handle exception
		e.printStackTrace();

		System.out.println("Error in add election query==+"+e+"\n");
	}
}

@Override
public List<VoterForm> getVoterList() {
	// TODO Auto-generated method stub
	
	List<VoterForm> voter_list = new ArrayList<VoterForm>();	
	String qry = "select * from VoterDeails";
		
		try {
			System.out.println("voter_list list="+qry);
			voter_list=jdbcTemplate.query(qry,new VoterRowmapper());
			
			
		}catch (Exception e) {
			// TODO: handle exception
			System.out.println("Error in add voter_list list==+"+e+"\n");
		}
	
		return voter_list;
}

@Override
public List<CandidateForm> getResult(String election) {
	// TODO Auto-generated method stub
	List<CandidateForm> candidateList = new ArrayList<CandidateForm>();
	String qry = "select candidate_name,party_name,vote,image from CandidateDeails where election_name='"+election+"'";
		
		try {
			System.out.println("candidate_list list="+qry);
			candidateList=jdbcTemplate.query(qry,new CandidateRowmapper());
			
			
		}catch (Exception e) {
			// TODO: handle exception
			System.out.println("Error in candidateList list==+"+e+"\n");
		}
	
		return candidateList;
}

@Override
public List<String> getElectionList() {
	// TODO Auto-generated method stub
	List<String> election_list = new ArrayList<String>();	
String qry = "select election_name from ElectionDeails";
	
	try {
		System.out.println("Election list="+qry);
		election_list=jdbcTemplate.queryForList(qry, String.class);
		
		
	}catch (Exception e) {
		// TODO: handle exception
		System.out.println("Error in add Election list==+"+e+"\n");
	}
	return election_list;
}

@Override
public void updateStatus(String name, String email) {
	// TODO Auto-generated method stub
	
String qry = "update VoterDeails set status='Approved' where fullname='"+name+"' and email='"+email+"'";
	
	try {
		System.out.println("updateStatus="+qry);
		jdbcTemplate.update(qry);
		
		
	}catch (Exception e) {
		// TODO: handle exception
		System.out.println("Error in updateStatus==+"+e+"\n");
	}
	
	
}









	
	
	
	
	
}
 







	
