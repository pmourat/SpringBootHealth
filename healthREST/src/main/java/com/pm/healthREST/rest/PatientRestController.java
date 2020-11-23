package com.pm.healthREST.rest;

import java.security.Principal;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pm.healthREST.dao.FeverSessionDAO;
import com.pm.healthREST.dao.PatientDAO;
import com.pm.healthREST.dao.TemperatureDAO;
import com.pm.healthREST.entity.Patient;
import com.pm.healthREST.entity.Temperature;
import com.pm.healthREST.service.PlayerService;

@RestController
@RequestMapping("/api")
public class PatientRestController {
	
	
	@Autowired
	private PasswordEncoder bcryptEncoder;
	
	@Autowired
	PlayerService playerService;
	
	@Autowired
	private PatientDAO patientDAO;
	
	//@Autowired
	//private TemperatureDAO temperatureDAO;
	
	//@Autowired
	//private FeverSessionDAO feverSessionDAO;
	
	@Autowired
	public PatientRestController(PatientDAO thePatientDAO, TemperatureDAO theTemperatureDAO,FeverSessionDAO theFeverSessionDAO ) {
		
		patientDAO = thePatientDAO;
		//temperatureDAO = theTemperatureDAO;
	//	feverSessionDAO = theFeverSessionDAO;
	}
	
	@GetMapping("/patients/{id}")
	public Optional<Patient> getPatient(@PathVariable int id, Principal principal, Patient thePatient ) throws Exception {
	
	Optional<Patient> patient = patientDAO.findById(id);
	 // Check if patient access his own data or not
	 String myPatientsName = patient.get().getUsername();
	 String x =principal.getName();
	 if (x.equals(myPatientsName)) {
		 return patient;

	 }
	
	else {
		 
 throw new Exception("Not current users data");
	 
	}
	 
	 }

	@GetMapping("/patients/health/{id}")
	public String getHealth(@PathVariable int id, Principal principal, Patient thePatient ) throws Exception {
	
	Optional<Patient> patient = patientDAO.findById(id);
	 // Check if patient access his own data or not
	 String myPatientsName = patient.get().getUsername();
	 String x =principal.getName();
	 if (x.equals(myPatientsName)) {
		 
		 if(patient.get().getFlag()) {
			 return "ONGOING FEVER";
		 }
		 else {
			 return "HEALTHY";
		 }
			 

	 }
	
	else {
		 
 throw new Exception("Not current users data");
	 
	}
	 
	 }
		

	
	@PutMapping("/patients/{id}")
	public Patient updatePatient(@RequestBody Patient thePatient, @PathVariable int id, Principal principal) throws Exception {
			
		
		
		Optional<Patient> patient = patientDAO.findById(id);
		 // Check if patient access his own data or not
		 String myPatientsName = patient.get().getUsername();
		 String x =principal.getName();
		 if (x.equals(myPatientsName)) {
		
		thePatient.setId(id);
		thePatient.setPassword(bcryptEncoder.encode(thePatient.getPassword()));

		patientDAO.save(thePatient);
		
		return thePatient;
	}

	
	else {
		 
 throw new Exception("Not current users data");
	 
	}
		 
	}
	
	@PostMapping("/patients/{username}")
	public Temperature saveTemperature(@RequestBody Temperature theTemperature, @PathVariable String username, Principal principal) throws Exception {
		
		return playerService.saveTemperature(theTemperature, username, principal);
	 
	}
	
	
	
}
