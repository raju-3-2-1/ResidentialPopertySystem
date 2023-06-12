package com.epl.Residential_property_System.entity;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Past;
import javax.validation.constraints.PastOrPresent;
import javax.validation.constraints.Positive;
@Entity
public class PropertyTax {


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	
	private int year;
	
	@NotBlank(message="name not be empty")
	private String ownerName;
	
	@NotBlank(message="Email not be empty")
	private String email;
	
	@NotBlank(message="addressOfProperty not to be empty")
	private String addressOfProperty;
	
	@NotBlank(message="zonalClassification not be empty")
	private String zonalClassification;
	
	@NotBlank(message="descriptionOfTheProperty not be empty")
	private String descriptionOfTheProperty;
	
	@NotBlank(message="status not be empty")
	private String status;
	
//	@Past(message="must be past")
	private int constructedYear;
	
	@Positive(message="buildupArea not be negative")
	private int buildupArea;
	
	private double totalTaxPayable;
	
	
	public PropertyTax() {
		super();
		// TODO Auto-generated constructor stub
	}

	public PropertyTax(@PastOrPresent int year, @NotBlank(message = "name not be empty") String ownerName,
			@NotBlank(message = "Email not be empty") String email,
			@NotBlank(message = "addressOfProperty not to be empty") String addressOfProperty,
			@NotBlank(message = "zonalClassification not be empty") String zonalClassification,
			@NotBlank(message = "descriptionOfTheProperty not be empty") String descriptionOfTheProperty,
			@NotBlank(message = "status not be empty") String status,
			@Past(message = "must be past") int constructedYear,
			@Positive(message = "buildupArea not be negative") int buildupArea, double totalTaxPayable) {
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
	
	
	@Override
	public int hashCode() {
		return Objects.hash(addressOfProperty, buildupArea, constructedYear, descriptionOfTheProperty, email, id,
				ownerName, status, totalTaxPayable, year, zonalClassification);
	}
	
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PropertyTax other = (PropertyTax) obj;
		return Objects.equals(addressOfProperty, other.addressOfProperty) && buildupArea == other.buildupArea
				&& constructedYear == other.constructedYear
				&& Objects.equals(descriptionOfTheProperty, other.descriptionOfTheProperty)
				&& Objects.equals(email, other.email) && id == other.id && Objects.equals(ownerName, other.ownerName)
				&& Objects.equals(status, other.status)
				&& Double.doubleToLongBits(totalTaxPayable) == Double.doubleToLongBits(other.totalTaxPayable)
				&& year == other.year && Objects.equals(zonalClassification, other.zonalClassification);
	}
	

}
