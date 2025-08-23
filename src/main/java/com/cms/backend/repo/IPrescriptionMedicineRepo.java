package com.cms.backend.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cms.backend.model.PrescriptionMedicine;

@Repository
public interface IPrescriptionMedicineRepo extends JpaRepository<PrescriptionMedicine, Integer>{

}
