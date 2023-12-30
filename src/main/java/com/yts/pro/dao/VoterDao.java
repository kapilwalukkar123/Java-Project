package com.yts.pro.dao;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import com.yts.pro.idao.IVoterDao;
import com.yts.pro.rowmapper.CandidateRowmapper;
import com.yts.pro.rowmapper.ElectionDataRowMapper;
import com.yts.pro.rowmapper.VoterRowmapper;
import com.yts.pro.vo.CandidateForm;
import com.yts.pro.vo.NewElection;
import com.yts.pro.vo.VoterForm;



public class VoterDao implements IVoterDao{

    JdbcTemplate jdbcTemplate;
	


    @Autowired
	public void setDataSource (DataSource dataSource) {
		
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}





	@Override
	public void saveVoterData(VoterForm voter) {
		// TODO Auto-generated method stub
		
		String qry="";
		
		try {
			
			 qry="Insert into VoterDeails (fullname,email,password,dob,phone,adhar,voterid,gender,status) Values('"+voter.getFullname()+"','"+voter.getEmail()+"','"+voter.getPassword()+"','"+voter.getDob()+"',"+voter.getPhone()+","+voter.getAdhar()+","+voter.getVoterid()+",'"+voter.getGender()+"','Pending')";
			System.out.println("Insert Data Into Voter Table"+qry);
			jdbcTemplate.execute(qry);
			
		}catch (Exception e) {
			// TODO: handle exception
			
			System.out.println("Error in Insert query"+e+"\n");
		}
		
		
	}





	@Override
	public List<NewElection> getElectionList() {
		// TODO Auto-generated method stub
		List<NewElection> election_list = new ArrayList<NewElection>();	
		String qry = "select * from ElectionDeails";
			
			try {
				System.out.println("Election list="+qry);
				election_list=jdbcTemplate.query(qry, new ElectionDataRowMapper());
				
				
			}catch (Exception e) {
				// TODO: handle exception
				System.out.println("Error in add Election list==+"+e+"\n");
			}
			return election_list;
	}





	@Override
	public List<CandidateForm> getVoterList(String election) {
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
	public int getVoteCount(String vote,String election_date,String election, String voter_email, String voter_pass) {
		// TODO Auto-generated method stub
	
		
		String qry="";
		int vote1;
		int voter_present=0;
		
		String qry1="";
		String qry2="";
		String qry3="";
		String qry4="";
		String voter_id="";
		try {
			
			
			qry2="select voterid from VoterDeails where email='"+voter_email+"' and password='"+voter_pass+"'";
			System.out.println("query for getting voter_id==>"+qry2);
			voter_id = jdbcTemplate.queryForObject(qry2, String.class);    
			qry4="select count(*) from VoterVoteStatus where email='"+voter_email+"' and voterid='"+voter_id+"' and election_name='"+election+"' and election_date='"+election_date+"'";						
		    System.out.println("select voter from VoterVoteStatus table==>"+qry4);
			
			voter_present = jdbcTemplate.queryForObject(qry4, Integer.class);
			
			if(voter_present!=0) {
				
				return voter_present;
			}
			
			qry1="select vote from CandidateDeails where candidate_name='"+vote+"' ";
			System.out.println("select vote from CandidateDeails Query==>"+qry1);
			
			/*
			 * qry2="select voterid from VoterDeails where email='"
			 * +voter_email+"' and password='"+voter_pass+"'";
			 * 
			 * System.out.println("query for getting voter_id==>"+qry2); voter_id =
			 * jdbcTemplate.queryForObject(qry2, String.class);
			 */
		    
		    qry3="insert into VoterVoteStatus (email,voterid,election_name,election_date) values('"+voter_email+"','"+voter_id+"','"+election+"','"+election_date+"')";
		    System.out.println("Insert into VoterVoteStatus query ="+qry3);
		    jdbcTemplate.update(qry3);
		    // qry="update CandidateDeails set vote="+vote1+" where candidate_name='"+vote+"' ";
			
			vote1=jdbcTemplate.queryForObject(qry1, Integer.class);
			
			vote1=vote1+1;
			qry="update CandidateDeails set vote="+vote1+" where candidate_name='"+vote+"' ";
			System.out.println("Update Vote Data Into CandidateDeails Table==>"+qry);
			jdbcTemplate.update(qry);
		}catch (Exception e) {
			// TODO: handle exception
			
			System.out.println("Error in Insert query=="+e+"\n");
		}
		
		return voter_present;
	}





	@Override
	public int checkUser(VoterForm voter) {
		// TODO Auto-generated method stub
		int count = 0;
	
		String qry1 = "select count(*) from VoterDeails where email='"+voter.getEmail()+"' and password='"+voter.getPassword()+"'";
		String qry="select count(*) from VoterDeails where email='"+voter.getEmail()+"' and password='"+voter.getPassword()+"' and status='Approved'";
		try {
			
			System.out.println("check user="+qry1);
			count=jdbcTemplate.queryForObject(qry1,Integer.class);
			System.out.println("check user count="+count);
			if(count==1) {
				
				System.out.println("check user="+qry);
				count=jdbcTemplate.queryForObject(qry,Integer.class);
				
				if(count==0) {
					
					count=5;
					
					return count;
				}
				count=6;
				System.out.println("check user count="+count);	
				
			}
			
			
		}
		catch (Exception e) {
			// TODO: handle exception
		}
		
		return count;
	}





	@Override
	public int getVoteCount1(String election, String date, String voter_email, String voter_pass) {
		// TODO Auto-generated method stub
		
		
		
		int voter_present=0;
		
		
		String qry2="";
		
		String qry4="";
		String voter_id="";
		try {
			
			
			qry2="select voterid from VoterDeails where email='"+voter_email+"' and password='"+voter_pass+"'";
			System.out.println("query for getting voter_id==>"+qry2);
			voter_id = jdbcTemplate.queryForObject(qry2, String.class);    
			qry4="select count(*) from VoterVoteStatus where email='"+voter_email+"' and voterid='"+voter_id+"' and election_name='"+election+"' and election_date='"+date+"'";						
		    System.out.println("select voter from VoterVoteStatus table==>"+qry4);
			
			voter_present = jdbcTemplate.queryForObject(qry4, Integer.class);
			
			if(voter_present!=0) {
				
				voter_present =1;
			}
				
		
		
	}catch(Exception e) {
		
		System.out.println("Error in count use==>"+e+"/n");
	}
		return voter_present;
		}

}
