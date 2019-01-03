package com.dost12.phls.controller.lab;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.naming.NamingException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.dost12.phls.phlsbackend.dao.HalalAnalysisReportDAO;
import com.dost12.phls.phlsbackend.dao.OnsiteAddressDAO;
import com.dost12.phls.phlsbackend.dao.ProductDAO;
import com.dost12.phls.phlsbackend.dao.SupplierDAO;
import com.dost12.phls.phlsbackend.dto.HalalAnalysisReport;
import com.dost12.phls.phlsbackend.dto.OnsiteAddress;
import com.dost12.phls.phlsbackend.dto.Product;
import com.dost12.phls.phlsbackend.dto.Supplier;
import com.dost12.phls.util.JasperReportUtil;


import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperReport;

@Controller
@RequestMapping("/laboratory")
public class ReportController {

	
	@Autowired
	private SupplierDAO supplierDAO;
	
	@Autowired
	private HalalAnalysisReportDAO halalAnalysisReportDAO;
	
	@Autowired
	private ProductDAO productDAO;
	
	@Autowired
	private OnsiteAddressDAO onsiteAddressDAO;
	
	@RequestMapping(value = "/supplier/pdf")
	public String generateReportCompany(@Valid @RequestParam(name = "id", required = false) String id,
			HttpServletRequest request, HttpServletResponse response)
			throws JRException, IOException, NamingException {

		
		Supplier supplier = new Supplier();
		
		if(id.length() > 0)
			supplier = supplierDAO.get(Integer.valueOf(id));
		
		String reportFileName = "company";
		JasperReportUtil jrdao = new JasperReportUtil();

		List<Map<String, ?>> fields = new ArrayList<Map<String, ?>>();
		Map<String, Object> m = new HashMap<String, Object>();
		
		HashMap<String, Object> hmParams = new HashMap<String, Object>();

		if(supplier.getActive()) {
			
			m = new HashMap<String, Object>();
			m.put("companyfield", "Name Of Establishment");
			m.put("companyfieldvalue",supplier.getNameOfEstablishment());
			fields.add(m);

			m = new HashMap<String, Object>();
			m.put("companyfield", "Owner");
			m.put("companyfieldvalue", supplier.getOwner());
			fields.add(m);
			
			m = new HashMap<String, Object>();
			m.put("companyfield", "Tel No.");
			m.put("companyfieldvalue", supplier.getTelNo());
			fields.add(m);
			
			m = new HashMap<String, Object>();
			m.put("companyfield", "Fax");
			m.put("companyfieldvalue", supplier.getFax());
			fields.add(m);
			
			m = new HashMap<String, Object>();
			m.put("companyfield", "Person Involved");
			m.put("companyfieldvalue", supplier.getPersonInvolved());
			fields.add(m);
			
			m = new HashMap<String, Object>();
			m.put("companyfield", "Position");
			m.put("companyfieldvalue", supplier.getPosition());
			fields.add(m);
			
			m = new HashMap<String, Object>();
			m.put("companyfield", "Email");
			m.put("companyfieldvalue", supplier.getEmail());
			fields.add(m);
			
			m = new HashMap<String, Object>();
			m.put("companyfield", "Website");
			m.put("companyfieldvalue", supplier.getWebsite());
			fields.add(m);
			
			m = new HashMap<String, Object>();
			m.put("companyfield", "Reason");
			m.put("companyfieldvalue", supplier.getReason());
			fields.add(m);
			
			m = new HashMap<String, Object>();
			m.put("companyfield", "Number of Employees");
			m.put("companyfieldvalue", String.valueOf(supplier.getNumOfEmployees()));
			fields.add(m);
			
			m = new HashMap<String, Object>();
			m.put("companyfield", "Production Area Size");
			m.put("companyfieldvalue", String.valueOf( supplier.getProductionAreaSize()));
			fields.add(m);
			
			m = new HashMap<String, Object>();
			m.put("companyfield", "Indoor Area");
			m.put("companyfieldvalue", String.valueOf(supplier.getIndoorArea()));
			fields.add(m);
			
			m = new HashMap<String, Object>();
			m.put("companyfield", "Open Area");
			m.put("companyfieldvalue", String.valueOf(supplier.getOpenArea()));
			fields.add(m);
			
			m = new HashMap<String, Object>();
			m.put("companyfield", "Number Of RawMaterial");
			m.put("companyfieldvalue", supplier.getNamesOfRawMaterials());
			
			m = new HashMap<String, Object>();
			m.put("companyfield", "Name Of Establishment");
			m.put("companyfieldvalue", supplier.getNumProductsWarehouses());
			fields.add(m);
			
			m = new HashMap<String, Object>();
			m.put("companyfield", "Production Capacity");
			m.put("companyfieldvalue", supplier.getProductionCapacity());
			fields.add(m);
			
			m = new HashMap<String, Object>();
			m.put("companyfield", "Production Lines");
			m.put("companyfieldvalue", supplier.getProductionLines());
			fields.add(m);
			
			m = new HashMap<String, Object>();
			m.put("companyfield", "Custom Production");
			m.put("companyfieldvalue", supplier.getCustomProduction());
			fields.add(m);
			
			m = new HashMap<String, Object>();
			m.put("companyfield", "Product Brands");
			m.put("companyfieldvalue", supplier.getProductBrands());
			fields.add(m);
			
			m = new HashMap<String, Object>();
			m.put("companyfield", "State Products that will not be Halal Certified (If any)");
			m.put("companyfieldvalue", supplier.getProductNotHalal());
			fields.add(m);
			
			m = new HashMap<String, Object>();
			m.put("companyfield", "Name Of Raw Materials");
			m.put("companyfieldvalue", supplier.getNamesOfRawMaterials());
			fields.add(m);
			
			m = new HashMap<String, Object>();
			m.put("companyfield", "Names Of Suppliers");
			m.put("companyfieldvalue", supplier.getNamesOfSuppliers());
			fields.add(m);
			
			m = new HashMap<String, Object>();
			m.put("companyfield", "Products Process");
			m.put("companyfieldvalue", supplier.getProductsProcess());
			fields.add(m);
			
			m = new HashMap<String, Object>();
			m.put("companyfield", "Any Additional Activities");
			m.put("companyfieldvalue", supplier.getAdditionalActivities());
			fields.add(m);
		}
		

		JasperReport jasperReport = jrdao.getCompiledFile(reportFileName, request);


		
		try {

			jrdao.generateReportPDF(response, hmParams, fields,  jasperReport);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} // For
			// PDF
			// report

		return null;
	}
	
