package com.cms.backend.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cms.backend.dto.UserDto;
import com.cms.backend.model.User;

@Repository
public interface IUserRepo extends JpaRepository<User, Integer>{
	
	User findByUsernameAndPassword(String Username, String Password);

	Optional<User> findByUsername(String string);

}
