package com.model.courses;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Entity
public class JobOriented {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long jobId;
	private String heading;
	private String typeOfProgram;
	private String  typeOfCertificate;
	public JobOriented() {
		super();
		// TODO Auto-generated constructor stub
	}
	public JobOriented(long jobId, String heading, String typeOfProgram, String typeOfCertificate) {
		super();
		this.jobId = jobId;
		this.heading = heading;
		this.typeOfProgram = typeOfProgram;
		this.typeOfCertificate = typeOfCertificate;
	}
	public long getJobId() {
		return jobId;
	}
	public void setJobId(long jobId) {
		this.jobId = jobId;
	}
	public String getHeading() {
		return heading;
	}
	public void setHeading(String heading) {
		this.heading = heading;
	}
	public String getTypeOfProgram() {
		return typeOfProgram;
	}
	public void setTypeOfProgram(String typeOfProgram) {
		this.typeOfProgram = typeOfProgram;
	}
	public String getTypeOfCertificate() {
		return typeOfCertificate;
	}
	public void setTypeOfCertificate(String typeOfCertificate) {
		this.typeOfCertificate = typeOfCertificate;
	}
	@Override
	public String toString() {
		return "JobOriented [jobId=" + jobId + ", heading=" + heading + ", typeOfProgram=" + typeOfProgram
				+ ", typeOfCertificate=" + typeOfCertificate + "]";
	}
	
	
	
	
	
}
