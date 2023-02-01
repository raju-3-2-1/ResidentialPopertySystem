package com.epl.Residential_property_System.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.epl.Residential_property_System.Entity.PropertyTax;

@Repository
public interface PropertyTaxRepository extends JpaRepository<PropertyTax, Integer>{

}
