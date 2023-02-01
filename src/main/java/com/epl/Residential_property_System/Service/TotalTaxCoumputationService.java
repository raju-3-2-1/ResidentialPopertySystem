package com.epl.Residential_property_System.Service;

import com.epl.Residential_property_System.Entity.PropertyTax;
import com.epl.Residential_property_System.Entity.ZoneWiseReport;

public interface TotalTaxCoumputationService {

	public float compute(PropertyTax pro) ;
	public double calculateTax(PropertyTax pr);
	
	public double calDepreciation(int y1,int y2);
	
	public void findZoneWiseReport(PropertyTax p);
	
}
