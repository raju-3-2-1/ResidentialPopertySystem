package com.epl.Residential_property_System.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.epl.Residential_property_System.entity.Cat_Description;
import com.epl.Residential_property_System.entity.ZonalDetails;
import com.epl.Residential_property_System.exception.Cat_DescrNotFoundException;
import com.epl.Residential_property_System.exception.ZonalDetailsNotFoundException;

import com.epl.Residential_property_System.repository.ZonalDetailsRepo;
import com.epl.Residential_property_System.service.AdminDetails;

// all exceptions handled to service layer

@Controller
public class AdminDetailsController {

	@Autowired
	AdminDetails adminDetails;
	
	@Autowired
	ZonalDetailsRepo dd;
	
	Logger logger = LoggerFactory.getLogger(AdminDetails.class);
	
	@PostMapping("/addCatDes")
	public ResponseEntity<Cat_Description> viewCat_Description(@RequestBody Cat_Description cdd) throws Cat_DescrNotFoundException{

		
		
		ResponseEntity<Cat_Description> response = null;
		try {
			Cat_Description adDetails = adminDetails.addCategoryDescr(cdd);
			response = new ResponseEntity<>(adDetails, HttpStatus.OK);
			logger.info("-------created successfully---------");
		} catch (Exception e) {
			response = new ResponseEntity<>(HttpStatus.NOT_FOUND);
			throw new Cat_DescrNotFoundException("unable to add the details into the database");
		}
		return response;
//		return adminDetails.addCategoryDescr(cdd);
	}
	

	@PostMapping("/addZones")
	public ZonalDetails  viewInfoToCateDesc(@RequestBody ZonalDetails zzd,@RequestParam Integer catId) throws ZonalDetailsNotFoundException{

//		ResponseEntity<ZonalDetails> response = null;
//		try {
//			ZonalDetails Zdetails = adminDetails.addZonalInfoToCateDesc(zzd, catId);
//			response = new ResponseEntity<>(Zdetails, HttpStatus.OK);
//			logger.info("-------created successfully---------");
//		} catch (Exception e) {
//			response = new ResponseEntity<>(HttpStatus.NOT_FOUND);
//			throw new ZonalDetailsNotFoundException("unable to add the details into the database");
//		}
		return  adminDetails.addZonalInfoToCateDesc(zzd, catId);
		
	}
	
	@DeleteMapping("/del")
	public  ZonalDetails deletecat(@RequestParam Integer id) throws ZonalDetailsNotFoundException {	
			return adminDetails.deletecat(id);			
	}
	
	
}
