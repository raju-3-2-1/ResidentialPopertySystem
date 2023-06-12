package com.epl.Residential_property_System;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.epl.Residential_property_System.entity.Cat_Description;
import com.epl.Residential_property_System.entity.PropertyTax;
import com.epl.Residential_property_System.entity.ZonalDetails;
import com.epl.Residential_property_System.service.TotalTaxCoumputationService;

@SpringBootTest
class ResidentialPropertySystemApplicationTests {

	@Autowired
	 TotalTaxCoumputationService tota;
	
	 Cat_Description descr;
	 PropertyTax pptaxform;
	 ZonalDetails zonedeta;

	@BeforeEach
	void setup() {
		pptaxform=new PropertyTax();
		pptaxform.setId(224);
		pptaxform.setEmail("kilo@gmail.com");
		pptaxform.setConstructedYear(1987);
		pptaxform.setOwnerName("Raaj");
		pptaxform.setYear(2023);
		pptaxform.setStatus("Owner");
		pptaxform.setZonalClassification("zone_A");
		pptaxform.setBuildupArea(1900);
		pptaxform.setDescriptionOfTheProperty("RCC building");
		pptaxform.setAddressOfProperty("kadapa");
	}
	
	@Test
	void computeees() {
		float f=tota.compute(pptaxform);
		System.out.println("tfvk "+f);
		assertEquals(2.5, f);
	}
	
	

}
