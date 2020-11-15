package com.pm.healthREST.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;

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
	
	@CreationTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "start_time")
	private Date startTime;
	
	@CreationTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "stop_time")
	private Date stopTime;

	public FeverSession() {
		super();
	}

	public FeverSession(int feverSessionId, int patientId, Date startTime, Date stopTime) {
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

	public Date getStartTime() {
		return startTime;
	}

	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}

	public Date getStopTime() {
		return stopTime;
	}

	public void setStopTime(Date stopTime) {
		this.stopTime = stopTime;
	}

	@Override
	public String toString() {
		return "FeverSession [id=" + id + ", feverSessionId=" + feverSessionId + ", patientId=" + patientId
				+ ", startTime=" + startTime + ", stopTime=" + stopTime + "]";
	}
	
	
	
	
	
	
}
