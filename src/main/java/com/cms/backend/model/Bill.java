package com.cms.backend.model;

import java.math.BigDecimal;
import java.time.LocalDate;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="bill")
public class Bill {
	
	@Id
	@Column(name="bill_id", nullable = false)
	private Integer billId;
	@OneToOne
	@JoinColumn(name="patient_id", nullable = false)
	private Patient patient;
	@OneToOne
	@JoinColumn(name="appointment_id", nullable = false)
	private Appointment appointment;
	private BigDecimal amount;
	@Column(name="billing_date")
	private LocalDate billingDate;
	@Enumerated(EnumType.STRING)
	@Column(name="payment_status")
	private PaymentStatus paymentStatus;
	
	public enum PaymentStatus{
		PENDING,
		COMPLETED
	}

	public Integer getBillId() {
		return billId;
	}

	public void setBillId(Integer billId) {
		this.billId = billId;
	}

	public Patient getPatient() {
		return patient;
	}

	public void setPatient(Patient patient) {
		this.patient = patient;
	}

	public Appointment getAppointment() {
		return appointment;
	}

	public void setAppointment(Appointment appointment) {
		this.appointment = appointment;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	public LocalDate getBillingDate() {
		return billingDate;
	}

	public void setBillingDate(LocalDate billingDate) {
		this.billingDate = billingDate;
	}

	public PaymentStatus getPaymentStatus() {
		return paymentStatus;
	}

	public void setPaymentStatus(PaymentStatus paymentStatus) {
		this.paymentStatus = paymentStatus;
	}

}
