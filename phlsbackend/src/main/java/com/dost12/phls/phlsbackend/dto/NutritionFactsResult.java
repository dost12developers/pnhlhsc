package com.dost12.phls.phlsbackend.dto;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "nutrition_facts_result")
public class NutritionFactsResult implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "created_on")	
	private Date createdOn;
	
	@Column(name = "updated_on")
	private Date updateOn;
	
	private String value;
	
	@Column(name = "is_active")	
	private Boolean active;
	
	@ManyToOne
	@JoinColumn(name = "nutrition_facts_param_id", nullable=false)
	private NutritionFactsParameter nutritionFactsParameter;

	@ManyToOne
	@JoinColumn(name = "product_id")
	private Product product;
	
	@Transient
	private int nutritionFactsParameterId;
	
	public NutritionFactsResult() {
		super();
		active = true;
		createdOn = new Date();
		updateOn = new Date();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public NutritionFactsParameter getNutritionFactsParameter() {
		return nutritionFactsParameter;
	}

	public void setNutritionFactsParameter(NutritionFactsParameter nutritionFactsParameter) {
		this.nutritionFactsParameter = nutritionFactsParameter;
	}

	public Date getCreatedOn() {
		return createdOn;
	}

	public void setCreatedOn(Date createdOn) {
		this.createdOn = createdOn;
	}

	public Date getUpdateOn() {
		return updateOn;
	}

	public void setUpdateOn(Date updateOn) {
		this.updateOn = updateOn;
	}

	public Boolean getActive() {
		return active;
	}

	public void setActive(Boolean active) {
		this.active = active;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public int getNutritionFactsParameterId() {
		return nutritionFactsParameterId;
	}

	public void setNutritionFactsParameterId(int nutritionFactsParameterId) {
		this.nutritionFactsParameterId = nutritionFactsParameterId;
	}
	
	

}
