package com.dost12.phls.controller.lab;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.naming.NamingException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
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
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.dost12.phls.model.JasperInputForm;
import com.dost12.phls.model.UserModel;
import com.dost12.phls.phlsbackend.dao.CategoryDAO;
import com.dost12.phls.phlsbackend.dao.CertificateDAO;
import com.dost12.phls.phlsbackend.dao.HalalAnalysisReportDAO;
import com.dost12.phls.phlsbackend.dao.HalalParameterDAO;
import com.dost12.phls.phlsbackend.dao.IngredientDAO;
import com.dost12.phls.phlsbackend.dao.IngredientDetailDAO;
import com.dost12.phls.phlsbackend.dao.NutritionFactsParameterDAO;
import com.dost12.phls.phlsbackend.dao.NutritionFactsResultDAO;
import com.dost12.phls.phlsbackend.dao.OnsiteAssessmentDAO;
import com.dost12.phls.phlsbackend.dao.ProductDAO;
import com.dost12.phls.phlsbackend.dao.SupplierDAO;
import com.dost12.phls.phlsbackend.dao.UserDAO;
import com.dost12.phls.phlsbackend.dao.UserlabDAO;
import com.dost12.phls.phlsbackend.dto.Category;
import com.dost12.phls.phlsbackend.dto.Certification;
import com.dost12.phls.phlsbackend.dto.HalalAnalysisReport;
import com.dost12.phls.phlsbackend.dto.HalalParameter;
import com.dost12.phls.phlsbackend.dto.Ingredient;
import com.dost12.phls.phlsbackend.dto.IngredientDetail;
import com.dost12.phls.phlsbackend.dto.NutritionFactsParameter;
import com.dost12.phls.phlsbackend.dto.NutritionFactsResult;
import com.dost12.phls.phlsbackend.dto.OnsiteAssessment;
import com.dost12.phls.phlsbackend.dto.Supplier;
import com.dost12.phls.phlsbackend.dto.User;
import com.dost12.phls.phlsbackend.dto.Product;
import com.dost12.phls.util.FileUtil;
import com.dost12.phls.util.JasperReportDAO;
import com.dost12.phls.util.JasperReportUtil;
import com.dost12.phls.validator.ProductValidator;


import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

@Controller
@RequestMapping("/laboratory")
public class LabController {

	private static final Logger logger = LoggerFactory.getLogger(LabController.class);

	@Autowired
	private HttpSession session;

	@Autowired
	private UserDAO userDAO;

	@Autowired
	private UserlabDAO userlabDAO;
	
	@Autowired
	private CategoryDAO categoryDAO;

	@Autowired
	private IngredientDAO ingredientDAO;

	@Autowired
	private ProductDAO productDAO;

	@Autowired
	private IngredientDetailDAO ingredientDetailDAO;

	@Autowired
	private SupplierDAO supplierDAO;

	@Autowired
	private OnsiteAssessmentDAO onsiteAssessmentDAO;

	@Autowired
	private CertificateDAO certificationDAO;

	@Autowired
	private NutritionFactsParameterDAO nutritionFactsParameterDAO;

	@Autowired
	private HalalParameterDAO halalParameterDAO;

	@Autowired
	private HalalAnalysisReportDAO halalAnalysisReportDAO;

	@Autowired
	private NutritionFactsResultDAO nutritionFactsResultDAO;
	


	@RequestMapping(value = { "/", "/main", "/index" })
	public ModelAndView manageLabProduct(@RequestParam(name = "success", required = false) String success) {
		ModelAndView mv = new ModelAndView("page-laboratory");
		mv.addObject("title", "Lab Page");
		mv.addObject("userClickDashboard", true);
		return mv;

	}

	@RequestMapping(value = "/products")
	public ModelAndView products(
			@RequestParam(name = "success", required = false) String success) {
		ModelAndView mv = new ModelAndView("page-laboratory");
		mv.addObject("title", "Products");
		mv.addObject("userClickProducts", true);
		return mv;
	}

