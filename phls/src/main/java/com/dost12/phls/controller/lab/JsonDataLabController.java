package com.dost12.phls.controller.lab;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dost12.phls.phlsbackend.dao.CategoryDAO;
import com.dost12.phls.phlsbackend.dao.CertificateDAO;
import com.dost12.phls.phlsbackend.dao.IngredientDAO;
import com.dost12.phls.phlsbackend.dao.ManufactureDAO;
import com.dost12.phls.phlsbackend.dao.ProductDAO;
import com.dost12.phls.phlsbackend.dto.Category;
import com.dost12.phls.phlsbackend.dto.Certification;
import com.dost12.phls.phlsbackend.dto.Ingredient;
import com.dost12.phls.phlsbackend.dto.Manufacture;
import com.dost12.phls.phlsbackend.dto.Product;

@Controller
@RequestMapping("/json/lab/data")
public class JsonDataLabController {

	@Autowired
	private ProductDAO productDAO;

	@Autowired
	private CategoryDAO categoryDAO;

	@Autowired
	private IngredientDAO ingredientDAO;
	
	@Autowired
	private CertificateDAO certificateDAO;
	
	@Autowired
	private ManufactureDAO manufactureDAO;
	
	@RequestMapping("/all/categories")
	@ResponseBody
	public List<Category> getAllCategorysList() {		
		return categoryDAO.list();
	}	
	
	@RequestMapping("/all/ingredients")
	@ResponseBody
	public List<Ingredient> getAllIngredientsList() {		
		return ingredientDAO.list();
	}
	
	@RequestMapping("/all/certifications")
	@ResponseBody
	public List<Certification> getAllCertificationsList() {		
		return certificateDAO.list();
	}		

	@RequestMapping("/all/products")
	@ResponseBody
	public List<Product> getAllProductsJSONList() {		
		return productDAO.list();
	}
	
	@RequestMapping("/all/manufacatures")
	@ResponseBody
	public List<Manufacture> getAllManufactureJSONList() {		
		return manufactureDAO.list();
	}	

}
 