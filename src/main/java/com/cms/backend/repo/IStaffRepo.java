package com.cms.backend.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cms.backend.model.Staff;

@Repository
public interface IStaffRepo extends JpaRepository<Staff, Integer>{
	
}
