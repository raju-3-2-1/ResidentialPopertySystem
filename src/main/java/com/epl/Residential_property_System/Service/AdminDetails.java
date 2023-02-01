package com.epl.Residential_property_System.Service;

import com.epl.Residential_property_System.Entity.Cat_Description;
import com.epl.Residential_property_System.Entity.ZonalDetails;
import com.epl.Residential_property_System.Exception.Cat_DescrNotFoundException;
import com.epl.Residential_property_System.Exception.ZonalDetailsNotFoundException;

public interface AdminDetails {

	public Cat_Description addCategoryDescr(Cat_Description cd) throws Cat_DescrNotFoundException;

	public ZonalDetails addZonalInfoToCateDesc(ZonalDetails zzd,Integer catId) throws ZonalDetailsNotFoundException ;
}
