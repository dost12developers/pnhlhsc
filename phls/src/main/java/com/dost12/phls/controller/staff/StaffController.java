package com.dost12.phls.controller.staff;

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
@RequestMapping("/staff")
public class StaffController {

	private static final Logger logger = LoggerFactory.getLogger(StaffController.class);
	
	@Autowired
	private CategoryDAO categoryDAO;	
	
	@Autowired
	private IngredientDAO ingredientDAO;
	
	@RequestMapping(value = {"/", "/main", "/index"})
	public ModelAndView dashboard(@RequestParam(name="success",required=false)String success) {		
		ModelAndView mv = new ModelAndView("page-staff");		
		mv.addObject("title","Staff Page");
		mv.addObject("userClickDashboard",true);
		return mv;
		
	}

}

	
