package com.epl.Residential_property_System.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.epl.Residential_property_System.Entity.ZoneWiseReport;

@Repository
public interface ZonalWiseRepository extends JpaRepository<ZoneWiseReport, Integer>{

}
