package com.cms.backend.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cms.backend.model.PrescriptionLabTest;

@Repository
public interface IPrescriptionLabTestRepo extends JpaRepository<PrescriptionLabTest, Integer>{

}
