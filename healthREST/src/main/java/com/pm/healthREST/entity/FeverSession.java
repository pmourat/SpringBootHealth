package com.pm.healthREST.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="fever_session")
public class FeverSession {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="fever_session_id")
	private int feverSessionId;
	
	@Column(name="patient_id")
	private int patientId;
	
	
	@Column(name = "start_time")
	private String startTime;
	
	
	@Column(name = "stop_time")
	private String stopTime;

	public FeverSession() {
		super();
	}

	public FeverSession(int feverSessionId, int patientId, String startTime, String stopTime) {
		super();
		this.feverSessionId = feverSessionId;
		this.patientId = patientId;
		this.startTime = startTime;
		this.stopTime = stopTime;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getFeverSessionId() {
		return feverSessionId;
	}

	public void setFeverSessionId(int feverSessionId) {
		this.feverSessionId = feverSessionId;
	}

	public int getPatientId() {
		return patientId;
	}

	public void setPatientId(int patientId) {
		this.patientId = patientId;
	}

	public String getStartTime() {
		return startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	public String getStopTime() {
		return stopTime;
	}

	public void setStopTime(String stopTime) {
		this.stopTime = stopTime;
	}

	@Override
	public String toString() {
		return "FeverSession [id=" + id + ", feverSessionId=" + feverSessionId + ", patientId=" + patientId
				+ ", startTime=" + startTime + ", stopTime=" + stopTime + "]";
	}
	
	
	
	
	
	
}
