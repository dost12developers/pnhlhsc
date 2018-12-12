package com.dost12.phls.phlsbackend.dto;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "halal_analysis_report")
public class HalalAnalysisReport implements Serializable{

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
	
	@Column(name = "is_active")	
	private Boolean active;
	
	private int mark;

	@ManyToOne
	@JoinColumn(name = "halal_param_id")
	private HalalParameter halalParameter;

	@ManyToOne
	@JoinColumn(name = "product_id")
	private Product product;
	
	@Transient
	private int halalParameterId;
	
	
	public HalalAnalysisReport() {
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

	public int getMark() {
		return mark;
	}

	public void setMark(int mark) {
		this.mark = mark;
	}

	public HalalParameter getHalalParameter() {
		return halalParameter;
	}

	public void setHalalParameter(HalalParameter halalParameter) {
		this.halalParameter = halalParameter;
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

	public int getHalalParameterId() {
		return halalParameterId;
	}

	public void setHalalParameterId(int halalParameterId) {
		this.halalParameterId = halalParameterId;
	}

	@Override
	public String toString() {
		return "HalalAnalysisReport [id=" + id + ", createdOn=" + createdOn + ", updateOn=" + updateOn + ", active="
				+ active + ", mark=" + mark + ", halalParameter=" + halalParameter + ", product=" + product
				+ ", halalParameterId=" + halalParameterId + "]";
	}

	
	
}
