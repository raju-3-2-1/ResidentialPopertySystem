package com.epl.Residential_property_System.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.epl.Residential_property_System.entity.ZonalDetails;

@Repository
public interface ZonalDetailsRepo extends JpaRepository<ZonalDetails, Integer>{

}
