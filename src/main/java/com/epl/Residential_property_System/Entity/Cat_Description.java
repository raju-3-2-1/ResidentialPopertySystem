package com.epl.Residential_property_System.Entity;

import java.util.ArrayList;

import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;


import javax.persistence.Id;
@Entity
public class Cat_Description {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int category_Id;
	
	public Cat_Description(String description_of_the_prop, Collection<ZonalDetails> zonalDetails) {
		super();
		Description_of_the_prop = description_of_the_prop;
		this.zonalDetails = zonalDetails;
	}

	public int getCategory_Id() {
		return category_Id;
	}

	public void setCategory_Id(int category_Id) {
		this.category_Id = category_Id;
	}

	public String getDescription_of_the_prop() {
		return Description_of_the_prop;
	}

	public void setDescription_of_the_prop(String description_of_the_prop) {
		Description_of_the_prop = description_of_the_prop;
	}

	public Collection<ZonalDetails> getZonalDetails() {
		return zonalDetails;
	}

	public void setZonalDetails(Collection<ZonalDetails> zonalDetails) {
		this.zonalDetails = zonalDetails;
	}

	private String Description_of_the_prop;
	
	@JsonIgnore
	@OneToMany(mappedBy="cat_Description")
	private Collection<ZonalDetails> zonalDetails =new ArrayList<ZonalDetails>();

	public Cat_Description() {
		
	}
	
}