	@RequestMapping(value = "/onsiteassessments")
	public ModelAndView onsiteassessments(
			@RequestParam(name = "success", required = false) String success) {
		ModelAndView mv = new ModelAndView("page-laboratory");
		mv.addObject("title", "On Site Assessments");
		mv.addObject("userClickOnsiteAssessments", true);
		if (success != null) {
			if (success.equals("onsiteassessment")) {
				mv.addObject("message", "On site Assessment submitted successfully!");
			}
			if (success.equals("remove")) {
				mv.addObject("message", "Removed successfully!");
			}
		}
		return mv;
	}

	@RequestMapping(value = "/suppliers")
	public ModelAndView suppliers(
			@RequestParam(name = "success", required = false) String success) {
		ModelAndView mv = new ModelAndView("page-laboratory");
		mv.addObject("title", "Supplier");
		mv.addObject("userClickSupplier", true);
		
		if (success != null) {
			if (success.equals("supplier")) {
				mv.addObject("message", "Company submitted successfully!");
			}
			if (success.equals("remove")) {
				mv.addObject("message", "Removed successfully!");
			}
		}
		
		return mv;
	}

	@RequestMapping(value = "/ingredients")
	public ModelAndView ingredient(
			@RequestParam(name = "success", required = false) String success,
			@RequestParam(name = "id", required = false) String id) {
		ModelAndView mv = new ModelAndView("page-laboratory");
		mv.addObject("title", "Ingredient");

		Ingredient ingredient = new Ingredient();
		if (id != null && ingredientDAO.get(Integer.valueOf(id)) != null) {
			mv.addObject("ingredientForm", true);
			ingredient = ingredientDAO.get(Integer.valueOf(id));
		} else
			mv.addObject("userClickIngredient", true);

		mv.addObject("ingredient", ingredient);
		if (success != null) {
			if (success.equals("ingredient")) {
				mv.addObject("message", "Ingredient submitted successfully!");
			}
			if (success.equals("remove")) {
				mv.addObject("message", "Removed successfully!");
			}
		}
		return mv;
	}

	@RequestMapping(value = "/ingredient", method = RequestMethod.POST)
	public String addIngredient(@ModelAttribute("ingredient") Ingredient ingredient, HttpServletRequest request) {
		if (ingredient.getId() != 0)
			ingredientDAO.update(ingredient);
		else
			ingredientDAO.add(ingredient);
		return "redirect:/laboratory/ingredients?success=ingredient";
	}

	@RequestMapping(value = "/ingredient/{id}/delete")
	public String deleteIngredient(@PathVariable int id, HttpServletRequest request) {
		if (ingredientDAO.get(Integer.valueOf(id)) != null)
			ingredientDAO.delete(ingredientDAO.get(Integer.valueOf(id)));
		return "redirect:/laboratory/ingredients?success=remove";
	}

	@RequestMapping(value = "/certificates")
	public ModelAndView certificates(
			@RequestParam(name = "success", required = false) String success) {
		ModelAndView mv = new ModelAndView("page-laboratory");
		mv.addObject("title", "Certificate");
		mv.addObject("userClickCertificate", true);
		if (success != null) {
			if (success.equals("certificate")) {
				mv.addObject("message", "Certicate submitted successfully!");
			}
			if (success.equals("remove")) {
				mv.addObject("message", "Removed successfully!");
			}
		}
		return mv;
	}

	@RequestMapping(value = "/locations")
	public ModelAndView addresses(@RequestParam(name = "success", required = false) String success) {
		ModelAndView mv = new ModelAndView("page-laboratory");
		mv.addObject("title", "shipment");
		mv.addObject("userClickShipment", true);
		if (success != null) {
			if (success.equals("location")) {
				mv.addObject("message", "Location submitted successfully!");
			}
			if (success.equals("remove")) {
				mv.addObject("message", "Removed successfully!");
			}
		}
		return mv;
	}

	@RequestMapping(value = "/nutritionfacts")
	public ModelAndView nutritionfact(
			@RequestParam(name = "success", required = false) String success) {
		ModelAndView mv = new ModelAndView("page-laboratory");
		mv.addObject("title", "Nutrition Facts");
		mv.addObject("userClickNutritionfact", true);
		if (success != null) {
			if (success.equals("nutritionfact")) {
				mv.addObject("message", "Nutrition Fact submitted successfully!");
			}
			if (success.equals("remove")) {
				mv.addObject("message", "Removed successfully!");
			}
		}
		return mv;
	}

