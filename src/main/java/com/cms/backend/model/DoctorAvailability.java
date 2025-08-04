package com.cms.backend.model;

import java.time.LocalTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="doctoravailability")
public class DoctorAvailability {
	
	@Id
	@Column(name="availability_id", nullable = false)
	private Integer availabilityId;
	@Column(name="day_of_week")
	@Enumerated(EnumType.STRING)
	private DayOfWeek dayOfWeek;
	@OneToOne
	@JoinColumn(name="doctor_id")
	private Doctor doctor;
	@Column(name="start_time")
	private LocalTime startTime;
	@Column(name="end_time")
	private LocalTime endTime;
	
	public enum DayOfWeek{
		MONDAY,
		TUESDAY,
		WEDNESDAY,
		THURSDAY,
		FRIDAY,
		SATURDAY,
		SUNDAY 
	}

	public Integer getAvailabilityId() {
		return availabilityId;
	}

	public void setAvailabilityId(Integer availabilityId) {
		this.availabilityId = availabilityId;
	}

	public DayOfWeek getDayOfWeek() {
		return dayOfWeek;
	}

	public void setDayOfWeek(DayOfWeek dayOfWeek) {
		this.dayOfWeek = dayOfWeek;
	}

	public Doctor getDoctor() {
		return doctor;
	}

	public void setDoctor(Doctor doctor) {
		this.doctor = doctor;
	}

	public LocalTime getStartTime() {
		return startTime;
	}

	public void setStartTime(LocalTime startTime) {
		this.startTime = startTime;
	}

	public LocalTime getEndTime() {
		return endTime;
	}

	public void setEndTime(LocalTime endTime) {
		this.endTime = endTime;
	} 
	
}