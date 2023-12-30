package com.yts.pro.controller;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.yts.pro.service.VoterService;
import com.yts.pro.vo.CandidateForm;
import com.yts.pro.vo.NewElection;
import com.yts.pro.vo.VoterForm;

@Controller
@RequestMapping("/voter")
public class VoterController {
	
	
	
	
	
	@Autowired
	VoterService votesr;
	
	
	
	@RequestMapping( value = "/Login", method = RequestMethod.GET)
	public String Login(
			
			Locale locale, Model model) {
	
		
		int count_user=2 ;
		String action="/pro/voter/election";
		  
		  model.addAttribute("count_user", count_user);
		  model.addAttribute("action", action);
		
		return "VoterLogin";
	}
	
	@RequestMapping( value = "/Login2", method = RequestMethod.GET)
	public String Login1(
			
			
			Locale locale, Model model) {
	
		
		int count_user=1 ;
		String action="/pro/voter/election";
		  
		
		
		String login="Your Voter ID Registration is Under Verification. Kindly wait for Approval";
		
		model.addAttribute("count_user", count_user);
		model.addAttribute("message", login);
		  
		
		  model.addAttribute("action", action);
		
		return "VoterLogin";
	}
	
	@RequestMapping( value = "/Login1", method = RequestMethod.GET)
	public String Login1(@ModelAttribute("voterdetails")VoterForm voter,Locale locale, Model model) {
	
		
		
		
		votesr.saveVoterData(voter);
		System.out.println("Voter Form Data"+voter);
		
		
		return "redirect:/voter/Login";
	}
	
	
	
