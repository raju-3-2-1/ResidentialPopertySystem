package com.epl.Residential_property_System.ReposTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;

import com.epl.Residential_property_System.entity.Cat_Description;
import com.epl.Residential_property_System.entity.ZonalDetails;
import com.epl.Residential_property_System.repository.Cat_DescriptionRepo;
import com.epl.Residential_property_System.repository.ZonalDetailsRepo;

@SpringBootTest
public class CatDescrptionTest {

	@Autowired
	private Cat_DescriptionRepo rep;
	@Autowired
	private ZonalDetailsRepo zdrepo;
	
	@Test
	void zonalDetails() {
		ZonalDetails zd=zdrepo.findById(11).get();
		assertEquals(5, zd.getValue());
	}
	
	@Test
	void catDescriFindAll() {
		List<Cat_Description> cd=rep.findAll();
		assertEquals(3,cd.size());
	}
	
	
	
}
