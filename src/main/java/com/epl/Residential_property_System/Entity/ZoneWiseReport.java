package com.epl.Residential_property_System.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class ZoneWiseReport {

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	@Id
	private int id;
	
	public double zoneA_Owner_Amount;
	public double zoneA_Tenant_Amount;
	public 	double zoneB_Owner_Amount;
	public double zoneB_Tenant_Amount;
	public double zoneC_Owner_Amount;
	public double zoneC_Tenant_Amount;
	public ZoneWiseReport() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ZoneWiseReport(double zoneA_Owner_Amount, double zoneA_Tenant_Amount, double zoneB_Owner_Amount,
			double zoneB_Tenant_Amount, double zoneC_Owner_Amount, double zoneC_Tenant_Amount) {
		super();
		this.zoneA_Owner_Amount = zoneA_Owner_Amount;
		this.zoneA_Tenant_Amount = zoneA_Tenant_Amount;
		this.zoneB_Owner_Amount = zoneB_Owner_Amount;
		this.zoneB_Tenant_Amount = zoneB_Tenant_Amount;
		this.zoneC_Owner_Amount = zoneC_Owner_Amount;
		this.zoneC_Tenant_Amount = zoneC_Tenant_Amount;
	}
	public double getZoneA_Owner_Amount() {
		return zoneA_Owner_Amount;
	}
	public void setZoneA_Owner_Amount(double zoneA_Owner_Amount) {
		this.zoneA_Owner_Amount = zoneA_Owner_Amount;
	}
	public double getZoneA_Tenant_Amount() {
		return zoneA_Tenant_Amount;
	}
	public void setZoneA_Tenant_Amount(double zoneA_Tenant_Amount) {
		this.zoneA_Tenant_Amount = zoneA_Tenant_Amount;
	}
	public double getZoneB_Owner_Amount() {
		return zoneB_Owner_Amount;
	}
	public void setZoneB_Owner_Amount(double zoneB_Owner_Amount) {
		this.zoneB_Owner_Amount = zoneB_Owner_Amount;
	}
	public double getZoneB_Tenant_Amount() {
		return zoneB_Tenant_Amount;
	}
	public void setZoneB_Tenant_Amount(double zoneB_Tenant_Amount) {
		this.zoneB_Tenant_Amount = zoneB_Tenant_Amount;
	}
	public double getZoneC_Owner_Amount() {
		return zoneC_Owner_Amount;
	}
	public void setZoneC_Owner_Amount(double zoneC_Owner_Amount) {
		this.zoneC_Owner_Amount = zoneC_Owner_Amount;
	}
	public double getZoneC_Tenant_Amount() {
		return zoneC_Tenant_Amount;
	}
	public void setZoneC_Tenant_Amount(double zoneC_Tenant_Amount) {
		this.zoneC_Tenant_Amount = zoneC_Tenant_Amount;
	}
}
