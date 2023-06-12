package com.epl.Residential_property_System.entity;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class ZonalDetails {


	@ManyToOne
	@JoinColumn(name="category_Id")
	private Cat_Description cat_Description;
	

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

	@Override
	public int hashCode() {
		return Objects.hash(Id, cat_Description, status, value, zone);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ZonalDetails other = (ZonalDetails) obj;
		return Id == other.Id && Objects.equals(cat_Description, other.cat_Description)
				&& Objects.equals(status, other.status)
				&& Float.floatToIntBits(value) == Float.floatToIntBits(other.value) && Objects.equals(zone, other.zone);
	}
	
}
