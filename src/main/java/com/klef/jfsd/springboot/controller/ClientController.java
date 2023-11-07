package com.klef.jfsd.springboot.controller;

import java.io.IOException;

import java.sql.Blob;
import java.sql.SQLException;
import java.util.List;

import javax.sql.rowset.serial.SerialException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.klef.jfsd.springboot.model.Admin;
import com.klef.jfsd.springboot.model.Job;
import com.klef.jfsd.springboot.model.JobApplication;
import com.klef.jfsd.springboot.model.JobSeeker;
import com.klef.jfsd.springboot.model.Recruiter;
import com.klef.jfsd.springboot.service.AdminService;
import com.klef.jfsd.springboot.service.EmailService;
import com.klef.jfsd.springboot.service.JobApplicationService;
import com.klef.jfsd.springboot.service.JobSeekerService;
import com.klef.jfsd.springboot.service.JobService;
import com.klef.jfsd.springboot.service.RecruiterService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;


@Controller

public class ClientController 
{
	
	private int sessionvaraiblejs = 0;

	@Autowired
	private AdminService adminService;
	
	@Autowired
	private JobSeekerService jobSeekerService;
	
	@Autowired
	private EmailService emailService;
	
	@Autowired
	private RecruiterService recruiterService;
	
	@Autowired
	private JobService jobService;
	

	
	@Autowired
	private JobApplicationService jobApplication;
	
	
	
	@GetMapping("/")
	public ModelAndView main()
	{
		ModelAndView mv = new ModelAndView("home");
		return mv;
	}
	
	@GetMapping("login")
	public ModelAndView login()
	{
		ModelAndView mv = new ModelAndView("login");
		return mv;
	}
	
	//registration
	
	
	//Modules
	
	@GetMapping("jobseeker")
	public ModelAndView jobseeker()
	{
		ModelAndView mv = new ModelAndView("jobseekerhome");
		return mv;
	}
	
	
	//admin operations
	@GetMapping("admin")
	public String admin(Model model)
	{
		model.addAttribute("admin",new Admin());
		return "adminlogin";
	}
	
	@PostMapping("checkadminlogin")
	public ModelAndView checkadminlogin(@ModelAttribute("admin") Admin obj)
	{
	              Admin a = adminService.checkAdminLogin(obj.getUsername(), obj.getPassword());
	              ModelAndView mv = new ModelAndView("adminlogin");
	              if(a!=null)
	              {
	            	  mv.setViewName("adminhome");
	            	  return mv;
	              }
	              mv.addObject("msg", "Login Failed!");
	              return mv;
	             
	}
	// Job seeker Logic
	@GetMapping("jobseekerreg")
	public String jobseekerreg(Model m)
	{
		m.addAttribute("JobSeeker", new JobSeeker());
		return "jobseekerreg";
	}
	
	@PostMapping("insertjs")
	public String insertjs(@ModelAttribute("JobSeeker") JobSeeker obj,HttpServletRequest request,@RequestParam("image") MultipartFile file) throws IOException, SerialException,SQLException
	{
		 byte[] bytes = file.getBytes();
		  Blob blob = new javax.sql.rowset.serial.SerialBlob(bytes);
		  
		  obj.setProductimage(blob);
		  jobSeekerService.addJobSeeker(obj);
		  emailService.sendEmail(obj.getEmail());
		  return "jobseekerlogin";
	}
	
	@GetMapping("displayprodimage")
	public ResponseEntity<byte[]> displayprodimagedemo(@RequestParam("email") String mail) throws IOException, SQLException
	{
	  JobSeeker js = jobSeekerService.getJs(mail);
	  byte [] imageBytes = null;
	  imageBytes = js.getProductimage().getBytes(1,(int) js.getProductimage().length());

	  return ResponseEntity.ok().contentType(MediaType.IMAGE_JPEG).body(imageBytes);
	}
	
	@GetMapping("emailverifypage")
	public ModelAndView addemailpage(@RequestParam("email") String email)
	{
		ModelAndView mv = new ModelAndView("verifyaccount");
		mv.addObject("email", email);
		return mv;
	}
	
	@PostMapping("emailverify")
	public ModelAndView setactive(HttpServletRequest req)
	{
		String email = req.getParameter("email");
		jobSeekerService.setActive(jobSeekerService.getJs(email));
	    ModelAndView mv = new ModelAndView("home");
	    return mv;
	}
	