	@RequestMapping(value = "/halalparameters")
	public ModelAndView halalparameters(@RequestParam(name = "success", required = false) String success) {
		ModelAndView mv = new ModelAndView("page-laboratory");
		mv.addObject("title", "Halal Parameters");
		mv.addObject("userClickHalalParameters", true);
		if (success != null) {
			if (success.equals("halalparameter")) {
				mv.addObject("message", "Halal parameter submitted successfully!");
			}
			if (success.equals("remove")) {
				mv.addObject("message", "Removed successfully!");
			}
		}
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

	@RequestMapping(value = "/halalparameter")
	public ModelAndView halalparam(@RequestParam(name = "id", required = false) String id) {
		ModelAndView mv = new ModelAndView("page-laboratory");
		mv.addObject("title", "Halal Param");
		mv.addObject("halalParamForm", true);

		if (id != null && halalParameterDAO.get(Integer.parseInt(id)) != null)
			mv.addObject("halalparameter", halalParameterDAO.get(Integer.parseInt(id)));
		else
			mv.addObject("halalparameter", new HalalParameter());
		return mv;
	}

	@RequestMapping(value = "/halalparameter", method = RequestMethod.POST)
	public String addHalal(@ModelAttribute("halalparameter") HalalParameter halalparameter,
			HttpServletRequest request) {
		boolean c = halalparameter.getId() != 0 ? halalParameterDAO.update(halalparameter)
				: halalParameterDAO.add(halalparameter);
		return "redirect:/laboratory/halalparameters?success=halalparameter";
	}

	@RequestMapping(value = "/halalparameter/{id}/delete")
	public String deleteHalalParam(@PathVariable int id, HttpServletRequest request) {
		if (halalParameterDAO.get(Integer.valueOf(id)) != null)
			halalParameterDAO.delete(halalParameterDAO.get(Integer.valueOf(id)));
		return "redirect:/laboratory/halalparameters?success=remove";
	}

	@RequestMapping(value = "/nutritionfactsparameter")
	public ModelAndView nutritionfacts(@RequestParam(name = "id", required = false) String id) {
		ModelAndView mv = new ModelAndView("page-laboratory");
		mv.addObject("title", "Nutrition Facts");
		mv.addObject("nutritionfactsForm", true);

		if (id != null && nutritionFactsParameterDAO.get(Integer.parseInt(id)) != null)
			mv.addObject("nutritionfactsparameter", nutritionFactsParameterDAO.get(Integer.parseInt(id)));
		else
			mv.addObject("nutritionfactsparameter", new NutritionFactsParameter());
		return mv;
	}

	@RequestMapping(value = "/nutritionfactsparameter", method = RequestMethod.POST)
	public String addNutritionFact(
			@ModelAttribute("nutritionfactsparameter") NutritionFactsParameter nutritionfactsparameter,
			HttpServletRequest request) {
		boolean c = nutritionfactsparameter.getId() != 0 ? nutritionFactsParameterDAO.update(nutritionfactsparameter)
				: nutritionFactsParameterDAO.add(nutritionfactsparameter);
		return "redirect:/laboratory/nutritionfacts?success=nutritionfact";
	}

	@RequestMapping(value = "/nutritionfactsparameter/{id}/delete")
	public String deleteNutritionFact(@PathVariable int id, HttpServletRequest request) {
		if (nutritionFactsParameterDAO.get(Integer.valueOf(id)) != null)
			nutritionFactsParameterDAO.delete(nutritionFactsParameterDAO.get(Integer.valueOf(id)));
		return "redirect:/laboratory/nutritionfacts?success=remove";
	}

	@RequestMapping(value = "/onsiteassessment")
	public ModelAndView onsiteassessment(
			@RequestParam(name = "id", required = false) String id) {
		ModelAndView mv = new ModelAndView("page-laboratory");
		mv.addObject("title", "On Site Assessment");
		mv.addObject("onsiteAssessmentForm", true);

		// remove existing Supplier
		List<Supplier> suppliers = supplierDAO.list();
		List<Supplier> supplierOnsites = new ArrayList<>();
		for (OnsiteAssessment onsiteAssessment : onsiteAssessmentDAO.list())
			supplierOnsites.add(onsiteAssessment.getSupplier());
		suppliers.removeAll(supplierOnsites);

		// remove existing Supplier
		List<Certification> certifications = certificationDAO.list();
		List<Certification> certificationOnsites = new ArrayList<>();
		for (OnsiteAssessment onsiteAssessment : onsiteAssessmentDAO.list())
			certificationOnsites.add(onsiteAssessment.getCertification());
		certifications.removeAll(certificationOnsites);

		mv.addObject("suppliers", suppliers);
		mv.addObject("certifications", certifications);

		if (id != null && id != "" && onsiteAssessmentDAO.get(Integer.parseInt(id)) != null) {
			mv.addObject("supplier", onsiteAssessmentDAO.get(Integer.parseInt(id)).getSupplier());
			mv.addObject("onsiteAssessment", onsiteAssessmentDAO.get(Integer.parseInt(id)));
			mv.addObject("certification", onsiteAssessmentDAO.get(Integer.parseInt(id)).getCertification());
		} else
			mv.addObject("onsiteAssessment", new OnsiteAssessment());

		return mv;
	}

	@RequestMapping(value = "/onsiteassessment", method = RequestMethod.POST)
	public String onsiteAssessment(@Valid @ModelAttribute("onsiteAssessment") OnsiteAssessment onsiteAssessment,
			BindingResult results, Model model, HttpServletRequest request) {
		onsiteAssessment.setValid(LocalDate.parse(onsiteAssessment.getValidStr()));
		onsiteAssessment.setCertification(certificationDAO.get(onsiteAssessment.getCertificationId()));
		onsiteAssessment.setSupplier(supplierDAO.get(onsiteAssessment.getSupplierId()));
		boolean c = onsiteAssessment.getId() != 0 ? onsiteAssessmentDAO.update(onsiteAssessment)
				: onsiteAssessmentDAO.add(onsiteAssessment);
		return "redirect:/laboratory/onsiteassessments?success=onsiteassessment";
	}

	@RequestMapping(value = "/onsiteassessment/{id}/delete")
	public String deleteonsiteassessment(@PathVariable int id, HttpServletRequest request) {
		onsiteAssessmentDAO.delete(onsiteAssessmentDAO.get(id));
		return "redirect:/laboratory/onsiteassessments?success=remove";
	}

	@RequestMapping(value = "/certificate")
	public ModelAndView certificate(@RequestParam(name = "id", required = false) String id) {
		ModelAndView mv = new ModelAndView("page-laboratory");

		mv.addObject("title", "Certificate");
		mv.addObject("certificateForm", true);

		if (id != null && certificationDAO.get(Integer.parseInt(id)) != null)
			mv.addObject("certification", certificationDAO.get(Integer.parseInt(id)));
		else
			mv.addObject("certification", new Certification());

		return mv;
	}

	@RequestMapping(value = "/certificate", method = RequestMethod.POST)
	public String certificate(@Valid @ModelAttribute("certification") Certification certification,
			BindingResult results, Model model, HttpServletRequest request) {
		boolean c = certification.getId() != 0 ? certificationDAO.update(certification)
				: certificationDAO.add(certification);
		return "redirect:/laboratory/certificates?success=certificate";
	}

	@RequestMapping(value = "/certificate/{id}/delete")
	public String deletecertificate(@PathVariable int id, HttpServletRequest request) {
		certificationDAO.delete(certificationDAO.get(id));
		return "redirect:/laboratory/certificates?success=remove";
	}

	@RequestMapping(value = "/product")
	public ModelAndView product(@RequestParam(name = "id", required = false) String id,
			@RequestParam(name = "supplierId", required = false) String supplierId) {
		ModelAndView mv = new ModelAndView("page-laboratory");

		// this for supplier form
		if (supplierId != null && supplierDAO.get(Integer.parseInt(supplierId)) != null)
			mv.addObject("supplier", supplierDAO.get(Integer.parseInt(supplierId)));

		mv.addObject("title", "Product");
		mv.addObject("productForm", true);

		if (id != null && productDAO.get(Integer.parseInt(id)).getId() != 0)
			mv.addObject("product", productDAO.get(Integer.parseInt(id)));
		else
			mv.addObject("product", new Product());

		return mv;
	}

	@RequestMapping(value = "/product", method = RequestMethod.POST)
	public String managePostProduct(@Valid @ModelAttribute("product") Product mProduct, 
			@RequestParam(name = "supplierId", required = false) String supplierId,
			BindingResult results,
			Model model, HttpServletRequest request){
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

		mProduct.setSupplier(supplierDAO.get(mProduct.getSupplierId()));

		if (mProduct.getId() != 0)
			productDAO.update(mProduct);
		else
			productDAO.add(mProduct);

		// upload the file
		if (!mProduct.getFile().getOriginalFilename().equals("")) {
			FileUtil.uploadFile(request, mProduct.getFile(), mProduct.getCode());
		}else
			FileUtil.uploadNoImage(request, mProduct.getCode());
		
		if(supplierId != "" && supplierDAO.get(Integer.parseInt(supplierId)) != null)
			return "redirect:/laboratory/supplier/"+
				supplierDAO.get(Integer.parseInt(supplierId)).getId()+"/products?success=product";
		
		return "redirect:/laboratory/products?success=product";
	}

	@RequestMapping(value = "/product/{id}/delete")
	public String deleteProduct(@PathVariable int id, HttpServletRequest request) {
		if (productDAO.get(id) != null)
			productDAO.delete(productDAO.get(id));
		return "redirect:/laboratory/products?success=remove";
	}

	@RequestMapping(value = "/product/{id}/activation", method = RequestMethod.GET)
	@ResponseBody
	public String managePostProductActivation(@PathVariable int id) {
		Product product = productDAO.get(id);
		boolean isActive = !product.isDisplayed();
		product.setDisplayed(isActive);
		;
		productDAO.update(product);
		return (isActive) ? "Product Activated Successfully" : "Product Dectivated Successfully!";
	}

	@RequestMapping(value = "/supplier")
	public ModelAndView supplier(@RequestParam(name = "id", required = false) String id) {
		ModelAndView mv = new ModelAndView("page-laboratory");
		mv.addObject("title", "Supplier");
		mv.addObject("supplierForm", true);
		if (id != null && supplierDAO.get(Integer.parseInt(id)).getId() != 0)
			mv.addObject("supplier", supplierDAO.get(Integer.parseInt(id)));
		else
			mv.addObject("supplier", new Supplier());
		return mv;
	}

	@RequestMapping(value = "/supplier", method = RequestMethod.POST)
	public String supplier(@Valid @ModelAttribute("supplier") Supplier supplier, BindingResult results, Model model,
			HttpServletRequest request) {
		if (session.getAttribute("userModel") != null) {
			UserModel userModel = (UserModel) session.getAttribute("userModel");
			supplier.setCreatedBy(userlabDAO.get(userModel.getId()));
		}
		if (supplier.getId() != 0)
			supplierDAO.update(supplier);
		else
			supplierDAO.add(supplier);
		return "redirect:/laboratory/suppliers?success=supplier";
	}

	@RequestMapping(value = "/supplier/{id}/delete")
	public String deleteSupplier(@PathVariable int id, HttpServletRequest request) {
		if (supplierDAO.get(id) != null) {
			User user = null;
			if (!supplierDAO.get(id).getEmail().isEmpty())
				user = userDAO.getByEmail(supplierDAO.get(id).getEmail());

			if (user != null && user.getId() > 0) {
				user.setEnabled(false);
				userDAO.update(user);
			}
			supplierDAO.delete(supplierDAO.get(id));

		}
		return "redirect:/laboratory/suppliers?success=remove";
	}

	@RequestMapping(value = "/supplier/{supplierId}/products")
	public ModelAndView supplierProduct(
			@RequestParam(name = "success", required = false) String success,
			@PathVariable int supplierId, HttpServletRequest request) {
		ModelAndView mv = new ModelAndView("page-laboratory");
		Supplier supplier = supplierDAO.get(supplierId);
		mv.addObject("title", "Supplier Products");
		mv.addObject("supplierProductsForm", true);
		mv.addObject("supplier", supplier);
		mv.addObject("products", productDAO.listActiveProductsBySupplier(supplier));
		if (success != null) {
			if (success.equals("product")) {
				mv.addObject("message", "Product submitted successfully!");
			}
			if (success.equals("remove")) {
				mv.addObject("message", "Removed successfully!");
			}
		}
		return mv;
	}

	@RequestMapping(value = "/product/{id}/ingredients")
	public ModelAndView productIngredients(@PathVariable int id,
			@RequestParam(name = "ingredientDetailId", required = false) String ingredientDetailId,
			HttpServletRequest request) {
		ModelAndView mv = new ModelAndView("page-laboratory");
		Product product = productDAO.get(id);
		mv.addObject("product", product);

		// remove
		List<Ingredient> ingredients = ingredientDAO.list();
		for (IngredientDetail ingredientDetail : ingredientDetailDAO.getList(productDAO.get(id)))
			for (Ingredient ingredient : ingredientDAO.list())
				if (ingredientDetail.getIngredient().getName().equals(ingredient.getName()))
					ingredients.remove(ingredient);

		if (id != 0) {
			if (ingredientDetailId != null && Integer.parseInt(ingredientDetailId) > 0) {
				mv.addObject("title", "Ingredient");
				mv.addObject("productIngredientDetailForm", true);
				mv.addObject("ingredientDetail", ingredientDetailDAO.get(Integer.parseInt(ingredientDetailId)));
				mv.addObject("ingredient",
						ingredientDetailDAO.get(Integer.parseInt(ingredientDetailId)).getIngredient());
				mv.addObject("ingredients", ingredients);
			} else {
				mv.addObject("title", "Product Ingredients");
				mv.addObject("productIngredientsForm", true);
				mv.addObject("ingredientDetails", ingredientDetailDAO.getList(product));
			}

		}
		return mv;
	}

	@RequestMapping(value = "/product/{id}/ingredients/add")
	public ModelAndView addproductingredients(@PathVariable int id, HttpServletRequest request) {
		ModelAndView mv = new ModelAndView("page-laboratory");

		List<Ingredient> ingredients = ingredientDAO.list();
		for (IngredientDetail ingredientDetail : ingredientDetailDAO.getList(productDAO.get(id)))
			for (Ingredient ingredient : ingredientDAO.list())
				if (ingredientDetail.getIngredient().getName().equals(ingredient.getName()))
					ingredients.remove(ingredient);

		mv.addObject("title", "Ingredient");
		mv.addObject("product", productDAO.get(id));
		mv.addObject("productIngredientDetailForm", true);
		mv.addObject("ingredientDetail", new IngredientDetail());
		mv.addObject("ingredients", ingredients);
		return mv;
	}

	@RequestMapping(value = "/product/{mProductId}/ingredients/ingredient", method = RequestMethod.POST)
	public String addProductIngredients(@PathVariable int mProductId, HttpServletRequest request,
			@Valid @ModelAttribute("ingredientDetail") IngredientDetail ingredientDetail, Model model,
			BindingResult results) {

		Product product = productDAO.get(mProductId);
		ingredientDetail.setIngredient(ingredientDAO.get(ingredientDetail.getIngredientId()));
		ingredientDetail.setProduct(product);

		if (ingredientDetail.getId() > 0)
			ingredientDetailDAO.update(ingredientDetail);
		else
			ingredientDetailDAO.add(ingredientDetail);

		return "redirect:/laboratory/product/" + product.getId() + "/ingredients";

	}

	@RequestMapping(value = "/product/{id}/ingredients/{ingredientDetailId}/delete")
	public String deleteProductIngredient(@PathVariable int id, @PathVariable int ingredientDetailId,
			HttpServletRequest request) {
		Product product = productDAO.get(id);
		ingredientDetailDAO.delete(ingredientDetailDAO.get(ingredientDetailId));
		return "redirect:/laboratory/product/" + product.getId() + "/ingredients";
	}

	/// end ingredient details

	@RequestMapping(value = "/product/{id}/halalanalysis")
	public ModelAndView productHalalanalysis(@PathVariable int id,
			@RequestParam(name = "halalanalysisId", required = false) String halalanalysisId,
			HttpServletRequest request) {
		ModelAndView mv = new ModelAndView("page-laboratory");
		Product product = productDAO.get(id);
		mv.addObject("product", productDAO.get(id));

		// remove
		List<HalalParameter> halalParameters = halalParameterDAO.list();
		for (HalalAnalysisReport halalAnalysisReport : halalAnalysisReportDAO.listOfProduct(product))
			for (HalalParameter halalParameter : halalParameterDAO.list())
				if (halalAnalysisReport.getHalalParameter().getName().equals(halalParameter.getName()))
					halalParameters.remove(halalParameter);

		if (halalanalysisId != null && Integer.parseInt(halalanalysisId) > 0) {
			mv.addObject("title", "Halal Analysis");
			mv.addObject("halalAnalysisReportForm", true);
			mv.addObject("halalParameters", halalParameters);
			mv.addObject("halalAnalysisReport", halalAnalysisReportDAO.get(Integer.parseInt(halalanalysisId)));
			mv.addObject("halalParameter",
					halalAnalysisReportDAO.get(Integer.parseInt(halalanalysisId)).getHalalParameter());
		} else {
			mv.addObject("title", "Product Halal Analysis");
			mv.addObject("productHalalParamForm", true);
			mv.addObject("halalAnalysisReports", halalAnalysisReportDAO.listOfProduct(product));
		}

		return mv;
	}

	@RequestMapping(value = "/product/{id}/halalanalysis/add")
	public ModelAndView addproductHalalanalysis(@PathVariable int id, HttpServletRequest request) {
		ModelAndView mv = new ModelAndView("page-laboratory");

		// remove
		List<HalalParameter> halalParameters = halalParameterDAO.list();
		for (HalalAnalysisReport halalAnalysisReport : halalAnalysisReportDAO.listOfProduct(productDAO.get(id)))
			for (HalalParameter halalParameter : halalParameterDAO.list())
				if (halalAnalysisReport.getHalalParameter().getName().equals(halalParameter.getName()))
					halalParameters.remove(halalParameter);

		mv.addObject("product", productDAO.get(id));
		mv.addObject("title", "Halal Analysis");
		mv.addObject("halalAnalysisReportForm", true);
		mv.addObject("halalParameters", halalParameters);
		mv.addObject("halalAnalysisReport", new HalalAnalysisReport());
		return mv;
	}

	@RequestMapping(value = "/product/{id}/halalanalysis", method = RequestMethod.POST)
	public String addproductHalalanalysis(@PathVariable int id,
			@Valid @ModelAttribute("halalAnalysisReport") HalalAnalysisReport halalAnalysisReport, Model model,
			BindingResult results, HttpServletRequest request) {
		Product product = productDAO.get(id);
		halalAnalysisReport.setHalalParameter(halalParameterDAO.get(halalAnalysisReport.getHalalParameterId()));
		halalAnalysisReport.setProduct(product);
		Boolean b = halalAnalysisReport.getId() > 0 ? halalAnalysisReportDAO.update(halalAnalysisReport)
				: halalAnalysisReportDAO.add(halalAnalysisReport);
		return "redirect:/laboratory/product/" + product.getId() + "/halalanalysis";
	}

	@RequestMapping(value = "/product/{id}/halalanalysis/{halalanalysisId}/delete")
	public String deleteProductHalalAnalysis(@PathVariable int id, @PathVariable int halalanalysisId,
			HttpServletRequest request) {
		Product product = productDAO.get(id);
		halalAnalysisReportDAO.delete(halalAnalysisReportDAO.get(halalanalysisId));
		return "redirect:/laboratory/product/" + product.getId() + "/halalanalysis";
	}

	/// nutrition
	@RequestMapping(value = "/product/{id}/nutritionfactsresult")
	public ModelAndView productnutrition(@PathVariable int id,
			@RequestParam(name = "nutritionfactsId", required = false) String nutritionfactsId,
			HttpServletRequest request) {
		ModelAndView mv = new ModelAndView("page-laboratory");
		Product product = productDAO.get(id);
		mv.addObject("product", productDAO.get(id));

		// remove
		List<NutritionFactsParameter> nutritionFactsParameters = nutritionFactsParameterDAO.list();
		for (NutritionFactsResult nutritionFactsResult : nutritionFactsResultDAO.listOfProduct(productDAO.get(id)))
			for (NutritionFactsParameter nutritionFactsParameter : nutritionFactsParameterDAO.list())
				if (nutritionFactsResult.getNutritionFactsParameter().getName()
						.equals(nutritionFactsParameter.getName()))
					nutritionFactsParameters.remove(nutritionFactsParameter);

		if (nutritionfactsId != null && Integer.parseInt(nutritionfactsId) > 0) {
			mv.addObject("title", "Nutrition Facts Result");
			mv.addObject("nutritionFactsResultForm", true);
			mv.addObject("nutritionFactsParameters", nutritionFactsParameters);
			mv.addObject("nutritionFactsResult", nutritionFactsResultDAO.get(Integer.parseInt(nutritionfactsId)));
			mv.addObject("nutritionFactsParameter",
					nutritionFactsResultDAO.get(Integer.parseInt(nutritionfactsId)).getNutritionFactsParameter());
		} else {
			mv.addObject("title", "Product Nutrition Facts");
			mv.addObject("productNutritionFactsParamForm", true);
			mv.addObject("nutritionFactsResults", nutritionFactsResultDAO.listOfProduct(product));
		}

		return mv;
	}

	@RequestMapping(value = "/product/{id}/nutritionfactsresult/add")
	public ModelAndView addproductnutrition(@PathVariable int id, HttpServletRequest request) {
		ModelAndView mv = new ModelAndView("page-laboratory");

		// remove
		List<NutritionFactsParameter> nutritionFactsParameters = nutritionFactsParameterDAO.list();
		for (NutritionFactsResult nutritionFactsResult : nutritionFactsResultDAO.listOfProduct(productDAO.get(id)))
			for (NutritionFactsParameter nutritionFactsParameter : nutritionFactsParameterDAO.list())
				if (nutritionFactsResult.getNutritionFactsParameter().getName()
						.equals(nutritionFactsParameter.getName()))
					nutritionFactsParameters.remove(nutritionFactsParameter);

		mv.addObject("product", productDAO.get(id));
		mv.addObject("title", "Nutrition Facts Result");
		mv.addObject("nutritionFactsResultForm", true);
		mv.addObject("nutritionFactsParameters", nutritionFactsParameters);
		mv.addObject("nutritionFactsResult", new NutritionFactsResult());
		return mv;
	}

	@RequestMapping(value = "/product/{id}/nutritionfactsresult", method = RequestMethod.POST)
	public String addproductnutrition(@PathVariable int id,
			@Valid @ModelAttribute("nutritionfactsresult") NutritionFactsResult nutritionfactsresult, Model model,
			BindingResult results, HttpServletRequest request) {
		Product product = productDAO.get(id);
		nutritionfactsresult.setNutritionFactsParameter(
				nutritionFactsParameterDAO.get(nutritionfactsresult.getNutritionFactsParameterId()));
		nutritionfactsresult.setProduct(product);
		Boolean b = nutritionfactsresult.getId() > 0 ? nutritionFactsResultDAO.update(nutritionfactsresult)
				: nutritionFactsResultDAO.add(nutritionfactsresult);
		return "redirect:/laboratory/product/" + product.getId() + "/nutritionfactsresult";
	}

	@RequestMapping(value = "/product/{id}/nutritionfactsresult/{nutritionfactsresultId}/delete")
	public String deleteproductnutrition(@PathVariable int id, @PathVariable int nutritionfactsresultId,
			HttpServletRequest request) {
		Product product = productDAO.get(id);
		nutritionFactsResultDAO.delete(nutritionFactsResultDAO.get(nutritionfactsresultId));
		return "redirect:/laboratory/product/" + product.getId() + "/nutritionfactsresult";
	}
	/// end nutrition

	@ModelAttribute("categories")
	public List<Category> modelCategories() {
		return categoryDAO.list();
	}

	@ModelAttribute("suppliers")
	public List<Supplier> modelSuppliers() {
		return supplierDAO.list();
	}

}
