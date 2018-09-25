package com.dost12.phls.phlsbackend.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Transient;
import javax.validation.constraints.Min;

import org.hibernate.validator.constraints.NotBlank;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Component
@Entity
public class Product implements Serializable {

	private static final long serialVersionUID = 1L;
	
	// private fields
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "is_active")	
	private boolean active;
	
	private String code;
	
	@NotBlank(message = "Please enter the product name!")
	private String name;
	
	@NotBlank(message = "Please enter the brand name!")
	private String brand;
	
	@NotBlank(message = "Please enter the description!")
	private String description;
	
	private int quantity;
	
	private Double weight;
	
	@Column(name = "manufactured_date")
	private Date manufacturedDate;
	
	@Column(name = "expiration_date")
	private Date expirationDate;
	
	@Column(name = "unit_price")
	@Min(value = 1, message="Please select at least one value!")
	private double unitPrice;
	
	@Column(name = "ingredient_id")
	@JsonIgnore
	private int ingredientId;	

	@Column(name = "certificate_id")
	@JsonIgnore
	private int certificationId;	
	
	@Column(name = "category_id")
	@JsonIgnore
	private int categoryId;
	
	@Column(name = "supplier_id")
	@JsonIgnore
	private int supplierId;
	
	private int purchases;
	
	private int views;
	

	
	
/*	@OneToMany(mappedBy="IngredientDetail", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private List<IngredientDetail> ingredientDetails = new ArrayList<>();*/
	
	@Transient
	@OneToMany(mappedBy="CertificationDetail", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private List<CertificationDetail> certificationDetails = new ArrayList<>();
	
	@Transient
	private MultipartFile file;
			
	public MultipartFile getFile() {
		return file;
	}

	public void setFile(MultipartFile file) {
		this.file = file;
	}

	// default constructor
	public Product() {
		this.code = "PRD" + UUID.randomUUID().toString().substring(26).toUpperCase();		
	}

	// setters and getters	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public double getUnitPrice() {
		return unitPrice;
	}
	public void setUnitPrice(double unitPrice) {
		this.unitPrice = unitPrice;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public boolean isActive() {
		return active;
	}
	public void setActive(boolean active) {
		this.active = active;
	}
	public int getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}
	public int getSupplierId() {
		return supplierId;
	}
	public void setSupplierId(int supplierId) {
		this.supplierId = supplierId;
	}

	public int getPurchases() {
		return purchases;
	}

	public void setPurchases(int purchases) {
		this.purchases = purchases;
	}

	public int getViews() {
		return views;
	}

	public void setViews(int views) {
		this.views = views;
	}
	
	public Double getWeight() {
		return weight;
	}

	public void setWeight(Double weight) {
		this.weight = weight;
	}

	public Date getManufacturedDate() {
		return manufacturedDate;
	}

	public void setManufacturedDate(Date manufacturedDate) {
		this.manufacturedDate = manufacturedDate;
	}

	public Date getExpirationDate() {
		return expirationDate;
	}

	public void setExpirationDate(Date expirationDate) {
		this.expirationDate = expirationDate;
	}
	
	

	public int getIngredientId() {
		return ingredientId;
	}

	public void setIngredientId(int ingredientId) {
		this.ingredientId = ingredientId;
	}

	public int getCertificationId() {
		return certificationId;
	}

	public void setCertificationId(int certificationId) {
		this.certificationId = certificationId;
	}

/*	public List<IngredientDetail> getIngredientDetails() {
		return ingredientDetails;
	}

	public void setIngredientDetails(List<IngredientDetail> ingredientDetails) {
		this.ingredientDetails = ingredientDetails;
	}*/


	
	// toString for debugging
	@Override
	public String toString() {
		return "Product [id=" + id + ", code=" + code + ", name=" + name + ", brand=" + brand + ", description="
				+ description + ", unitPrice=" + unitPrice + ", quantity=" + quantity + ", active=" + active
				+ ", categoryId=" + categoryId + ", supplierId=" + supplierId + ", purchases=" + purchases + ", views="
				+ views + "]";
	}

	public List<CertificationDetail> getCertificationDetails() {
		return certificationDetails;
	}

	public void setCertificationDetails(List<CertificationDetail> certificationDetails) {
		this.certificationDetails = certificationDetails;
	}

}