	@PostMapping("checkjobseekerlogin")
	public ModelAndView checkjobseekerlogin(@ModelAttribute("JobSeeker") JobSeeker obj, HttpSession session)
	{
	              JobSeeker a = jobSeekerService.checkseekerlogin(obj.getEmail(), obj.getPassword());
	              ModelAndView mv = new ModelAndView("jobseekerlogin");
	              if(a!=null&&a.isActive()==true)
	              {
	            	  session.setAttribute("jsobject", a);
	            	  mv.setViewName("jobseekerhome");
	            	  mv.addObject("email", a.getEmail());
	            	  List<Job> jlist = jobService.viewalljobs();
	            	  mv.addObject("joblist", jlist);
	            	  sessionvaraiblejs = 1;
	            	  return mv;
	              }
	              else if(a!=null&&a.isActive()==false)
	              {
	            	  mv.addObject("msg", "Activate Your Account");
		              return mv;
	              }
	              mv.addObject("msg", "Login Failed!");
	              return mv;
	             
	}
	@GetMapping("jobseekerlog")
	public String jobseekerlogin(Model m)
	{
		m.addAttribute("JobSeeker", new JobSeeker());
		return "jobseekerlogin";
	}
	
	//Recruiter Logic
	@GetMapping("recruiterreg")
	public String recruiterreg(Model m)
	{
		m.addAttribute("Recruiter", new Recruiter());
		return "recruiterreg";
	}
	
	
	@PostMapping("recruiterinsert")
	public String insertrecruiter(@ModelAttribute("Recruiter") Recruiter obj,HttpServletRequest request,@RequestParam("image") MultipartFile file) throws IOException, SerialException,SQLException
	{
		 byte[] bytes = file.getBytes();
		  Blob blob = new javax.sql.rowset.serial.SerialBlob(bytes);
		  obj.setRecruiterimage(blob);
		  recruiterService.addRecruiter(obj);
		  return "recruiterlogin";
	}

	@GetMapping("displayrecruiterimage")
	public ResponseEntity<byte[]> displayrecruiterimagedemo(@RequestParam("email") String mail) throws IOException, SQLException
	{
	  Recruiter r = recruiterService.getRecruiter(mail);
	  byte [] imageBytes = null;
	  imageBytes = r.getRecruiterimage().getBytes(1,(int) r.getRecruiterimage().length());

	  return ResponseEntity.ok().contentType(MediaType.IMAGE_JPEG).body(imageBytes);
	}
	@GetMapping("recruiterlog")
	public String recruiterlogin(Model m) {
		m.addAttribute("Recruiter", new Recruiter());
		return "recruiterlogin";
	}
	@PostMapping("checkrecruiterlogin")
	public ModelAndView checkrecruiterlogin(@ModelAttribute("Recruiter") Recruiter obj, HttpSession session)
	{
		  Recruiter  reg = recruiterService.checkrecruiterlogin(obj.getEmail(), obj.getPassword());
		  session.setAttribute("email", obj.getEmail());
		  ModelAndView mv = new ModelAndView("recruiterlogin");
		  if(reg!=null&&reg.isIsactive())
		  {
			  session.setAttribute("email", reg.getEmail());
			  mv.setViewName("recruiternav");
        	  mv.addObject("email", reg.getEmail());
			  return mv;
		  }
		  else if(reg!=null&&reg.isIsactive()==false)
		  {
			 mv.addObject("msg", "please activate your account!");
			  return mv;
		  }
		  else {
			  mv.addObject("msg", "Login Failed!");
			  return mv;
		  }

	}
	
	 @GetMapping("viewallrecpage")
	   public ModelAndView viewallrec()
	   {
		   ModelAndView mv = new ModelAndView();
		   mv.setViewName("adminrecruiter");
		   List<Recruiter> reclist = adminService.viewallrec();
		   mv.addObject("recdata", reclist);
		   return mv;
	   }
	 
	   @GetMapping("delete")
	    public String deleteaction(@RequestParam("email") String email)
	    {
	      adminService.deleterec(email);
	      return "redirect:/viewallrecpage";
	    }
	   
	   @GetMapping("updaterecruiterpage")
	   public ModelAndView updatepage(@RequestParam("email") String email)
	   {
		   ModelAndView mv = new ModelAndView();
		   mv.setViewName("recruiterupdate");
		   Recruiter obj = recruiterService.getRecruiter(email);
		   mv.addObject("obj",obj);
		   return mv;
	   }
	   
	 @PostMapping("updaterecruiter")
	 public ModelAndView updatejs(HttpServletRequest request)
	 {
		 
		 String email   = request.getParameter("email");
		 String fullname   = request.getParameter("fullname");
		 String password = request.getParameter("password");
		 String gender = request.getParameter("gender");
		 Recruiter re = new Recruiter();
		 re.setEmail(email);
		 re.setFullname(fullname);
		 re.setPassword(password);
		 re.setGender(gender);
		 
		 String msg=null;
		  ModelAndView mv = new ModelAndView();

		 try {
		  msg = recruiterService.updatereruiter(re);
		  mv.setViewName("recruiterupdate");
		  mv.addObject("message", msg);
		  return mv;
		 }
		 catch (Exception e) {
		   mv.addObject("message", "failed to update");
		   return mv;
		}
		 
	 }
	 
	 
	    
