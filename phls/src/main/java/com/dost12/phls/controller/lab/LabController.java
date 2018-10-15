package com.dost12.phls.controller.lab;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
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
import com.dost12.phls.util.FileUtil;
import com.dost12.phls.validator.ProductValidator;

@Controller
@RequestMapping("/laboratory")
public class LabController {

	private static final Logger logger = LoggerFactory.getLogger(LabController.class);

	@Autowired
	private CategoryDAO categoryDAO;

	@Autowired
	private IngredientDAO ingredientDAO;

	@Autowired
	private ProductDAO productDAO;

	@RequestMapping(value = { "/", "/main", "/index" })
	public ModelAndView manageLabProduct(@RequestParam(name = "success", required = false) String success) {
		ModelAndView mv = new ModelAndView("page-laboratory");
		mv.addObject("title", "Lab Page");
		mv.addObject("userClickDashboard", true);
		return mv;

	}

	@RequestMapping(value = "/products")
	public ModelAndView products() {
		ModelAndView mv = new ModelAndView("page-laboratory");
		mv.addObject("title", "Products");
		mv.addObject("userClickProducts", true);
		return mv;
	}

	@RequestMapping(value = "/manufactures")
	public ModelAndView manufacture() {
		ModelAndView mv = new ModelAndView("page-laboratory");
		mv.addObject("title", "Manufacture");
		mv.addObject("userClickManufacture", true);
		return mv;
	}

	@RequestMapping(value = "/ingredients")
	public ModelAndView ingredient() {
		ModelAndView mv = new ModelAndView("page-laboratory");
		mv.addObject("title", "Ingredient");
		mv.addObject("userClickIngredient", true);

		Ingredient ingredient = new Ingredient();
		mv.addObject("ingredient", ingredient);
		return mv;
	}

	@RequestMapping(value = "/ingredient", method = RequestMethod.POST)
	public String addIngredient(@ModelAttribute("ingredient") Ingredient ingredient, HttpServletRequest request) {
		ingredientDAO.add(ingredient);
		return "redirect:/laboratory/ingredient?success=ingredient";
	}

	@RequestMapping(value = "/certificates")
	public ModelAndView certificate() {
		ModelAndView mv = new ModelAndView("page-laboratory");
		mv.addObject("title", "Certificate");
		mv.addObject("userClickCertificate", true);
		return mv;
	}

	@RequestMapping(value = "/locations")
	public ModelAndView address() {
		ModelAndView mv = new ModelAndView("page-laboratory");
		mv.addObject("title", "shipment");
		mv.addObject("userClickShipment", true);
		return mv;
	}

	@RequestMapping(value = "/categories")
	public ModelAndView category(@RequestParam(name = "success", required = false) String success,
			@RequestParam(name = "id", required = false) String id) {
		ModelAndView mv = new ModelAndView("page-laboratory");
		mv.addObject("title", "Category");

		if (id != null && categoryDAO.get(Integer.valueOf(id)) != null) {
			mv.addObject("userClickCat", true);
			mv.addObject("category", categoryDAO.get(Integer.valueOf(id)));
		} else {
			mv.addObject("userClickCats", true);
			mv.addObject("category", new Category());
		}

		if (success != null) {
			if (success.equals("category")) {
				mv.addObject("message", "Category submitted successfully!");
			}
			if (success.equals("remove")) {
				mv.addObject("message", "Removed successfully!");
			}
		}

		return mv;
	}

	@RequestMapping(value = "/category", method = RequestMethod.POST)
	public String addCategory(@ModelAttribute("category") Category mCategory, HttpServletRequest request) {
		boolean c = mCategory.getId() != 0 ? categoryDAO.update(mCategory) : categoryDAO.add(mCategory);
		return "redirect:/laboratory/categories?success=category";
	}

	@RequestMapping(value = "/category/{id}/delete")
	public String delete(@PathVariable int id, HttpServletRequest request) {
		if (categoryDAO.get(Integer.valueOf(id)) != null)
			categoryDAO.delete(categoryDAO.get(Integer.valueOf(id)));
		return "redirect:/laboratory/categories?success=remove";
	}

	@RequestMapping(value = "/product")
	public ModelAndView product(@RequestParam(name = "id", required = false) String id) {
		ModelAndView mv = new ModelAndView("page-laboratory");
		mv.addObject("title", "Product");
		mv.addObject("productForm", true);

		if (id != null && productDAO.get(Integer.parseInt(id)).getId() != 0)
			mv.addObject("product", productDAO.get(Integer.parseInt(id)));
		else
			mv.addObject("product", new Product());

		return mv;
	}

	@RequestMapping(value = "/product", method = RequestMethod.POST)
	public String managePostProduct(@Valid @ModelAttribute("product") Product mProduct, BindingResult results,
			Model model, HttpServletRequest request) {

		// mandatory file upload check
		if (mProduct.getId() == 0) {
			new ProductValidator().validate(mProduct, results);
		} else {
			// edit check only when the file has been selected
			if (!mProduct.getFile().getOriginalFilename().equals("")) {
				new ProductValidator().validate(mProduct, results);
			}
		}

		if (results.hasErrors()) {
			model.addAttribute("message", "Validation fails for adding the product!");
			model.addAttribute("userClickProducts", true);
			return "page-laboratory";
		}

		boolean p = mProduct.getId() != 0 ? productDAO.update(mProduct) : productDAO.add(mProduct);

		// upload the file
		if (!mProduct.getFile().getOriginalFilename().equals("")) {
			FileUtil.uploadFile(request, mProduct.getFile(), mProduct.getCode());
		}

		return "redirect:/laboratory/products?success=product";
	}

	@RequestMapping(value = "/product/{id}/delete")
	public String deleteProduct(@PathVariable int id, HttpServletRequest request) {
		if (productDAO.get(id) != null)
			productDAO.delete(productDAO.get(id));
		return "redirect:/laboratory/products?success=remove";
	}

	@ModelAttribute("categories")
	public List<Category> modelCategories() {
		return categoryDAO.list();
	}

}
