package com.pm.healthREST.service;

import java.security.Principal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.pm.healthREST.dao.FeverSessionDAO;
import com.pm.healthREST.dao.PatientDAO;
import com.pm.healthREST.dao.TemperatureDAO;
import com.pm.healthREST.entity.FeverSession;
import com.pm.healthREST.entity.Patient;
import com.pm.healthREST.entity.Temperature;

@Service
public class PlayerServiceImpl implements PlayerService {

	
	@Autowired
	private PasswordEncoder bcryptEncoder;
	
	@Autowired
	private PatientDAO patientDAO;
	
	@Autowired
	private TemperatureDAO temperatureDAO;
	
	@Autowired
	private FeverSessionDAO feverSessionDAO;
	
	//field injection
	
	@Autowired
	public void setPatientDAO(PatientDAO thePatientDAO) {
		patientDAO = thePatientDAO;
		}
	@Autowired
	public void setTemperatureDAO(TemperatureDAO theTemperatureDAO) {
		temperatureDAO = theTemperatureDAO;
	}
	@Autowired
	public void setFeverSessionDAO(FeverSessionDAO theFeverSessionDAO) {
		feverSessionDAO = theFeverSessionDAO;
	}
		
	@Override
	@Transactional
	public Temperature saveTemperature(@RequestBody Temperature theTemperature, @PathVariable String username, Principal principal) throws Exception {
		Patient patient = patientDAO.findByUsername(username);
		 // Check if patient access his own data or not
		 String myPatientsName = patient.getUsername();
		 String x =principal.getName();
		 
		 if (x.equals(myPatientsName)) {
			 
			 if (theTemperature.getTemperature()<42 && theTemperature.getTemperature()>35)
			 {
			 theTemperature.setPatientId(patient.getId());
			 String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
			 theTemperature.setTime(timeStamp);

			 FeverSession fv = new FeverSession();
			 
			 //if it's not the first insertion
			 if ((feverSessionDAO.existsById(1))) {
			 
				 List<FeverSession> s= feverSessionDAO.findLastInsertion(patient.getId());
				// Find last insertion for current patient id in table feverSession 
				 fv =(FeverSession) s.get(s.size() - 1);
			 }
			 if (patient.getFlag()&& theTemperature.getTemperature()>=37.0) {
			 theTemperature.setFeverSessionId(fv.getFeverSessionId());
			 }
			 
			 if (!(patient.getFlag()) && theTemperature.getTemperature()>=38.0) {
				 FeverSession newSession = new FeverSession();


				 if (!(feverSessionDAO.existsById(1))) {
				fv.setFeverSessionId(1);
				theTemperature.setFeverSessionId((fv.getFeverSessionId()));		
				newSession.setFeverSessionId(fv.getFeverSessionId());

			}
			else
			{
				

				theTemperature.setFeverSessionId((fv.getFeverSessionId())+1);	
				newSession.setFeverSessionId((fv.getFeverSessionId())+1);

			}
				newSession.setPatientId(patient.getId());
				newSession.setStartTime(theTemperature.getTime()); 
				patient.setFlag(true);
				patientDAO.save(patient);
				feverSessionDAO.save(newSession);


				
			 }
			 
			 if (patient.getFlag()&& theTemperature.getTemperature()<37.0) {
			  theTemperature.setFeverSessionIdNull(null);
			  fv.setStopTime(theTemperature.getTime());
			  patient.setFlag(false);		
			  patientDAO.save(patient);	
			  feverSessionDAO.save(fv);

			 }

		temperatureDAO.save(theTemperature);
		return theTemperature;
			 }
			 else {
				 
				 throw new Exception("Not valid data");
			 }
	}

	
	else {
		 
throw new Exception("Not current users data");
	 
	}
		
		
		
	}
}