	    @GetMapping("responses")
		public 	ModelAndView responses(HttpSession session)
		{
			ModelAndView mv = new ModelAndView();
			mv.setViewName("recruiterresponses");
			mv.addObject("email", session.getAttribute("email"));
			return mv;
		}
	       @GetMapping("deletejobs")
	  		public 	ModelAndView deletejobs(HttpSession session)
	  		{
	  			ModelAndView mv = new ModelAndView();
	  			mv.setViewName("deletejobs");
	  			mv.addObject("email", session.getAttribute("email"));
	  			return mv;
	  		}
	       
	       //Adding JOBS logic
	
	       @GetMapping("addjob")
			public 	ModelAndView job(Model m, HttpSession session)
			{
				m.addAttribute("Job", new Job());
				ModelAndView mv = new ModelAndView();
				mv.setViewName("jobrecruitment");
				mv.addObject("email", session.getAttribute("email"));
				return mv;
			}
	       
	   	@PostMapping("insertjob")
	   	public ModelAndView insertjob(@ModelAttribute("Job") Job obj,HttpServletRequest request,@RequestParam("image") MultipartFile file,HttpSession session) throws IOException, SerialException,SQLException
	   	{
	   		 byte[] bytes = file.getBytes();
	   		  Blob blob = new javax.sql.rowset.serial.SerialBlob(bytes);
	   		  ModelAndView mv = new ModelAndView();
	   		  obj.setCompanyimage(blob);
	   		  String message = jobService.insertjob(obj);
	   		  mv.setViewName("jobrecruitment");
	   		  mv.addObject("msg", message);
	   		  session.setAttribute("job_id", obj.getId());
	   		  return mv;
	   	}
	   	@GetMapping("displayjobimage")
		public ResponseEntity<byte[]> displayjobimage(@RequestParam("id") int jid) throws IOException, SQLException
		{
		  Job job = jobService.getjob(jid);
		  byte [] imageBytes = null;
		  imageBytes = job.getCompanyimage().getBytes(1,(int) job.getCompanyimage().length());

		  return ResponseEntity.ok().contentType(MediaType.IMAGE_JPEG).body(imageBytes);
		}
		//Apply Job Logic
		
	   @GetMapping("jobapplicationform")
	   public ModelAndView jobapplicationform(Model m,HttpSession httpSession,@RequestParam("job_id") int id)
	   {
		   
		   m.addAttribute("JobApplication", new JobApplication());
		   ModelAndView mv = new ModelAndView();
		   mv.setViewName("jobapplication");
		   JobSeeker jobvar = (JobSeeker) httpSession.getAttribute("jsobject");
		   mv.addObject("obj", jobvar);
	   	   mv.addObject("job_id", id);
		   return mv;
	   }
		@PostMapping("insertjobapplication")
	   	public ModelAndView insertjobapplication(@ModelAttribute("JobApplication") JobApplication obj,HttpServletRequest request ,@RequestParam("file") MultipartFile file) throws IOException, SerialException,SQLException
	   	{
			
	   		 byte[] bytes = file.getBytes();
	   		  Blob blob = new javax.sql.rowset.serial.SerialBlob(bytes);
	   		  ModelAndView mv = new ModelAndView();
	   		  obj.setResume(blob);
	   		  String message = jobApplication.insertapplication(obj);
	   		  mv.setViewName("jobapplication");
	   		  mv.addObject("msg", message);
	   		  return mv;
	   	}
		
		//recruiter responses logic
		@GetMapping("recruiterresponsespage")
		public ModelAndView recruiterresponses(HttpSession httpsession)
		{
			ModelAndView mv = new ModelAndView();
			mv.setViewName("recruiterresponses");
			String em = (String) httpsession.getAttribute("email");
		    Job j = jobService.getjobemail(em);
		    List<JobApplication> rlist = jobApplication.viewbyjobid(j.getId());
			mv.addObject("list", rlist);
			return mv;
		}
		
		@GetMapping("downloadpdf")
		public ResponseEntity<byte[]> downloadPdf(@RequestParam("id") int jid) throws IOException, SQLException {
		    JobApplication job = jobApplication.getapplication(jid);
		    byte[] pdfBytes = null;

		    // Assuming that job.getCompanyPdf() returns the PDF file data
		    pdfBytes = job.getResume().getBytes(1, (int) job.getResume().length());

		    HttpHeaders headers = new HttpHeaders();
		    headers.setContentType(MediaType.APPLICATION_PDF);
		    headers.setContentDispositionFormData("attachment", "job.pdf"); // You can specify the filename here.
		    return ResponseEntity.ok().headers(headers).body(pdfBytes);
		}
		
