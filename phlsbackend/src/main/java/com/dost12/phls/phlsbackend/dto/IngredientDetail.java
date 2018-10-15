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
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "ingredient_detail")
public class IngredientDetail implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/*
	 * Private fields
	 * */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name="created_on")
	private Date createdOn;
	
	
	@Column(name="updated_on")
	private Date updateOn;

	@Column(name="is_active")
	private Boolean active;
	
	private Boolean mark;

	@Column(name="mark_description")
	private String markDescription;
	
	@ManyToOne
	@JoinColumn(name = "product_id")
	private Product product;
	
	@ManyToOne
	@JoinColumn(name = "ingredient_id", nullable=false)
	private Ingredient ingredient;

	
	
	public IngredientDetail() {
		super();
		active = true;
		mark = true;
		createdOn = new Date();
		updateOn = new Date();
		markDescription = ""; 
		product = new Product();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public Ingredient getIngredient() {
		return ingredient;
	}

	public void setIngredient(Ingredient ingredient) {
		this.ingredient = ingredient;
	}

	public Boolean getActive() {
		return active;
	}

	public void setActive(Boolean active) {
		this.active = active;
	}

	public Boolean getMark() {
		return mark;
	}

	public void setMark(Boolean mark) {
		this.mark = mark;
	}

	public String getMarkDescription() {
		return markDescription;
	}

	public void setMarkDescription(String markDescription) {
		this.markDescription = markDescription;
	}


	
	
	
}
