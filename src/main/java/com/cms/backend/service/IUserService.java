package com.cms.backend.service;

import java.util.Optional;

import com.cms.backend.model.User;

public interface IUserService {
	
	Optional<User> findById(Integer userId);

}
