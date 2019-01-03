package com.dost12.phls.controller.lab;

import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;

import javax.naming.NamingException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.dost12.phls.phlsbackend.dao.SupplierDAO;
import com.dost12.phls.phlsbackend.dto.Supplier;
import com.dost12.phls.util.JasperReportUtil;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperReport;

@Controller
@RequestMapping("/laboratory")
public class ReportController {

	
	@Autowired
	private SupplierDAO supplierDAO;
	
	@RequestMapping(value = "/supplier/pdf")
	public String generateReport(@Valid @RequestParam(name = "id", required = false) String id,
			HttpServletRequest request, HttpServletResponse response)
			throws JRException, IOException, NamingException {

		
		Supplier supplier = new Supplier();
		
		if(id.length() > 0)
			supplier = supplierDAO.get(Integer.valueOf(id));
		
		String reportFileName = "companyprofile-form";
		JasperReportUtil jrdao = new JasperReportUtil();

		HashMap<String, Object> hmParams = new HashMap<String, Object>();

		if(supplier.getActive()) {
			hmParams.put("nameOfEstablishment", supplier.getNameOfEstablishment());
			hmParams.put("owner", supplier.getOwner());
			hmParams.put("telNo", supplier.getTelNo());
			hmParams.put("fax", supplier.getFax());
			hmParams.put("personInvolved", supplier.getPersonInvolved());
			hmParams.put("position", supplier.getPosition());
			hmParams.put("email", supplier.getEmail());
			hmParams.put("website", supplier.getWebsite());
			hmParams.put("reason", supplier.getReason());
			hmParams.put("numOfEmployees", String.valueOf(supplier.getNumOfEmployees()));
			hmParams.put("productionAreaSize", String.valueOf( supplier.getProductionAreaSize()));
			hmParams.put("indoorArea", String.valueOf(supplier.getIndoorArea()));
			hmParams.put("openArea", String.valueOf(supplier.getOpenArea()));
			hmParams.put("numOfRawMaterial", supplier.getNamesOfRawMaterials());
			hmParams.put("numProductsWarehouses", supplier.getNumProductsWarehouses());
			hmParams.put("productionCapacity", supplier.getProductionCapacity());
			hmParams.put("productionLines", supplier.getProductionLines());
			hmParams.put("customProduction", supplier.getCustomProduction());
			hmParams.put("productBrands", supplier.getProductBrands());
			hmParams.put("productNotHalal", supplier.getProductNotHalal());
			hmParams.put("namesOfRawMaterials", supplier.getNamesOfRawMaterials());
			hmParams.put("namesOfSuppliers", supplier.getNamesOfSuppliers());
			hmParams.put("productsProcess", supplier.getProductsProcess());
			hmParams.put("additionalActivities", supplier.getAdditionalActivities());
	
		}
		JasperReport jasperReport = jrdao.getCompiledFile(reportFileName, request);

		try {
			jrdao.generateReportPDF(response, hmParams, jasperReport);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} // For
			// PDF
			// report

		return null;
	}

}
