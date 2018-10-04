package com.dost12.phls.controller.supplier;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.dost12.phls.phlsbackend.dao.CategoryDAO;
import com.dost12.phls.phlsbackend.dao.IngredientDAO;

@Controller
@RequestMapping("/supplier")
public class SupplierController {

	private static final Logger logger = LoggerFactory.getLogger(SupplierController.class);
	
	@Autowired
	private CategoryDAO categoryDAO;	
	
	@Autowired
	private IngredientDAO ingredientDAO;
	
	@RequestMapping(value = {"/", "/main", "/index"})
	public ModelAndView dashboard(@RequestParam(name="success",required=false)String success) {		
		ModelAndView mv = new ModelAndView("page-supplier");		
		mv.addObject("title","Supplier Page");
		mv.addObject("userClickDashboard",true);
		return mv;
		
	}
	
}

	
