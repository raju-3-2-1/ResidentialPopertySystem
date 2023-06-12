package com.epl.Residential_property_System.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.epl.Residential_property_System.entity.Cat_Description;
import com.epl.Residential_property_System.entity.ZonalDetails;
import com.epl.Residential_property_System.exception.Cat_DescrNotFoundException;
import com.epl.Residential_property_System.exception.ZonalDetailsNotFoundException;
import com.epl.Residential_property_System.repository.Cat_DescriptionRepo;
import com.epl.Residential_property_System.repository.ZonalDetailsRepo;

//this is related to admin details as admin should add the all details regarding zones, category discription and its vales....etc


@Service
public class AdminDetailsImpl implements AdminDetails{

	@Autowired
	Cat_DescriptionRepo cat_DescriptionRepo;
	
	@Autowired
	ZonalDetailsRepo zonalDetailsRepo;
	
	public Cat_Description addCategoryDescr(Cat_Description cd) throws Cat_DescrNotFoundException {
		
		
			if(cat_DescriptionRepo.existsById(cd.getCategory_Id())||cd==null) {
				throw new Cat_DescrNotFoundException("either ID will be null or Cat_Description with this id already exists in database");
		}
		else
			cat_DescriptionRepo.saveAndFlush(cd);
		
		return cd;
	}
	

// adding the zones..we can add as many as zones and its corresponding rating values we need ,using json method method in post man 
	public ZonalDetails addZonalInfoToCateDesc(ZonalDetails zzd,Integer catId) throws ZonalDetailsNotFoundException {
		Cat_Description cat_Description = new Cat_Description();
		if(catId!=null) {
			if(zonalDetailsRepo.existsById(zzd.getId())) {
				throw new ZonalDetailsNotFoundException("No ZonalClassification Found");
		}
		else {
			cat_Description=cat_DescriptionRepo.findById(catId).get();
			zzd.setCat_Description(cat_Description);
		}
		zonalDetailsRepo.saveAndFlush(zzd);
		}
		return zzd;
		
	}
	
	
	
	public ZonalDetails deletecat( Integer id) throws ZonalDetailsNotFoundException{
		
		if(zonalDetailsRepo.findById(id).isEmpty()) {
			throw new ZonalDetailsNotFoundException("Id entered is not found in database");
	}else {
		ZonalDetails j=zonalDetailsRepo.findById(id).get();
		zonalDetailsRepo.deleteById(id);
		return j;
	}
				
	}
	
}
