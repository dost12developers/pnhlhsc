package com.dost12.phls.controller.lab;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;

import com.dost12.phls.phlsbackend.dao.CategoryDAO;
import com.dost12.phls.phlsbackend.dao.ProductDAO;
import com.dost12.phls.phlsbackend.dto.Category;
import com.dost12.phls.phlsbackend.dto.Product;

@Controller
@RequestMapping("/laboratory-admin")
public class LabController {

	private static final Logger logger = LoggerFactory.getLogger(LabController.class);
	
	@Autowired
	private CategoryDAO categoryDAO;	
	
	@RequestMapping(value = {"/", "/main", "/index"})
	public ModelAndView manageLabProduct(@RequestParam(name="success",required=false)String success) {		
		ModelAndView mv = new ModelAndView("lab-page");		
		mv.addObject("title","Lab Page");
		mv.addObject("userClickDashboard",true);
		return mv;
		
	}
	@RequestMapping(value = "/product")
	public ModelAndView products() {		
		ModelAndView mv = new ModelAndView("lab-page");		
		mv.addObject("title","Products");
		mv.addObject("userClickProducts",true);
		return mv;				
	}	
	
	@RequestMapping(value = "/manufacture")
	public ModelAndView manufacture() {		
		ModelAndView mv = new ModelAndView("lab-page");		
		mv.addObject("title","Manufacture");
		mv.addObject("userClickManufacture",true);
		return mv;				
	}	

	@RequestMapping(value = "/ingredient")
	public ModelAndView ingredient() {		
		ModelAndView mv = new ModelAndView("lab-page");		
		mv.addObject("title","Ingredient");
		mv.addObject("userClickIngredient",true);
		return mv;				
	}	
	
	@RequestMapping(value = "/certificate")
	public ModelAndView certificate() {		
		ModelAndView mv = new ModelAndView("lab-page");		
		mv.addObject("title","Certificate");
		mv.addObject("userClickCertificate",true);
		return mv;				
	}	

	@RequestMapping(value = "/address")
	public ModelAndView address() {		
		ModelAndView mv = new ModelAndView("lab-page");		
		mv.addObject("title","Address");
		mv.addObject("userClickAddress",true);
		return mv;				
	}		
	@RequestMapping(value = "/category")
	public ModelAndView category() {		
		ModelAndView mv = new ModelAndView("lab-page");		
		mv.addObject("title","Category");
		mv.addObject("userClickCategory",true);

		Category category = new Category();
		mv.addObject("category" , category);
		return mv;				
	}	
	
	@RequestMapping(value = "/category", method=RequestMethod.POST)
	public String addCategory(@ModelAttribute("category") Category mCategory, HttpServletRequest request) {					
		categoryDAO.add(mCategory);		
		return "redirect:/laboratory-admin/category?success=category";
		
	}
}

	
