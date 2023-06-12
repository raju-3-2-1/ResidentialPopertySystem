package com.epl.Residential_property_System.Exception;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.epl.Residential_property_System.entity.Cat_Description;
import com.epl.Residential_property_System.entity.PropertyTax;
import com.epl.Residential_property_System.entity.ZonalDetails;
import com.epl.Residential_property_System.exception.Cat_DescrNotFoundException;
import com.epl.Residential_property_System.exception.PropertTaxException;
import com.epl.Residential_property_System.exception.ZonalDetailsNotFoundException;
import com.epl.Residential_property_System.repository.Cat_DescriptionRepo;
import com.epl.Residential_property_System.repository.ZonalDetailsRepo;
import com.epl.Residential_property_System.service.AdminDetails;
import com.epl.Residential_property_System.service.TotalTaxCoumputationService;


@SpringBootTest
public class ExceptionTestings {

	
	@Autowired
	 TotalTaxCoumputationService tota;
	
	@Autowired
	AdminDetails ad;
	
	 Cat_Description descr;
	 
	 @Autowired
	 Cat_DescriptionRepo cad;
	 PropertyTax pptaxform;
	 
	 @Autowired
	 ZonalDetailsRepo zonedeta;

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
	void zonalexceptionTesting() {
	    
	ZonalDetails zzz=zonedeta.findById(15).get();
		
	    Throwable exception = assertThrows(ZonalDetailsNotFoundException.class, () -> ad.addZonalInfoToCateDesc(zzz, 3));
	    assertEquals("No ZonalClassification Found", exception.getMessage());
	}
	
	
	@Test
	void catexceptionTesting() {
	    
		Cat_Description ccc=cad.findById(2).get();
		
	    Throwable exception = assertThrows(Cat_DescrNotFoundException.class, () -> ad.addCategoryDescr(ccc));
	    assertEquals("either ID will be null or Cat_Description with this id already exists in database", exception.getMessage());
	}

	@Test
	void propexceptionTesting2() {
	    
	    Throwable exception = assertThrows(PropertTaxException.class, () -> pptaxform.setStatus("someone"));
	    assertEquals("No status Found", exception.getMessage());
	}
}