		@GetMapping("acceptjob")
		@ResponseBody
		public String acceptjobs(@RequestParam("email") String email,@RequestParam("job_id") int id)
		{
			 JobSeeker obj =  jobSeekerService.getJs(email);
			 obj.setJob_id(id);
			 jobSeekerService.updatejobseeker(obj);
			 emailService.sendEmailAccepted(obj.getEmail());
			 return "accepted! <a href='recruiterresponsespage'>return back</a>";
		}
		
		@GetMapping("jobseekerresponses")
		public ModelAndView jobseekerresponses(HttpSession httpSession)
		{
			ModelAndView mv = new ModelAndView();
			mv.setViewName("noresponses");
			try {
				mv.setViewName("noresponses");
			  if(sessionvaraiblejs==1) {
			  JobSeeker js = (JobSeeker) httpSession.getAttribute("jsobject");
		      Job jlist = jobService.getjob(js.getJob_id());
			  mv.setViewName("jobseekerresponses");
			  mv.addObject("list", jlist);
			  return mv;
			  }
			  return mv;
			}
			catch(Exception e)
			{
				return mv;
			}
		}
		
		   @GetMapping("viewalljobseekerpage")
		   public ModelAndView viewalljobseekerpage()
		   {
			   ModelAndView mv = new ModelAndView();
			   mv.setViewName("adminjobseeker");
			   List<JobSeeker> joblist = jobSeekerService.viewalljobseekers();
			   mv.addObject("jsdata", joblist);
			   return mv;
		   }
		    @GetMapping("deletejobseeker")
		    public String deletejobseeker(@RequestParam("email") String email)
		    {
		      adminService.deletejobseeker(email);
		      return "redirect:/viewalljobseekerpage";
		    }
		    
		       @GetMapping("updatejobseekerpage")
			   public ModelAndView updatejobseekerpage(@RequestParam("email") String email)
			   {
				   ModelAndView mv = new ModelAndView();
				   mv.setViewName("jobseekerupdate");
				   JobSeeker obj = jobSeekerService.getJs(email);
				   mv.addObject("obj",obj);
				   return mv;
			   }
		     @PostMapping("updatejobseeker")
		  	 public ModelAndView updatejobseeker(HttpServletRequest request)
		  	 {
		  		 
		  		 String email   = request.getParameter("email");
		  		 String fullname   = request.getParameter("fullname");
		  		 String password = request.getParameter("password");
		  		 String gender = request.getParameter("gender");
		  		 JobSeeker re = new JobSeeker();
		  		 re.setEmail(email);
		  		 re.setFullname(fullname);
		  		 re.setPassword(password);
		  		 re.setGender(gender);
		  		 
		  		 String msg=null;
		  		  ModelAndView mv = new ModelAndView();

		  		 try {
		  		  msg = jobSeekerService.updatejobseeker(re);
		  		  mv.setViewName("jobseekerupdate");
		  		  mv.addObject("message", msg);
		  		  return mv;
		  		 }
		  		 catch (Exception e) {
		  		   mv.addObject("message", "failed to update");
		  		   return mv;
		  		}
		  		 
		  	 }
		     @GetMapping("adminrequests")
		     public ModelAndView adminrequests()
		     {
		    	 ModelAndView mv = new ModelAndView();
		    	 List<Recruiter> reclist = adminService.viewallrec();
				 mv.addObject("recdata", reclist);
		    	 mv.setViewName("adminrequests");
		    	 return mv;
		     }
		     @GetMapping("recruiteractionactive")
		     public String recruiteractiveaction(@RequestParam("email")String email)
		     {
		    	
		    	 Recruiter  obj = recruiterService.getRecruiter(email);
		    	 obj.setIsactive(true);
		    	
		    	 recruiterService.updatereruiter(obj);
		    	 return "redirect:/adminrequests";
		   
		     }
		     @GetMapping("recruiteractioninactive")
		     public String recruiterinactiveaction(@RequestParam("email")String email)
		     {
		    	 Recruiter  obj = recruiterService.getRecruiter(email);
		    	 obj.setIsactive(false);
		    	 recruiterService.updatereruiter(obj);
		    	 return "redirect:/adminrequests";
		     }
		     @GetMapping("deletejobspage")
		     public ModelAndView viewalljobs() {
		    	 ModelAndView mv = new ModelAndView();
		    	 List<Job> jlist = jobService.viewalljobs();
		    	 mv.setViewName("deletejobs");
		    	 mv.addObject("jsdata", jlist);
		    	 return mv;
		     }
		     @GetMapping("deletejob")
		     public String deletejob(@RequestParam("id")int id)
		     {
		    	 jobService.deletejob(id);
			      return "redirect:/deletejobs";

		     }
		     @GetMapping("logout")
		     public String logout(HttpSession session)
		     {
		    	 sessionvaraiblejs = 0;
		    	 session.invalidate();
		    	 return "redirect:/";
		     }

		  
}
