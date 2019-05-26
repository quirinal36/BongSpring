package com.bong.patientphoto.vo;

import java.sql.Date;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

public class PhotoInfo implements Cloneable{
	int id;
	String patientId;
	String doctor;
	String uploader;
	String classification;
	Date date;
	String photoUrl;
	int sync;
	String comment;
	
	public PhotoInfo() {
		
	}


	
	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}



	public String getPatientId() {
		return patientId;
	}



	public void setPatientId(String patientId) {
		this.patientId = patientId;
	}



	public String getDoctor() {
		return doctor;
	}



	public void setDoctor(String doctor) {
		this.doctor = doctor;
	}



	public String getUploader() {
		return uploader;
	}



	public void setUploader(String uploader) {
		this.uploader = uploader;
	}



	public String getClassification() {
		return classification;
	}



	public void setClassification(String classification) {
		this.classification = classification;
	}



	public Date getDate() {
		return date;
	}



	public void setDate(Date date) {
		this.date = date;
	}



	public String getPhotoUrl() {
		return photoUrl;
	}



	public void setPhotoUrl(String photoUrl) {
		this.photoUrl = photoUrl;
	}



	public int getSync() {
		return sync;
	}



	public void setSync(int sync) {
		this.sync = sync;
	}



	public String getComment() {
		return comment;
	}



	public void setComment(String comment) {
		this.comment = comment;
	}



	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.JSON_STYLE);
	}



	@Override
	public Object clone() throws CloneNotSupportedException {
		// TODO Auto-generated method stub
		return super.clone();
	}
	
	
}
