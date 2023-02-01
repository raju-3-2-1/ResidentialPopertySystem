package com.epl.Residential_property_System.Controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.epl.Residential_property_System.Entity.Cat_Description;
import com.epl.Residential_property_System.Entity.ZonalDetails;
import com.epl.Residential_property_System.Exception.Cat_DescrNotFoundException;
import com.epl.Residential_property_System.Exception.ZonalDetailsNotFoundException;
import com.epl.Residential_property_System.Repository.Cat_DescriptionRepo;
import com.epl.Residential_property_System.Repository.ZonalDetailsRepo;
import com.epl.Residential_property_System.Service.AdminDetails;

@Controller
public class AdminDetailsController {

	@Autowired
	AdminDetails adminDetails;
	
	@Autowired
	ZonalDetailsRepo dd;
	
	Logger logger = LoggerFactory.getLogger(AdminDetails.class);
	
	@PostMapping("/addCatDes")
	public ResponseEntity<Cat_Description> viewCat_Description(@RequestBody Cat_Description cdd) throws Cat_DescrNotFoundException{
		logger.info("Successfully added");
		return ResponseEntity.ok(adminDetails.addCategoryDescr(cdd));
	}
	

	@PostMapping("/addZones")
	public ResponseEntity<ZonalDetails>  viewInfoToCateDesc(@RequestBody ZonalDetails zzd,@RequestParam Integer catId) throws ZonalDetailsNotFoundException{
		logger.info("Successfully Added");
		return ResponseEntity.ok(adminDetails.addZonalInfoToCateDesc(zzd, catId));
	}
	
	@DeleteMapping("/del")
	public ZonalDetails deletecat(@RequestParam Integer id){
		ZonalDetails j=dd.findById(id).get();
		dd.deleteById(id);
		return j;
				
	}
	
	
}
