package com.dost12.phls.controller.main;

import java.io.PrintWriter;
import java.io.StringWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.View;

import com.dost12.phls.exception.ProductNotFoundException;
import com.dost12.phls.model.UserModel;
import com.dost12.phls.phlsbackend.dao.CategoryDAO;
import com.dost12.phls.phlsbackend.dao.ProductDAO;
import com.dost12.phls.phlsbackend.dto.Category;
import com.dost12.phls.phlsbackend.dto.Product;

@Controller
public class MainPageController {
	
	private static final Logger logger = LoggerFactory.getLogger(MainPageController.class);
	
	@Autowired
	private CategoryDAO categoryDAO;
	
	@Autowired
	private ProductDAO productDAO;
	
	@Autowired
	private HttpSession session;
	
	@RequestMapping(value = {"/home", "/index"})
	public ModelAndView index(@RequestParam(name="logout",required=false)String logout) {		
		ModelAndView mv = new ModelAndView("page");		
		mv.addObject("title","Home");
		
		logger.info("Inside PageController index method - INFO");
		logger.debug("Inside PageController index method - DEBUG");
		
		//passing the list of categories
		mv.addObject("categories", categoryDAO.list());
		
		if(logout!=null) {
			mv.addObject("message", "You have successfully logged out!");			
		}
		
		mv.addObject("userClickHome",true);	
		return mv;				
	}

	@RequestMapping(value = {"/"})
	public String index(@RequestParam(name="logout",required=false)String logout,
			HttpServletRequest request, HttpServletResponse response) {
		if(session.getAttribute("userModel") != null) {
			UserModel userModel = (UserModel) session.getAttribute("userModel");
			if(userModel.getRole().equals("ADMIN_LAB")) {
				return "redirect:/laboratory-admin/";
				
			}
		}
		return "redirect:/home";
		
	}	
	
	
	
	@RequestMapping(value = "/servicesLaboratory")
	public ModelAndView servicesLaboratoryPage() {		
		ModelAndView mv = new ModelAndView("page");		
		mv.addObject("title","Halal Laboratory");
		mv.addObject("userClickServicesLaboratory",true);
		return mv;				
	}	
	
	@RequestMapping(value = "/servicesFoodDevelopment")
	public ModelAndView foodDevelopmentPage() {		
		ModelAndView mv = new ModelAndView("page");		
		mv.addObject("title","Halal Food Developement/Training");
		mv.addObject("userClickServicesFoodDev",true);
		return mv;				
	}	

	@RequestMapping(value = "/servicesPackageLabel")
	public ModelAndView servicesPackageLabelPage() {		
		ModelAndView mv = new ModelAndView("page");		
		mv.addObject("title","Halal Packaging and Labeling");
		mv.addObject("userClickServicesPackageLabel",true);
		return mv;				
	}	
	
	@RequestMapping(value = "/servicesResearch")
	public ModelAndView servicesResearchPage() {		
		ModelAndView mv = new ModelAndView("page");		
		mv.addObject("title","Halal Research and Development");
		mv.addObject("userClickServicesResearch",true);
		return mv;				
	}
	@RequestMapping(value = "/about")
	public ModelAndView about() {		
		ModelAndView mv = new ModelAndView("page");		
		mv.addObject("title","About Us");
		mv.addObject("userClickAbout",true);
		return mv;				
	}	
	
	@RequestMapping(value = "/contact")
	public ModelAndView contact() {		
		ModelAndView mv = new ModelAndView("page");		
		mv.addObject("title","Contact Us");
		mv.addObject("userClickContact",true);
		return mv;				
	}
	
	@RequestMapping(value = "/multimedia")
	public ModelAndView multimedia() {		
		ModelAndView mv = new ModelAndView("page");		
		mv.addObject("title","Multimedia");
		mv.addObject("userClickMultimedia",true);
		return mv;				
	}		
	@RequestMapping(value="/login")
	public ModelAndView login(@RequestParam(name="error", required = false)	String error,
			@RequestParam(name="logout", required = false) String logout) {
		ModelAndView mv= new ModelAndView("login");
		mv.addObject("title", "Login");
		if(error!=null) {
			mv.addObject("message", "Username and Password is invalid!");
		}
		if(logout!=null) {
			mv.addObject("logout", "You have logged out successfully!");
		}
		return mv;
	}
	
	@RequestMapping(value="/logout")
	public String logout(HttpServletRequest request, HttpServletResponse response) {
		// Invalidates HTTP Session, then unbinds any objects bound to it.
	    // Removes the authentication from securitycontext 		
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
	    if (auth != null){    
	        new SecurityContextLogoutHandler().logout(request, response, auth);
	    }
		
		return "redirect:/login?logout";
	}	
	
	
	@RequestMapping(value="/access-denied")
	public ModelAndView accessDenied() {
		ModelAndView mv = new ModelAndView("error");		
		mv.addObject("errorTitle", "Error");		
		mv.addObject("errorDescription", "You are not authorized to view this page!");		
		mv.addObject("title", "403 Access Denied");		
		return mv;
	}	
		
}
