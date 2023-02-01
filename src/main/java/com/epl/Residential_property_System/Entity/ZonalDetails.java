package com.epl.Residential_property_System.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class ZonalDetails {

	
	@javax.persistence.Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int Id;
	private String status;
	
	private String zone;
	
	private float value;
	
	
	
	
	public ZonalDetails(String status, String zone, float value, Cat_Description cat_Description) {
		super();
		this.status = status;
		this.zone = zone;
		this.value = value;
		this.cat_Description = cat_Description;
	}

	public int getId() {
		return Id;
	}

	public void setId(int id) {
		Id = id;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getZone() {
		return zone;
	}

	public void setZone(String zone) {
		this.zone = zone;
	}

	public float getValue() {
		return value;
	}

	public void setValue(float value) {
		this.value = value;
	}

	public Cat_Description getCat_Description() {
		return cat_Description;
	}

	public void setCat_Description(Cat_Description cat_Description) {
		this.cat_Description = cat_Description;
	}

	public ZonalDetails() {
	
	}

	@ManyToOne
	@JoinColumn(name="category_Id")
	private Cat_Description cat_Description;



	
}
