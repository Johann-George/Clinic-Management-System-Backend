package com.cms.backend.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cms.backend.model.User;

@Repository
public interface IUserRepo extends JpaRepository<User, Integer>{

}
