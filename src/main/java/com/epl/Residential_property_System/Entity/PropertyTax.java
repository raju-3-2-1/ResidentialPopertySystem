package com.epl.Residential_property_System.Entity;

import java.util.ArrayList;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.beans.factory.annotation.Autowired;

import com.epl.Residential_property_System.Repository.Cat_DescriptionRepo;
import com.epl.Residential_property_System.Repository.PropertyTaxRepository;
@Entity
public class PropertyTax {

	public PropertyTax() {
		super();
		// TODO Auto-generated constructor stub
	}
	public PropertyTax(int year, String ownerName, String email, String addressOfProperty, String zonalClassification,
			String descriptionOfTheProperty, String status, int constructedYear, int buildupArea, double totalTaxPayable) {
		super();
		this.year = year;
		this.ownerName = ownerName;
		this.email = email;
		this.addressOfProperty = addressOfProperty;
		this.zonalClassification = zonalClassification;
		this.descriptionOfTheProperty = descriptionOfTheProperty;
		this.status = status;
		this.constructedYear = constructedYear;
		this.buildupArea = buildupArea;
		this.totalTaxPayable = totalTaxPayable;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public String getOwnerName() {
		return ownerName;
	}
	public void setOwnerName(String ownerName) {
		this.ownerName = ownerName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAddressOfProperty() {
		return addressOfProperty;
	}
	public void setAddressOfProperty(String addressOfProperty) {
		this.addressOfProperty = addressOfProperty;
	}
	public String getZonalClassification() {
		return zonalClassification;
	}
	public void setZonalClassification(String zonalClassification) {
		this.zonalClassification = zonalClassification;
	}
	public String getDescriptionOfTheProperty() {
		return descriptionOfTheProperty;
	}
	public void setDescriptionOfTheProperty(String descriptionOfTheProperty) {
		this.descriptionOfTheProperty = descriptionOfTheProperty;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public int getConstructedYear() {
		return constructedYear;
	}
	public void setConstructedYear(int constructedYear) {
		this.constructedYear = constructedYear;
	}
	public int getBuildupArea() {
		return buildupArea;
	}
	public void setBuildupArea(int buildupArea) {
		this.buildupArea = buildupArea;
	}
	public double getTotalTaxPayable() {
		return totalTaxPayable;
	}
	public void setTotalTaxPayable(double t5) {
		this.totalTaxPayable = t5;
	}
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private int year;
	
	private String ownerName;
	
	private String email;
	
	private String addressOfProperty;
	private String zonalClassification;
	
	private String descriptionOfTheProperty;
	private String status;
	private int constructedYear;
	private int buildupArea;
	private double totalTaxPayable;
	
//	public int addi() {
//		return year+constructedYear;
//	}
	
//	@Autowired
//	Cat_DescriptionRepo catRepo;
	

}
