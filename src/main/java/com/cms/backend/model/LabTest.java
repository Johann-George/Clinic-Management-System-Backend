package com.cms.backend.model;

public class LabTest {
	
	private String testId;
	private String patientId;
	private String testName;
	private String status;
	private String result;
	
	public LabTest(String testId, String testName, String patientId) {
		this.testId = testId;
		this.testName = testName;
		this.patientId = patientId;
	}

	public String getTestId() {
		return testId;
	}

	public void setTestId(String testId) {
		this.testId = testId;
	}

	public String getPatientId() {
		return patientId;
	}

	public void setPatientId(String patientId) {
		this.patientId = patientId;
	}

	public String getTestName() {
		return testName;
	}

	public void setTestName(String testName) {
		this.testName = testName;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}
	
	

}
