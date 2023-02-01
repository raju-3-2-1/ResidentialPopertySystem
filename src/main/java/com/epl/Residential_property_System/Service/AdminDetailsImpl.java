package com.epl.Residential_property_System.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.epl.Residential_property_System.Entity.Cat_Description;
import com.epl.Residential_property_System.Entity.ZonalDetails;
import com.epl.Residential_property_System.Exception.Cat_DescrNotFoundException;
import com.epl.Residential_property_System.Exception.ZonalDetailsNotFoundException;
import com.epl.Residential_property_System.Repository.Cat_DescriptionRepo;
import com.epl.Residential_property_System.Repository.ZonalDetailsRepo;

//this is related to admin details as admin should add the all details regarding zones, category discription and its vales....etc


@Service
public class AdminDetailsImpl implements AdminDetails{

	@Autowired
	Cat_DescriptionRepo cat_DescriptionRepo;
	
	@Autowired
	ZonalDetailsRepo zonalDetailsRepo;
	
	public Cat_Description addCategoryDescr(Cat_Description cd) throws Cat_DescrNotFoundException {
		
		if(cd!=null) {
			if(cat_DescriptionRepo.existsById(cd.getCategory_Id())) {
				throw new Cat_DescrNotFoundException("Cat_Description with this id already exists");
		}
		else
			cat_DescriptionRepo.saveAndFlush(cd);
		}
		return cd;
	}
	

// adding the zones..we can add as many as zones and its corresponding rating values we need ,using json method method in post man 
	public ZonalDetails addZonalInfoToCateDesc(ZonalDetails zzd,Integer catId) throws ZonalDetailsNotFoundException {
		Cat_Description cat_Description = new Cat_Description();
		if(catId!=null) {
			if(zonalDetailsRepo.existsById(zzd.getId())) {
				throw new ZonalDetailsNotFoundException("Cat_Description with this id already exists");
		}
		else {
			cat_Description=cat_DescriptionRepo.findById(catId).get();
			zzd.setCat_Description(cat_Description);
		}
		zonalDetailsRepo.saveAndFlush(zzd);
		}
		return zzd;
		
	}
	
	
	
	
}
