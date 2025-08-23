package com.cms.backend.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cms.backend.model.Prescription;

@Repository
public interface IPrescriptionRepo extends JpaRepository<Prescription, Integer>{

}
