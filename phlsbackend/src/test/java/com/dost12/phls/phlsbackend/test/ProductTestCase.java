package com.dost12.phls.phlsbackend.test;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.dost12.phls.phlsbackend.dao.CertificateDAO;
import com.dost12.phls.phlsbackend.dao.ProductDAO;
import com.dost12.phls.phlsbackend.dto.Product;

public class ProductTestCase {

	private static AnnotationConfigApplicationContext context;
	
	
	private static ProductDAO productDAO;
	
	private static CertificateDAO certificateDAO;
	
	
	private Product product;
	
	
	@BeforeClass
	public static void init() {
		context = new AnnotationConfigApplicationContext();
		context.scan("com.dost12.phls.phlsbackend");
		context.refresh();
		productDAO = (ProductDAO)context.getBean("productDAO");
		certificateDAO = (CertificateDAO) context.getBean("certificateDAO");
	}
	
	@Test
	public void testCRUDProduct() {
		
		// create operation
		product = new Product();
				
		product.setName("Tomato");
		product.setBrand("Manang Karen");
		product.setDescription("This available for you.");
		product.setUnitPrice(25000);
		product.setActive(true);
		product.setCategoryId(3);
		product.setSupplierId(3);

		assertEquals("Something went wrong while inserting a new product!",
				true,productDAO.add(product));	
		
		
		// reading and updating the category
/*		product = productDAO.get(2);
		product.setName("Samsung Galaxy S7");
		assertEquals("Something went wrong while updating the existing record!",
				true,productDAO.update(product));		
				
		assertEquals("Something went wrong while deleting the existing record!",
				true,productDAO.delete(product));		
		*/
		// list
/*		assertEquals("Something went wrong while fetching the list of products!",
				6,productDAO.list().size());	*/	
				
		
/*		product = productDAO.get(9);
		assertEquals("Something went wrong while fetching the list of products!",
				6,product.getCertificationDetails().size());*/
/*		assertEquals("Something went wrong while inserting a new product!",
				3, certificateDAO.list().size());	*/		
	}
	
	
	@Test
	public void testListActiveProducts() {
		assertEquals("Something went wrong while fetching the list of products!",
				5,productDAO.listActiveProducts().size());				
	} 
	
	/*	
	@Test
	public void testListActiveProductsByCategory() {
		assertEquals("Something went wrong while fetching the list of products!",
				3,productDAO.listActiveProductsByCategory(3).size());
		assertEquals("Something went wrong while fetching the list of products!",
				2,productDAO.listActiveProductsByCategory(1).size());
	} 
	
	@Test
	public void testGetLatestActiveProduct() {
		assertEquals("Something went wrong while fetching the list of products!",
				3,productDAO.getLatestActiveProducts(3).size());
		
	} */
	
/*	@Test
	public void testGetProductsByParam() {
		assertEquals("Something went wrong while fetching the list of products!",
				3,productDAO.getProductsByParam("views", 5).size());
		
	} */
	
		
}
