package com.cms.backend.model;

public class Doctor extends Staff {
	
	private String specialization;

	public Doctor(String id, String name, String dob, String username, String password, String role, String specialization) {
		super(id, name, dob, username, password, role);
		this.setSpecialization(specialization);
	}

	public String getSpecialization() {
		return specialization;
	}

	public void setSpecialization(String specialization) {
		this.specialization = specialization;
	}

}
