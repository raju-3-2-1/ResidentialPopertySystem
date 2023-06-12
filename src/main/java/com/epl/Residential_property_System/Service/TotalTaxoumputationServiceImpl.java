package com.epl.Residential_property_System.service;

import java.util.ArrayList;
import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.epl.Residential_property_System.entity.Cat_Description;
import com.epl.Residential_property_System.entity.PropertyTax;
import com.epl.Residential_property_System.entity.ZonalDetails;
import com.epl.Residential_property_System.entity.ZoneWiseReport;
import com.epl.Residential_property_System.exception.PropertTaxException;
import com.epl.Residential_property_System.repository.Cat_DescriptionRepo;
import com.epl.Residential_property_System.repository.PropertyTaxRepository;
import com.epl.Residential_property_System.repository.ZonalDetailsRepo;
import com.epl.Residential_property_System.repository.ZonalWiseRepository;

@Service
public class TotalTaxoumputationServiceImpl implements TotalTaxCoumputationService {

	@Autowired
	Cat_DescriptionRepo cat_DescriptionRepo;
	
	@Autowired
	ZonalDetailsRepo zonalDetailsRepo;
	
	@Autowired
	PropertyTaxRepository ptr;
	
	@Autowired
	ZonalWiseRepository zrepo;
	
	double zoneATenanted;
	double zoneBTenanted;
	double zoneCTenanted;
	double zoneAOwner; double zoneBOwner; double zoneCOwner;


	
	
//code for getting the value rate of a particular zone	
	public float compute(PropertyTax pro) {
		List<ZonalDetails> zd= zonalDetailsRepo.findAll();
		List<Cat_Description> cd	= cat_DescriptionRepo.findAll();
		
		float vv=1;
		int flag=0;
		for(Cat_Description c:cd) {
			if(c.getDescription_of_the_prop().contentEquals(pro.getDescriptionOfTheProperty())) {
				for(ZonalDetails z:zd) {
				if(c.getCategory_Id()== z.getCat_Description().getCategory_Id()) {
					if(z.getStatus().equals(pro.getStatus())  && z.getZone().equals(pro.getZonalClassification()) ) {
						vv= z.getValue();
						flag=1;
						break;
					}
				}	 
				}
		}
			if(flag==1) {
				break;
			}
		}
		return vv;
	}
	

//this  will update the zone wise collected tax amount 
	
	@Transactional
	public void findZoneWiseReport(PropertyTax p) {
		
		
		
		ZoneWiseReport z=zrepo.findById(25).get();
		if(("Tenanted").equals(p.getStatus()) && ("zone_A").equals(p.getZonalClassification())) {
			 zoneATenanted=z.getZoneA_Tenant_Amount()  +calculateTax( p);
		z.setZoneA_Tenant_Amount(zoneATenanted);
		zrepo.saveAndFlush(z);    }
		else if(("Owner").equals(p.getStatus()) && ("zone_A").equals(p.getZonalClassification())) {
			zoneAOwner=z.getZoneA_Owner_Amount()+calculateTax( p);
			z.setZoneA_Owner_Amount(zoneAOwner);
			zrepo.saveAndFlush(z);
		}
		else if(("Tenanted").equals(p.getStatus()) && ("zone_B").equals(p.getZonalClassification())) {
			zoneBTenanted=z.getZoneB_Tenant_Amount()+calculateTax( p);
			z.setZoneB_Tenant_Amount(zoneBTenanted);
			zrepo.saveAndFlush(z);
		}
		else if(("Owner").equals(p.getStatus())  && ("zone_B").equals(p.getZonalClassification())) {
			zoneBOwner=z.getZoneB_Owner_Amount()+calculateTax( p);
			z.setZoneB_Owner_Amount(zoneBOwner);
			zrepo.saveAndFlush(z);
		}
		else if(("Tenanted").equals(p.getStatus()) && ("zone_C").equals(p.getZonalClassification())) {
			zoneCTenanted=z.getZoneC_Tenant_Amount()+calculateTax( p);
			z.setZoneC_Tenant_Amount(zoneCTenanted);
			zrepo.saveAndFlush(z);
		}
		else  if(("Owner").equals(p.getStatus())  && ("zone_C").equals(p.getZonalClassification())){
			zoneCOwner=z.getZoneC_Owner_Amount()+calculateTax( p);
			z.setZoneC_Owner_Amount(zoneCOwner);
			zrepo.saveAndFlush(z);
		}
		
		
	}
	
//using the value rate from compute() method , the below code will calculate tax 	
	 @Transactional(readOnly = false,isolation = Isolation.READ_COMMITTED,propagation = Propagation.REQUIRED)
	public double calculateTax(PropertyTax pr) {
		
		double t1;
		double t2;
		double t3;double t4;
		double t5;
		
		t1=pr.getBuildupArea()*compute(pr)*10;
		
		
		t2= t1-(t1*(calDepreciation(pr.getConstructedYear(),pr.getYear())));
		t3=t2*0.2;
		t4=t3*0.24;
		t5=t3+t4;
		ZoneWiseReport z= new ZoneWiseReport();
		
//wantedly specifying the only one ID for zonalwisereport
		
		List kk=zrepo.findAll();
		if(kk.size()==0) {
			z.setId(25);
		zrepo.saveAndFlush(z);}
		pr.setTotalTaxPayable(t5);
		ptr.save(pr);
		return t5;
		
	}
	
	public double calDepreciation(int y2,int y1) {
		if(y1-y2 <= 25)
			return 0.25;
		if(y1-y2 >= 60)
			return 0.6;
		else return 0.43;
			//average of 25 and 60 
			
	}
	
	public void savingFormDetails(PropertyTax pp) throws PropertTaxException {
		
		if(pp!=null)
			ptr.save(pp);
		else
			throw new PropertTaxException("enter the details to save");
	}

	
}
