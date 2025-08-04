package com.cms.backend.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="labtest")
public class LabTest {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="lab_test_id", nullable = false)
	private Integer labTestId;
	private String name;
	private Float price;
	
	public Integer getLabTestId() {
		return labTestId;
	}
	public void setLabTestId(Integer labTestId) {
		this.labTestId = labTestId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Float getPrice() {
		return price;
	}
	public void setPrice(Float price) {
		this.price = price;
	}

}