	@RequestMapping(value = "/VoterReg", method = RequestMethod.GET)
	public String Voter_register(Locale locale, Model model) {
		
		/*
		 * Date date = new Date(); DateFormat dateFormat =
		 * DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		 * 
		 * String formattedDate = dateFormat.format(date);
		 */
		
		/* model.addAttribute("serverTime", formattedDate ); */
		
		return "RegisterVoter";
		
		
	}
	
	
	@RequestMapping(value = "/VoterReg1", method = RequestMethod.GET)
	public String Voter_register1(@ModelAttribute("logindetails")VoterForm voter,
									Locale locale, Model model) {
		
		/*
		 * Date date = new Date(); DateFormat dateFormat =
		 * DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		 * 
		 * String formattedDate = dateFormat.format(date);
		 */
		
		/* model.addAttribute("serverTime", formattedDate ); */
		
		
		 String email=voter.getEmail();
		  String pass=voter.getPassword();
		  
		  if(email!=null) {
			  
			  if((pass.equals("12345") && email.equals("admin@123")) ) {
				  
				  return "ElectionAuthority";
			  
			  }
		}
		
		
		  String auth="authority";
			
			int count_user=4 ;
			  
			  model.addAttribute("count_user", count_user); 
			
			model.addAttribute("auth", auth);
			
			
			
			return "VoterLogin";
	
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	@RequestMapping(value = "/election", method = RequestMethod.GET)
	public String VoteElection(@ModelAttribute("logindetails")VoterForm voter,
								@RequestParam(required=false)String vote,
								@RequestParam(required=false)String election_date,
								@RequestParam(required=false)String election,
								@RequestParam(required=false)String voter_email,
								@RequestParam(required=false)String voter_pass,Locale locale, Model model) {
		
		
		/*
		 * List<String> election_list = new ArrayList<String>(); election_list =
		 * votesr.getElectionList(); System.out.println("election_list="+election_list);
		 * 
		 * model.addAttribute("election_list", election_list);
		 * 
		 * List<CandidateForm> candidateList = new ArrayList<CandidateForm>();
		 * candidateList = votesr.getVoterList();
		 * System.out.println("candidate list="+candidateList);
		 * 
		 * model.addAttribute("candidateList", candidateList);
		 */
		
		
		if(voter_email!=null) {
			
			voter.setEmail(voter_email);
			voter.setPassword(voter_pass);
			
		}
		
		
		
		
		
		
		
			String email=voter.getEmail();
		  String pass=voter.getPassword();
		  
		  if(email!=null) {
			  
			  if((pass.equals("12345") && email.equals("admin@123")) ) {
				  
				  
				  return "redirect:/voter/VoterReg1"; }
			  
			  
		  }
		  
		
		 
		   if(pass!=null) {
			  
			  int count_user = 0;
				
				count_user = votesr.checkUser(voter);
				if(count_user==5) {
					
					
					
					
					
					return "redirect:/voter/Login2";
					//return "redirect:/voter/Login?count_user="+count_user+"&message="+login;
				}
				else if(count_user==0){
					
					String login="Please enter correct username or passward!";
					
					model.addAttribute("count_user", count_user);
					model.addAttribute("message", login);
					
					
					return "VoterLogin";
				}
			  
			  
		  }
		
		
		
		
		
	 	if(!(vote==null)) {
		
			
		   int voter_count =	votesr.getVoteCount(vote,election_date,election,voter_email,voter_pass);
		
			
			  if(voter_count!=0) {
			  
			  
				  String message="Already Voted";
					
					model.addAttribute("voter_count", voter_count);
					model.addAttribute("message", message);
					
					List<NewElection> election_list = new ArrayList<NewElection>(); 
					
					election_list =  votesr.getElectionList(); System.out.println("election_list="+election_list);
							 
							  model.addAttribute("election_list", election_list);
							  model.addAttribute("voter_email", email);
							  model.addAttribute("voter_pass", pass);
				  
				  return "VoterTabs";
			  
			  
			  }
			 
	}
		
		
		List<NewElection> election_list = new ArrayList<NewElection>(); 
		
		election_list =  votesr.getElectionList(); System.out.println("election_list="+election_list);
				 
				  model.addAttribute("election_list", election_list);
				  model.addAttribute("voter_email", email);
				  model.addAttribute("voter_pass", pass);
		
		
		
		
		
		return "VoterTabs";
	}
	
	
	
	
	@RequestMapping(value = "/electionList", method = RequestMethod.GET)
	public String VoteElectionList(@RequestParam(required=false)String Election,
									@RequestParam(required=false)String date,
									@RequestParam(required=false)String voter_email,
									@RequestParam(required=false)String voter_pass,Locale locale, Model model) {
		
		
		System.out.println("voter_email="+voter_email+"voter_pass="+voter_pass);
		
		int voter_count =	votesr.getVoteCount1(Election,date,voter_email,voter_pass);
		
		
		  if(voter_count!=0) {
		  
		  
			  String message="Already Voted for "+Election +" election.";
				
				model.addAttribute("voter_count", voter_count);
				model.addAttribute("message", message);
				
				List<NewElection> election_list = new ArrayList<NewElection>(); 
				
				election_list =  votesr.getElectionList(); System.out.println("election_list="+election_list);
						 
						  model.addAttribute("election_list", election_list);
						  model.addAttribute("voter_email", voter_email);
						  model.addAttribute("voter_pass", voter_pass);
			  
			  return "VoterTabs";
		  
		  
		  }
		
		
		
		List<NewElection> election_list = new ArrayList<NewElection>();
		election_list =   votesr.getElectionList(); System.out.println("election_list="+election_list);
		  
		
		model.addAttribute("election_list", election_list);
		  
		  List<CandidateForm> candidateList = new ArrayList<CandidateForm>();
		  candidateList = votesr.getVoterList(Election);
		  System.out.println("candidate list="+candidateList);
		  
		  model.addAttribute("candidateList", candidateList);
		 
		
		model.addAttribute("Election", Election);
		model.addAttribute("Election_date", date);
		model.addAttribute("voter_email", voter_email);
		model.addAttribute("voter_pass", voter_pass);
		
		
		//votesr.getVoteCount(Vote);
		
		
		
		return "VoterElectionList";
	}
	
	

}
