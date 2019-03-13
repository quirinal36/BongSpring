package com.bong.patientphoto.vo;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

public class OPRecord {
	int id;
	int patientId;
	String name;
	String opdate;
	String doctor;
	String dx;
	String anesthesia;
	String opname;
	String opfinding;
	String procedure;
	String opfee;
	String ref;
	
	public OPRecord() {
	
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
	public String getOpdate() {
		return opdate;
	}
	public void setOpdate(String opdate) {
		this.opdate = opdate;
	}
	public String getDoctor() {
		return doctor;
	}
	public void setDoctor(String doctor) {
		this.doctor = doctor;
	}
	public String getDx() {
		return dx;
	}
	public void setDx(String dx) {
		this.dx = dx;
	}
	public String getAnesthesia() {
		return anesthesia;
	}
	public void setAnesthesia(String anesthesia) {
		this.anesthesia = anesthesia;
	}
	public String getOpname() {
		return opname;
	}
	public void setOpname(String opname) {
		this.opname = opname;
	}
	public String getOpfinding() {
		return opfinding;
	}
	public void setOpfinding(String opfinding) {
		this.opfinding = opfinding;
	}
	public String getProcedure() {
		return procedure;
	}
	public void setProcedure(String procedure) {
		this.procedure = procedure;
	}
	public String getOpfee() {
		return opfee;
	}
	public void setOpfee(String opfee) {
		this.opfee = opfee;
	}
	public String getRef() {
		return ref;
	}
	public void setRef(String ref) {
		this.ref = ref;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return ToStringBuilder.reflectionToString(this, ToStringStyle.JSON_STYLE);
	}
	
	

}
