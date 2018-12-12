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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.Min;

import org.hibernate.validator.constraints.NotBlank;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Component
@Entity
@Table(name="product")
public class Product implements Serializable {

	private static final long serialVersionUID = 1L;
	
	// private fields
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "created_on")	
	private Date createdOn;
	
	@Column(name = "updated_on")	
	private Date updatedOn;
	
	@Column(name = "is_active")	
	private boolean active;
	
	@Column(name = "is_display")	
	private Boolean displayed;
	
	private String code;
	
	@NotBlank(message = "Please enter the product name!")
	private String name;

	private String brand;
	
	private String description;
	
	private int quantity;
	
	@Column(name = "unit_price")
	private double unitPrice;	

	private Double weight;
	
	@Column(name = "manufactured_date")
	private Date manufacturedDate;
	
	@Column(name = "expiration_date")
	private Date expirationDate;
	
	
	@Column(name = "category_id")
	@JsonIgnore
	private int categoryId;
	
	@ManyToOne
	@JoinColumn(name = "supplier_id", nullable=false)
	private Supplier supplier;
					 
	@Column(name = "origin_latitude")
	@JsonIgnore
	private double originLatitude;
	
	@Column(name = "origin_longitude")
	@JsonIgnore
	private double originLongitude;
	
	@Column(name = "destination_latitude")
	@JsonIgnore
	private double destinationLatitude;
	
	@Column(name = "destination_longitude")
	@JsonIgnore
	private double destinationLongitude;	

	

	@Transient
	private int supplierId;
	
	
	@OneToMany(fetch = FetchType.EAGER, mappedBy = "ingredient", cascade = CascadeType.ALL)
	private List<IngredientDetail> ingredientDetails;	
	
	@Transient
	private MultipartFile file;

	private int purchases;
	
	private int views;
	

	// default constructor
	public Product() {
		this.createdOn = new Date();
		this.updatedOn = new Date();
		this.code = "PRD" + UUID.randomUUID().toString().substring(26).toUpperCase();		
		this.active = true;
		this.displayed = false;
		ingredientDetails = new ArrayList<>();
		supplier = new Supplier();
	}

	// setters and getters	
	public MultipartFile getFile() {
		return file;
	}

	public void setFile(MultipartFile file) {
		this.file = file;
	}

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

	public double getOriginLatitude() {
		return originLatitude;
	}

	public void setOriginLatitude(double originLatitude) {
		this.originLatitude = originLatitude;
	}

	public double getOriginLongitude() {
		return originLongitude;
	}

	public void setOriginLongitude(double originLongitude) {
		this.originLongitude = originLongitude;
	}

	public double getDestinationLatitude() {
		return destinationLatitude;
	}

	public void setDestinationLatitude(double destinationLatitude) {
		this.destinationLatitude = destinationLatitude;
	}

	public double getDestinationLongitude() {
		return destinationLongitude;
	}

	public void setDestinationLongitude(double destinationLongitude) {
		this.destinationLongitude = destinationLongitude;
	}

	public List<IngredientDetail> getIngredientDetails() {
		return ingredientDetails;
	}

	public void setIngredientDetails(List<IngredientDetail> ingredientDetails) {
		this.ingredientDetails = ingredientDetails;
	}


	public Date getCreatedOn() {
		return createdOn;
	}

	public void setCreatedOn(Date createdOn) {
		this.createdOn = createdOn;
	}

	public Date getUpdatedOn() {
		return updatedOn;
	}

	public void setUpdatedOn(Date updatedOn) {
		this.updatedOn = updatedOn;
	}

	public Supplier getSupplier() {
		return supplier;
	}

	public void setSupplier(Supplier supplier) {
		this.supplier = supplier;
	}

	public Boolean isDisplayed() {
		return displayed;
	}

	public void setDisplayed(Boolean displayed) {
		this.displayed = displayed;
	}

	
}
