package com.cms.backend.service;

import java.util.Optional;
import com.cms.backend.dto.LoginResponseDto;
import com.cms.backend.model.User;

public interface IUserService {
	
	Optional<User> findById(Integer userId);
	LoginResponseDto validateLogin(String username, String password);

}
