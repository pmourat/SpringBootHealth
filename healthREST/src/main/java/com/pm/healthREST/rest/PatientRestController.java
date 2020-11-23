package com.pm.healthREST.rest;

import java.security.Principal;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pm.healthREST.entity.Patient;
import com.pm.healthREST.entity.Temperature;
import com.pm.healthREST.service.PlayerService;

//endpoints that need JWT token in header's request
@RestController
@RequestMapping("/api")
public class PatientRestController {
	

	
	@Autowired
	PlayerService playerService;
	
	
	
	
	
	@Autowired
	public PatientRestController( ) {
		
		
	}
	
	@GetMapping("/patients/{id}")
	public Optional<Patient> getPatient(@PathVariable int id, Principal principal, Patient thePatient ) throws Exception {
	
		return playerService.getPatient(thePatient, id, principal);
	}
	

	@GetMapping("/patients/health/{id}")
	public String getHealth(@PathVariable int id, Principal principal, Patient thePatient ) throws Exception {
		return playerService.getHealth(thePatient,id,principal);

		}		

	
	@PutMapping("/patients/{id}")
	public Patient updatePatient(@RequestBody Patient thePatient, @PathVariable int id, Principal principal) throws Exception {
			
		return playerService.updatePatient(thePatient,id,principal);
		
		
	}
	
	@PostMapping("/patients/{username}")
	public Temperature saveTemperature(@RequestBody Temperature theTemperature, @PathVariable String username, Principal principal) throws Exception {
		
		return playerService.saveTemperature(theTemperature, username, principal);
	 
	}
	
		
	
	
}
