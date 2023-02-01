package com.epl.Residential_property_System.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.epl.Residential_property_System.Entity.Cat_Description;

@Repository
public interface Cat_DescriptionRepo  extends JpaRepository<Cat_Description, Integer>{

}
