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
import com.dost12.phls.phlsbackend.dao.IngredientDAO;
import com.dost12.phls.phlsbackend.dao.ProductDAO;
import com.dost12.phls.phlsbackend.dto.Category;
import com.dost12.phls.phlsbackend.dto.Ingredient;
import com.dost12.phls.phlsbackend.dto.Product;

@Controller
@RequestMapping("/laboratory")
public class LabController {

	private static final Logger logger = LoggerFactory.getLogger(LabController.class);
	
	@Autowired
	private CategoryDAO categoryDAO;	
	
	@Autowired
	private IngredientDAO ingredientDAO;
	
	@RequestMapping(value = {"/", "/main", "/index"})
	public ModelAndView manageLabProduct(@RequestParam(name="success",required=false)String success) {		
		ModelAndView mv = new ModelAndView("page-laboratory");		
		mv.addObject("title","Lab Page");
		mv.addObject("userClickDashboard",true);
		return mv;
		
	}
	@RequestMapping(value = "/product")
	public ModelAndView products() {		
		ModelAndView mv = new ModelAndView("page-laboratory");		
		mv.addObject("title","Products");
		mv.addObject("userClickProducts",true);
		return mv;				
	}	
	
	@RequestMapping(value = "/manufacture")
	public ModelAndView manufacture() {		
		ModelAndView mv = new ModelAndView("page-laboratory");		
		mv.addObject("title","Manufacture");
		mv.addObject("userClickManufacture",true);
		return mv;				
	}	

	@RequestMapping(value = "/ingredient")
	public ModelAndView ingredient() {		
		ModelAndView mv = new ModelAndView("page-laboratory");		
		mv.addObject("title","Ingredient");
		mv.addObject("userClickIngredient",true);
		
		Ingredient ingredient = new Ingredient();
		mv.addObject("ingredient", ingredient);
		return mv;				
	}
	                          
	@RequestMapping(value = "/ingredient", method=RequestMethod.POST)
	public String addIngredient(@ModelAttribute("ingredient") Ingredient ingredient, HttpServletRequest request) {					
		ingredientDAO.add(ingredient);		
		return "redirect:/laboratory/ingredient?success=ingredient";
	}
	
	
	@RequestMapping(value = "/certificate")
	public ModelAndView certificate() {		
		ModelAndView mv = new ModelAndView("page-laboratory");		
		mv.addObject("title","Certificate");
		mv.addObject("userClickCertificate",true);
		return mv;				
	}	

	@RequestMapping(value = "/shipment")
	public ModelAndView address() {		
		ModelAndView mv = new ModelAndView("page-laboratory");		
		mv.addObject("title","shipment");
		mv.addObject("userClickShipment",true);
		return mv;				
	}		
	@RequestMapping(value = "/category")
	public ModelAndView category(@RequestParam(name="success",required=false)String success,
								 @RequestParam(name="id",required=false)String id) {		
		ModelAndView mv = new ModelAndView("page-laboratory");		
		mv.addObject("title","Category");
		
		Category category = new Category();
		
		
		if(id != null && categoryDAO.get(Integer.valueOf(id)) != null) {
			mv.addObject("userClickCat",true);
			category = categoryDAO.get(Integer.valueOf(id));
		}
		else
		    mv.addObject("userClickCats",true);
	
		
		mv.addObject("category" , category);
		
		if(success != null) {
			if (success.equals("category")) {
				mv.addObject("message", "Category submitted successfully!");
			}
		}
		
		return mv;				
	}	
	
	@RequestMapping(value = "/category", method=RequestMethod.POST)
	public String addCategory(@ModelAttribute("category") Category mCategory, HttpServletRequest request) {
		if(mCategory.getId() != 0)
			categoryDAO.update(mCategory);			
		else
			categoryDAO.add(mCategory);
		return "redirect:/laboratory/category?success=category";
		
	}
}

	
