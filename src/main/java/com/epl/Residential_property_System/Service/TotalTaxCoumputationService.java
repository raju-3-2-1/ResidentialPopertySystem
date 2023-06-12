package com.epl.Residential_property_System.service;

import com.epl.Residential_property_System.entity.PropertyTax;
import com.epl.Residential_property_System.entity.ZoneWiseReport;
import com.epl.Residential_property_System.exception.PropertTaxException;

public interface TotalTaxCoumputationService {

	public float compute(PropertyTax pro) ;
	public double calculateTax(PropertyTax pr);
	
	public double calDepreciation(int y1,int y2);
	
	public void findZoneWiseReport(PropertyTax p);

	public void savingFormDetails(PropertyTax pp) throws PropertTaxException ;
}
