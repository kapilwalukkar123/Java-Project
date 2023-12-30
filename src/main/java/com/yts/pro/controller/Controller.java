package com.yts.pro.controller;


import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.lang.Object;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;

import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.yts.pro.dao.Dao;
import com.yts.pro.service.Service;
import com.yts.pro.service.VoterService;
import com.yts.pro.vo.CandidateForm;
import com.yts.pro.vo.NewElection;
import com.yts.pro.vo.QuoteVO;
import com.yts.pro.vo.VO;
import com.yts.pro.vo.VO2;
import com.yts.pro.vo.VoterForm;

@org.springframework.stereotype.Controller

@RequestMapping("/main")
public class Controller {
    
	@Autowired
	Dao dao;
	
	@Autowired
	Service service;
	
	@Autowired
	VoterService votesr;
	
	
	private static final String UPLOAD_DIRECTORY ="/resources/images";
	private static final int THRESHOLD_SIZE     = 1024 * 1024 * 3;  // 3MB
	
	@RequestMapping("uploadform")
	public ModelAndView uploadForm(){
		return new ModelAndView("uploadform");	
	}
	
	@RequestMapping(value="/savefile",method=RequestMethod.POST,consumes = {MediaType.MULTIPART_FORM_DATA_VALUE})
	public ModelAndView saveimage( @ModelAttribute("candidatedetails")CandidateForm candidate,@RequestParam CommonsMultipartFile file,HttpSession session,BindingResult bindingResult) throws Exception
	{
	DiskFileItemFactory factory = new DiskFileItemFactory();
	factory.setSizeThreshold(THRESHOLD_SIZE);
	factory.setRepository(new File(System.getProperty("java.io.tmpdir")));
	 
	ServletFileUpload upload = new ServletFileUpload(factory);
	ServletContext context = session.getServletContext();

	String uploadPath = context.getRealPath(UPLOAD_DIRECTORY);
	System.out.println(uploadPath);	    

	byte[] bytes = file.getBytes();
	BufferedOutputStream stream =new BufferedOutputStream(new FileOutputStream(new File(uploadPath + File.separator + file.getOriginalFilename())));
	stream.write(bytes);
	stream.flush();
	stream.close();
	
	
	
	service.saveCandidate(candidate);
	
	return new ModelAndView("RegisterCandidate","filesuccess","File successfully saved!="+uploadPath);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	@RequestMapping("/getAuthority")  
	public String getAuthority(Model model)
	{
		String auth="authority";
		String action="/pro/voter/VoterReg1";
		
		int count_user=3 ;
		  
		  model.addAttribute("count_user", count_user); 
		
		model.addAttribute("auth", auth);
		model.addAttribute("action", action);
		
		
		return "VoterLogin";
	}
	
	
	
	
	
	@RequestMapping("/addElection")  
	public String addElection()
	{
		
		
		return "AddElection";
	}
	
	@RequestMapping("/saveElection")  
	public String saveElection()
	{
		
		
		return "AddElection";
	}
	
	
	@RequestMapping( value = "/saveElection", method = RequestMethod.GET)
	public String saveElection(@ModelAttribute("electiondetails")NewElection newelect,Locale locale, Model model) {
	
			
		service.saveElection(newelect);
		System.out.println("Voter Form Data"+newelect);
		
		return "AddElection";
	}
	
	
	@RequestMapping("/addCandidate")  
	public String addCandidate(Model model)
	{
		List<String> election_list = new ArrayList<String>();
		election_list = service.getElectionList();
		System.out.println("election_list="+election_list);
		
		model.addAttribute("election_list", election_list);
		
		return "RegisterCandidate";
	}
	
	@RequestMapping( value = "/saveCandidate", method = RequestMethod.GET, headers = "Accept=multipart/form-data", produces = "multipart/form-data", consumes = {MediaType.MULTIPART_FORM_DATA_VALUE})
	public String saveCandidate(@ModelAttribute("candidatedetails")CandidateForm candidate,@RequestParam CommonsMultipartFile file,HttpSession session,BindingResult bindingResult,Locale locale, Model model)throws Exception
	
	{
	
		
		
			
		service.saveCandidate(candidate);
		System.out.println("Voter Form Data"+candidate);
		
		
		return "RegisterCandidate";
	}
	
	@RequestMapping(value = "/viewVoters", method = RequestMethod.GET)  
	public String viewVoters(Model model)
	{
		
		
		
		List<VoterForm> voterList = new ArrayList<VoterForm>();
		voterList = service.getVoterList();
		System.out.println("voter list="+voterList);
		
		model.addAttribute("voterList", voterList);
		
		
		
		return "VoterList";
	}
	
	@RequestMapping(value = "/viewVoters1", method = RequestMethod.GET)  
	public String viewVoters1(Model model,
			@RequestParam(required = false)String name,
			@RequestParam(required = false)String email,
			@RequestParam(required = false)String status)
	{
		
		
		service.updateStatus(name,email);
		
		
		
		
		return "redirect:/main/viewVoters";
	}
	
	
	@RequestMapping(value="/viewResults",method = RequestMethod.GET)  
	public String viewResults(@RequestParam(required=false)String Election,
			                  @RequestParam(required=false)String date,Model model)
	{
		
	//	List<CandidateForm> result = new ArrayList<CandidateForm>();
		List<NewElection> election_list = new ArrayList<NewElection>();
		election_list =   votesr.getElectionList(); System.out.println("election_list="+election_list);
		  
		
		model.addAttribute("election_list", election_list);
		model.addAttribute("Election", Election);
		
		
		
		List<CandidateForm> candidateList = new ArrayList<CandidateForm>();
		  candidateList =service.getResult(Election);
		  System.out.println("candidate list="+candidateList);
		  
		  model.addAttribute("candidateList", candidateList);
		
		
	//	result = service.getResult();
		//model.addAttribute("result", result);
		
		
		return "ElectionResult";
	}

	/*@RequestMapping("/getStudentData")  
	public String getStudentData()
	{		
		
		return "StudentData";
	}*/
	
	
	@RequestMapping("/getData")
	public String getData(@ModelAttribute VO2 logInfo, Model model)
	{
		int a=dao.validate(logInfo); 
		
        if(a==1){
			
			return "StudentData";
		}
		else{
			
			return "redirect:/main/getLog";
		}	
		
	
	}
	
	
	
	@RequestMapping("/getDataAgain")  
	public String getDataAgain()
	{
		
		
		return "Database";
	}
	
	
	
	
	@RequestMapping("/getLog")
	public String getLog()
	{
		System.out.println("alert");
		return "Login";
	}
	

	


	
	@RequestMapping(value="/getHome", method=RequestMethod.POST)
	public String getHome(@ModelAttribute QuoteVO quoteData, Model model)
	{
		dao.saveQuote(quoteData);
		
		return "Welcome";
		
	}

	
	
	
	
	@RequestMapping(value="/getHomepage", method=RequestMethod.POST)
	public String getHomepage()
	{
		
		
		return "Welcome";
		
	}
	
	@RequestMapping(value="/getWelcome",method=RequestMethod.POST)
	
	public String getLogin(@ModelAttribute  VO formData,Model model)
	{		
		service.saveData(formData);
		return "Welcome";
	}
	
	@RequestMapping("/getDatabase")
	public String getDatabase( Model model)
	
	{
		
		List<VO> listData=new ArrayList<VO>();
		/*List<QuoteVO> listQuote=new ArrayList<QuoteVO>();
		
		listQuote=service.getQuote();*/
		

		listData=service.getData();
		
		
		
		/*model.addAttribute("quoteList", listQuote);*/
		
		model.addAttribute("dataList", listData);
		
		      
			
			return "Database";
		
	
		
	} 
	
	@RequestMapping("/getQuoteDatabase")
	public String getQuoteDatabase( @ModelAttribute QuoteVO quoteData, Model model)
	
	{
		
		
		List<QuoteVO> listQuote=new ArrayList<QuoteVO>();
		
		listQuote=service.getQuote();	
		
		
		model.addAttribute("quoteList", listQuote);		
		     
			
			return "Database";			
		
	}
	
	
	
	
	
	
	
	
	
	
	
	 @RequestMapping(value="/deletepat/{id}",method = RequestMethod.GET)    
	    public String delete(@PathVariable int id){    
	          
		    
			dao.delete(id); 
			
	        return "redirect:/main/getDatabase";      
	    } 
	 
	 @RequestMapping(value="/updatepat/{id}")    
	 public String updatepat(@PathVariable int id, Model m){    
	 	 VO vo=dao.getStudentById(id);    
	     m.addAttribute("user_id", Integer.toString(vo.getId())); 
	     m.addAttribute("user_name", vo.getUsername());
	     m.addAttribute("last_name", vo.getLastname());
	     m.addAttribute("course", vo.getCoursename_1());
	     m.addAttribute("mail", vo.getEmail());
	     m.addAttribute("no", vo.getContact_no());
	     m.addAttribute("addr", vo.getAddress());
	     m.addAttribute("date", vo.getAdmission_date());
	     m.addAttribute("feesp", vo.getFees_paid());
	     m.addAttribute("feesr", vo.getFees_remaining());	
	     m.addAttribute("totfees", vo.getTotal_fees());
	 
	     return "EditRegistration";    
	 }   
	
				
		
	
	

	

	 @RequestMapping(value="/Update",method = RequestMethod.POST)    
	 public String Update(@ModelAttribute VO info, Model model){    
	     dao.update(info);    
	    return "redirect:/main/getDataAgain";    
	 }  
	 

	@RequestMapping(value="/getWelcome2",method=RequestMethod.POST)
	public String getWelcome2()
	{
		
		
		return "Welcome2";
	}
	
	
	
}
