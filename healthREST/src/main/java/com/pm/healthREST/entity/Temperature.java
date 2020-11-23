package com.pm.healthREST.entity;

//import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;



@Entity
@Table(name="temperature")
public class Temperature {

	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="patient_id")
	private int patientId;
	
	@Column(name="temperature")
	private double temperature;

	
	
	@Column(name = "time")
	private String time;
	
	
	@Column(name="fever_session_id")
	private int feverSessionId;

	public Temperature() {
		super();
	}

	public Temperature(int patientId, double temperature, String time, int feverSessionId) {
		super();
		this.patientId = patientId;
		this.temperature = temperature;
		this.time = time;
		this.feverSessionId = feverSessionId;
	}

	//constructor without fever session id
	public Temperature(int patientId, double temperature, String time) {
		super();
		this.patientId = patientId;
		this.temperature = temperature;
		this.time = time;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getPatientId() {
		return patientId;
	}

	public void setPatientId(int patientId) {
		this.patientId = patientId;
	}

	public double getTemperature() {
		return temperature;
	}

	public void setTemperature(double temperature) {
		this.temperature = temperature;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public int getFeverSessionId() {
		return feverSessionId;
	}

	public void setFeverSessionId(int feverSessionId) {
		this.feverSessionId = feverSessionId;
	}

	@Override
	public String toString() {
		return "Temperature [id=" + id + ", patientId=" + patientId + ", temperature=" + temperature + ", time=" + time
				+ ", feverSessionId=" + feverSessionId + "]";
	}

	public void setFeverSessionIdNull(Object object) {
		// TODO Auto-generated method stub
		
	}
	
	
	
}
