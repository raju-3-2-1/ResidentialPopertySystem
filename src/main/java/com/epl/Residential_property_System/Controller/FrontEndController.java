package com.epl.Residential_property_System.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.epl.Residential_property_System.entity.PropertyTax;
import com.epl.Residential_property_System.entity.ZoneWiseReport;
import com.epl.Residential_property_System.exception.PropertTaxException;
import com.epl.Residential_property_System.repository.PropertyTaxRepository;
import com.epl.Residential_property_System.repository.ZonalWiseRepository;
import com.epl.Residential_property_System.service.TotalTaxCoumputationService;



@Controller
public class FrontEndController {

	@Autowired
	PropertyTaxRepository propRepo;
	
	@Autowired
	TotalTaxCoumputationService tot;
	@Autowired
	ZonalWiseRepository zp;
	
	@GetMapping({"/home","/"})
	public ModelAndView showEmployees() {
		ModelAndView mov=new ModelAndView("home-page");

		return mov;
	}
	
	@GetMapping("/selfAssessmentForm")
	public ModelAndView addNewEmployee() {
		ModelAndView mov=new ModelAndView("self-assessment-form");
		PropertyTax newProp=new PropertyTax();
		mov.addObject("propertytax",newProp);
		return mov; 
	}
	
	@PostMapping("/saveForm")
	public String saveEmployee(@ModelAttribute PropertyTax prop) throws PropertTaxException {
		tot.savingFormDetails(prop);
		return "redirect:/home";
	}
	@PostMapping({"/result","/res"})
	public String comp(@ModelAttribute PropertyTax prop,BindingResult result,Model model) {

		double k= tot.calculateTax(prop);
		tot.findZoneWiseReport( prop);
		model.addAttribute("k",k);
		return "result";
	}
	
	@GetMapping("/zonalwisereport")
	public ModelAndView showz() {
		ModelAndView mov=new ModelAndView("zonal-wise-report");
		
		ZoneWiseReport zones=zp.findById(25).get();
		mov.addObject("zones",zones);
		return mov;
	}
	
}