	@RequestMapping(value = "/product/{id}/halalanalysis/pdf")
	public String generateReportHalalProduct(@PathVariable int id,
			@Valid @RequestParam(name = "halalanalysisid", required = false) String halalanalysisid,
			HttpServletRequest request, HttpServletResponse response)
			throws JRException, IOException, NamingException {

		Product product = null;
		HalalAnalysisReport halalAnalysisReport = null;
		try {
			product = productDAO.get(id);
			halalAnalysisReport = halalAnalysisReportDAO.get(Integer.parseInt(halalanalysisid));
		}catch(Exception e) {}
		
		String reportFileName = "halalform";
		JasperReportUtil jrdao = new JasperReportUtil();

		List<Map<String, ?>> fields = new ArrayList<Map<String, ?>>();
		Map<String, Object> m = new HashMap<String, Object>();
		HashMap<String, Object> hmParams = new HashMap<String, Object>();

	
		if (product != null && halalAnalysisReport != null) {
			String address = "";
			List<OnsiteAddress> addresses = onsiteAddressDAO.list(product.getSupplier());
			
			if(addresses.size() > 0)
				address = addresses.get(0).getAddress();
			
			String dateSubmitted = halalAnalysisReport.getDateSubmitted() != null ? halalAnalysisReport.getDateSubmitted().toString() : "";
			String dateAnalyzed = halalAnalysisReport.getFromDateAnalyzed() != null ? halalAnalysisReport.getFromDateAnalyzed().toString() : "";
			String dateReported = halalAnalysisReport.getDateReported() != null ? halalAnalysisReport.getDateReported().toString() : "";
			       
			String sampleSubmittedBy = product.getSupplier().getPersonInvolved();
			String nameOfCompany = product.getSupplier().getNameOfEstablishment();
			String testMethod =  halalAnalysisReport.getTestMethod();
			m.put("laboratoryNo", String.valueOf(halalAnalysisReport.getId()));
			m.put("dateSubmitted", dateSubmitted ) ;
			m.put("dateAnalyzed", dateAnalyzed ); 
			m.put("dateReported", dateReported );
			m.put("sampleSubmittedBy", sampleSubmittedBy );
			m.put("nameOfCompany", nameOfCompany );
			m.put("address",  address);
				
			m.put("sampleCode", product.getCode());
			m.put("sampleDescription", product.getDescription());
			m.put("testMethod",testMethod );
			m.put("parameter", halalAnalysisReport.getHalalParameter().getName());
			m.put("result", String.valueOf(halalAnalysisReport.getResult()));
			m.put("unit", halalAnalysisReport.getUnit() );
			fields.add(m);
			
			
		}

		JasperReport jasperReport = jrdao.getCompiledFile(reportFileName, request);

		try {

			jrdao.generateReportPDF(response, hmParams, fields,  jasperReport);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} // For
			// PDF
			// report

		return null;
	}

}
