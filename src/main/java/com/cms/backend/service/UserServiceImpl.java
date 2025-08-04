package com.cms.backend.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cms.backend.model.User;
import com.cms.backend.repo.IUserRepo;

@Service
public class UserServiceImpl implements IUserService {
	
	private final IUserRepo userRepo;
	
	@Autowired
	public UserServiceImpl(IUserRepo userRepo) {
		this.userRepo = userRepo;
	}

	@Override
	public Optional<User> findById(Integer userId) {
		return userRepo.findById(userId);
	}

}
