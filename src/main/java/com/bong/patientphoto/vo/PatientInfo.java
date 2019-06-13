package com.bong.patientphoto.vo;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

public class PatientInfo extends Paging{
	int id;
	int patientId;
	String name;
	String birth;
	
	public PatientInfo() {
		
	}
	public static PatientInfo newInstance() {
		PatientInfo result = new PatientInfo();
		return result;
	}
	public static PatientInfo newInstance(int patientId) {
		PatientInfo result = new PatientInfo();
		result.setPatientId(patientId);
		return result;
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
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getBirth() {
		return birth;
	}
	public void setBirth(String birth) {
		this.birth = birth;
	}
	
	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.JSON_STYLE);
	}
}
