package com.cms.backend.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="labtesttype")
public class LabTestType {
	
	@Id
	@Column(name="test_type_id")
	private Integer testTypeId;
	private String name;
	private Integer cost;

	public Integer getTestTypeId() {
		return testTypeId;
	}
	public void setTestTypeId(Integer testTypeId) {
		this.testTypeId = testTypeId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getCost() {
		return cost;
	}
	public void setCost(Integer cost) {
		this.cost = cost;
	}

}
