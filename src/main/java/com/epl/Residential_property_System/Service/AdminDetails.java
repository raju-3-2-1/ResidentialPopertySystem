package com.epl.Residential_property_System.service;

import com.epl.Residential_property_System.entity.Cat_Description;
import com.epl.Residential_property_System.entity.ZonalDetails;
import com.epl.Residential_property_System.exception.Cat_DescrNotFoundException;
import com.epl.Residential_property_System.exception.ZonalDetailsNotFoundException;

public interface AdminDetails {

	public Cat_Description addCategoryDescr(Cat_Description cd) throws Cat_DescrNotFoundException;
	
	public ZonalDetails deletecat( Integer id) throws ZonalDetailsNotFoundException;
	public ZonalDetails addZonalInfoToCateDesc(ZonalDetails zzd,Integer catId) throws ZonalDetailsNotFoundException ;
}
